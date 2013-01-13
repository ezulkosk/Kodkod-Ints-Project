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
    (all p_this: this/S | 
      one (p_this . this/S.Weight) && 
      (p_this . this/S.Weight) in ints) && 
    (this/S.Weight . univ) in this/S && 
    (all p_this: this/S | 
      one (p_this . this/S.X) && 
      (p_this . this/S.X) in ints) && 
    (this/S.X . univ) in this/S && 
    (all p_this: this/S | 
      one (p_this . this/S.Y) && 
      (p_this . this/S.Y) in ints) && 
    (this/S.Y . univ) in this/S && 
    (all p_this: this/S | 
      (p_this . this/S.Weight) = Int[int[p_this . this/S.X] + int[p_this . 
      this/S.Y]]) && 
    Int/min = Int/min && 
    Int/zero = Int/zero && 
    Int/max = Int/max && 
    Int/next = Int/next && 
    seq/Int = seq/Int && 
    String = String && 
    this/S = this/S && 
    this/S.Weight = this/S.Weight && 
    this/S.X = this/S.X && 
    this/S.Y = this/S.Y
  ==================================================
*/
public final class ModifiedAlloyWeight {

public static void main(String[] args) throws Exception {

Relation x0 = Relation.unary("Int/min");
Relation x1 = Relation.unary("Int/zero");
Relation x2 = Relation.unary("Int/max");
Relation x3 = Relation.nary("Int/next", 2);
Relation x4 = Relation.unary("seq/Int");
Relation x5 = Relation.unary("String");
Relation x6 = Relation.unary("this/S");
Relation x7 = Relation.nary("this/S.Weight", 2);
Relation x8 = Relation.nary("this/S.X", 2);
Relation x9 = Relation.nary("this/S.Y", 2);

List<String> atomlist = Arrays.asList(
 "-1", "-2", "0", "1", "100",
 "15", "16", "23", "A%", "B%", "C%",
 "D%"
);

Universe universe = new Universe(atomlist);
TupleFactory factory = universe.factory();
Bounds bounds = new Bounds(universe);

TupleSet x0_upper = factory.noneOf(1);
x0_upper.add(factory.tuple("-2"));
bounds.boundExactly(x0, x0_upper);

TupleSet x1_upper = factory.noneOf(1);
x1_upper.add(factory.tuple("0"));
bounds.boundExactly(x1, x1_upper);

TupleSet x2_upper = factory.noneOf(1);
x2_upper.add(factory.tuple("100"));
bounds.boundExactly(x2, x2_upper);

TupleSet x3_upper = factory.noneOf(2);
x3_upper.add(factory.tuple("-2").product(factory.tuple("-1")));
x3_upper.add(factory.tuple("-1").product(factory.tuple("0")));
x3_upper.add(factory.tuple("0").product(factory.tuple("1")));
x3_upper.add(factory.tuple("1").product(factory.tuple("15")));
x3_upper.add(factory.tuple("15").product(factory.tuple("16")));
x3_upper.add(factory.tuple("16").product(factory.tuple("23")));
x3_upper.add(factory.tuple("23").product(factory.tuple("100")));
bounds.boundExactly(x3, x3_upper);

TupleSet x4_upper = factory.noneOf(1);
x4_upper.add(factory.tuple("0"));
bounds.boundExactly(x4, x4_upper);

TupleSet x5_upper = factory.noneOf(1);
bounds.boundExactly(x5, x5_upper);

TupleSet x6_upper = factory.noneOf(1);
x6_upper.add(factory.tuple("A%"));
x6_upper.add(factory.tuple("B%"));
x6_upper.add(factory.tuple("C%"));
x6_upper.add(factory.tuple("D%"));
bounds.boundExactly(x6, x6_upper);

TupleSet x7_upper = factory.noneOf(2);
x7_upper.add(factory.tuple("A%").product(factory.tuple("-2")));
x7_upper.add(factory.tuple("A%").product(factory.tuple("-1")));
x7_upper.add(factory.tuple("A%").product(factory.tuple("0")));
x7_upper.add(factory.tuple("A%").product(factory.tuple("1")));
x7_upper.add(factory.tuple("A%").product(factory.tuple("15")));
x7_upper.add(factory.tuple("A%").product(factory.tuple("16")));
x7_upper.add(factory.tuple("A%").product(factory.tuple("23")));
x7_upper.add(factory.tuple("A%").product(factory.tuple("100")));
x7_upper.add(factory.tuple("B%").product(factory.tuple("-2")));
x7_upper.add(factory.tuple("B%").product(factory.tuple("-1")));
x7_upper.add(factory.tuple("B%").product(factory.tuple("0")));
x7_upper.add(factory.tuple("B%").product(factory.tuple("1")));
x7_upper.add(factory.tuple("B%").product(factory.tuple("15")));
x7_upper.add(factory.tuple("B%").product(factory.tuple("16")));
x7_upper.add(factory.tuple("B%").product(factory.tuple("23")));
x7_upper.add(factory.tuple("B%").product(factory.tuple("100")));
x7_upper.add(factory.tuple("C%").product(factory.tuple("-2")));
x7_upper.add(factory.tuple("C%").product(factory.tuple("-1")));
x7_upper.add(factory.tuple("C%").product(factory.tuple("0")));
x7_upper.add(factory.tuple("C%").product(factory.tuple("1")));
x7_upper.add(factory.tuple("C%").product(factory.tuple("15")));
x7_upper.add(factory.tuple("C%").product(factory.tuple("16")));
x7_upper.add(factory.tuple("C%").product(factory.tuple("23")));
x7_upper.add(factory.tuple("C%").product(factory.tuple("100")));
x7_upper.add(factory.tuple("D%").product(factory.tuple("-2")));
x7_upper.add(factory.tuple("D%").product(factory.tuple("-1")));
x7_upper.add(factory.tuple("D%").product(factory.tuple("0")));
x7_upper.add(factory.tuple("D%").product(factory.tuple("1")));
x7_upper.add(factory.tuple("D%").product(factory.tuple("15")));
x7_upper.add(factory.tuple("D%").product(factory.tuple("16")));
x7_upper.add(factory.tuple("D%").product(factory.tuple("23")));
x7_upper.add(factory.tuple("D%").product(factory.tuple("100")));
bounds.bound(x7, x7_upper);

TupleSet x8_upper = factory.noneOf(2);
x8_upper.add(factory.tuple("A%").product(factory.tuple("15")));
x8_upper.add(factory.tuple("B%").product(factory.tuple("16")));
x8_upper.add(factory.tuple("C%").product(factory.tuple("23")));
x8_upper.add(factory.tuple("D%").product(factory.tuple("100")));
bounds.boundExactly(x8, x8_upper);

TupleSet x9_upper = factory.noneOf(2);
x9_upper.add(factory.tuple("A%").product(factory.tuple("-2")));
x9_upper.add(factory.tuple("A%").product(factory.tuple("-1")));
x9_upper.add(factory.tuple("A%").product(factory.tuple("0")));
x9_upper.add(factory.tuple("A%").product(factory.tuple("1")));
x9_upper.add(factory.tuple("A%").product(factory.tuple("15")));
x9_upper.add(factory.tuple("A%").product(factory.tuple("16")));
x9_upper.add(factory.tuple("A%").product(factory.tuple("23")));
x9_upper.add(factory.tuple("A%").product(factory.tuple("100")));
x9_upper.add(factory.tuple("B%").product(factory.tuple("-2")));
x9_upper.add(factory.tuple("B%").product(factory.tuple("-1")));
x9_upper.add(factory.tuple("B%").product(factory.tuple("0")));
x9_upper.add(factory.tuple("B%").product(factory.tuple("1")));
x9_upper.add(factory.tuple("B%").product(factory.tuple("15")));
x9_upper.add(factory.tuple("B%").product(factory.tuple("16")));
x9_upper.add(factory.tuple("B%").product(factory.tuple("23")));
x9_upper.add(factory.tuple("B%").product(factory.tuple("100")));
x9_upper.add(factory.tuple("C%").product(factory.tuple("-2")));
x9_upper.add(factory.tuple("C%").product(factory.tuple("-1")));
x9_upper.add(factory.tuple("C%").product(factory.tuple("0")));
x9_upper.add(factory.tuple("C%").product(factory.tuple("1")));
x9_upper.add(factory.tuple("C%").product(factory.tuple("15")));
x9_upper.add(factory.tuple("C%").product(factory.tuple("16")));
x9_upper.add(factory.tuple("C%").product(factory.tuple("23")));
x9_upper.add(factory.tuple("C%").product(factory.tuple("100")));
x9_upper.add(factory.tuple("D%").product(factory.tuple("-2")));
x9_upper.add(factory.tuple("D%").product(factory.tuple("-1")));
x9_upper.add(factory.tuple("D%").product(factory.tuple("0")));
x9_upper.add(factory.tuple("D%").product(factory.tuple("1")));
x9_upper.add(factory.tuple("D%").product(factory.tuple("15")));
x9_upper.add(factory.tuple("D%").product(factory.tuple("16")));
x9_upper.add(factory.tuple("D%").product(factory.tuple("23")));
x9_upper.add(factory.tuple("D%").product(factory.tuple("100")));
bounds.bound(x9, x9_upper);

bounds.boundExactly(-2,factory.range(factory.tuple("-2"),factory.tuple("-2")));
bounds.boundExactly(-1,factory.range(factory.tuple("-1"),factory.tuple("-1")));
bounds.boundExactly(0,factory.range(factory.tuple("0"),factory.tuple("0")));
bounds.boundExactly(1,factory.range(factory.tuple("1"),factory.tuple("1")));
bounds.boundExactly(15,factory.range(factory.tuple("15"),factory.tuple("15")));
bounds.boundExactly(16,factory.range(factory.tuple("16"),factory.tuple("16")));
bounds.boundExactly(23,factory.range(factory.tuple("23"),factory.tuple("23")));
bounds.boundExactly(100,factory.range(factory.tuple("100"),factory.tuple("100")));

Variable x13=Variable.unary("p_this");
Decls x12=x13.oneOf(x6);
Expression x16=x13.join(x7);
Formula x15=x16.one();
Formula x17=x16.in(Expression.INTS);
Formula x14=x15.and(x17);
Formula x11=x14.forAll(x12);
Expression x20=x7.join(Expression.UNIV);
Formula x19=x20.in(x6);
Variable x24=Variable.unary("p_this");
Decls x23=x24.oneOf(x6);
Expression x27=x24.join(x8);
Formula x26=x27.one();
Formula x28=x27.in(Expression.INTS);
Formula x25=x26.and(x28);
Formula x22=x25.forAll(x23);
Expression x30=x8.join(Expression.UNIV);
Formula x29=x30.in(x6);
Variable x33=Variable.unary("p_this");
Decls x32=x33.oneOf(x6);
Expression x36=x33.join(x9);
Formula x35=x36.one();
Formula x37=x36.in(Expression.INTS);
Formula x34=x35.and(x37);
Formula x31=x34.forAll(x32);
Expression x39=x9.join(Expression.UNIV);
Formula x38=x39.in(x6);
Variable x42=Variable.unary("p_this");
Decls x41=x42.oneOf(x6);
Expression x44=x42.join(x7);
Expression x48=x42.join(x8);
IntExpression x47=x48.sum();
Expression x50=x42.join(x9);
IntExpression x49=x50.sum();
IntExpression x46=x47.plus(x49);
Expression x45=x46.toExpression();
Formula x43=x44.eq(x45);
Formula x40=x43.forAll(x41);
Formula x51=x0.eq(x0);
Formula x52=x1.eq(x1);
Formula x53=x2.eq(x2);
Formula x54=x3.eq(x3);
Formula x55=x4.eq(x4);
Formula x56=x5.eq(x5);
Formula x57=x6.eq(x6);
Formula x58=x7.eq(x7);
Formula x59=x8.eq(x8);
Formula x60=x9.eq(x9);
Formula x10=Formula.compose(FormulaOperator.AND, x11, x19, x22, x29, x31, x38, x40, x51, x52, x53, x54, x55, x56, x57, x58, x59, x60);

IntExprReduction ier = new IntExprReduction();
Formula[] formulas = ier.reduceIntExpressions(x11, x19, x22, x29, x31, x38, x40, x51, x52, x53, x54, x55, x56, x57, x58, x59, x60);//x77, x78
Formula newFormula=Formula.compose(FormulaOperator.AND, formulas);
ier.solve(newFormula, bounds, factory, universe, 32); }}