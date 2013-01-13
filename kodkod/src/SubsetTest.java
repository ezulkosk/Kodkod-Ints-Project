import java.util.Arrays;
import java.util.List;

import kodkod.arithmetic.IntExprReduction;
import kodkod.ast.*;
import kodkod.ast.operator.*;
import kodkod.instance.*;
import kodkod.engine.*;
import kodkod.engine.satlab.SATFactory;
import kodkod.engine.config.Options;

/* 
  ==================================================
    kodkod formula: 
  ==================================================
    (all Pred_this: this/Test | 
      one (Pred_this . this/Test.field) && 
      (Pred_this . this/Test.field) in ints) && 
    (this/Test.field . univ) in this/Test && 
    (all Pred_this: this/Test | 
      one (Pred_this . this/Test.field2) && 
      (Pred_this . this/Test.field2) in ints) && 
    (this/Test.field2 . univ) in this/Test && 
    (all Pred_this: this/Test | 
      one (Pred_this . this/Test.total) && 
      (Pred_this . this/Test.total) in ints) && 
    (this/Test.total . univ) in this/Test && 
    (all Pred_this: this/Test | 
      (Pred_this . this/Test.total) = Int[int[Pred_this . this/Test.field] + int
      [Pred_this . this/Test.field2]] && 
      (Pred_this . this/Test.field) in (Int[2] + Int[3]) && 
      (Pred_this . this/Test.field2) in Int[-2]) && 
    Int/min = Int/min && 
    Int/zero = Int/zero && 
    Int/max = Int/max && 
    Int/next = Int/next && 
    seq/Int = seq/Int && 
    String = String && 
    this/Test = this/Test && 
    this/Test.field = this/Test.field && 
    this/Test.field2 = this/Test.field2 && 
    this/Test.total = this/Test.total
  ==================================================
*/
public final class SubsetTest {

public static void main(String[] args) throws Exception {

Relation x0 = Relation.unary("Int/min");
Relation x1 = Relation.unary("Int/zero");
Relation x2 = Relation.unary("Int/max");
Relation x3 = Relation.nary("Int/next", 2);
Relation x4 = Relation.unary("seq/Int");
Relation x5 = Relation.unary("String");
Relation x6 = Relation.unary("this/Test");
Relation x7 = Relation.nary("this/Test.field", 2);
Relation x8 = Relation.nary("this/Test.field2", 2);
Relation x9 = Relation.nary("this/Test.total", 2);

List<String> atomlist = Arrays.asList(
 "-1", "-2", "-3", "-4", "-5",
 "-6", "-7", "-8", "0", "1", "2",
 "3", "4", "5", "6", "7", "Test$0"
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
bounds.bound(x9, x9_upper);

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

Variable x13=Variable.unary("Pred_this");
Decls x12=x13.oneOf(x6);
Expression x16=x13.join(x7);
Formula x15=x16.one();
Formula x17=x16.in(Expression.INTS);
Formula x14=x15.and(x17);
Formula x11=x14.forAll(x12);
Expression x20=x7.join(Expression.UNIV);
Formula x19=x20.in(x6);
Variable x24=Variable.unary("Pred_this");
Decls x23=x24.oneOf(x6);
Expression x27=x24.join(x8);
Formula x26=x27.one();
Formula x28=x27.in(Expression.INTS);
Formula x25=x26.and(x28);
Formula x22=x25.forAll(x23);
Expression x30=x8.join(Expression.UNIV);
Formula x29=x30.in(x6);
Variable x33=Variable.unary("Pred_this");
Decls x32=x33.oneOf(x6);
Expression x36=x33.join(x9);
Formula x35=x36.one();
Formula x37=x36.in(Expression.INTS);
Formula x34=x35.and(x37);
Formula x31=x34.forAll(x32);
Expression x39=x9.join(Expression.UNIV);
Formula x38=x39.in(x6);
Variable x42=Variable.unary("Pred_this");
Decls x41=x42.oneOf(x6);
Expression x46=x42.join(x9);
Expression x50=x42.join(x7);
IntExpression x49=x50.sum();
Expression x52=x42.join(x8);
IntExpression x51=x52.sum();
IntExpression x48=x49.plus(x51);
Expression x47=x48.toExpression();
Formula x45=x46.eq(x47);
Expression x54=x42.join(x7);
IntExpression x57=IntConstant.constant(2);
Expression x56=x57.toExpression();
IntExpression x59=IntConstant.constant(3);
Expression x58=x59.toExpression();
Expression x55=x56.union(x58);
Formula x53=x54.in(x55);
Formula x44=x45.and(x53);
Expression x61=x42.join(x8);
IntExpression x63=IntConstant.constant(-2);
Expression x62=x63.toExpression();
Formula x60=x61.in(x62);
Formula x43=x44.and(x60);
Formula x40=x43.forAll(x41);
Formula x64=x0.eq(x0);
Formula x65=x1.eq(x1);
Formula x66=x2.eq(x2);
Formula x67=x3.eq(x3);
Formula x68=x4.eq(x4);
Formula x69=x5.eq(x5);
Formula x70=x6.eq(x6);
Formula x71=x7.eq(x7);
Formula x72=x8.eq(x8);
Formula x73=x9.eq(x9);
Formula x10=Formula.compose(FormulaOperator.AND, x11, x19, x22, x29, x31, x38, x40, x64, x65, x66, x67, x68, x69, x70, x71, x72, x73);


IntExprReduction ier = new IntExprReduction();
Formula[] formulas = ier.reduceIntExpressions( x11, x19, x22, x29, x31, x38, x40, x64, x65, x66, x67, x68, x69, x70, x71, x72, x73);//x77, x78
Formula newFormula=Formula.compose(FormulaOperator.AND, formulas);
ier.solve(newFormula, bounds, factory, universe, 32); 
}}

