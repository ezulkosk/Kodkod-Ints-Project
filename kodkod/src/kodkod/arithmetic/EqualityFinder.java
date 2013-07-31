package kodkod.arithmetic;

import java.util.HashSet;

import kodkod.ast.BinaryExpression;
import kodkod.ast.ComparisonFormula;
import kodkod.ast.Decl;
import kodkod.ast.Decls;
import kodkod.ast.ExprToIntCast;
import kodkod.ast.Expression;
import kodkod.ast.IntComparisonFormula;
import kodkod.ast.IntToExprCast;
import kodkod.ast.Node;
import kodkod.ast.QuantifiedFormula;
import kodkod.ast.Relation;
import kodkod.ast.operator.ExprCastOperator;
import kodkod.ast.operator.ExprCompOperator;
import kodkod.ast.visitor.AbstractVoidVisitor;

//Traverses the tree marking equality and inequality nodes 
public class EqualityFinder extends AbstractVoidVisitor {

	public HashSet<ComparisonFormula> comparisonNodes = new HashSet<ComparisonFormula>();
	public HashSet<IntComparisonFormula> intComparisonNodes = new HashSet<IntComparisonFormula>();
	
	
	public String quantVariable;
	public Expression quantExpression;
	public String multiplicity; 
	
	
	
	public EqualityFinder()
	{
		comparisonNodes = new HashSet<ComparisonFormula>();
		intComparisonNodes = new HashSet<IntComparisonFormula>();
	}
	/*
	public static void callByType(Object f)
	{
		if (f instanceof BinaryFormula)
			checkForInts((BinaryFormula) f);
		else if (f instanceof ComparisonFormula)
			checkForInts((ComparisonFormula) f);
		else if (f instanceof ConstantFormula)
			checkForInts((ConstantFormula) f);
		else if (f instanceof MultiplicityFormula)
			checkForInts((MultiplicityFormula) f);
		else if (f instanceof IntComparisonFormula)
			checkForInts((IntComparisonFormula) f);
		else if (f instanceof QuantifiedFormula)
			checkForInts((QuantifiedFormula) f);
		else if (f instanceof NaryFormula)
			checkForInts((NaryFormula) f);
		else if (f instanceof NotFormula)
			checkForInts((NotFormula) f);
		else if (f instanceof BinaryExpression)
			checkForInts((BinaryExpression) f);
		else if (f instanceof Relation)
			checkForInts((Relation) f);
		else if (f instanceof ConstantExpression)
			checkForInts((ConstantExpression) f);
		else if (f instanceof Variable)
			checkForInts((Variable) f);
		else if (f instanceof ExprToIntCast)
			checkForInts((ExprToIntCast) f);
		else if (f instanceof IntToExprCast)
			checkForInts((IntToExprCast) f);
		else if (f instanceof IntConstant)
			checkForInts((IntConstant) f);
		else if (f instanceof BinaryIntExpression)
			checkForInts((BinaryIntExpression) f);
		else if (f instanceof UnaryExpression)
			checkForInts((UnaryExpression) f);
		else
			System.out.println("ERROR" + f);
	}
	*/
	
	public void visit(ComparisonFormula f)
	{
		f.left().accept(this);
		f.right().accept(this);
		if(f.op() == ExprCompOperator.EQUALS && (f.left() instanceof IntToExprCast || f.right() instanceof IntToExprCast)){
			
			
			if(f.left() instanceof BinaryExpression || f.left() instanceof Relation){ // && ((BinaryExpression)f.left()).right() instanceof Relation)
				comparisonNodes.add(f);
				//f.variable = (Relation)quantExpression;
				IntExprReduction.variables.put(f, quantExpression);
				//System.out.println(f.variable);
				if(f.left() instanceof Relation)
					//f.answer = f.left().toString();
					IntExprReduction.answers.put(f, f.left().toString());
				else if(multiplicity != null)
					//f.answer = myToString((BinaryExpression)f.left(), multiplicity.toString(), quantExpression.toString());
					IntExprReduction.answers.put(f, 
							myToString((BinaryExpression)f.left(), multiplicity.toString(), quantExpression.toString()));
				else 
					//f.answer = myToString((BinaryExpression)f.left(), "","");
					IntExprReduction.answers.put(f, myToString((BinaryExpression)f.left(), "",""));
			}
			else if(f.right() instanceof BinaryExpression  || f.right() instanceof Relation){
				//f.variable = (Relation)quantExpression;
				IntExprReduction.variables.put(f, quantExpression);
				comparisonNodes.add(f);
				if(f.right() instanceof Relation)
					//f.answer = f.right().toString();
					IntExprReduction.answers.put(f, f.right().toString());
				else if(multiplicity != null)
					//f.answer = myToString((BinaryExpression)f.right(), multiplicity.toString(), quantExpression.toString());
					IntExprReduction.answers.put(f, myToString((BinaryExpression)f.right(), multiplicity.toString(), quantExpression.toString()));
				else 
					//f.answer = myToString((BinaryExpression)f.right(), "","");
					IntExprReduction.answers.put(f, myToString((BinaryExpression)f.right(), "",""));
			}
				
		}
	}

	// TODO: rewrite this myToString() method
	static String myToString(final BinaryExpression be, final String mult, final String expression){
		if(be.right() instanceof BinaryExpression)
			return myToString(((BinaryExpression)be.right()), mult,expression);
		else if(be.right() instanceof Relation)
			return be.right().toString();
		else 
			System.exit(1); // TODO: remove this call
		return "";
	}
	

	
	public void visit(IntComparisonFormula f)
	{
		f.left().accept(this);
		f.right().accept(this);
		intComparisonNodes.add(f);
	}
	
	public void visit(QuantifiedFormula f)
	{
		Decls decls = f.decls();
		Decl d = decls.get(0);
		multiplicity = d.multiplicity().toString();
		quantVariable = d.variable().toString();
		quantExpression = d.expression();
		f.formula().accept(this);
		multiplicity = null;
		quantVariable = null;
		quantExpression = null;
	}
	
	public void visit(IntToExprCast castExpr) {
		castExpr.intExpr().accept(this);
	}
	
	
	public void visit(ExprToIntCast intExpr) {
		if(intExpr.op() == ExprCastOperator.SUM){
			intExpr.expression().accept(this);
		}
	}


	protected boolean visited(Node n) {
		return false;
	}
	
}
