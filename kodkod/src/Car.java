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
    no (this/Petrol & this/D) && 
    no (this/A & this/B) && 
    no ((this/Petrol + this/D) & (this/A + this/B)) && 
    one (this/Car . (this/Car -> this/Car.e)) && 
    (this/Car . (this/Car -> this/Car.e)) in (this/Petrol + this/D) && 
    one (this/Car . (this/Car -> this/Car.f)) && 
    (this/Car . (this/Car -> this/Car.f)) in (this/A + this/B) && 
    one (this/Car . (this/Car -> this/Car.w)) && 
    (this/Car . (this/Car -> this/Car.w)) in ints && 
    this/Car.w = Int[int[this/Car.e . this/Part.x] + int[this/Car.f . 
    this/Part.x]] && 
    int[this/Car.w] < 9 && 
    (this/Petrol . this/Part.x) = Int[3] && 
    (this/D . this/Part.x) = Int[4] && 
    (this/A . this/Part.x) = Int[5] && 
    (this/B . this/Part.x) = Int[6] && 
    (all this: this/Petrol + this/D + this/A + this/B | 
      one (this . this/Part.x) && 
      (this . this/Part.x) in ints) && 
    (this/Part.x . univ) in (this/Petrol + this/D + this/A + this/B) && 
    Int/min = Int/min && 
    Int/zero = Int/zero && 
    Int/max = Int/max && 
    Int/next = Int/next && 
    seq/Int = seq/Int && 
    String = String && 
    this/Car = this/Car && 
    this/Petrol = this/Petrol && 
    this/D = this/D && 
    this/A = this/A && 
    this/B = this/B && 
    this/Car.e = this/Car.e && 
    this/Car.f = this/Car.f && 
    this/Car.w = this/Car.w && 
    this/Part.x = this/Part.x
  ==================================================
*/
public final class Car {

public static void main(String[] args) throws Exception {

Relation x0 = Relation.unary("Int/min");
Relation x1 = Relation.unary("Int/zero");
Relation x2 = Relation.unary("Int/max");
Relation x3 = Relation.nary("Int/next", 2);
Relation x4 = Relation.unary("seq/Int");
Relation x5 = Relation.unary("String");
Relation x6 = Relation.unary("this/Car");
Relation x7 = Relation.unary("this/Petrol");
Relation x8 = Relation.unary("this/D");
Relation x9 = Relation.unary("this/A");
Relation x10 = Relation.unary("this/B");
Relation x11 = Relation.unary("this/Car.e");
Relation x12 = Relation.unary("this/Car.f");
Relation x13 = Relation.unary("this/Car.w");
Relation x14 = Relation.nary("this/Part.x", 2);

List<String> atomlist = Arrays.asList(
 "-1", "-2", "-3", "-4", "-5",
 "-6", "-7", "-8", "0", "1", "2",
 "3", "4", "5", "6", "7", "A$0",
 "B$0", "Car$0", "D$0", "Petrol$0"
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
x6_upper.add(factory.tuple("Car$0"));
bounds.boundExactly(x6, x6_upper);

TupleSet x7_upper = factory.noneOf(1);
x7_upper.add(factory.tuple("Petrol$0"));
bounds.boundExactly(x7, x7_upper);

TupleSet x8_upper = factory.noneOf(1);
x8_upper.add(factory.tuple("D$0"));
bounds.boundExactly(x8, x8_upper);

TupleSet x9_upper = factory.noneOf(1);
x9_upper.add(factory.tuple("A$0"));
bounds.boundExactly(x9, x9_upper);

TupleSet x10_upper = factory.noneOf(1);
x10_upper.add(factory.tuple("B$0"));
bounds.boundExactly(x10, x10_upper);

TupleSet x11_upper = factory.noneOf(1);
x11_upper.add(factory.tuple("Petrol$0"));
x11_upper.add(factory.tuple("D$0"));
bounds.bound(x11, x11_upper);

TupleSet x12_upper = factory.noneOf(1);
x12_upper.add(factory.tuple("A$0"));
x12_upper.add(factory.tuple("B$0"));
bounds.bound(x12, x12_upper);

TupleSet x13_upper = factory.noneOf(1);
x13_upper.add(factory.tuple("-8"));
x13_upper.add(factory.tuple("-7"));
x13_upper.add(factory.tuple("-6"));
x13_upper.add(factory.tuple("-5"));
x13_upper.add(factory.tuple("-4"));
x13_upper.add(factory.tuple("-3"));
x13_upper.add(factory.tuple("-2"));
x13_upper.add(factory.tuple("-1"));
x13_upper.add(factory.tuple("0"));
x13_upper.add(factory.tuple("1"));
x13_upper.add(factory.tuple("2"));
x13_upper.add(factory.tuple("3"));
x13_upper.add(factory.tuple("4"));
x13_upper.add(factory.tuple("5"));
x13_upper.add(factory.tuple("6"));
x13_upper.add(factory.tuple("7"));
bounds.bound(x13, x13_upper);

TupleSet x14_upper = factory.noneOf(2);
x14_upper.add(factory.tuple("Petrol$0").product(factory.tuple("-8")));
x14_upper.add(factory.tuple("Petrol$0").product(factory.tuple("-7")));
x14_upper.add(factory.tuple("Petrol$0").product(factory.tuple("-6")));
x14_upper.add(factory.tuple("Petrol$0").product(factory.tuple("-5")));
x14_upper.add(factory.tuple("Petrol$0").product(factory.tuple("-4")));
x14_upper.add(factory.tuple("Petrol$0").product(factory.tuple("-3")));
x14_upper.add(factory.tuple("Petrol$0").product(factory.tuple("-2")));
x14_upper.add(factory.tuple("Petrol$0").product(factory.tuple("-1")));
x14_upper.add(factory.tuple("Petrol$0").product(factory.tuple("0")));
x14_upper.add(factory.tuple("Petrol$0").product(factory.tuple("1")));
x14_upper.add(factory.tuple("Petrol$0").product(factory.tuple("2")));
x14_upper.add(factory.tuple("Petrol$0").product(factory.tuple("3")));
x14_upper.add(factory.tuple("Petrol$0").product(factory.tuple("4")));
x14_upper.add(factory.tuple("Petrol$0").product(factory.tuple("5")));
x14_upper.add(factory.tuple("Petrol$0").product(factory.tuple("6")));
x14_upper.add(factory.tuple("Petrol$0").product(factory.tuple("7")));
x14_upper.add(factory.tuple("D$0").product(factory.tuple("-8")));
x14_upper.add(factory.tuple("D$0").product(factory.tuple("-7")));
x14_upper.add(factory.tuple("D$0").product(factory.tuple("-6")));
x14_upper.add(factory.tuple("D$0").product(factory.tuple("-5")));
x14_upper.add(factory.tuple("D$0").product(factory.tuple("-4")));
x14_upper.add(factory.tuple("D$0").product(factory.tuple("-3")));
x14_upper.add(factory.tuple("D$0").product(factory.tuple("-2")));
x14_upper.add(factory.tuple("D$0").product(factory.tuple("-1")));
x14_upper.add(factory.tuple("D$0").product(factory.tuple("0")));
x14_upper.add(factory.tuple("D$0").product(factory.tuple("1")));
x14_upper.add(factory.tuple("D$0").product(factory.tuple("2")));
x14_upper.add(factory.tuple("D$0").product(factory.tuple("3")));
x14_upper.add(factory.tuple("D$0").product(factory.tuple("4")));
x14_upper.add(factory.tuple("D$0").product(factory.tuple("5")));
x14_upper.add(factory.tuple("D$0").product(factory.tuple("6")));
x14_upper.add(factory.tuple("D$0").product(factory.tuple("7")));
x14_upper.add(factory.tuple("A$0").product(factory.tuple("-8")));
x14_upper.add(factory.tuple("A$0").product(factory.tuple("-7")));
x14_upper.add(factory.tuple("A$0").product(factory.tuple("-6")));
x14_upper.add(factory.tuple("A$0").product(factory.tuple("-5")));
x14_upper.add(factory.tuple("A$0").product(factory.tuple("-4")));
x14_upper.add(factory.tuple("A$0").product(factory.tuple("-3")));
x14_upper.add(factory.tuple("A$0").product(factory.tuple("-2")));
x14_upper.add(factory.tuple("A$0").product(factory.tuple("-1")));
x14_upper.add(factory.tuple("A$0").product(factory.tuple("0")));
x14_upper.add(factory.tuple("A$0").product(factory.tuple("1")));
x14_upper.add(factory.tuple("A$0").product(factory.tuple("2")));
x14_upper.add(factory.tuple("A$0").product(factory.tuple("3")));
x14_upper.add(factory.tuple("A$0").product(factory.tuple("4")));
x14_upper.add(factory.tuple("A$0").product(factory.tuple("5")));
x14_upper.add(factory.tuple("A$0").product(factory.tuple("6")));
x14_upper.add(factory.tuple("A$0").product(factory.tuple("7")));
x14_upper.add(factory.tuple("B$0").product(factory.tuple("-8")));
x14_upper.add(factory.tuple("B$0").product(factory.tuple("-7")));
x14_upper.add(factory.tuple("B$0").product(factory.tuple("-6")));
x14_upper.add(factory.tuple("B$0").product(factory.tuple("-5")));
x14_upper.add(factory.tuple("B$0").product(factory.tuple("-4")));
x14_upper.add(factory.tuple("B$0").product(factory.tuple("-3")));
x14_upper.add(factory.tuple("B$0").product(factory.tuple("-2")));
x14_upper.add(factory.tuple("B$0").product(factory.tuple("-1")));
x14_upper.add(factory.tuple("B$0").product(factory.tuple("0")));
x14_upper.add(factory.tuple("B$0").product(factory.tuple("1")));
x14_upper.add(factory.tuple("B$0").product(factory.tuple("2")));
x14_upper.add(factory.tuple("B$0").product(factory.tuple("3")));
x14_upper.add(factory.tuple("B$0").product(factory.tuple("4")));
x14_upper.add(factory.tuple("B$0").product(factory.tuple("5")));
x14_upper.add(factory.tuple("B$0").product(factory.tuple("6")));
x14_upper.add(factory.tuple("B$0").product(factory.tuple("7")));
bounds.bound(x14, x14_upper);

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

Expression x17=x7.intersection(x8);
Formula x16=x17.no();
Expression x19=x9.intersection(x10);
Formula x18=x19.no();
Expression x22=x7.union(x8);
Expression x23=x9.union(x10);
Expression x21=x22.intersection(x23);
Formula x20=x21.no();
Expression x27=x6.product(x11);
Expression x26=x6.join(x27);
Formula x25=x26.one();
Formula x28=x26.in(x22);
Formula x24=x25.and(x28);
Expression x32=x6.product(x12);
Expression x31=x6.join(x32);
Formula x30=x31.one();
Formula x33=x31.in(x23);
Formula x29=x30.and(x33);
Expression x37=x6.product(x13);
Expression x36=x6.join(x37);
Formula x35=x36.one();
Formula x38=x36.in(Expression.INTS);
Formula x34=x35.and(x38);
Expression x45=x11.join(x14);
IntExpression x44=x45.sum();
Expression x47=x12.join(x14);
IntExpression x46=x47.sum();
IntExpression x43=x44.plus(x46);
Expression x42=x43.toExpression();
Formula x41=x13.eq(x42);
IntExpression x49=x13.sum();
IntExpression x50=IntConstant.constant(9);
Formula x48=x49.lt(x50);
Formula x40=x41.and(x48);
Expression x52=x7.join(x14);
IntExpression x54=IntConstant.constant(3);
Expression x53=x54.toExpression();
Formula x51=x52.eq(x53);
Expression x56=x8.join(x14);
IntExpression x58=IntConstant.constant(4);
Expression x57=x58.toExpression();
Formula x55=x56.eq(x57);
Expression x60=x9.join(x14);
IntExpression x62=IntConstant.constant(5);
Expression x61=x62.toExpression();
Formula x59=x60.eq(x61);
Expression x64=x10.join(x14);
IntExpression x66=IntConstant.constant(6);
Expression x65=x66.toExpression();
Formula x63=x64.eq(x65);
Variable x69=Variable.unary("this");
Expression x70=x22.union(x23);
Decls x68=x69.oneOf(x70);
Expression x73=x69.join(x14);
Formula x72=x73.one();
Formula x74=x73.in(Expression.INTS);
Formula x71=x72.and(x74);
Formula x67=x71.forAll(x68);
Expression x76=x14.join(Expression.UNIV);
Formula x75=x76.in(x70);
Formula x78=x0.eq(x0);
Formula x79=x1.eq(x1);
Formula x80=x2.eq(x2);
Formula x81=x3.eq(x3);
Formula x82=x4.eq(x4);
Formula x83=x5.eq(x5);
Formula x84=x6.eq(x6);
Formula x85=x7.eq(x7);
Formula x86=x8.eq(x8);
Formula x87=x9.eq(x9);
Formula x88=x10.eq(x10);
Formula x89=x11.eq(x11);
Formula x90=x12.eq(x12);
Formula x91=x13.eq(x13);
Formula x92=x14.eq(x14);
Formula x15=Formula.compose(FormulaOperator.AND, x16, x18, x20, x24, x29, x34, x40, x51, x55, x59, x63, x67, x75, x78, x79, x80, x81, x82, x83, x84, x85, x86, x87, x88, x89, x90, x91, x92);


IntExprReduction ier = new IntExprReduction();
Formula[] formulas = ier.reduceIntExpressions(x16, x18, x20, x24, x29, x34, x40, x51, x55, x59, x63, x67, x75, x78, x79, x80, x81, x82, x83, x84, x85, x86, x87, x88, x89, x90, x91, x92);//x77, x78
Formula newf=Formula.compose(FormulaOperator.AND, formulas);
ier.solve(newf, bounds, factory, universe, 32);}} 
