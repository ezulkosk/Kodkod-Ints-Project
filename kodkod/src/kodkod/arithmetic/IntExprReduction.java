package kodkod.arithmetic;

import java.util.HashMap;
import java.util.HashSet;

import kodkod.ast.BinaryExpression;
import kodkod.ast.ComparisonFormula;
import kodkod.ast.Expression;
import kodkod.ast.Formula;
import kodkod.ast.IntComparisonFormula;
import kodkod.ast.Node.Reduction;
import kodkod.ast.Relation;
import kodkod.engine.Solution;
import kodkod.engine.Solver;
import kodkod.engine.config.Options;
import kodkod.engine.satlab.SATFactory;
import kodkod.instance.Bounds;
import kodkod.instance.TupleFactory;
import kodkod.instance.Universe;

public final class IntExprReduction {
	
	
	
	
	HashSet<String> vars = new HashSet<String>();
	public HashSet<ComparisonFormula> equalsNodes = new HashSet<ComparisonFormula>();
	public HashSet<ComparisonFormula> currentEqualsNodes;
	public HashSet<IntComparisonFormula> inequalityNodes = new HashSet<IntComparisonFormula>();
	public HashSet<IntComparisonFormula> currentInequalityNodes;
	//public ArrayList<ComparisonFormula> todoNodes = new ArrayList<ComparisonFormula>();
	public HashMap<IntComparisonFormula, IntComparisonFormula> swapNodePairs= new HashMap<IntComparisonFormula, IntComparisonFormula>();
	public HashMap<String, Expression> swapAnswerPairs= new HashMap<String, Expression>();
	public HashSet<Relation> bogusVariables = new HashSet<Relation>(); 
	Formula newTree;
	public Formula[] oldFormulas;
	public boolean[] createNewTree;
	
	public Formula[] reduceIntExpressions(Formula...formulas)
	{
		AnnotateTree.start();
		createNewTree = new boolean[formulas.length];
		for(int i = 0; i < formulas.length; i++)
		{
			Formula f = formulas[i];
			AnnotateTree.start();
			AnnotateTree.callByType(f);
			currentEqualsNodes = AnnotateTree.equalsNodes;
			currentInequalityNodes = AnnotateTree.inequalityNodes;
			createNewTree[i] = false;
			if(!currentEqualsNodes.isEmpty() || !currentInequalityNodes.isEmpty())
				createNewTree[i] = true;
			
			equalsNodes.addAll(currentEqualsNodes);
			inequalityNodes.addAll(currentInequalityNodes);
		}
		for(ComparisonFormula cf : equalsNodes){
			System.out.println(cf);
			
			if(cf.right().containsRelations){
				cf.reduction = Reduction.DELETE;
				swapAnswerPairs.put(((Relation)((BinaryExpression)cf.left()).right()).name(), cf.right());
				bogusVariables.add((Relation)((BinaryExpression)cf.left()).right());
			}
			else
				cf.reduction = Reduction.EQUALITY;
		}
		for(IntComparisonFormula icf : inequalityNodes){
			icf.reduction = Reduction.INEQUALITY;
		}
		/*
		for(ComparisonFormula cf : equalsNodes){
			for(IntComparisonFormula icf : inequalityNodes){
				if(icf.left().toString().contains(((BinaryExpression)cf.left()).right().toString())){
					icf.reduction = Reduction.INEQUALITY;
					cf.reduction = Reduction.DELETE;
					
					//add weight to "bogusVariables" list
					//todoNodes.add(cf); 
					if(cf.right() instanceof IntToExprCast){
						IntExpression left = ((IntToExprCast)cf.right()).intExpr();
						IntComparisonFormula newNode = (IntComparisonFormula) left.compare(icf.op(), icf.right());
						newNode.reduction = Reduction.NONE;
						swapNodePairs.put(icf, newNode);
						BinaryExpression cfLeft = (BinaryExpression)cf.left();
						
						if(cfLeft.right() instanceof Relation)
							bogusVariables.add(((Relation)((BinaryExpression)cf.left()).right()));
						else//TODO clafer hack, needs to be cleaned
							bogusVariables.add(((Relation)((BinaryExpression)((BinaryExpression)cf.left()).right()).right()));
					}
					else
						System.out.println("ERROR in reduceIntExpressions");
				}
			}
			
			
		}*/
		for(int i = 0; i < formulas.length; i++)
		if(createNewTree[i]){
			Formula f = formulas[i];
			BuildTree bt = new BuildTree(f, swapNodePairs, swapAnswerPairs);
			newTree = (Formula)bt.build();
			formulas[i] = newTree;
		}
		
		return formulas;
	}
	
	public void solve(Formula formula, Bounds bounds, TupleFactory factory, Universe universe, int bitwidth)
	{
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
		
		System.out.println(Recompute.recompute(sol, factory, equalsNodes, bogusVariables, bitwidth).toString());
	}
	
	
	
}
