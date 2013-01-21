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
	public HashSet<ComparisonFormula> comparisonNodes = new HashSet<ComparisonFormula>();
	public HashSet<IntComparisonFormula> intComparisonNodes = new HashSet<IntComparisonFormula>();
	public HashMap<String, Expression> swapAnswerPairs= new HashMap<String, Expression>();
	public HashSet<String> bogusVariables = new HashSet<String>();//Relation>(); 
	
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
			HashSet<ComparisonFormula> currentComparisonNodes = AnnotateTree.comparisonNodes;
			HashSet<IntComparisonFormula> currentInequalityNodes = AnnotateTree.intComparisonNodes;
			createNewTree[i] = false;
			if(!currentComparisonNodes.isEmpty() || !currentInequalityNodes.isEmpty())
				createNewTree[i] = true;
			
			comparisonNodes.addAll(currentComparisonNodes);
			intComparisonNodes.addAll(currentInequalityNodes);
		}
		for(ComparisonFormula cf : comparisonNodes){
			Relation answer;
			Expression expr;
			if(cf.assignmentOnLeft){
				//answer = (Relation)((BinaryExpression)cf.left()).right();
				
				expr = cf.right();
			}
			else{
				//answer = (Relation)((BinaryExpression)cf.right()).right();
				expr = cf.left();
			}
			cf.reduction = Reduction.DELETE;
			if(swapAnswerPairs.containsKey(cf.answer)){//answer.name())){
				cf.equalExpression = swapAnswerPairs.get(cf.answer);//answer.name());
				cf.reduction=Reduction.EQUALEXPRESSIONS;
			}
			swapAnswerPairs.put(cf.answer, expr);//answer.name(), expr);
			bogusVariables.add(cf.answer);//answer);
		}
		for(IntComparisonFormula icf : intComparisonNodes){
			icf.reduction = Reduction.INTCOMPARISON;
		}
		for(int i = 0; i < formulas.length; i++)
		if(createNewTree[i]){
			Formula f = formulas[i];
			
			BuildTree bt = new BuildTree(f, swapAnswerPairs);
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
		
		System.out.println(Recompute.recompute(sol, factory, comparisonNodes, bogusVariables, bitwidth).toString());
	}
	
	
	
}
