package kodkod.arithmetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import kodkod.ast.BinaryExpression;
import kodkod.ast.ComparisonFormula;
import kodkod.ast.Formula;
import kodkod.ast.IntComparisonFormula;
import kodkod.ast.IntExpression;
import kodkod.ast.IntToExprCast;
import kodkod.ast.Relation;
import kodkod.ast.operator.FormulaOperator;
import kodkod.engine.Solution;
import kodkod.engine.Solver;
import kodkod.engine.config.Options;
import kodkod.engine.satlab.SATFactory;
import kodkod.instance.Bounds;
import kodkod.instance.Instance;
import kodkod.instance.TupleFactory;
import kodkod.instance.TupleSet;
import kodkod.instance.Universe;

public final class IntExprReduction {
	HashSet<String> vars = new HashSet<String>();
	public HashSet<ComparisonFormula> equalsNodes = new HashSet<ComparisonFormula>();
	public ArrayList<ComparisonFormula> currentEqualsNodes;
	public ArrayList<IntComparisonFormula> inequalityNodes;
	public ArrayList<ComparisonFormula> todoNodes = new ArrayList<ComparisonFormula>();
	public HashMap<IntComparisonFormula, IntComparisonFormula> swapNodePairs= new HashMap<IntComparisonFormula, IntComparisonFormula>();
	public boolean createNewTree = false;
	public HashSet<Relation> bogusVariables = new HashSet<Relation>(); 
	Formula newTree;
	public Formula[] oldFormulas;
	
	public Formula[] reduceIntExpressions(Formula...formulas)
	{
		for(int i = 0; i < formulas.length; i++)
		{
			Formula f = formulas[i];
			AnnotateTree.clear();
			AnnotateTree.callByType(f);
			currentEqualsNodes = AnnotateTree.equalsNodes;
			inequalityNodes = AnnotateTree.inequalityNodes;
			createNewTree = false;
			for(ComparisonFormula cf : currentEqualsNodes){
				for(IntComparisonFormula icf : inequalityNodes){
					if(icf.left().toString().contains(cf.left().toString())){
						createNewTree = true;
						icf.canBeReduced = 2;
						cf.canBeReduced = 1;
						//add weight to "bogusVariables" list
						todoNodes.add(cf); 
						if(cf.right() instanceof IntToExprCast){
							IntExpression left = ((IntToExprCast)cf.right()).intExpr();
							IntComparisonFormula newNode = (IntComparisonFormula) left.compare(icf.op(), icf.right());
							newNode.canBeReduced = 3;
							swapNodePairs.put(icf, newNode);
							bogusVariables.add(((Relation)((BinaryExpression)cf.left()).right()));
						}
						else
							System.out.println("ERROR in reduceIntExpressions");
					}
				}
			}
			if(createNewTree){
				equalsNodes.addAll(currentEqualsNodes);
				BuildTree bt = new BuildTree(f, swapNodePairs);
				newTree = (Formula)bt.build();
				formulas[i] = newTree;
			}
		}
		return formulas;
	}
	
	public void solve(Formula formula, Bounds bounds, TupleFactory factory, Universe universe)
	{
		int bitwidth = 4;
		Solver solver = new Solver();
		solver.options().setSolver(SATFactory.DefaultSAT4J);
		solver.options().setBitwidth(bitwidth);
		solver.options().setIntEncoding(Options.IntEncoding.TWOSCOMPLEMENT);
		solver.options().setSymmetryBreaking(20);
		solver.options().setSkolemDepth(0);
		System.out.println("Solving...");
		System.out.flush();
		Solution sol = solver.solve(formula,bounds);
		System.out.println(sol.toString());
		
		Recompute.recompute(sol, factory, equalsNodes, bogusVariables, bitwidth);
	}
	
	
	
}
