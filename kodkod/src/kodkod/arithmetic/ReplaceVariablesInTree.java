package kodkod.arithmetic;

import kodkod.ast.BinaryExpression;
import kodkod.ast.BinaryFormula;
import kodkod.ast.BinaryIntExpression;
import kodkod.ast.ComparisonFormula;
import kodkod.ast.ConstantExpression;
import kodkod.ast.ConstantFormula;
import kodkod.ast.Decl;
import kodkod.ast.ExprToIntCast;
import kodkod.ast.Expression;
import kodkod.ast.IntComparisonFormula;
import kodkod.ast.IntConstant;
import kodkod.ast.IntExpression;
import kodkod.ast.IntToExprCast;
import kodkod.ast.MultiplicityFormula;
import kodkod.ast.NaryFormula;
import kodkod.ast.Node;
import kodkod.ast.NotFormula;
import kodkod.ast.QuantifiedFormula;
import kodkod.ast.Relation;
import kodkod.ast.Variable;
import kodkod.ast.operator.ExprCastOperator;

public class ReplaceVariablesInTree {

	static Variable variable;
	
	public static Node build(Node f, Variable v)
	{
		variable = v;
		if(v == null)
			return f;
		Node n = replaceByType(f);
		return n;
	}
	
	
	public static Node replaceByType(Node f)
	{
		if(f instanceof BinaryFormula)
			return replaceVariable(( BinaryFormula) f);
		else if(f instanceof ComparisonFormula)
			return replaceVariable(( ComparisonFormula) f);
		else if(f instanceof ConstantFormula)
			return replaceVariable(( ConstantFormula) f);
		else if(f instanceof MultiplicityFormula)
			return replaceVariable(( MultiplicityFormula) f);
		else if(f instanceof IntComparisonFormula)
			return replaceVariable(( IntComparisonFormula) f);
		else if(f instanceof QuantifiedFormula)
			return replaceVariable(( QuantifiedFormula) f);
		else if(f instanceof NaryFormula)
			return replaceVariable(( NaryFormula) f);
		else if(f instanceof NotFormula)
			return replaceVariable(( NotFormula) f);
		else if(f instanceof BinaryExpression)
			return replaceVariable((BinaryExpression) f);
		else if(f instanceof Relation)
			return replaceVariable((Relation) f);
		else if(f instanceof ConstantExpression)
			return replaceVariable((ConstantExpression) f);
		else if(f instanceof Variable)
			return replaceVariable((Variable) f);
		else if(f instanceof ExprToIntCast)
			return replaceVariable((ExprToIntCast) f);
		else if(f instanceof IntToExprCast)
			return replaceVariable((IntToExprCast) f);
		else if(f instanceof IntConstant)
			return replaceVariable((IntConstant) f);
		else if(f instanceof BinaryIntExpression)
			return replaceVariable((BinaryIntExpression) f);
		else if(f instanceof Decl)
			return replaceVariable((Decl) f);
		else{
			System.out.println("ERROR" + f);
			return null;
		}
	}

	private static Node replaceVariable(Decl f) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Node replaceVariable(BinaryIntExpression f) {
		return new BinaryIntExpression((IntExpression) replaceByType(f.left()), f.op(), (IntExpression) replaceByType(f.right()));
	}

	private static Node replaceVariable(IntConstant f) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Node replaceVariable(IntToExprCast f) {
		return new IntToExprCast((IntExpression)replaceByType(f.intExpr()),f.op());
	}

	private static Node replaceVariable(ExprToIntCast f) {
		return new ExprToIntCast((Expression) replaceByType(f.expression()), f.op());
	}

	private static Node replaceVariable(Variable f) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Node replaceVariable(ConstantExpression f) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Node replaceVariable(Relation f) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Node replaceVariable(NaryFormula f) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Node replaceVariable(NotFormula f) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Node replaceVariable(BinaryExpression f) {
		if(f.left() instanceof Variable)
		{
			return new BinaryExpression(variable, f.op(), f.right());
		}
		else
		{
			System.out.println("error in replace variables");
			return null;
		}
	}

	private static Node replaceVariable(ConstantFormula f) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Node replaceVariable(MultiplicityFormula f) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Node replaceVariable(IntComparisonFormula f) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Node replaceVariable(QuantifiedFormula f) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Node replaceVariable(ComparisonFormula f) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Node replaceVariable(BinaryFormula f) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
