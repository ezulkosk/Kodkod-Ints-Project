import kodkod.arithmetic.IntExprReduction;
import java.util.Arrays;
import java.util.List;
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
    (all this: this/Test | 
      lone (this . this/Test.weight) && 
      (this . this/Test.weight) in ints) && 
    (this/Test.weight . univ) in this/Test && 
    (all this: this/Test | 
      one (this . this/Test.x) && 
      (this . this/Test.x) in this/X) && 
    (this/Test.x . univ) in this/Test && 
    (all this: this/Test | 
      one (this . this/Test.y) && 
      (this . this/Test.y) in this/Y) && 
    (this/Test.y . univ) in this/Test && 
    (all this: this/Test | 
      (this . this/Test.weight) = Int[int[(this . this/Test.x) . this/X.ref] + 
      int[(this . this/Test.y) . this/Y.ref]]) && 
    (all this: this/X | 
      one (this . this/X.ref) && 
      (this . this/X.ref) in ints) && 
    (this/X.ref . univ) in this/X && 
    (all this: this/Y | 
      one (this . this/Y.ref) && 
      (this . this/Y.ref) in ints) && 
    (this/Y.ref . univ) in this/Y && 
    Int/min = Int/min && 
    Int/zero = Int/zero && 
    Int/max = Int/max && 
    Int/next = Int/next && 
    seq/Int = seq/Int && 
    String = String && 
    this/Test = this/Test && 
    this/X = this/X && 
    this/Y = this/Y && 
    this/Test.weight = this/Test.weight && 
    this/Test.x = this/Test.x && 
    this/Test.y = this/Test.y && 
    this/X.ref = this/X.ref && 
    this/Y.ref = this/Y.ref
  ==================================================
*/
public final class MultiSigLone {

public static void main(String[] args) throws Exception {

Relation x0 = Relation.unary("Int/min");
Relation x1 = Relation.unary("Int/zero");
Relation x2 = Relation.unary("Int/max");
Relation x3 = Relation.nary("Int/next", 2);
Relation x4 = Relation.unary("seq/Int");
Relation x5 = Relation.unary("String");
Relation x6 = Relation.unary("this/Test");
Relation x7 = Relation.unary("this/X");
Relation x8 = Relation.unary("this/Y");
Relation x9 = Relation.nary("this/Test.weight", 2);
Relation x10 = Relation.nary("this/Test.x", 2);
Relation x11 = Relation.nary("this/Test.y", 2);
Relation x12 = Relation.nary("this/X.ref", 2);
Relation x13 = Relation.nary("this/Y.ref", 2);

List<String> atomlist = Arrays.asList(
 "-1", "-2", "-3", "-4", "-5",
 "-6", "-7", "-8", "0", "1", "2",
 "3", "4", "5", "6", "7", "Test$0",
 "Test$1", "Test$2", "X$0", "Y$0"
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
bounds.boundExactly(x6, x6_upper);

TupleSet x7_upper = factory.noneOf(1);
x7_upper.add(factory.tuple("X$0"));
bounds.bound(x7, x7_upper);

TupleSet x8_upper = factory.noneOf(1);
x8_upper.add(factory.tuple("Y$0"));
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
bounds.bound(x9, x9_upper);

TupleSet x10_upper = factory.noneOf(2);
x10_upper.add(factory.tuple("Test$0").product(factory.tuple("X$0")));
x10_upper.add(factory.tuple("Test$1").product(factory.tuple("X$0")));
x10_upper.add(factory.tuple("Test$2").product(factory.tuple("X$0")));
bounds.bound(x10, x10_upper);

TupleSet x11_upper = factory.noneOf(2);
x11_upper.add(factory.tuple("Test$0").product(factory.tuple("Y$0")));
x11_upper.add(factory.tuple("Test$1").product(factory.tuple("Y$0")));
x11_upper.add(factory.tuple("Test$2").product(factory.tuple("Y$0")));
bounds.bound(x11, x11_upper);

TupleSet x12_upper = factory.noneOf(2);
x12_upper.add(factory.tuple("X$0").product(factory.tuple("-8")));
x12_upper.add(factory.tuple("X$0").product(factory.tuple("-7")));
x12_upper.add(factory.tuple("X$0").product(factory.tuple("-6")));
x12_upper.add(factory.tuple("X$0").product(factory.tuple("-5")));
x12_upper.add(factory.tuple("X$0").product(factory.tuple("-4")));
x12_upper.add(factory.tuple("X$0").product(factory.tuple("-3")));
x12_upper.add(factory.tuple("X$0").product(factory.tuple("-2")));
x12_upper.add(factory.tuple("X$0").product(factory.tuple("-1")));
x12_upper.add(factory.tuple("X$0").product(factory.tuple("0")));
x12_upper.add(factory.tuple("X$0").product(factory.tuple("1")));
x12_upper.add(factory.tuple("X$0").product(factory.tuple("2")));
x12_upper.add(factory.tuple("X$0").product(factory.tuple("3")));
x12_upper.add(factory.tuple("X$0").product(factory.tuple("4")));
x12_upper.add(factory.tuple("X$0").product(factory.tuple("5")));
x12_upper.add(factory.tuple("X$0").product(factory.tuple("6")));
x12_upper.add(factory.tuple("X$0").product(factory.tuple("7")));
bounds.bound(x12, x12_upper);

TupleSet x13_upper = factory.noneOf(2);
x13_upper.add(factory.tuple("Y$0").product(factory.tuple("-8")));
x13_upper.add(factory.tuple("Y$0").product(factory.tuple("-7")));
x13_upper.add(factory.tuple("Y$0").product(factory.tuple("-6")));
x13_upper.add(factory.tuple("Y$0").product(factory.tuple("-5")));
x13_upper.add(factory.tuple("Y$0").product(factory.tuple("-4")));
x13_upper.add(factory.tuple("Y$0").product(factory.tuple("-3")));
x13_upper.add(factory.tuple("Y$0").product(factory.tuple("-2")));
x13_upper.add(factory.tuple("Y$0").product(factory.tuple("-1")));
x13_upper.add(factory.tuple("Y$0").product(factory.tuple("0")));
x13_upper.add(factory.tuple("Y$0").product(factory.tuple("1")));
x13_upper.add(factory.tuple("Y$0").product(factory.tuple("2")));
x13_upper.add(factory.tuple("Y$0").product(factory.tuple("3")));
x13_upper.add(factory.tuple("Y$0").product(factory.tuple("4")));
x13_upper.add(factory.tuple("Y$0").product(factory.tuple("5")));
x13_upper.add(factory.tuple("Y$0").product(factory.tuple("6")));
x13_upper.add(factory.tuple("Y$0").product(factory.tuple("7")));
bounds.bound(x13, x13_upper);

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

Variable x17=Variable.unary("this");
Decls x16=x17.oneOf(x6);
Expression x20=x17.join(x9);
Formula x19=x20.lone();
Formula x21=x20.in(Expression.INTS);
Formula x18=x19.and(x21);
Formula x15=x18.forAll(x16);
Expression x24=x9.join(Expression.UNIV);
Formula x23=x24.in(x6);
Variable x28=Variable.unary("this");
Decls x27=x28.oneOf(x6);
Expression x31=x28.join(x10);
Formula x30=x31.one();
Formula x32=x31.in(x7);
Formula x29=x30.and(x32);
Formula x26=x29.forAll(x27);
Expression x34=x10.join(Expression.UNIV);
Formula x33=x34.in(x6);
Variable x37=Variable.unary("this");
Decls x36=x37.oneOf(x6);
Expression x40=x37.join(x11);
Formula x39=x40.one();
Formula x41=x40.in(x8);
Formula x38=x39.and(x41);
Formula x35=x38.forAll(x36);
Expression x43=x11.join(Expression.UNIV);
Formula x42=x43.in(x6);
Variable x46=Variable.unary("this");
Decls x45=x46.oneOf(x6);
Expression x48=x46.join(x9);
Expression x53=x46.join(x10);
Expression x52=x53.join(x12);
IntExpression x51=x52.sum();
Expression x56=x46.join(x11);
Expression x55=x56.join(x13);
IntExpression x54=x55.sum();
IntExpression x50=x51.plus(x54);
Expression x49=x50.toExpression();
Formula x47=x48.eq(x49);
Formula x44=x47.forAll(x45);
Variable x59=Variable.unary("this");
Decls x58=x59.oneOf(x7);
Expression x62=x59.join(x12);
Formula x61=x62.one();
Formula x63=x62.in(Expression.INTS);
Formula x60=x61.and(x63);
Formula x57=x60.forAll(x58);
Expression x65=x12.join(Expression.UNIV);
Formula x64=x65.in(x7);
Variable x68=Variable.unary("this");
Decls x67=x68.oneOf(x8);
Expression x71=x68.join(x13);
Formula x70=x71.one();
Formula x72=x71.in(Expression.INTS);
Formula x69=x70.and(x72);
Formula x66=x69.forAll(x67);
Expression x74=x13.join(Expression.UNIV);
Formula x73=x74.in(x8);
Formula x75=x0.eq(x0);
Formula x76=x1.eq(x1);
Formula x77=x2.eq(x2);
Formula x78=x3.eq(x3);
Formula x79=x4.eq(x4);
Formula x80=x5.eq(x5);
Formula x81=x6.eq(x6);
Formula x82=x7.eq(x7);
Formula x83=x8.eq(x8);
Formula x84=x9.eq(x9);
Formula x85=x10.eq(x10);
Formula x86=x11.eq(x11);
Formula x87=x12.eq(x12);
Formula x88=x13.eq(x13);
IntExprReduction ier = new IntExprReduction();
Formula[] formulas = ier.reduceIntExpressions(x15,x23,x26,x33,x35,x42,x44,x57,x64,x66,x73,x75,x76,x77,x78,x79,x80,x81,x82,x83,x84,x85,x86,x87,x88);
Formula newFormula=Formula.compose(FormulaOperator.AND, formulas);
ier.solve(newFormula, bounds, factory, universe, 32);
}}
