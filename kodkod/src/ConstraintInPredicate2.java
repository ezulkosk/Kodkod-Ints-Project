import java.util.Arrays;
import java.util.List;

import kodkod.arithmetic.IntExprReduction;
import kodkod.ast.Decls;
import kodkod.ast.Expression;
import kodkod.ast.Formula;
import kodkod.ast.IntConstant;
import kodkod.ast.IntExpression;
import kodkod.ast.Relation;
import kodkod.ast.Variable;
import kodkod.ast.operator.FormulaOperator;
import kodkod.engine.Solution;
import kodkod.engine.Solver;
import kodkod.engine.config.Options;
import kodkod.engine.satlab.SATFactory;
import kodkod.instance.Bounds;
import kodkod.instance.TupleFactory;
import kodkod.instance.TupleSet;
import kodkod.instance.Universe;

/*
sig Test 
{  
	x: Int,
	y: Int,
	z: Int,
	weight: Int,
}
{ 
	weight = x.plus[y].plus[z]
	weight < 4
	weight > -2
} 

pred Pred{
	all test: Test | test.weight  < 0
}
run Pred for exactly 4 Test, 4 Int
*/
/* 
  ==================================================
    kodkod formula: 
  ==================================================
    (all Pred_this: this/Test | 
      one (Pred_this . this/Test.x) && 
      (Pred_this . this/Test.x) in ints) && 
    (this/Test.x . univ) in this/Test && 
    (all Pred_this: this/Test | 
      one (Pred_this . this/Test.y) && 
      (Pred_this . this/Test.y) in ints) && 
    (this/Test.y . univ) in this/Test && 
    (all Pred_this: this/Test | 
      one (Pred_this . this/Test.z) && 
      (Pred_this . this/Test.z) in ints) && 
    (this/Test.z . univ) in this/Test && 
    (all Pred_this: this/Test | 
      one (Pred_this . this/Test.weight) && 
      (Pred_this . this/Test.weight) in ints) && 
    (this/Test.weight . univ) in this/Test && 
    (all Pred_this: this/Test | 
      (Pred_this . this/Test.weight) = Int[int[Pred_this . this/Test.x] + int[
      Pred_this . this/Test.y] + int[Pred_this . this/Test.z]] && 
      int[Pred_this . this/Test.weight] < 4 && 
      int[Pred_this . this/Test.weight] > -2) && 
    (all Pred_test: this/Test | 
      int[Pred_test . this/Test.weight] < 0) && 
    Int/min = Int/min && 
    Int/zero = Int/zero && 
    Int/max = Int/max && 
    Int/next = Int/next && 
    seq/Int = seq/Int && 
    String = String && 
    this/Test = this/Test && 
    this/Test.x = this/Test.x && 
    this/Test.y = this/Test.y && 
    this/Test.z = this/Test.z && 
    this/Test.weight = this/Test.weight
  ==================================================
*/
public final class ConstraintInPredicate2 {

public static void main(String[] args) throws Exception {

Relation x0 = Relation.unary("Int/min");
Relation x1 = Relation.unary("Int/zero");
Relation x2 = Relation.unary("Int/max");
Relation x3 = Relation.nary("Int/next", 2);
Relation x4 = Relation.unary("seq/Int");
Relation x5 = Relation.unary("String");
Relation x6 = Relation.unary("this/Test");
Relation x7 = Relation.nary("this/Test.x", 2);
Relation x8 = Relation.nary("this/Test.y", 2);
Relation x9 = Relation.nary("this/Test.z", 2);
Relation x10 = Relation.nary("this/Test.weight", 2);

List<String> atomlist = Arrays.asList(
 "-1", "-2", "-3", "-4", "-5",
 "-6", "-7", "-8", "0", "1", "2",
 "3", "4", "5", "6", "7", "Test$0",
 "Test$1", "Test$2", "Test$3"
);

Universe universe = new Universe(atomlist);
TupleFactory factory = universe.factory();
Bounds bounds = new Bounds(universe);

TupleSet x0_upper = factory.noneOf(1);
x0_upper.add(factory.tuple("-8"));
bounds.boundExactly(x0, x0_upper);

TupleSet x1_upper = factory.noneOf(1);
x1_upper.add(factory.tuple("0"));
bounds.boundExactly(x1, x1_upper);

TupleSet x2_upper = factory.noneOf(1);
x2_upper.add(factory.tuple("7"));
bounds.boundExactly(x2, x2_upper);

TupleSet x3_upper = factory.noneOf(2);
x3_upper.add(factory.tuple("-8").product(factory.tuple("-7")));
x3_upper.add(factory.tuple("-7").product(factory.tuple("-6")));
x3_upper.add(factory.tuple("-6").product(factory.tuple("-5")));
x3_upper.add(factory.tuple("-5").product(factory.tuple("-4")));
x3_upper.add(factory.tuple("-4").product(factory.tuple("-3")));
x3_upper.add(factory.tuple("-3").product(factory.tuple("-2")));
x3_upper.add(factory.tuple("-2").product(factory.tuple("-1")));
x3_upper.add(factory.tuple("-1").product(factory.tuple("0")));
x3_upper.add(factory.tuple("0").product(factory.tuple("1")));
x3_upper.add(factory.tuple("1").product(factory.tuple("2")));
x3_upper.add(factory.tuple("2").product(factory.tuple("3")));
x3_upper.add(factory.tuple("3").product(factory.tuple("4")));
x3_upper.add(factory.tuple("4").product(factory.tuple("5")));
x3_upper.add(factory.tuple("5").product(factory.tuple("6")));
x3_upper.add(factory.tuple("6").product(factory.tuple("7")));
bounds.boundExactly(x3, x3_upper);

TupleSet x4_upper = factory.noneOf(1);
x4_upper.add(factory.tuple("0"));
x4_upper.add(factory.tuple("1"));
x4_upper.add(factory.tuple("2"));
x4_upper.add(factory.tuple("3"));
bounds.boundExactly(x4, x4_upper);

TupleSet x5_upper = factory.noneOf(1);
bounds.boundExactly(x5, x5_upper);

TupleSet x6_upper = factory.noneOf(1);
x6_upper.add(factory.tuple("Test$0"));
x6_upper.add(factory.tuple("Test$1"));
x6_upper.add(factory.tuple("Test$2"));
x6_upper.add(factory.tuple("Test$3"));
bounds.boundExactly(x6, x6_upper);

TupleSet x7_upper = factory.noneOf(2);
x7_upper.add(factory.tuple("Test$0").product(factory.tuple("-8")));
x7_upper.add(factory.tuple("Test$0").product(factory.tuple("-7")));
x7_upper.add(factory.tuple("Test$0").product(factory.tuple("-6")));
x7_upper.add(factory.tuple("Test$0").product(factory.tuple("-5")));
x7_upper.add(factory.tuple("Test$0").product(factory.tuple("-4")));
x7_upper.add(factory.tuple("Test$0").product(factory.tuple("-3")));
x7_upper.add(factory.tuple("Test$0").product(factory.tuple("-2")));
x7_upper.add(factory.tuple("Test$0").product(factory.tuple("-1")));
x7_upper.add(factory.tuple("Test$0").product(factory.tuple("0")));
x7_upper.add(factory.tuple("Test$0").product(factory.tuple("1")));
x7_upper.add(factory.tuple("Test$0").product(factory.tuple("2")));
x7_upper.add(factory.tuple("Test$0").product(factory.tuple("3")));
x7_upper.add(factory.tuple("Test$0").product(factory.tuple("4")));
x7_upper.add(factory.tuple("Test$0").product(factory.tuple("5")));
x7_upper.add(factory.tuple("Test$0").product(factory.tuple("6")));
x7_upper.add(factory.tuple("Test$0").product(factory.tuple("7")));
x7_upper.add(factory.tuple("Test$1").product(factory.tuple("-8")));
x7_upper.add(factory.tuple("Test$1").product(factory.tuple("-7")));
x7_upper.add(factory.tuple("Test$1").product(factory.tuple("-6")));
x7_upper.add(factory.tuple("Test$1").product(factory.tuple("-5")));
x7_upper.add(factory.tuple("Test$1").product(factory.tuple("-4")));
x7_upper.add(factory.tuple("Test$1").product(factory.tuple("-3")));
x7_upper.add(factory.tuple("Test$1").product(factory.tuple("-2")));
x7_upper.add(factory.tuple("Test$1").product(factory.tuple("-1")));
x7_upper.add(factory.tuple("Test$1").product(factory.tuple("0")));
x7_upper.add(factory.tuple("Test$1").product(factory.tuple("1")));
x7_upper.add(factory.tuple("Test$1").product(factory.tuple("2")));
x7_upper.add(factory.tuple("Test$1").product(factory.tuple("3")));
x7_upper.add(factory.tuple("Test$1").product(factory.tuple("4")));
x7_upper.add(factory.tuple("Test$1").product(factory.tuple("5")));
x7_upper.add(factory.tuple("Test$1").product(factory.tuple("6")));
x7_upper.add(factory.tuple("Test$1").product(factory.tuple("7")));
x7_upper.add(factory.tuple("Test$2").product(factory.tuple("-8")));
x7_upper.add(factory.tuple("Test$2").product(factory.tuple("-7")));
x7_upper.add(factory.tuple("Test$2").product(factory.tuple("-6")));
x7_upper.add(factory.tuple("Test$2").product(factory.tuple("-5")));
x7_upper.add(factory.tuple("Test$2").product(factory.tuple("-4")));
x7_upper.add(factory.tuple("Test$2").product(factory.tuple("-3")));
x7_upper.add(factory.tuple("Test$2").product(factory.tuple("-2")));
x7_upper.add(factory.tuple("Test$2").product(factory.tuple("-1")));
x7_upper.add(factory.tuple("Test$2").product(factory.tuple("0")));
x7_upper.add(factory.tuple("Test$2").product(factory.tuple("1")));
x7_upper.add(factory.tuple("Test$2").product(factory.tuple("2")));
x7_upper.add(factory.tuple("Test$2").product(factory.tuple("3")));
x7_upper.add(factory.tuple("Test$2").product(factory.tuple("4")));
x7_upper.add(factory.tuple("Test$2").product(factory.tuple("5")));
x7_upper.add(factory.tuple("Test$2").product(factory.tuple("6")));
x7_upper.add(factory.tuple("Test$2").product(factory.tuple("7")));
x7_upper.add(factory.tuple("Test$3").product(factory.tuple("-8")));
x7_upper.add(factory.tuple("Test$3").product(factory.tuple("-7")));
x7_upper.add(factory.tuple("Test$3").product(factory.tuple("-6")));
x7_upper.add(factory.tuple("Test$3").product(factory.tuple("-5")));
x7_upper.add(factory.tuple("Test$3").product(factory.tuple("-4")));
x7_upper.add(factory.tuple("Test$3").product(factory.tuple("-3")));
x7_upper.add(factory.tuple("Test$3").product(factory.tuple("-2")));
x7_upper.add(factory.tuple("Test$3").product(factory.tuple("-1")));
x7_upper.add(factory.tuple("Test$3").product(factory.tuple("0")));
x7_upper.add(factory.tuple("Test$3").product(factory.tuple("1")));
x7_upper.add(factory.tuple("Test$3").product(factory.tuple("2")));
x7_upper.add(factory.tuple("Test$3").product(factory.tuple("3")));
x7_upper.add(factory.tuple("Test$3").product(factory.tuple("4")));
x7_upper.add(factory.tuple("Test$3").product(factory.tuple("5")));
x7_upper.add(factory.tuple("Test$3").product(factory.tuple("6")));
x7_upper.add(factory.tuple("Test$3").product(factory.tuple("7")));
bounds.bound(x7, x7_upper);

TupleSet x8_upper = factory.noneOf(2);
x8_upper.add(factory.tuple("Test$0").product(factory.tuple("-8")));
x8_upper.add(factory.tuple("Test$0").product(factory.tuple("-7")));
x8_upper.add(factory.tuple("Test$0").product(factory.tuple("-6")));
x8_upper.add(factory.tuple("Test$0").product(factory.tuple("-5")));
x8_upper.add(factory.tuple("Test$0").product(factory.tuple("-4")));
x8_upper.add(factory.tuple("Test$0").product(factory.tuple("-3")));
x8_upper.add(factory.tuple("Test$0").product(factory.tuple("-2")));
x8_upper.add(factory.tuple("Test$0").product(factory.tuple("-1")));
x8_upper.add(factory.tuple("Test$0").product(factory.tuple("0")));
x8_upper.add(factory.tuple("Test$0").product(factory.tuple("1")));
x8_upper.add(factory.tuple("Test$0").product(factory.tuple("2")));
x8_upper.add(factory.tuple("Test$0").product(factory.tuple("3")));
x8_upper.add(factory.tuple("Test$0").product(factory.tuple("4")));
x8_upper.add(factory.tuple("Test$0").product(factory.tuple("5")));
x8_upper.add(factory.tuple("Test$0").product(factory.tuple("6")));
x8_upper.add(factory.tuple("Test$0").product(factory.tuple("7")));
x8_upper.add(factory.tuple("Test$1").product(factory.tuple("-8")));
x8_upper.add(factory.tuple("Test$1").product(factory.tuple("-7")));
x8_upper.add(factory.tuple("Test$1").product(factory.tuple("-6")));
x8_upper.add(factory.tuple("Test$1").product(factory.tuple("-5")));
x8_upper.add(factory.tuple("Test$1").product(factory.tuple("-4")));
x8_upper.add(factory.tuple("Test$1").product(factory.tuple("-3")));
x8_upper.add(factory.tuple("Test$1").product(factory.tuple("-2")));
x8_upper.add(factory.tuple("Test$1").product(factory.tuple("-1")));
x8_upper.add(factory.tuple("Test$1").product(factory.tuple("0")));
x8_upper.add(factory.tuple("Test$1").product(factory.tuple("1")));
x8_upper.add(factory.tuple("Test$1").product(factory.tuple("2")));
x8_upper.add(factory.tuple("Test$1").product(factory.tuple("3")));
x8_upper.add(factory.tuple("Test$1").product(factory.tuple("4")));
x8_upper.add(factory.tuple("Test$1").product(factory.tuple("5")));
x8_upper.add(factory.tuple("Test$1").product(factory.tuple("6")));
x8_upper.add(factory.tuple("Test$1").product(factory.tuple("7")));
x8_upper.add(factory.tuple("Test$2").product(factory.tuple("-8")));
x8_upper.add(factory.tuple("Test$2").product(factory.tuple("-7")));
x8_upper.add(factory.tuple("Test$2").product(factory.tuple("-6")));
x8_upper.add(factory.tuple("Test$2").product(factory.tuple("-5")));
x8_upper.add(factory.tuple("Test$2").product(factory.tuple("-4")));
x8_upper.add(factory.tuple("Test$2").product(factory.tuple("-3")));
x8_upper.add(factory.tuple("Test$2").product(factory.tuple("-2")));
x8_upper.add(factory.tuple("Test$2").product(factory.tuple("-1")));
x8_upper.add(factory.tuple("Test$2").product(factory.tuple("0")));
x8_upper.add(factory.tuple("Test$2").product(factory.tuple("1")));
x8_upper.add(factory.tuple("Test$2").product(factory.tuple("2")));
x8_upper.add(factory.tuple("Test$2").product(factory.tuple("3")));
x8_upper.add(factory.tuple("Test$2").product(factory.tuple("4")));
x8_upper.add(factory.tuple("Test$2").product(factory.tuple("5")));
x8_upper.add(factory.tuple("Test$2").product(factory.tuple("6")));
x8_upper.add(factory.tuple("Test$2").product(factory.tuple("7")));
x8_upper.add(factory.tuple("Test$3").product(factory.tuple("-8")));
x8_upper.add(factory.tuple("Test$3").product(factory.tuple("-7")));
x8_upper.add(factory.tuple("Test$3").product(factory.tuple("-6")));
x8_upper.add(factory.tuple("Test$3").product(factory.tuple("-5")));
x8_upper.add(factory.tuple("Test$3").product(factory.tuple("-4")));
x8_upper.add(factory.tuple("Test$3").product(factory.tuple("-3")));
x8_upper.add(factory.tuple("Test$3").product(factory.tuple("-2")));
x8_upper.add(factory.tuple("Test$3").product(factory.tuple("-1")));
x8_upper.add(factory.tuple("Test$3").product(factory.tuple("0")));
x8_upper.add(factory.tuple("Test$3").product(factory.tuple("1")));
x8_upper.add(factory.tuple("Test$3").product(factory.tuple("2")));
x8_upper.add(factory.tuple("Test$3").product(factory.tuple("3")));
x8_upper.add(factory.tuple("Test$3").product(factory.tuple("4")));
x8_upper.add(factory.tuple("Test$3").product(factory.tuple("5")));
x8_upper.add(factory.tuple("Test$3").product(factory.tuple("6")));
x8_upper.add(factory.tuple("Test$3").product(factory.tuple("7")));
bounds.bound(x8, x8_upper);

TupleSet x9_upper = factory.noneOf(2);
x9_upper.add(factory.tuple("Test$0").product(factory.tuple("-8")));
x9_upper.add(factory.tuple("Test$0").product(factory.tuple("-7")));
x9_upper.add(factory.tuple("Test$0").product(factory.tuple("-6")));
x9_upper.add(factory.tuple("Test$0").product(factory.tuple("-5")));
x9_upper.add(factory.tuple("Test$0").product(factory.tuple("-4")));
x9_upper.add(factory.tuple("Test$0").product(factory.tuple("-3")));
x9_upper.add(factory.tuple("Test$0").product(factory.tuple("-2")));
x9_upper.add(factory.tuple("Test$0").product(factory.tuple("-1")));
x9_upper.add(factory.tuple("Test$0").product(factory.tuple("0")));
x9_upper.add(factory.tuple("Test$0").product(factory.tuple("1")));
x9_upper.add(factory.tuple("Test$0").product(factory.tuple("2")));
x9_upper.add(factory.tuple("Test$0").product(factory.tuple("3")));
x9_upper.add(factory.tuple("Test$0").product(factory.tuple("4")));
x9_upper.add(factory.tuple("Test$0").product(factory.tuple("5")));
x9_upper.add(factory.tuple("Test$0").product(factory.tuple("6")));
x9_upper.add(factory.tuple("Test$0").product(factory.tuple("7")));
x9_upper.add(factory.tuple("Test$1").product(factory.tuple("-8")));
x9_upper.add(factory.tuple("Test$1").product(factory.tuple("-7")));
x9_upper.add(factory.tuple("Test$1").product(factory.tuple("-6")));
x9_upper.add(factory.tuple("Test$1").product(factory.tuple("-5")));
x9_upper.add(factory.tuple("Test$1").product(factory.tuple("-4")));
x9_upper.add(factory.tuple("Test$1").product(factory.tuple("-3")));
x9_upper.add(factory.tuple("Test$1").product(factory.tuple("-2")));
x9_upper.add(factory.tuple("Test$1").product(factory.tuple("-1")));
x9_upper.add(factory.tuple("Test$1").product(factory.tuple("0")));
x9_upper.add(factory.tuple("Test$1").product(factory.tuple("1")));
x9_upper.add(factory.tuple("Test$1").product(factory.tuple("2")));
x9_upper.add(factory.tuple("Test$1").product(factory.tuple("3")));
x9_upper.add(factory.tuple("Test$1").product(factory.tuple("4")));
x9_upper.add(factory.tuple("Test$1").product(factory.tuple("5")));
x9_upper.add(factory.tuple("Test$1").product(factory.tuple("6")));
x9_upper.add(factory.tuple("Test$1").product(factory.tuple("7")));
x9_upper.add(factory.tuple("Test$2").product(factory.tuple("-8")));
x9_upper.add(factory.tuple("Test$2").product(factory.tuple("-7")));
x9_upper.add(factory.tuple("Test$2").product(factory.tuple("-6")));
x9_upper.add(factory.tuple("Test$2").product(factory.tuple("-5")));
x9_upper.add(factory.tuple("Test$2").product(factory.tuple("-4")));
x9_upper.add(factory.tuple("Test$2").product(factory.tuple("-3")));
x9_upper.add(factory.tuple("Test$2").product(factory.tuple("-2")));
x9_upper.add(factory.tuple("Test$2").product(factory.tuple("-1")));
x9_upper.add(factory.tuple("Test$2").product(factory.tuple("0")));
x9_upper.add(factory.tuple("Test$2").product(factory.tuple("1")));
x9_upper.add(factory.tuple("Test$2").product(factory.tuple("2")));
x9_upper.add(factory.tuple("Test$2").product(factory.tuple("3")));
x9_upper.add(factory.tuple("Test$2").product(factory.tuple("4")));
x9_upper.add(factory.tuple("Test$2").product(factory.tuple("5")));
x9_upper.add(factory.tuple("Test$2").product(factory.tuple("6")));
x9_upper.add(factory.tuple("Test$2").product(factory.tuple("7")));
x9_upper.add(factory.tuple("Test$3").product(factory.tuple("-8")));
x9_upper.add(factory.tuple("Test$3").product(factory.tuple("-7")));
x9_upper.add(factory.tuple("Test$3").product(factory.tuple("-6")));
x9_upper.add(factory.tuple("Test$3").product(factory.tuple("-5")));
x9_upper.add(factory.tuple("Test$3").product(factory.tuple("-4")));
x9_upper.add(factory.tuple("Test$3").product(factory.tuple("-3")));
x9_upper.add(factory.tuple("Test$3").product(factory.tuple("-2")));
x9_upper.add(factory.tuple("Test$3").product(factory.tuple("-1")));
x9_upper.add(factory.tuple("Test$3").product(factory.tuple("0")));
x9_upper.add(factory.tuple("Test$3").product(factory.tuple("1")));
x9_upper.add(factory.tuple("Test$3").product(factory.tuple("2")));
x9_upper.add(factory.tuple("Test$3").product(factory.tuple("3")));
x9_upper.add(factory.tuple("Test$3").product(factory.tuple("4")));
x9_upper.add(factory.tuple("Test$3").product(factory.tuple("5")));
x9_upper.add(factory.tuple("Test$3").product(factory.tuple("6")));
x9_upper.add(factory.tuple("Test$3").product(factory.tuple("7")));
bounds.bound(x9, x9_upper);

TupleSet x10_upper = factory.noneOf(2);
x10_upper.add(factory.tuple("Test$0").product(factory.tuple("-8")));
x10_upper.add(factory.tuple("Test$0").product(factory.tuple("-7")));
x10_upper.add(factory.tuple("Test$0").product(factory.tuple("-6")));
x10_upper.add(factory.tuple("Test$0").product(factory.tuple("-5")));
x10_upper.add(factory.tuple("Test$0").product(factory.tuple("-4")));
x10_upper.add(factory.tuple("Test$0").product(factory.tuple("-3")));
x10_upper.add(factory.tuple("Test$0").product(factory.tuple("-2")));
x10_upper.add(factory.tuple("Test$0").product(factory.tuple("-1")));
x10_upper.add(factory.tuple("Test$0").product(factory.tuple("0")));
x10_upper.add(factory.tuple("Test$0").product(factory.tuple("1")));
x10_upper.add(factory.tuple("Test$0").product(factory.tuple("2")));
x10_upper.add(factory.tuple("Test$0").product(factory.tuple("3")));
x10_upper.add(factory.tuple("Test$0").product(factory.tuple("4")));
x10_upper.add(factory.tuple("Test$0").product(factory.tuple("5")));
x10_upper.add(factory.tuple("Test$0").product(factory.tuple("6")));
x10_upper.add(factory.tuple("Test$0").product(factory.tuple("7")));
x10_upper.add(factory.tuple("Test$1").product(factory.tuple("-8")));
x10_upper.add(factory.tuple("Test$1").product(factory.tuple("-7")));
x10_upper.add(factory.tuple("Test$1").product(factory.tuple("-6")));
x10_upper.add(factory.tuple("Test$1").product(factory.tuple("-5")));
x10_upper.add(factory.tuple("Test$1").product(factory.tuple("-4")));
x10_upper.add(factory.tuple("Test$1").product(factory.tuple("-3")));
x10_upper.add(factory.tuple("Test$1").product(factory.tuple("-2")));
x10_upper.add(factory.tuple("Test$1").product(factory.tuple("-1")));
x10_upper.add(factory.tuple("Test$1").product(factory.tuple("0")));
x10_upper.add(factory.tuple("Test$1").product(factory.tuple("1")));
x10_upper.add(factory.tuple("Test$1").product(factory.tuple("2")));
x10_upper.add(factory.tuple("Test$1").product(factory.tuple("3")));
x10_upper.add(factory.tuple("Test$1").product(factory.tuple("4")));
x10_upper.add(factory.tuple("Test$1").product(factory.tuple("5")));
x10_upper.add(factory.tuple("Test$1").product(factory.tuple("6")));
x10_upper.add(factory.tuple("Test$1").product(factory.tuple("7")));
x10_upper.add(factory.tuple("Test$2").product(factory.tuple("-8")));
x10_upper.add(factory.tuple("Test$2").product(factory.tuple("-7")));
x10_upper.add(factory.tuple("Test$2").product(factory.tuple("-6")));
x10_upper.add(factory.tuple("Test$2").product(factory.tuple("-5")));
x10_upper.add(factory.tuple("Test$2").product(factory.tuple("-4")));
x10_upper.add(factory.tuple("Test$2").product(factory.tuple("-3")));
x10_upper.add(factory.tuple("Test$2").product(factory.tuple("-2")));
x10_upper.add(factory.tuple("Test$2").product(factory.tuple("-1")));
x10_upper.add(factory.tuple("Test$2").product(factory.tuple("0")));
x10_upper.add(factory.tuple("Test$2").product(factory.tuple("1")));
x10_upper.add(factory.tuple("Test$2").product(factory.tuple("2")));
x10_upper.add(factory.tuple("Test$2").product(factory.tuple("3")));
x10_upper.add(factory.tuple("Test$2").product(factory.tuple("4")));
x10_upper.add(factory.tuple("Test$2").product(factory.tuple("5")));
x10_upper.add(factory.tuple("Test$2").product(factory.tuple("6")));
x10_upper.add(factory.tuple("Test$2").product(factory.tuple("7")));
x10_upper.add(factory.tuple("Test$3").product(factory.tuple("-8")));
x10_upper.add(factory.tuple("Test$3").product(factory.tuple("-7")));
x10_upper.add(factory.tuple("Test$3").product(factory.tuple("-6")));
x10_upper.add(factory.tuple("Test$3").product(factory.tuple("-5")));
x10_upper.add(factory.tuple("Test$3").product(factory.tuple("-4")));
x10_upper.add(factory.tuple("Test$3").product(factory.tuple("-3")));
x10_upper.add(factory.tuple("Test$3").product(factory.tuple("-2")));
x10_upper.add(factory.tuple("Test$3").product(factory.tuple("-1")));
x10_upper.add(factory.tuple("Test$3").product(factory.tuple("0")));
x10_upper.add(factory.tuple("Test$3").product(factory.tuple("1")));
x10_upper.add(factory.tuple("Test$3").product(factory.tuple("2")));
x10_upper.add(factory.tuple("Test$3").product(factory.tuple("3")));
x10_upper.add(factory.tuple("Test$3").product(factory.tuple("4")));
x10_upper.add(factory.tuple("Test$3").product(factory.tuple("5")));
x10_upper.add(factory.tuple("Test$3").product(factory.tuple("6")));
x10_upper.add(factory.tuple("Test$3").product(factory.tuple("7")));
bounds.bound(x10, x10_upper);

bounds.boundExactly(-8,factory.range(factory.tuple("-8"),factory.tuple("-8")));
bounds.boundExactly(-7,factory.range(factory.tuple("-7"),factory.tuple("-7")));
bounds.boundExactly(-6,factory.range(factory.tuple("-6"),factory.tuple("-6")));
bounds.boundExactly(-5,factory.range(factory.tuple("-5"),factory.tuple("-5")));
bounds.boundExactly(-4,factory.range(factory.tuple("-4"),factory.tuple("-4")));
bounds.boundExactly(-3,factory.range(factory.tuple("-3"),factory.tuple("-3")));
bounds.boundExactly(-2,factory.range(factory.tuple("-2"),factory.tuple("-2")));
bounds.boundExactly(-1,factory.range(factory.tuple("-1"),factory.tuple("-1")));
bounds.boundExactly(0,factory.range(factory.tuple("0"),factory.tuple("0")));
bounds.boundExactly(1,factory.range(factory.tuple("1"),factory.tuple("1")));
bounds.boundExactly(2,factory.range(factory.tuple("2"),factory.tuple("2")));
bounds.boundExactly(3,factory.range(factory.tuple("3"),factory.tuple("3")));
bounds.boundExactly(4,factory.range(factory.tuple("4"),factory.tuple("4")));
bounds.boundExactly(5,factory.range(factory.tuple("5"),factory.tuple("5")));
bounds.boundExactly(6,factory.range(factory.tuple("6"),factory.tuple("6")));
bounds.boundExactly(7,factory.range(factory.tuple("7"),factory.tuple("7")));

Variable x14=Variable.unary("Pred_this");
Decls x13=x14.oneOf(x6);
Expression x17=x14.join(x7);
Formula x16=x17.one();
Formula x18=x17.in(Expression.INTS);
Formula x15=x16.and(x18);
Formula x12=x15.forAll(x13);
Expression x21=x7.join(Expression.UNIV);
Formula x20=x21.in(x6);
Variable x25=Variable.unary("Pred_this");
Decls x24=x25.oneOf(x6);
Expression x28=x25.join(x8);
Formula x27=x28.one();
Formula x29=x28.in(Expression.INTS);
Formula x26=x27.and(x29);
Formula x23=x26.forAll(x24);
Expression x31=x8.join(Expression.UNIV);
Formula x30=x31.in(x6);
Variable x34=Variable.unary("Pred_this");
Decls x33=x34.oneOf(x6);
Expression x37=x34.join(x9);
Formula x36=x37.one();
Formula x38=x37.in(Expression.INTS);
Formula x35=x36.and(x38);
Formula x32=x35.forAll(x33);
Expression x40=x9.join(Expression.UNIV);
Formula x39=x40.in(x6);
Variable x43=Variable.unary("Pred_this");
Decls x42=x43.oneOf(x6);
Expression x46=x43.join(x10);
Formula x45=x46.one();
Formula x47=x46.in(Expression.INTS);
Formula x44=x45.and(x47);
Formula x41=x44.forAll(x42);
Expression x49=x10.join(Expression.UNIV);
Formula x48=x49.in(x6);
Variable x52=Variable.unary("Pred_this");
Decls x51=x52.oneOf(x6);
Expression x56=x52.join(x10);
Expression x61=x52.join(x7);
IntExpression x60=x61.sum();
Expression x63=x52.join(x8);
IntExpression x62=x63.sum();
IntExpression x59=x60.plus(x62);
Expression x65=x52.join(x9);
IntExpression x64=x65.sum();
IntExpression x58=x59.plus(x64);
Expression x57=x58.toExpression();
Formula x55=x56.eq(x57);
Expression x68=x52.join(x10);
IntExpression x67=x68.sum();
IntExpression x69=IntConstant.constant(4);
Formula x66=x67.lt(x69);
Formula x54=x55.and(x66);
Expression x72=x52.join(x10);
IntExpression x71=x72.sum();
IntExpression x73=IntConstant.constant(-2);
Formula x70=x71.gt(x73);
Formula x53=x54.and(x70);
Formula x50=x53.forAll(x51);
Variable x76=Variable.unary("Pred_test");//Pred_test
Decls x75=x76.oneOf(x6);
Expression x79=x76.join(x10);
IntExpression x78=x79.sum();
IntExpression x80=IntConstant.constant(0);
Formula x77=x78.lt(x80);
Formula x74=x77.forAll(x75);
Formula x81=x0.eq(x0);
Formula x82=x1.eq(x1);
Formula x83=x2.eq(x2);
Formula x84=x3.eq(x3);
Formula x85=x4.eq(x4);
Formula x86=x5.eq(x5);
Formula x87=x6.eq(x6);
Formula x88=x7.eq(x7);
Formula x89=x8.eq(x8);
Formula x90=x9.eq(x9);
Formula x91=x10.eq(x10);
Formula x11=Formula.compose(FormulaOperator.AND, x12, x20, x23, x30, x32, x39, x41, x48, x50, x74, x81, x82, x83, x84, x85, x86, x87, x88, x89, x90, x91);


IntExprReduction ier = new IntExprReduction();
Formula[] formulas = ier.reduceIntExpressions( x12, x20, x23, x30, x32, x39, x41, x48, x50, x74, x81, x82, x83, x84, x85, x86, x87, x88, x89, x90, x91);//x77, x78
Formula newFormula=Formula.compose(FormulaOperator.AND, formulas);
ier.solve(newFormula, bounds, factory, universe,4); 

}}
