package kodkod.arithmetic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import kodkod.ast.BinaryExpression;
import kodkod.ast.BinaryIntExpression;
import kodkod.ast.ComparisonFormula;
import kodkod.ast.ExprToIntCast;
import kodkod.ast.IntConstant;
import kodkod.ast.IntToExprCast;
import kodkod.ast.Node;
import kodkod.ast.Node.Reduction;
import kodkod.ast.Relation;
import kodkod.engine.Solution;
import kodkod.instance.Instance;
import kodkod.instance.Tuple;
import kodkod.instance.TupleFactory;
import kodkod.instance.TupleSet;
import kodkod.instance.Universe;

public class Recompute {

	static HashSet<Relation> bogusVariables = new HashSet<Relation>();
	static Map<Relation, TupleSet> relationTuples;
	static HashSet<ComparisonFormula> formulas;
	static TupleFactory factory;
	static int bitwidth;
	static ArrayList<Relation> bogusRelations = new ArrayList<Relation>();
	static int numberOfType = 0;
	
	//shouldn't be static
	public static Solution recompute(Solution sol, TupleFactory factory, HashSet<ComparisonFormula> formulas, HashSet<Relation> bogusVariables, int bitwidth)
	{
		Recompute.formulas = formulas;
		Recompute.bogusVariables = bogusVariables;
		Recompute.factory = factory;
		Recompute.bitwidth = bitwidth;
		
		ArrayList<ArrayList<TemporaryTuple>> tempTuples = new ArrayList<ArrayList<TemporaryTuple>>();
		
		System.out.println("RECOMPUTE");
		if(sol.outcome() == Solution.Outcome.UNSATISFIABLE)
			return sol;
		
		Instance in = sol.instance();
		relationTuples =  in.relationTuples();
		
		for(ComparisonFormula cf: formulas)
		{
			if(cf.reduction != Reduction.DELETE)
				continue;
			//new
			System.out.println("B" +relationTuples.get(((BinaryExpression)cf.left()).right()));
			TupleSet ts;
			ts = relationTuples.get(((BinaryExpression)cf.left()).right());
			numberOfType = ts.size();
			//Iterator<Tuple> itr = ts.iterator();
			
			//ArrayList<TemporaryTuple> vals = new ArrayList<TemporaryTuple>();
			ArrayList<Integer> tempInts;
			//while(itr.hasNext()){
				//Tuple t = itr.next();
				//vals.add(new TemporaryTuple(t.atom(0), 0));//Integer.parseInt(t.atom(1).toString()));
			//}
			//end new and remove 2nd arg of below first add
			tempInts = computeByType(cf.right());
			tempTuples.add(concat(ts, tempInts));
			bogusRelations.add((Relation)((BinaryExpression)cf.left()).right());
		}
		boundTemporaryTuplesToBitwidth(tempTuples);
		return computeNewSolution(sol, tempTuples);
	}
	
	//Creates the new solution with the corrected values for "dependent variables"
	//Essentially a copy of the old Solution, but with a new Instance
	//This method can probably simplified a lot, but I had trouble creating tuples, etc. due to Universe errors.. 
	public static Solution computeNewSolution(Solution oldSolution, ArrayList<ArrayList<TemporaryTuple>> tempTuples)
	{
		Instance oldInstance = oldSolution.instance();
		Universe oldUniverse = oldInstance.universe();
		Iterator<Object> itr = oldUniverse.iterator();
		ArrayList<Object> newUniverseList = new ArrayList<Object>();
		
		while(itr.hasNext())
			newUniverseList.add(itr.next());
		for(ArrayList<TemporaryTuple> a: tempTuples)
			for(TemporaryTuple t: a)
				if(!newUniverseList.contains(t.right()+""))
					newUniverseList.add(t.right()+"");
		
		Universe newUniverse = new Universe(newUniverseList);
		Instance newInstance = new Instance(newUniverse);
		Set<Relation> keys =  relationTuples.keySet();
		Iterator<Relation> itr2 = keys.iterator();
		
		while(itr2.hasNext()){
			Relation r = itr2.next();
			TupleSet ts = relationTuples.get(r);
			if(!bogusVariables.contains(r))
			{
				Iterator<Tuple> itr3 = ts.iterator();
				//System.out.println(ts);
				TupleSet newTupleSet = newUniverse.factory().noneOf(ts.arity());
				//System.out.println("\n"+ r + " " + ts + " " + ts.arity());
				while(itr3.hasNext())
				{
					Tuple next = itr3.next();
					Tuple newTuple;
					if(ts.arity() == 1)
						newTuple = newUniverse.factory().tuple(next.atom(0));
					else
						newTuple = newUniverse.factory().tuple(next.atom(0), next.atom(1));
					//System.out.println(newTuple);
					newTupleSet.add(newTuple);
					
					
				}
				newInstance.add(r, newTupleSet);
			}
			//newUniverse.factory()
		}
		//for(int i = 0; i < )
		//newUniverse.factory().
		for(int i = 0; i < tempTuples.size(); i++)
		{
			TupleSet newTupleSet = newUniverse.factory().noneOf(2);
			for(int j = 0; j < tempTuples.get(i).size(); j++){
				System.out.println(tempTuples.get(i));
				System.out.println(bogusRelations.get(i));
				newTupleSet.add(newUniverse.factory().tuple(tempTuples.get(i).get(j).left(), tempTuples.get(i).get(j).right()+""));
				newInstance.add(bogusRelations.get(i), newTupleSet);		
			}
		}
		//System.out.println(newInstance);
		return new Solution(oldSolution.outcome(), oldSolution.stats(), newInstance, oldSolution.proof());
	}
	
	public static ArrayList<TemporaryTuple> concat(TupleSet ts, ArrayList<Integer> tempInts)
	{
		System.out.println(ts);
		ArrayList<TemporaryTuple> tuples = new ArrayList<TemporaryTuple>();
		Iterator<Integer>itr = tempInts.iterator();
		Iterator<Tuple>itr2 = ts.iterator();
		while(itr.hasNext())
			tuples.add(new TemporaryTuple(itr2.next().atom(0), itr.next()));
		return tuples;
	}
	
	public static ArrayList<Integer> computeByType(Node f){
		System.out.println(f);
		//System.out.println(ts);
		if(f instanceof IntToExprCast)
			return compute((IntToExprCast) f);
		else if(f instanceof BinaryIntExpression)
			return compute((BinaryIntExpression) f);
		else if(f instanceof BinaryExpression)
			return compute((BinaryExpression) f);
		else if(f instanceof ExprToIntCast)
			return compute((ExprToIntCast) f);
		else if(f instanceof IntConstant)
			return compute((IntConstant) f);
		else{
			System.out.println("Error in recompute5");
			System.out.println(f);
			return null;
		}
	}
	
	public static ArrayList<Integer> compute(IntToExprCast f)
	{
		return computeByType(f.intExpr());
	}
	
	public static ArrayList<Integer> compute(BinaryExpression f)
	{
		//System.out.println(f.right());
		//might need something like this
		//if(bogusVariables.contains(f.right()))
		//	System.out.println("Error Here");
		
		//TupleSet ts;
		//TODO claferhack, needs to be fixed
		//if(f.right() instanceof BinaryExpression)
		//	ts = relationTuples.get(((BinaryExpression)f.right()).right());
		//else
		TupleSet fTuples = relationTuples.get(f.right());
		//Iterator<TemporaryTuple> itr = ts.iterator();
		//ArrayList<TemporaryTuple> vals = new ArrayList<TemporaryTuple>();
		Iterator<Tuple> itr = fTuples.iterator();
		ArrayList<Integer> tempInts = new ArrayList<Integer>();
		while(itr.hasNext()){
			Tuple ft = itr.next();
			//vals.add(new TemporaryTuple(t.atom(0),Integer.parseInt(t.atom(1).toString())));//Integer.parseInt(t.atom(1).toString()));
			System.out.println(ft.atom(1));
			//ft.setRight(Integer.parseInt(ft.atom(1).toString()));
			tempInts.add(Integer.parseInt(ft.atom(1).toString()));
		}
		return tempInts;
	}
	
	public static ArrayList<Integer> compute(ExprToIntCast f)
	{
		switch(f.op()){
		case CARDINALITY:
			System.out.println("Error in recompute");
			break;
		case SUM:
			return computeByType(f.expression());
		default:
			break;
		}
		return null;
	}
	
	public static ArrayList<Integer> compute(IntConstant f)
 	{
		System.out.println("IN" + numberOfType);
		ArrayList<Integer> tempInts = new ArrayList<Integer>();
		for(int i = 0; i < numberOfType; i++)
			tempInts.add(f.value());
		return tempInts;
	}
	
	public static ArrayList<Integer> compute(BinaryIntExpression f)
	{
		switch(f.op()){
		case ABS:
			break;
		case AND:
			break;
		case DIVIDE:
			return composeArrayLists(computeByType(f.left()), '/', computeByType(f.right()));
		case MINUS:
			return composeArrayLists(computeByType(f.left()), '-', computeByType(f.right()));
		case MODULO:
			break;
		case MULTIPLY:
			return composeArrayLists(computeByType(f.left()), '*', computeByType(f.right()));
		case NEG:
			break;
		case NOT:
			break;
		case OR:
			break;
		case PLUS:
			return composeArrayLists(computeByType(f.left()), '+', computeByType(f.right()));
		case SGN:
			break;
		case SHA:
			break;
		case SHL:
			break;
		case SHR:
			break;
		case XOR:
			break;
		default:
			break;
		
		}
		System.out.println("error in recompute2");
		return null;
	}
	
	public static ArrayList<Integer> composeArrayLists(ArrayList<Integer> left, char op, ArrayList<Integer> right)
	{
		if(left.size() != right.size() || left.size() == 0){
			System.out.println("Error in recompute3333");
			return null;
		}
		ArrayList<Integer> vals = new ArrayList<Integer>();
		
		switch(op){
		case '+':
			for(int i = 0; i < left.size(); i++)
				vals.add(left.get(i) + right.get(i));
			break;
		case '-':
			for(int i = 0; i < left.size(); i++)
				vals.add(left.get(i) - right.get(i));
			break;
		case '*':
			for(int i = 0; i < left.size(); i++)
				vals.add(left.get(i)* right.get(i));
			break;
		case '/':
			for(int i = 0; i < left.size(); i++)
				vals.add(left.get(i) / right.get(i));
			break;
		default:
			System.out.println("Error in recompute");
		}
		
		return vals;
	}
	
	public static void boundTemporaryTuplesToBitwidth(ArrayList<ArrayList<TemporaryTuple>> tempTuples)
	{
		if(bitwidth == 32)
			return;
		for(ArrayList<TemporaryTuple> a : tempTuples)
			for(TemporaryTuple t: a)
				t.rebound(bitwidth);
	}
	
	
	
}
	
