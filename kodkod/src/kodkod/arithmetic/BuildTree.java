package kodkod.arithmetic;

import java.util.HashMap;

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
import kodkod.ast.Expression;
import kodkod.ast.Formula;
import kodkod.ast.IfExpression;
import kodkod.ast.IfIntExpression;
import kodkod.ast.IntComparisonFormula;
import kodkod.ast.IntConstant;
import kodkod.ast.IntExpression;
import kodkod.ast.IntToExprCast;
import kodkod.ast.MultiplicityFormula;
import kodkod.ast.NaryExpression;
import kodkod.ast.NaryFormula;
import kodkod.ast.NaryIntExpression;
import kodkod.ast.Node;
import kodkod.ast.Node.Reduction;
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

public class BuildTree {
	public enum Replace{
		FALSE,
		COMPARISON,
		INTCOMPARISON,
		VARIABLES
	};
	Node node;
	//static Variable variable = null;
	static Replace replace = Replace.FALSE;
	static HashMap<String, Expression> swapAnswerPairs;
	
	public static Variable quantVariable=null;
	public static String quantExpression="";
	public static String multiplicity=""; 
	
	public BuildTree(Node node,HashMap<String, Expression> swapAnswerPairs)
	{
		BuildTree.swapAnswerPairs = swapAnswerPairs;
		this.node = node;
	}
	
	public Node build()
	{
		return buildByType(node);
	}
	
	public static Node buildByType(Node f)
	{
		if(f instanceof BinaryFormula)
			return buildTree(( BinaryFormula) f);
		else if(f instanceof ComparisonFormula)
			return buildTree(( ComparisonFormula) f);
		else if(f instanceof ConstantFormula)
			return buildTree(( ConstantFormula) f);
		else if(f instanceof MultiplicityFormula)
			return buildTree(( MultiplicityFormula) f);
		else if(f instanceof IntComparisonFormula)
			return buildTree(( IntComparisonFormula) f);
		else if(f instanceof QuantifiedFormula)
			return buildTree(( QuantifiedFormula) f);
		else if(f instanceof NaryFormula)
			return buildTree(( NaryFormula) f);
		else if(f instanceof NotFormula)
			return buildTree(( NotFormula) f);
		else if(f instanceof BinaryExpression)
			return buildTree((BinaryExpression) f);
		else if(f instanceof Relation)
			return buildTree((Relation) f);
		else if(f instanceof ConstantExpression)
			return buildTree((ConstantExpression) f);
		else if(f instanceof Variable)
			return buildTree((Variable) f);
		else if(f instanceof ExprToIntCast)
			return buildTree((ExprToIntCast) f);
		else if(f instanceof IntToExprCast)
			return buildTree((IntToExprCast) f);
		else if(f instanceof IntConstant)
			return buildTree((IntConstant) f);
		else if(f instanceof BinaryIntExpression)
			return buildTree((BinaryIntExpression) f);
		else if(f instanceof Decl)
			return buildTree((Decl) f);
		else{
			System.out.println("ERROR" + f);
			return null;
		}
	}
	
	//*************************************************
		//
		//Build Tree Section
		//Traverses the original tree, building a copy of
		//it that contains modified nodes to avoid 
		//arithmetic storage where possible
		//
		//*************************************************
		
		public static Decls buildTree(Decls decls) {
			return null;
			
		}

		
		public static Decl buildTree(Decl decl) {
			return null;
			
		}

		
		public static Relation buildTree(Relation relation) {
			return null;
			
		}

		
		public static Variable buildTree(Variable variable) {
			return null;
			
		}

		
		public static ConstantExpression buildTree(ConstantExpression constExpr) {
			return null;
			
		}

		
		public static UnaryExpression buildTree(UnaryExpression unaryExpr) {
			return null;
			
		}

		
		public static Node buildTree(BinaryExpression binExpr) {
			/*if(binExpr.op() == ExprOperator.JOIN)
			{
				if(swapAnswerPairs.containsKey(((Relation)binExpr.right()).name()))
				{
					Expression e  = swapAnswerPairs.get(((Relation)binExpr.right()).name());
					if(e instanceof IntToExprCast){
						if(replace == Replace.INTCOMPARISON){
							
							IntExpression i =(IntExpression) ((IntToExprCast)e).intExpr();
							return ReplaceVariablesInTree.build(i, binExpr.left());
						}
						else if(replace == Replace.COMPARISON)
							return ReplaceVariablesInTree.build(e, ((Variable)binExpr.left()));
					}
				}
				return binExpr;
			}
			else
				return binExpr;
				*/
			String answer =binExpr.myToString(multiplicity, quantExpression);
			if(swapAnswerPairs.containsKey(answer))
			{
				Expression e  = swapAnswerPairs.get(answer);//((Relation)binExpr.right()).name());
				if(e instanceof IntToExprCast){
					if(replace == Replace.INTCOMPARISON){
						
						IntExpression i =(IntExpression) ((IntToExprCast)e).intExpr();
						return ReplaceVariablesInTree.build(i, quantVariable);// binExpr.left());
					}
					else if(replace == Replace.COMPARISON){
						System.out.println("CHECK THIS WHEN IT COMES UP");
						return ReplaceVariablesInTree.build(e, ((Variable)binExpr.left()));
					}
				}
			}
			return binExpr;
			
		}

		
		public static NaryExpression buildTree(NaryExpression expr) {
			return null;
			
		}

		
		public static Comprehension buildTree(Comprehension comprehension) {
			return null;
			
		}

		
		public IfExpression buildTree(IfExpression ifExpr) {
			return null;
			
		}

		
		public static ProjectExpression buildTree(ProjectExpression project) {
			return null;
			
		}

		
		public static IntToExprCast buildTree(IntToExprCast castExpr) {
			return null;
			
		}

		
		public static IntConstant buildTree(IntConstant intConst) {
			return intConst;
			
		}

		
		public static IfIntExpression buildTree(IfIntExpression intExpr) {
			return null;
			
		}

		
		public static IntExpression buildTree(ExprToIntCast intExpr) {
			if(replace == Replace.FALSE || intExpr.op() == ExprCastOperator.CARDINALITY)
				return intExpr;
			else
			{
				Node n = buildByType(intExpr.expression());
				if(n instanceof IntExpression)
					return (IntExpression)n;
				else
					return intExpr;
							
			}	
		}

		
		public static NaryIntExpression buildTree(NaryIntExpression intExpr) {
			return null;
			
		}

		
		public static BinaryIntExpression buildTree(BinaryIntExpression intExpr) {
			return new BinaryIntExpression((IntExpression)buildByType(intExpr.left()), intExpr.op(), (IntExpression)buildByType(intExpr.right()));
			
		}

		
		public static UnaryIntExpression buildTree(UnaryIntExpression intExpr) {
			return null;
			
		}

		
		public static SumExpression buildTree(SumExpression intExpr) {
			return null;
			
		}

		
		public static Node buildTree(IntComparisonFormula n) {
			Node newNode = null;
			if(n.reduction == Reduction.INTCOMPARISON ){
				replace = Replace.INTCOMPARISON;
				newNode = new IntComparisonFormula((IntExpression)buildByType(n.left()), n.op(), (IntExpression)buildByType(n.right()));
				replace = Replace.FALSE;
			}
			return newNode;
		}

		public static QuantifiedFormula buildTree(QuantifiedFormula quantFormula) {	
			Decls decls = quantFormula.decls();
			Decl d = decls.get(0);
			multiplicity = d.multiplicity().toString();
			quantVariable = d.variable();
			quantExpression = d.expression().toString();
			QuantifiedFormula q = new QuantifiedFormula(quantFormula.quantifier(), 
					quantFormula.decls(), (Formula)buildByType(quantFormula.formula()));
			multiplicity = null;
			quantVariable = null;
			quantExpression = null;
			return q;
		}
		
		public static NaryFormula buildTree(NaryFormula formula) {
			return null;
			
		}
		
		public static BinaryFormula buildTree(BinaryFormula binFormula) {
			return new BinaryFormula((Formula)buildByType(binFormula.left()), binFormula.op(), (Formula)buildByType(binFormula.right()));
		}

		
		public static NotFormula buildTree(NotFormula not) {
			return null;
			
		}

		
		public static ConstantFormula buildTree(ConstantFormula constant) {
			return null;
			
		}

		
		public static Node buildTree(ComparisonFormula n) {
			Node newNode;
			if(n.reduction == Reduction.DELETE){ //|| n.reduction == Reduction.INTCONSTANT){
				return Formula.constant(true);
			}
			else if(n.reduction == Reduction.INTCONSTANT)
			{
				return n;
			}
			else if(n.reduction == Reduction.EQUALEXPRESSIONS){
				ComparisonFormula tempForm = (ComparisonFormula)n;
				return new ComparisonFormula(tempForm.right(), tempForm.op(), tempForm.equalExpression);
			}
			else if( n.reduction == Reduction.COMPARISON)
			{
				replace = Replace.COMPARISON;
				newNode = new ComparisonFormula((Expression) buildByType(n.left()), n.op(), (Expression) n.right());
				replace = Replace.FALSE;
			}
			else
				newNode = n;
			return newNode;
		}

		
		public static MultiplicityFormula buildTree(MultiplicityFormula multFormula) {
			return multFormula;
		}

		public RelationPredicate buildTree(RelationPredicate predicate) {
			return null;
		}
}