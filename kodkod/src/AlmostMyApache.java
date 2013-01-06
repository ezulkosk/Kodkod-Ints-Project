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
    (all this: this/Apache | 
      one (this . this/Apache.base) && 
      (this . this/Apache.base) in ints) && 
    (this/Apache.base . univ) in this/Apache && 
    (all this: this/Apache | 
      one (this . this/Apache.HNL) && 
      (this . this/Apache.HNL) in ints) && 
    (this/Apache.HNL . univ) in this/Apache && 
    (all this: this/Apache | 
      one (this . this/Apache.KA) && 
      (this . this/Apache.KA) in ints) && 
    (this/Apache.KA . univ) in this/Apache && 
    (all this: this/Apache | 
      one (this . this/Apache.enableSend) && 
      (this . this/Apache.enableSend) in ints) && 
    (this/Apache.enableSend . univ) in this/Apache && 
    (all this: this/Apache | 
      one (this . this/Apache.followSym) && 
      (this . this/Apache.followSym) in ints) && 
    (this/Apache.followSym . univ) in this/Apache && 
    (all this: this/Apache | 
      one (this . this/Apache.accessLog) && 
      (this . this/Apache.accessLog) in ints) && 
    (this/Apache.accessLog . univ) in this/Apache && 
    (all this: this/Apache | 
      one (this . this/Apache.ES) && 
      (this . this/Apache.ES) in ints) && 
    (this/Apache.ES . univ) in this/Apache && 
    (all this: this/Apache | 
      one (this . this/Apache.mem) && 
      (this . this/Apache.mem) in ints) && 
    (this/Apache.mem . univ) in this/Apache && 
    (all this: this/Apache | 
      one (this . this/Apache.handle) && 
      (this . this/Apache.handle) in ints) && 
    (this/Apache.handle . univ) in this/Apache && 
    (all this: this/Apache | 
      one (this . this/Apache.total) && 
      (this . this/Apache.total) in ints) && 
    (this/Apache.total . univ) in this/Apache && 
    (all this: this/Apache | 
      ((this . this/Apache.base) = Int[0] || 
       (this . this/Apache.base) = Int[150]) && 
      ((this . this/Apache.HNL) = Int[0] || 
       (this . this/Apache.HNL) = Int[-26]) && 
      ((this . this/Apache.enableSend) = Int[0] || 
       (this . this/Apache.enableSend) = Int[15]) && 
      ((this . this/Apache.mem) = Int[0] || 
       (this . this/Apache.mem) = Int[26]) && 
      ((this . this/Apache.handle) = Int[0] || 
       (this . this/Apache.handle) = Int[4]) && 
      (this . this/Apache.followSym) = Int[0] && 
      (this . this/Apache.total) = Int[int[this . this/Apache.base] + int[this . 
      this/Apache.HNL] + int[this . this/Apache.KA] + int[this . 
      this/Apache.enableSend] + int[this . this/Apache.followSym] + int[this . 
      this/Apache.accessLog] + int[this . this/Apache.ES] + int[this . 
      this/Apache.mem] + int[this . this/Apache.handle]] && 
      ((this . this/Apache.KA) = Int[0] || 
       (this . this/Apache.KA) = Int[105]) && 
      ((this . this/Apache.accessLog) = Int[0] || 
       (this . this/Apache.accessLog) = Int[-15]) && 
      ((this . this/Apache.ES) = Int[0] || 
       (this . this/Apache.ES) = Int[-11])) && 
    Int/min = Int/min && 
    Int/zero = Int/zero && 
    Int/max = Int/max && 
    Int/next = Int/next && 
    seq/Int = seq/Int && 
    String = String && 
    this/Apache = this/Apache && 
    this/Apache.base = this/Apache.base && 
    this/Apache.HNL = this/Apache.HNL && 
    this/Apache.KA = this/Apache.KA && 
    this/Apache.enableSend = this/Apache.enableSend && 
    this/Apache.followSym = this/Apache.followSym && 
    this/Apache.accessLog = this/Apache.accessLog && 
    this/Apache.ES = this/Apache.ES && 
    this/Apache.mem = this/Apache.mem && 
    this/Apache.handle = this/Apache.handle && 
    this/Apache.total = this/Apache.total
  ==================================================
*/
public final class AlmostMyApache {

public static void main(String[] args) throws Exception {

Relation x0 = Relation.unary("Int/min");
Relation x1 = Relation.unary("Int/zero");
Relation x2 = Relation.unary("Int/max");


Relation x5 = Relation.unary("String");
Relation x6 = Relation.unary("this/Apache");
Relation x7 = Relation.nary("this/Apache.base", 2);
Relation x8 = Relation.nary("this/Apache.HNL", 2);
Relation x9 = Relation.nary("this/Apache.KA", 2);
Relation x10 = Relation.nary("this/Apache.enableSend", 2);
Relation x11 = Relation.nary("this/Apache.followSym", 2);
Relation x12 = Relation.nary("this/Apache.accessLog", 2);
Relation x13 = Relation.nary("this/Apache.ES", 2);
Relation x14 = Relation.nary("this/Apache.mem", 2);
Relation x15 = Relation.nary("this/Apache.handle", 2);
Relation x16 = Relation.nary("this/Apache.total", 2);

List<String> atomlist = Arrays.asList(
 "-4000000" ,"4000000", "0","150","-26", "105","15","-15","-11","26", "4", "Apache$0"
);

Universe universe = new Universe(atomlist);
TupleFactory factory = universe.factory();
Bounds bounds = new Bounds(universe);

TupleSet x0_upper = factory.noneOf(1);
x0_upper.add(factory.tuple("-4000000"));
bounds.boundExactly(x0, x0_upper);

TupleSet x1_upper = factory.noneOf(1);
x1_upper.add(factory.tuple("0"));
bounds.boundExactly(x1, x1_upper);

TupleSet x2_upper = factory.noneOf(1);
x2_upper.add(factory.tuple("4000000"));
bounds.boundExactly(x2, x2_upper);




TupleSet x5_upper = factory.noneOf(1);
bounds.boundExactly(x5, x5_upper);

TupleSet x6_upper = factory.noneOf(1);
x6_upper.add(factory.tuple("Apache$0"));
bounds.boundExactly(x6, x6_upper);

TupleSet x7_upper = factory.noneOf(2);
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("0")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("150")));
bounds.bound(x7, x7_upper);

TupleSet x8_upper = factory.noneOf(2);
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("0")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("-26")));
bounds.bound(x8, x8_upper);

TupleSet x9_upper = factory.noneOf(2);
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("0")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("105")));
bounds.bound(x9, x9_upper);

TupleSet x10_upper = factory.noneOf(2);
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("0")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("15")));
bounds.bound(x10, x10_upper);

TupleSet x11_upper = factory.noneOf(2);
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("0")));
bounds.bound(x11, x11_upper);

TupleSet x12_upper = factory.noneOf(2);
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("0")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("-15")));
bounds.bound(x12, x12_upper);

TupleSet x13_upper = factory.noneOf(2);
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("0")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("-11")));
bounds.bound(x13, x13_upper);

TupleSet x14_upper = factory.noneOf(2);
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("0")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("26")));
bounds.bound(x14, x14_upper);

TupleSet x15_upper = factory.noneOf(2);
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("0")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("4")));
bounds.bound(x15, x15_upper);

TupleSet x16_upper = factory.noneOf(2);
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("0")));
bounds.bound(x16, x16_upper);

bounds.boundExactly(150,factory.range(factory.tuple("150"),factory.tuple("150")));
bounds.boundExactly(-26,factory.range(factory.tuple("-26"),factory.tuple("-26")));
bounds.boundExactly(105,factory.range(factory.tuple("105"),factory.tuple("105")));
bounds.boundExactly(15,factory.range(factory.tuple("15"),factory.tuple("15")));
bounds.boundExactly(0,factory.range(factory.tuple("0"),factory.tuple("0")));
bounds.boundExactly(-15,factory.range(factory.tuple("-15"),factory.tuple("-15")));
bounds.boundExactly(-11,factory.range(factory.tuple("-11"),factory.tuple("-11")));
bounds.boundExactly(26,factory.range(factory.tuple("26"),factory.tuple("26")));
bounds.boundExactly(4,factory.range(factory.tuple("4"),factory.tuple("4")));

Variable x20=Variable.unary("this");
Decls x19=x20.oneOf(x6);
Expression x23=x20.join(x7);
Formula x22=x23.one();
Formula x24=x23.in(Expression.INTS);
Formula x21=x22.and(x24);
Formula x18=x21.forAll(x19);
Expression x27=x7.join(Expression.UNIV);
Formula x26=x27.in(x6);
Variable x31=Variable.unary("this");
Decls x30=x31.oneOf(x6);
Expression x34=x31.join(x8);
Formula x33=x34.one();
Formula x35=x34.in(Expression.INTS);
Formula x32=x33.and(x35);
Formula x29=x32.forAll(x30);
Expression x37=x8.join(Expression.UNIV);
Formula x36=x37.in(x6);
Variable x40=Variable.unary("this");
Decls x39=x40.oneOf(x6);
Expression x43=x40.join(x9);
Formula x42=x43.one();
Formula x44=x43.in(Expression.INTS);
Formula x41=x42.and(x44);
Formula x38=x41.forAll(x39);
Expression x46=x9.join(Expression.UNIV);
Formula x45=x46.in(x6);
Variable x49=Variable.unary("this");
Decls x48=x49.oneOf(x6);
Expression x52=x49.join(x10);
Formula x51=x52.one();
Formula x53=x52.in(Expression.INTS);
Formula x50=x51.and(x53);
Formula x47=x50.forAll(x48);
Expression x55=x10.join(Expression.UNIV);
Formula x54=x55.in(x6);
Variable x58=Variable.unary("this");
Decls x57=x58.oneOf(x6);
Expression x61=x58.join(x11);
Formula x60=x61.one();
Formula x62=x61.in(Expression.INTS);
Formula x59=x60.and(x62);
Formula x56=x59.forAll(x57);
Expression x64=x11.join(Expression.UNIV);
Formula x63=x64.in(x6);
Variable x67=Variable.unary("this");
Decls x66=x67.oneOf(x6);
Expression x70=x67.join(x12);
Formula x69=x70.one();
Formula x71=x70.in(Expression.INTS);
Formula x68=x69.and(x71);
Formula x65=x68.forAll(x66);
Expression x73=x12.join(Expression.UNIV);
Formula x72=x73.in(x6);
Variable x76=Variable.unary("this");
Decls x75=x76.oneOf(x6);
Expression x79=x76.join(x13);
Formula x78=x79.one();
Formula x80=x79.in(Expression.INTS);
Formula x77=x78.and(x80);
Formula x74=x77.forAll(x75);
Expression x82=x13.join(Expression.UNIV);
Formula x81=x82.in(x6);
Variable x85=Variable.unary("this");
Decls x84=x85.oneOf(x6);
Expression x88=x85.join(x14);
Formula x87=x88.one();
Formula x89=x88.in(Expression.INTS);
Formula x86=x87.and(x89);
Formula x83=x86.forAll(x84);
Expression x91=x14.join(Expression.UNIV);
Formula x90=x91.in(x6);
Variable x94=Variable.unary("this");
Decls x93=x94.oneOf(x6);
Expression x97=x94.join(x15);
Formula x96=x97.one();
Formula x98=x97.in(Expression.INTS);
Formula x95=x96.and(x98);
Formula x92=x95.forAll(x93);
Expression x100=x15.join(Expression.UNIV);
Formula x99=x100.in(x6);
Variable x103=Variable.unary("this");
Decls x102=x103.oneOf(x6);
Expression x106=x103.join(x16);
Formula x105=x106.one();
Formula x107=x106.in(Expression.INTS);
Formula x104=x105.and(x107);
Formula x101=x104.forAll(x102);
Expression x109=x16.join(Expression.UNIV);
Formula x108=x109.in(x6);
Variable x112=Variable.unary("this");
Decls x111=x112.oneOf(x6);
Expression x117=x112.join(x7);
IntExpression x119=IntConstant.constant(0);
Expression x118=x119.toExpression();
Formula x116=x117.eq(x118);
Expression x121=x112.join(x7);
IntExpression x123=IntConstant.constant(150);
Expression x122=x123.toExpression();
Formula x120=x121.eq(x122);
Formula x115=x116.or(x120);
Expression x128=x112.join(x8);
IntExpression x130=IntConstant.constant(0);
Expression x129=x130.toExpression();
Formula x127=x128.eq(x129);
Expression x132=x112.join(x8);
IntExpression x134=IntConstant.constant(-26);
Expression x133=x134.toExpression();
Formula x131=x132.eq(x133);
Formula x126=x127.or(x131);
Expression x139=x112.join(x10);
IntExpression x141=IntConstant.constant(0);
Expression x140=x141.toExpression();
Formula x138=x139.eq(x140);
Expression x143=x112.join(x10);
IntExpression x145=IntConstant.constant(15);
Expression x144=x145.toExpression();
Formula x142=x143.eq(x144);
Formula x137=x138.or(x142);
Expression x148=x112.join(x14);
IntExpression x150=IntConstant.constant(0);
Expression x149=x150.toExpression();
Formula x147=x148.eq(x149);
Expression x152=x112.join(x14);
IntExpression x154=IntConstant.constant(26);
Expression x153=x154.toExpression();
Formula x151=x152.eq(x153);
Formula x146=x147.or(x151);
Formula x136=x137.and(x146);
Expression x157=x112.join(x15);
IntExpression x159=IntConstant.constant(0);
Expression x158=x159.toExpression();
Formula x156=x157.eq(x158);
Expression x161=x112.join(x15);
IntExpression x163=IntConstant.constant(4);
Expression x162=x163.toExpression();
Formula x160=x161.eq(x162);
Formula x155=x156.or(x160);
Formula x135=x136.and(x155);
Formula x125=x126.and(x135);
Expression x166=x112.join(x11);
IntExpression x168=IntConstant.constant(0);
Expression x167=x168.toExpression();
Formula x165=x166.eq(x167);
Expression x170=x112.join(x16);
Expression x181=x112.join(x7);
IntExpression x180=x181.sum();
Expression x183=x112.join(x8);
IntExpression x182=x183.sum();
IntExpression x179=x180.plus(x182);
Expression x185=x112.join(x9);
IntExpression x184=x185.sum();
IntExpression x178=x179.plus(x184);
Expression x187=x112.join(x10);
IntExpression x186=x187.sum();
IntExpression x177=x178.plus(x186);
Expression x189=x112.join(x11);
IntExpression x188=x189.sum();
IntExpression x176=x177.plus(x188);
Expression x191=x112.join(x12);
IntExpression x190=x191.sum();
IntExpression x175=x176.plus(x190);
Expression x193=x112.join(x13);
IntExpression x192=x193.sum();
IntExpression x174=x175.plus(x192);
Expression x195=x112.join(x14);
IntExpression x194=x195.sum();
IntExpression x173=x174.plus(x194);
Expression x197=x112.join(x15);
IntExpression x196=x197.sum();
IntExpression x172=x173.plus(x196);
Expression x171=x172.toExpression();
Formula x169=x170.eq(x171);
Formula x164=x165.and(x169);
Formula x124=x125.and(x164);
Formula x114=x115.and(x124);
Expression x202=x112.join(x9);
IntExpression x204=IntConstant.constant(0);
Expression x203=x204.toExpression();
Formula x201=x202.eq(x203);
Expression x206=x112.join(x9);
IntExpression x208=IntConstant.constant(105);
Expression x207=x208.toExpression();
Formula x205=x206.eq(x207);
Formula x200=x201.or(x205);
Expression x211=x112.join(x12);
IntExpression x213=IntConstant.constant(0);
Expression x212=x213.toExpression();
Formula x210=x211.eq(x212);
Expression x215=x112.join(x12);
IntExpression x217=IntConstant.constant(-15);
Expression x216=x217.toExpression();
Formula x214=x215.eq(x216);
Formula x209=x210.or(x214);
Formula x199=x200.and(x209);
Expression x220=x112.join(x13);
IntExpression x222=IntConstant.constant(0);
Expression x221=x222.toExpression();
Formula x219=x220.eq(x221);
Expression x224=x112.join(x13);
IntExpression x226=IntConstant.constant(-11);
Expression x225=x226.toExpression();
Formula x223=x224.eq(x225);
Formula x218=x219.or(x223);
Formula x198=x199.and(x218);
Formula x113=x114.and(x198);
Formula x110=x113.forAll(x111);
Formula x227=x0.eq(x0);
Formula x228=x1.eq(x1);
Formula x229=x2.eq(x2);

Formula x232=x5.eq(x5);
Formula x233=x6.eq(x6);
Formula x234=x7.eq(x7);
Formula x235=x8.eq(x8);
Formula x236=x9.eq(x9);
Formula x237=x10.eq(x10);
Formula x238=x11.eq(x11);
Formula x239=x12.eq(x12);
Formula x240=x13.eq(x13);
Formula x241=x14.eq(x14);
Formula x242=x15.eq(x15);
Formula x243=x16.eq(x16);
Formula x17=Formula.compose(FormulaOperator.AND, x18, x26, x29, x36, x38, x45, x47, x54, x56, x63, x65, x72, x74, x81, x83, x90, x92, x99, x101, x108, x110, x227, x228, x229, x232, x233, x234, x235, x236, x237, x238, x239, x240, x241, x242, x243);

IntExprReduction ier = new IntExprReduction();
Formula[] formulas = ier.reduceIntExpressions(x18, x26, x29, x36, x38, x45, x47, x54, x56, x63, x65, x72, x74, x81, x83, x90, x92, x99, x101, x108, x110, x227, x228, x229,  x232, x233, x234, x235, x236, x237, x238, x239, x240, x241, x242, x243);//x77, x78
Formula newFormula=Formula.compose(FormulaOperator.AND, formulas);
ier.solve(newFormula, bounds, factory, universe, 32); 


}}
