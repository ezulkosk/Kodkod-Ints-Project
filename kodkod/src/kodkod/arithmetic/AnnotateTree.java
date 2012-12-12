package kodkod.arithmetic;

import java.util.HashSet;

import kodkod.ast.BinaryExpression;
import kodkod.ast.BinaryFormula;
import kodkod.ast.BinaryIntExpression;
import kodkod.ast.ComparisonFormula;
import kodkod.ast.Comprehension;
import kodkod.ast.ConstantExpression;
import kodkod.ast.ConstantFormula;
import kodkod.ast.Decl;
import kodkod.ast.Decls;
import kodkod.ast.ExprToIntCast;
import kodkod.ast.IfExpression;
import kodkod.ast.IfIntExpression;
import kodkod.ast.IntComparisonFormula;
import kodkod.ast.IntConstant;
import kodkod.ast.IntToExprCast;
import kodkod.ast.MultiplicityFormula;
import kodkod.ast.NaryExpression;
import kodkod.ast.NaryFormula;
import kodkod.ast.NaryIntExpression;
import kodkod.ast.NotFormula;
import kodkod.ast.ProjectExpression;
import kodkod.ast.QuantifiedFormula;
import kodkod.ast.Relation;
import kodkod.ast.RelationPredicate;
import kodkod.ast.SumExpression;
import kodkod.ast.UnaryExpression;
import kodkod.ast.UnaryIntExpression;
import kodkod.ast.Variable;
import kodkod.ast.operator.ExprCastOperator;
import kodkod.ast.operator.ExprCompOperator;

//Traverses the tree looking for equality and inequality nodes, 
//annotating accordingly
public class AnnotateTree {

	public static HashSet<ComparisonFormula> equalsNodes = new HashSet<ComparisonFormula>();
	public static HashSet<IntComparisonFormula> inequalityNodes = new HashSet<IntComparisonFormula>();
	
	public static void start()
	{
		equalsNodes = new HashSet<ComparisonFormula>();
		inequalityNodes = new HashSet<IntComparisonFormula>();
	}
	
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
		else
			System.out.println("ERROR" + f);
	}
	
	public static void checkForInts(BinaryFormula f)
	{
		callByType(f.left());
		callByType(f.right());
	}
	
	public static void checkForInts(ComparisonFormula f)
	{
		callByType(f.left());
		callByType(f.right());
		if(f.op() == ExprCompOperator.EQUALS && (f.left().isIntExpr || f.right().isIntExpr)){
			equalsNodes.add(f);
		}
	}
	public static void checkForInts(ConstantFormula f)
	{
		
	}
	
	public static void checkForInts(MultiplicityFormula f)
	{

	}
	
	public static void checkForInts(IntComparisonFormula f)
	{
		callByType(f.left());
		callByType(f.right());
		inequalityNodes.add(f);
		if(f.left().containsRelations || f.right().containsRelations)
			f.containsRelations = true;
	}
	
	public static void checkForInts(QuantifiedFormula f)
	{
		callByType(f.formula());
	}
	
	public static void checkForInts(NaryFormula f)
	{

	}
	
	public static void checkForInts(NotFormula f)
	{

	}
	
	public static void checkForInts(Decls decls) {
		
	}
	
	public static void checkForInts(Decl decl) {		
		
	}
	
	public static void checkForInts(Relation relation) {
		relation.containsRelations = true;
	}
	
	public static void checkForInts(Variable variable) {
			
	}
	
	public static void checkForInts(ConstantExpression constExpr) {	
		
	}
	
	public static void checkForInts(UnaryExpression unaryExpr) {	
		
	}
	
	public static void checkForInts(BinaryExpression binExpr) {
		callByType(binExpr.left());
		callByType(binExpr.right());
		if(binExpr.left().containsRelations || binExpr.right().containsRelations)
			binExpr.containsRelations = true;
	}

	public static void checkForInts(NaryExpression expr) {
	}

	public static void checkForInts(Comprehension comprehension) {
		
	}
	
	public static void checkForInts(IfExpression ifExpr) {
		
	}

	public static void checkForInts(ProjectExpression project) {
		
	}
	
	public static void checkForInts(IntToExprCast castExpr) {
		castExpr.isIntExpr = true;
		callByType(castExpr.intExpr());
		if(castExpr.intExpr().containsRelations)
			castExpr.containsRelations = true;
	}
	
	public static void checkForInts(IntConstant intConst) {

	}

	public static void checkForInts(IfIntExpression intExpr) {
		
	}
	
	public static void checkForInts(ExprToIntCast intExpr) {
		if(intExpr.op() == ExprCastOperator.SUM){
			callByType(intExpr.expression());
			if(intExpr.expression().containsRelations)
				intExpr.containsRelations = true;
		}
	}

	
	public static void checkForInts(NaryIntExpression intExpr) {
		
	}
	
	public static void checkForInts(BinaryIntExpression intExpr) {
		callByType(intExpr.left());
		callByType(intExpr.right());
		if(intExpr.left().containsRelations || intExpr.right().containsRelations)
			intExpr.containsRelations = true;
	}

	
	public static void checkForInts(UnaryIntExpression intExpr) {
		
	}

	
	public static void checkForInts(SumExpression intExpr) {
		
	}

	public static void checkForInts(RelationPredicate predicate) {
		
	}
	
	
}
