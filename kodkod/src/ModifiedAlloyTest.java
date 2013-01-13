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
      one (p_this . this/S.X) && 
      (p_this . this/S.X) in ints) && 
    (this/S.X . univ) in this/S && 
    Int/min = Int/min && 
    Int/zero = Int/zero && 
    Int/max = Int/max && 
    Int/next = Int/next && 
    seq/Int = seq/Int && 
    String = String && 
    this/S = this/S && 
    this/S.X = this/S.X
  ==================================================
*/
public final class ModifiedAlloyTest {

public static void main(String[] args) throws Exception {

Relation x0 = Relation.unary("Int/min");
Relation x1 = Relation.unary("Int/zero");
Relation x2 = Relation.unary("Int/max");
Relation x3 = Relation.nary("Int/next", 2);
Relation x4 = Relation.unary("seq/Int");
Relation x5 = Relation.unary("String");
Relation x6 = Relation.unary("this/S");
Relation x7 = Relation.nary("this/S.X", 2);

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
x7_upper.add(factory.tuple("A%").product(factory.tuple("15")));
x7_upper.add(factory.tuple("B%").product(factory.tuple("16")));
x7_upper.add(factory.tuple("C%").product(factory.tuple("23")));
x7_upper.add(factory.tuple("D%").product(factory.tuple("100")));
bounds.boundExactly(x7, x7_upper);

bounds.boundExactly(-2,factory.range(factory.tuple("-2"),factory.tuple("-2")));
bounds.boundExactly(-1,factory.range(factory.tuple("-1"),factory.tuple("-1")));
bounds.boundExactly(0,factory.range(factory.tuple("0"),factory.tuple("0")));
bounds.boundExactly(1,factory.range(factory.tuple("1"),factory.tuple("1")));
bounds.boundExactly(15,factory.range(factory.tuple("15"),factory.tuple("15")));
bounds.boundExactly(16,factory.range(factory.tuple("16"),factory.tuple("16")));
bounds.boundExactly(23,factory.range(factory.tuple("23"),factory.tuple("23")));
bounds.boundExactly(100,factory.range(factory.tuple("100"),factory.tuple("100")));

Variable x11=Variable.unary("p_this");
Decls x10=x11.oneOf(x6);
Expression x14=x11.join(x7);
Formula x13=x14.one();
Formula x15=x14.in(Expression.INTS);
Formula x12=x13.and(x15);
Formula x9=x12.forAll(x10);
Expression x18=x7.join(Expression.UNIV);
Formula x17=x18.in(x6);
Formula x20=x0.eq(x0);
Formula x21=x1.eq(x1);
Formula x22=x2.eq(x2);
Formula x23=x3.eq(x3);
Formula x24=x4.eq(x4);
Formula x25=x5.eq(x5);
Formula x26=x6.eq(x6);
Formula x27=x7.eq(x7);
Formula x8=Formula.compose(FormulaOperator.AND, x9, x17, x20, x21, x22, x23, x24, x25, x26, x27);

IntExprReduction ier = new IntExprReduction();
Formula[] formulas = ier.reduceIntExpressions(x9, x17, x20, x21, x22, x23, x24, x25, x26, x27);//x77, x78
Formula newFormula=Formula.compose(FormulaOperator.AND, formulas);
ier.solve(newFormula, bounds, factory, universe, 32); }}