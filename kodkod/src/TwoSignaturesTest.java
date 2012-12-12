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
    (all Pred_this: this/Test2 | 
      one (Pred_this . this/Test2.x) && 
      (Pred_this . this/Test2.x) in ints) && 
    (this/Test2.x . univ) in this/Test2 && 
    (all Pred_this: this/Test2 | 
      one (Pred_this . this/Test2.y) && 
      (Pred_this . this/Test2.y) in ints) && 
    (this/Test2.y . univ) in this/Test2 && 
    (all Pred_this: this/Test2 | 
      one (Pred_this . this/Test2.z) && 
      (Pred_this . this/Test2.z) in ints) && 
    (this/Test2.z . univ) in this/Test2 && 
    (all Pred_this: this/Test2 | 
      one (Pred_this . this/Test2.weight) && 
      (Pred_this . this/Test2.weight) in ints) && 
    (this/Test2.weight . univ) in this/Test2 && 
    (all Pred_this: this/Test2 | 
      (Pred_this . this/Test2.weight) = Int[int[Pred_this . this/Test2.x] + int[
      Pred_this . this/Test2.y] + int[Pred_this . this/Test2.z]] && 
      int[Pred_this . this/Test2.weight] < 4 && 
      int[Pred_this . this/Test2.weight] > -2) && 
    Int/min = Int/min && 
    Int/zero = Int/zero && 
    Int/max = Int/max && 
    Int/next = Int/next && 
    seq/Int = seq/Int && 
    String = String && 
    this/Test = this/Test && 
    this/Test2 = this/Test2 && 
    this/Test.x = this/Test.x && 
    this/Test.y = this/Test.y && 
    this/Test.z = this/Test.z && 
    this/Test.weight = this/Test.weight && 
    this/Test2.x = this/Test2.x && 
    this/Test2.y = this/Test2.y && 
    this/Test2.z = this/Test2.z && 
    this/Test2.weight = this/Test2.weight
  ==================================================
*/
public final class TwoSignaturesTest {

public static void main(String[] args) throws Exception {

Relation x0 = Relation.unary("Int/min");
Relation x1 = Relation.unary("Int/zero");
Relation x2 = Relation.unary("Int/max");
Relation x3 = Relation.nary("Int/next", 2);
Relation x4 = Relation.unary("seq/Int");
Relation x5 = Relation.unary("String");
Relation x6 = Relation.unary("this/Test");
Relation x7 = Relation.unary("this/Test2");
Relation x8 = Relation.nary("this/Test.x", 2);
Relation x9 = Relation.nary("this/Test.y", 2);
Relation x10 = Relation.nary("this/Test.z", 2);
Relation x11 = Relation.nary("this/Test.weight", 2);
Relation x12 = Relation.nary("this/Test2.x", 2);
Relation x13 = Relation.nary("this/Test2.y", 2);
Relation x14 = Relation.nary("this/Test2.z", 2);
Relation x15 = Relation.nary("this/Test2.weight", 2);

List<String> atomlist = Arrays.asList(
 "-1", "-2", "-3", "-4", "-5",
 "-6", "-7", "-8", "0", "1", "2",
 "3", "4", "5", "6", "7", "Test$0",
 "Test$1", "Test$2", "Test$3", "Test$4", "Test2$0", "Test2$1",
 "Test2$2", "Test2$3"
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
x6_upper.add(factory.tuple("Test$4"));
bounds.boundExactly(x6, x6_upper);

TupleSet x7_upper = factory.noneOf(1);
x7_upper.add(factory.tuple("Test2$0"));
x7_upper.add(factory.tuple("Test2$1"));
x7_upper.add(factory.tuple("Test2$2"));
x7_upper.add(factory.tuple("Test2$3"));
bounds.boundExactly(x7, x7_upper);

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
x8_upper.add(factory.tuple("Test$4").product(factory.tuple("-8")));
x8_upper.add(factory.tuple("Test$4").product(factory.tuple("-7")));
x8_upper.add(factory.tuple("Test$4").product(factory.tuple("-6")));
x8_upper.add(factory.tuple("Test$4").product(factory.tuple("-5")));
x8_upper.add(factory.tuple("Test$4").product(factory.tuple("-4")));
x8_upper.add(factory.tuple("Test$4").product(factory.tuple("-3")));
x8_upper.add(factory.tuple("Test$4").product(factory.tuple("-2")));
x8_upper.add(factory.tuple("Test$4").product(factory.tuple("-1")));
x8_upper.add(factory.tuple("Test$4").product(factory.tuple("0")));
x8_upper.add(factory.tuple("Test$4").product(factory.tuple("1")));
x8_upper.add(factory.tuple("Test$4").product(factory.tuple("2")));
x8_upper.add(factory.tuple("Test$4").product(factory.tuple("3")));
x8_upper.add(factory.tuple("Test$4").product(factory.tuple("4")));
x8_upper.add(factory.tuple("Test$4").product(factory.tuple("5")));
x8_upper.add(factory.tuple("Test$4").product(factory.tuple("6")));
x8_upper.add(factory.tuple("Test$4").product(factory.tuple("7")));
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
x9_upper.add(factory.tuple("Test$4").product(factory.tuple("-8")));
x9_upper.add(factory.tuple("Test$4").product(factory.tuple("-7")));
x9_upper.add(factory.tuple("Test$4").product(factory.tuple("-6")));
x9_upper.add(factory.tuple("Test$4").product(factory.tuple("-5")));
x9_upper.add(factory.tuple("Test$4").product(factory.tuple("-4")));
x9_upper.add(factory.tuple("Test$4").product(factory.tuple("-3")));
x9_upper.add(factory.tuple("Test$4").product(factory.tuple("-2")));
x9_upper.add(factory.tuple("Test$4").product(factory.tuple("-1")));
x9_upper.add(factory.tuple("Test$4").product(factory.tuple("0")));
x9_upper.add(factory.tuple("Test$4").product(factory.tuple("1")));
x9_upper.add(factory.tuple("Test$4").product(factory.tuple("2")));
x9_upper.add(factory.tuple("Test$4").product(factory.tuple("3")));
x9_upper.add(factory.tuple("Test$4").product(factory.tuple("4")));
x9_upper.add(factory.tuple("Test$4").product(factory.tuple("5")));
x9_upper.add(factory.tuple("Test$4").product(factory.tuple("6")));
x9_upper.add(factory.tuple("Test$4").product(factory.tuple("7")));
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
x10_upper.add(factory.tuple("Test$4").product(factory.tuple("-8")));
x10_upper.add(factory.tuple("Test$4").product(factory.tuple("-7")));
x10_upper.add(factory.tuple("Test$4").product(factory.tuple("-6")));
x10_upper.add(factory.tuple("Test$4").product(factory.tuple("-5")));
x10_upper.add(factory.tuple("Test$4").product(factory.tuple("-4")));
x10_upper.add(factory.tuple("Test$4").product(factory.tuple("-3")));
x10_upper.add(factory.tuple("Test$4").product(factory.tuple("-2")));
x10_upper.add(factory.tuple("Test$4").product(factory.tuple("-1")));
x10_upper.add(factory.tuple("Test$4").product(factory.tuple("0")));
x10_upper.add(factory.tuple("Test$4").product(factory.tuple("1")));
x10_upper.add(factory.tuple("Test$4").product(factory.tuple("2")));
x10_upper.add(factory.tuple("Test$4").product(factory.tuple("3")));
x10_upper.add(factory.tuple("Test$4").product(factory.tuple("4")));
x10_upper.add(factory.tuple("Test$4").product(factory.tuple("5")));
x10_upper.add(factory.tuple("Test$4").product(factory.tuple("6")));
x10_upper.add(factory.tuple("Test$4").product(factory.tuple("7")));
bounds.bound(x10, x10_upper);

TupleSet x11_upper = factory.noneOf(2);
x11_upper.add(factory.tuple("Test$0").product(factory.tuple("-8")));
x11_upper.add(factory.tuple("Test$0").product(factory.tuple("-7")));
x11_upper.add(factory.tuple("Test$0").product(factory.tuple("-6")));
x11_upper.add(factory.tuple("Test$0").product(factory.tuple("-5")));
x11_upper.add(factory.tuple("Test$0").product(factory.tuple("-4")));
x11_upper.add(factory.tuple("Test$0").product(factory.tuple("-3")));
x11_upper.add(factory.tuple("Test$0").product(factory.tuple("-2")));
x11_upper.add(factory.tuple("Test$0").product(factory.tuple("-1")));
x11_upper.add(factory.tuple("Test$0").product(factory.tuple("0")));
x11_upper.add(factory.tuple("Test$0").product(factory.tuple("1")));
x11_upper.add(factory.tuple("Test$0").product(factory.tuple("2")));
x11_upper.add(factory.tuple("Test$0").product(factory.tuple("3")));
x11_upper.add(factory.tuple("Test$0").product(factory.tuple("4")));
x11_upper.add(factory.tuple("Test$0").product(factory.tuple("5")));
x11_upper.add(factory.tuple("Test$0").product(factory.tuple("6")));
x11_upper.add(factory.tuple("Test$0").product(factory.tuple("7")));
x11_upper.add(factory.tuple("Test$1").product(factory.tuple("-8")));
x11_upper.add(factory.tuple("Test$1").product(factory.tuple("-7")));
x11_upper.add(factory.tuple("Test$1").product(factory.tuple("-6")));
x11_upper.add(factory.tuple("Test$1").product(factory.tuple("-5")));
x11_upper.add(factory.tuple("Test$1").product(factory.tuple("-4")));
x11_upper.add(factory.tuple("Test$1").product(factory.tuple("-3")));
x11_upper.add(factory.tuple("Test$1").product(factory.tuple("-2")));
x11_upper.add(factory.tuple("Test$1").product(factory.tuple("-1")));
x11_upper.add(factory.tuple("Test$1").product(factory.tuple("0")));
x11_upper.add(factory.tuple("Test$1").product(factory.tuple("1")));
x11_upper.add(factory.tuple("Test$1").product(factory.tuple("2")));
x11_upper.add(factory.tuple("Test$1").product(factory.tuple("3")));
x11_upper.add(factory.tuple("Test$1").product(factory.tuple("4")));
x11_upper.add(factory.tuple("Test$1").product(factory.tuple("5")));
x11_upper.add(factory.tuple("Test$1").product(factory.tuple("6")));
x11_upper.add(factory.tuple("Test$1").product(factory.tuple("7")));
x11_upper.add(factory.tuple("Test$2").product(factory.tuple("-8")));
x11_upper.add(factory.tuple("Test$2").product(factory.tuple("-7")));
x11_upper.add(factory.tuple("Test$2").product(factory.tuple("-6")));
x11_upper.add(factory.tuple("Test$2").product(factory.tuple("-5")));
x11_upper.add(factory.tuple("Test$2").product(factory.tuple("-4")));
x11_upper.add(factory.tuple("Test$2").product(factory.tuple("-3")));
x11_upper.add(factory.tuple("Test$2").product(factory.tuple("-2")));
x11_upper.add(factory.tuple("Test$2").product(factory.tuple("-1")));
x11_upper.add(factory.tuple("Test$2").product(factory.tuple("0")));
x11_upper.add(factory.tuple("Test$2").product(factory.tuple("1")));
x11_upper.add(factory.tuple("Test$2").product(factory.tuple("2")));
x11_upper.add(factory.tuple("Test$2").product(factory.tuple("3")));
x11_upper.add(factory.tuple("Test$2").product(factory.tuple("4")));
x11_upper.add(factory.tuple("Test$2").product(factory.tuple("5")));
x11_upper.add(factory.tuple("Test$2").product(factory.tuple("6")));
x11_upper.add(factory.tuple("Test$2").product(factory.tuple("7")));
x11_upper.add(factory.tuple("Test$3").product(factory.tuple("-8")));
x11_upper.add(factory.tuple("Test$3").product(factory.tuple("-7")));
x11_upper.add(factory.tuple("Test$3").product(factory.tuple("-6")));
x11_upper.add(factory.tuple("Test$3").product(factory.tuple("-5")));
x11_upper.add(factory.tuple("Test$3").product(factory.tuple("-4")));
x11_upper.add(factory.tuple("Test$3").product(factory.tuple("-3")));
x11_upper.add(factory.tuple("Test$3").product(factory.tuple("-2")));
x11_upper.add(factory.tuple("Test$3").product(factory.tuple("-1")));
x11_upper.add(factory.tuple("Test$3").product(factory.tuple("0")));
x11_upper.add(factory.tuple("Test$3").product(factory.tuple("1")));
x11_upper.add(factory.tuple("Test$3").product(factory.tuple("2")));
x11_upper.add(factory.tuple("Test$3").product(factory.tuple("3")));
x11_upper.add(factory.tuple("Test$3").product(factory.tuple("4")));
x11_upper.add(factory.tuple("Test$3").product(factory.tuple("5")));
x11_upper.add(factory.tuple("Test$3").product(factory.tuple("6")));
x11_upper.add(factory.tuple("Test$3").product(factory.tuple("7")));
x11_upper.add(factory.tuple("Test$4").product(factory.tuple("-8")));
x11_upper.add(factory.tuple("Test$4").product(factory.tuple("-7")));
x11_upper.add(factory.tuple("Test$4").product(factory.tuple("-6")));
x11_upper.add(factory.tuple("Test$4").product(factory.tuple("-5")));
x11_upper.add(factory.tuple("Test$4").product(factory.tuple("-4")));
x11_upper.add(factory.tuple("Test$4").product(factory.tuple("-3")));
x11_upper.add(factory.tuple("Test$4").product(factory.tuple("-2")));
x11_upper.add(factory.tuple("Test$4").product(factory.tuple("-1")));
x11_upper.add(factory.tuple("Test$4").product(factory.tuple("0")));
x11_upper.add(factory.tuple("Test$4").product(factory.tuple("1")));
x11_upper.add(factory.tuple("Test$4").product(factory.tuple("2")));
x11_upper.add(factory.tuple("Test$4").product(factory.tuple("3")));
x11_upper.add(factory.tuple("Test$4").product(factory.tuple("4")));
x11_upper.add(factory.tuple("Test$4").product(factory.tuple("5")));
x11_upper.add(factory.tuple("Test$4").product(factory.tuple("6")));
x11_upper.add(factory.tuple("Test$4").product(factory.tuple("7")));
bounds.bound(x11, x11_upper);

TupleSet x12_upper = factory.noneOf(2);
x12_upper.add(factory.tuple("Test2$0").product(factory.tuple("-8")));
x12_upper.add(factory.tuple("Test2$0").product(factory.tuple("-7")));
x12_upper.add(factory.tuple("Test2$0").product(factory.tuple("-6")));
x12_upper.add(factory.tuple("Test2$0").product(factory.tuple("-5")));
x12_upper.add(factory.tuple("Test2$0").product(factory.tuple("-4")));
x12_upper.add(factory.tuple("Test2$0").product(factory.tuple("-3")));
x12_upper.add(factory.tuple("Test2$0").product(factory.tuple("-2")));
x12_upper.add(factory.tuple("Test2$0").product(factory.tuple("-1")));
x12_upper.add(factory.tuple("Test2$0").product(factory.tuple("0")));
x12_upper.add(factory.tuple("Test2$0").product(factory.tuple("1")));
x12_upper.add(factory.tuple("Test2$0").product(factory.tuple("2")));
x12_upper.add(factory.tuple("Test2$0").product(factory.tuple("3")));
x12_upper.add(factory.tuple("Test2$0").product(factory.tuple("4")));
x12_upper.add(factory.tuple("Test2$0").product(factory.tuple("5")));
x12_upper.add(factory.tuple("Test2$0").product(factory.tuple("6")));
x12_upper.add(factory.tuple("Test2$0").product(factory.tuple("7")));
x12_upper.add(factory.tuple("Test2$1").product(factory.tuple("-8")));
x12_upper.add(factory.tuple("Test2$1").product(factory.tuple("-7")));
x12_upper.add(factory.tuple("Test2$1").product(factory.tuple("-6")));
x12_upper.add(factory.tuple("Test2$1").product(factory.tuple("-5")));
x12_upper.add(factory.tuple("Test2$1").product(factory.tuple("-4")));
x12_upper.add(factory.tuple("Test2$1").product(factory.tuple("-3")));
x12_upper.add(factory.tuple("Test2$1").product(factory.tuple("-2")));
x12_upper.add(factory.tuple("Test2$1").product(factory.tuple("-1")));
x12_upper.add(factory.tuple("Test2$1").product(factory.tuple("0")));
x12_upper.add(factory.tuple("Test2$1").product(factory.tuple("1")));
x12_upper.add(factory.tuple("Test2$1").product(factory.tuple("2")));
x12_upper.add(factory.tuple("Test2$1").product(factory.tuple("3")));
x12_upper.add(factory.tuple("Test2$1").product(factory.tuple("4")));
x12_upper.add(factory.tuple("Test2$1").product(factory.tuple("5")));
x12_upper.add(factory.tuple("Test2$1").product(factory.tuple("6")));
x12_upper.add(factory.tuple("Test2$1").product(factory.tuple("7")));
x12_upper.add(factory.tuple("Test2$2").product(factory.tuple("-8")));
x12_upper.add(factory.tuple("Test2$2").product(factory.tuple("-7")));
x12_upper.add(factory.tuple("Test2$2").product(factory.tuple("-6")));
x12_upper.add(factory.tuple("Test2$2").product(factory.tuple("-5")));
x12_upper.add(factory.tuple("Test2$2").product(factory.tuple("-4")));
x12_upper.add(factory.tuple("Test2$2").product(factory.tuple("-3")));
x12_upper.add(factory.tuple("Test2$2").product(factory.tuple("-2")));
x12_upper.add(factory.tuple("Test2$2").product(factory.tuple("-1")));
x12_upper.add(factory.tuple("Test2$2").product(factory.tuple("0")));
x12_upper.add(factory.tuple("Test2$2").product(factory.tuple("1")));
x12_upper.add(factory.tuple("Test2$2").product(factory.tuple("2")));
x12_upper.add(factory.tuple("Test2$2").product(factory.tuple("3")));
x12_upper.add(factory.tuple("Test2$2").product(factory.tuple("4")));
x12_upper.add(factory.tuple("Test2$2").product(factory.tuple("5")));
x12_upper.add(factory.tuple("Test2$2").product(factory.tuple("6")));
x12_upper.add(factory.tuple("Test2$2").product(factory.tuple("7")));
x12_upper.add(factory.tuple("Test2$3").product(factory.tuple("-8")));
x12_upper.add(factory.tuple("Test2$3").product(factory.tuple("-7")));
x12_upper.add(factory.tuple("Test2$3").product(factory.tuple("-6")));
x12_upper.add(factory.tuple("Test2$3").product(factory.tuple("-5")));
x12_upper.add(factory.tuple("Test2$3").product(factory.tuple("-4")));
x12_upper.add(factory.tuple("Test2$3").product(factory.tuple("-3")));
x12_upper.add(factory.tuple("Test2$3").product(factory.tuple("-2")));
x12_upper.add(factory.tuple("Test2$3").product(factory.tuple("-1")));
x12_upper.add(factory.tuple("Test2$3").product(factory.tuple("0")));
x12_upper.add(factory.tuple("Test2$3").product(factory.tuple("1")));
x12_upper.add(factory.tuple("Test2$3").product(factory.tuple("2")));
x12_upper.add(factory.tuple("Test2$3").product(factory.tuple("3")));
x12_upper.add(factory.tuple("Test2$3").product(factory.tuple("4")));
x12_upper.add(factory.tuple("Test2$3").product(factory.tuple("5")));
x12_upper.add(factory.tuple("Test2$3").product(factory.tuple("6")));
x12_upper.add(factory.tuple("Test2$3").product(factory.tuple("7")));
bounds.bound(x12, x12_upper);

TupleSet x13_upper = factory.noneOf(2);
x13_upper.add(factory.tuple("Test2$0").product(factory.tuple("-8")));
x13_upper.add(factory.tuple("Test2$0").product(factory.tuple("-7")));
x13_upper.add(factory.tuple("Test2$0").product(factory.tuple("-6")));
x13_upper.add(factory.tuple("Test2$0").product(factory.tuple("-5")));
x13_upper.add(factory.tuple("Test2$0").product(factory.tuple("-4")));
x13_upper.add(factory.tuple("Test2$0").product(factory.tuple("-3")));
x13_upper.add(factory.tuple("Test2$0").product(factory.tuple("-2")));
x13_upper.add(factory.tuple("Test2$0").product(factory.tuple("-1")));
x13_upper.add(factory.tuple("Test2$0").product(factory.tuple("0")));
x13_upper.add(factory.tuple("Test2$0").product(factory.tuple("1")));
x13_upper.add(factory.tuple("Test2$0").product(factory.tuple("2")));
x13_upper.add(factory.tuple("Test2$0").product(factory.tuple("3")));
x13_upper.add(factory.tuple("Test2$0").product(factory.tuple("4")));
x13_upper.add(factory.tuple("Test2$0").product(factory.tuple("5")));
x13_upper.add(factory.tuple("Test2$0").product(factory.tuple("6")));
x13_upper.add(factory.tuple("Test2$0").product(factory.tuple("7")));
x13_upper.add(factory.tuple("Test2$1").product(factory.tuple("-8")));
x13_upper.add(factory.tuple("Test2$1").product(factory.tuple("-7")));
x13_upper.add(factory.tuple("Test2$1").product(factory.tuple("-6")));
x13_upper.add(factory.tuple("Test2$1").product(factory.tuple("-5")));
x13_upper.add(factory.tuple("Test2$1").product(factory.tuple("-4")));
x13_upper.add(factory.tuple("Test2$1").product(factory.tuple("-3")));
x13_upper.add(factory.tuple("Test2$1").product(factory.tuple("-2")));
x13_upper.add(factory.tuple("Test2$1").product(factory.tuple("-1")));
x13_upper.add(factory.tuple("Test2$1").product(factory.tuple("0")));
x13_upper.add(factory.tuple("Test2$1").product(factory.tuple("1")));
x13_upper.add(factory.tuple("Test2$1").product(factory.tuple("2")));
x13_upper.add(factory.tuple("Test2$1").product(factory.tuple("3")));
x13_upper.add(factory.tuple("Test2$1").product(factory.tuple("4")));
x13_upper.add(factory.tuple("Test2$1").product(factory.tuple("5")));
x13_upper.add(factory.tuple("Test2$1").product(factory.tuple("6")));
x13_upper.add(factory.tuple("Test2$1").product(factory.tuple("7")));
x13_upper.add(factory.tuple("Test2$2").product(factory.tuple("-8")));
x13_upper.add(factory.tuple("Test2$2").product(factory.tuple("-7")));
x13_upper.add(factory.tuple("Test2$2").product(factory.tuple("-6")));
x13_upper.add(factory.tuple("Test2$2").product(factory.tuple("-5")));
x13_upper.add(factory.tuple("Test2$2").product(factory.tuple("-4")));
x13_upper.add(factory.tuple("Test2$2").product(factory.tuple("-3")));
x13_upper.add(factory.tuple("Test2$2").product(factory.tuple("-2")));
x13_upper.add(factory.tuple("Test2$2").product(factory.tuple("-1")));
x13_upper.add(factory.tuple("Test2$2").product(factory.tuple("0")));
x13_upper.add(factory.tuple("Test2$2").product(factory.tuple("1")));
x13_upper.add(factory.tuple("Test2$2").product(factory.tuple("2")));
x13_upper.add(factory.tuple("Test2$2").product(factory.tuple("3")));
x13_upper.add(factory.tuple("Test2$2").product(factory.tuple("4")));
x13_upper.add(factory.tuple("Test2$2").product(factory.tuple("5")));
x13_upper.add(factory.tuple("Test2$2").product(factory.tuple("6")));
x13_upper.add(factory.tuple("Test2$2").product(factory.tuple("7")));
x13_upper.add(factory.tuple("Test2$3").product(factory.tuple("-8")));
x13_upper.add(factory.tuple("Test2$3").product(factory.tuple("-7")));
x13_upper.add(factory.tuple("Test2$3").product(factory.tuple("-6")));
x13_upper.add(factory.tuple("Test2$3").product(factory.tuple("-5")));
x13_upper.add(factory.tuple("Test2$3").product(factory.tuple("-4")));
x13_upper.add(factory.tuple("Test2$3").product(factory.tuple("-3")));
x13_upper.add(factory.tuple("Test2$3").product(factory.tuple("-2")));
x13_upper.add(factory.tuple("Test2$3").product(factory.tuple("-1")));
x13_upper.add(factory.tuple("Test2$3").product(factory.tuple("0")));
x13_upper.add(factory.tuple("Test2$3").product(factory.tuple("1")));
x13_upper.add(factory.tuple("Test2$3").product(factory.tuple("2")));
x13_upper.add(factory.tuple("Test2$3").product(factory.tuple("3")));
x13_upper.add(factory.tuple("Test2$3").product(factory.tuple("4")));
x13_upper.add(factory.tuple("Test2$3").product(factory.tuple("5")));
x13_upper.add(factory.tuple("Test2$3").product(factory.tuple("6")));
x13_upper.add(factory.tuple("Test2$3").product(factory.tuple("7")));
bounds.bound(x13, x13_upper);

TupleSet x14_upper = factory.noneOf(2);
x14_upper.add(factory.tuple("Test2$0").product(factory.tuple("-8")));
x14_upper.add(factory.tuple("Test2$0").product(factory.tuple("-7")));
x14_upper.add(factory.tuple("Test2$0").product(factory.tuple("-6")));
x14_upper.add(factory.tuple("Test2$0").product(factory.tuple("-5")));
x14_upper.add(factory.tuple("Test2$0").product(factory.tuple("-4")));
x14_upper.add(factory.tuple("Test2$0").product(factory.tuple("-3")));
x14_upper.add(factory.tuple("Test2$0").product(factory.tuple("-2")));
x14_upper.add(factory.tuple("Test2$0").product(factory.tuple("-1")));
x14_upper.add(factory.tuple("Test2$0").product(factory.tuple("0")));
x14_upper.add(factory.tuple("Test2$0").product(factory.tuple("1")));
x14_upper.add(factory.tuple("Test2$0").product(factory.tuple("2")));
x14_upper.add(factory.tuple("Test2$0").product(factory.tuple("3")));
x14_upper.add(factory.tuple("Test2$0").product(factory.tuple("4")));
x14_upper.add(factory.tuple("Test2$0").product(factory.tuple("5")));
x14_upper.add(factory.tuple("Test2$0").product(factory.tuple("6")));
x14_upper.add(factory.tuple("Test2$0").product(factory.tuple("7")));
x14_upper.add(factory.tuple("Test2$1").product(factory.tuple("-8")));
x14_upper.add(factory.tuple("Test2$1").product(factory.tuple("-7")));
x14_upper.add(factory.tuple("Test2$1").product(factory.tuple("-6")));
x14_upper.add(factory.tuple("Test2$1").product(factory.tuple("-5")));
x14_upper.add(factory.tuple("Test2$1").product(factory.tuple("-4")));
x14_upper.add(factory.tuple("Test2$1").product(factory.tuple("-3")));
x14_upper.add(factory.tuple("Test2$1").product(factory.tuple("-2")));
x14_upper.add(factory.tuple("Test2$1").product(factory.tuple("-1")));
x14_upper.add(factory.tuple("Test2$1").product(factory.tuple("0")));
x14_upper.add(factory.tuple("Test2$1").product(factory.tuple("1")));
x14_upper.add(factory.tuple("Test2$1").product(factory.tuple("2")));
x14_upper.add(factory.tuple("Test2$1").product(factory.tuple("3")));
x14_upper.add(factory.tuple("Test2$1").product(factory.tuple("4")));
x14_upper.add(factory.tuple("Test2$1").product(factory.tuple("5")));
x14_upper.add(factory.tuple("Test2$1").product(factory.tuple("6")));
x14_upper.add(factory.tuple("Test2$1").product(factory.tuple("7")));
x14_upper.add(factory.tuple("Test2$2").product(factory.tuple("-8")));
x14_upper.add(factory.tuple("Test2$2").product(factory.tuple("-7")));
x14_upper.add(factory.tuple("Test2$2").product(factory.tuple("-6")));
x14_upper.add(factory.tuple("Test2$2").product(factory.tuple("-5")));
x14_upper.add(factory.tuple("Test2$2").product(factory.tuple("-4")));
x14_upper.add(factory.tuple("Test2$2").product(factory.tuple("-3")));
x14_upper.add(factory.tuple("Test2$2").product(factory.tuple("-2")));
x14_upper.add(factory.tuple("Test2$2").product(factory.tuple("-1")));
x14_upper.add(factory.tuple("Test2$2").product(factory.tuple("0")));
x14_upper.add(factory.tuple("Test2$2").product(factory.tuple("1")));
x14_upper.add(factory.tuple("Test2$2").product(factory.tuple("2")));
x14_upper.add(factory.tuple("Test2$2").product(factory.tuple("3")));
x14_upper.add(factory.tuple("Test2$2").product(factory.tuple("4")));
x14_upper.add(factory.tuple("Test2$2").product(factory.tuple("5")));
x14_upper.add(factory.tuple("Test2$2").product(factory.tuple("6")));
x14_upper.add(factory.tuple("Test2$2").product(factory.tuple("7")));
x14_upper.add(factory.tuple("Test2$3").product(factory.tuple("-8")));
x14_upper.add(factory.tuple("Test2$3").product(factory.tuple("-7")));
x14_upper.add(factory.tuple("Test2$3").product(factory.tuple("-6")));
x14_upper.add(factory.tuple("Test2$3").product(factory.tuple("-5")));
x14_upper.add(factory.tuple("Test2$3").product(factory.tuple("-4")));
x14_upper.add(factory.tuple("Test2$3").product(factory.tuple("-3")));
x14_upper.add(factory.tuple("Test2$3").product(factory.tuple("-2")));
x14_upper.add(factory.tuple("Test2$3").product(factory.tuple("-1")));
x14_upper.add(factory.tuple("Test2$3").product(factory.tuple("0")));
x14_upper.add(factory.tuple("Test2$3").product(factory.tuple("1")));
x14_upper.add(factory.tuple("Test2$3").product(factory.tuple("2")));
x14_upper.add(factory.tuple("Test2$3").product(factory.tuple("3")));
x14_upper.add(factory.tuple("Test2$3").product(factory.tuple("4")));
x14_upper.add(factory.tuple("Test2$3").product(factory.tuple("5")));
x14_upper.add(factory.tuple("Test2$3").product(factory.tuple("6")));
x14_upper.add(factory.tuple("Test2$3").product(factory.tuple("7")));
bounds.bound(x14, x14_upper);

TupleSet x15_upper = factory.noneOf(2);
x15_upper.add(factory.tuple("Test2$0").product(factory.tuple("-8")));
x15_upper.add(factory.tuple("Test2$0").product(factory.tuple("-7")));
x15_upper.add(factory.tuple("Test2$0").product(factory.tuple("-6")));
x15_upper.add(factory.tuple("Test2$0").product(factory.tuple("-5")));
x15_upper.add(factory.tuple("Test2$0").product(factory.tuple("-4")));
x15_upper.add(factory.tuple("Test2$0").product(factory.tuple("-3")));
x15_upper.add(factory.tuple("Test2$0").product(factory.tuple("-2")));
x15_upper.add(factory.tuple("Test2$0").product(factory.tuple("-1")));
x15_upper.add(factory.tuple("Test2$0").product(factory.tuple("0")));
x15_upper.add(factory.tuple("Test2$0").product(factory.tuple("1")));
x15_upper.add(factory.tuple("Test2$0").product(factory.tuple("2")));
x15_upper.add(factory.tuple("Test2$0").product(factory.tuple("3")));
x15_upper.add(factory.tuple("Test2$0").product(factory.tuple("4")));
x15_upper.add(factory.tuple("Test2$0").product(factory.tuple("5")));
x15_upper.add(factory.tuple("Test2$0").product(factory.tuple("6")));
x15_upper.add(factory.tuple("Test2$0").product(factory.tuple("7")));
x15_upper.add(factory.tuple("Test2$1").product(factory.tuple("-8")));
x15_upper.add(factory.tuple("Test2$1").product(factory.tuple("-7")));
x15_upper.add(factory.tuple("Test2$1").product(factory.tuple("-6")));
x15_upper.add(factory.tuple("Test2$1").product(factory.tuple("-5")));
x15_upper.add(factory.tuple("Test2$1").product(factory.tuple("-4")));
x15_upper.add(factory.tuple("Test2$1").product(factory.tuple("-3")));
x15_upper.add(factory.tuple("Test2$1").product(factory.tuple("-2")));
x15_upper.add(factory.tuple("Test2$1").product(factory.tuple("-1")));
x15_upper.add(factory.tuple("Test2$1").product(factory.tuple("0")));
x15_upper.add(factory.tuple("Test2$1").product(factory.tuple("1")));
x15_upper.add(factory.tuple("Test2$1").product(factory.tuple("2")));
x15_upper.add(factory.tuple("Test2$1").product(factory.tuple("3")));
x15_upper.add(factory.tuple("Test2$1").product(factory.tuple("4")));
x15_upper.add(factory.tuple("Test2$1").product(factory.tuple("5")));
x15_upper.add(factory.tuple("Test2$1").product(factory.tuple("6")));
x15_upper.add(factory.tuple("Test2$1").product(factory.tuple("7")));
x15_upper.add(factory.tuple("Test2$2").product(factory.tuple("-8")));
x15_upper.add(factory.tuple("Test2$2").product(factory.tuple("-7")));
x15_upper.add(factory.tuple("Test2$2").product(factory.tuple("-6")));
x15_upper.add(factory.tuple("Test2$2").product(factory.tuple("-5")));
x15_upper.add(factory.tuple("Test2$2").product(factory.tuple("-4")));
x15_upper.add(factory.tuple("Test2$2").product(factory.tuple("-3")));
x15_upper.add(factory.tuple("Test2$2").product(factory.tuple("-2")));
x15_upper.add(factory.tuple("Test2$2").product(factory.tuple("-1")));
x15_upper.add(factory.tuple("Test2$2").product(factory.tuple("0")));
x15_upper.add(factory.tuple("Test2$2").product(factory.tuple("1")));
x15_upper.add(factory.tuple("Test2$2").product(factory.tuple("2")));
x15_upper.add(factory.tuple("Test2$2").product(factory.tuple("3")));
x15_upper.add(factory.tuple("Test2$2").product(factory.tuple("4")));
x15_upper.add(factory.tuple("Test2$2").product(factory.tuple("5")));
x15_upper.add(factory.tuple("Test2$2").product(factory.tuple("6")));
x15_upper.add(factory.tuple("Test2$2").product(factory.tuple("7")));
x15_upper.add(factory.tuple("Test2$3").product(factory.tuple("-8")));
x15_upper.add(factory.tuple("Test2$3").product(factory.tuple("-7")));
x15_upper.add(factory.tuple("Test2$3").product(factory.tuple("-6")));
x15_upper.add(factory.tuple("Test2$3").product(factory.tuple("-5")));
x15_upper.add(factory.tuple("Test2$3").product(factory.tuple("-4")));
x15_upper.add(factory.tuple("Test2$3").product(factory.tuple("-3")));
x15_upper.add(factory.tuple("Test2$3").product(factory.tuple("-2")));
x15_upper.add(factory.tuple("Test2$3").product(factory.tuple("-1")));
x15_upper.add(factory.tuple("Test2$3").product(factory.tuple("0")));
x15_upper.add(factory.tuple("Test2$3").product(factory.tuple("1")));
x15_upper.add(factory.tuple("Test2$3").product(factory.tuple("2")));
x15_upper.add(factory.tuple("Test2$3").product(factory.tuple("3")));
x15_upper.add(factory.tuple("Test2$3").product(factory.tuple("4")));
x15_upper.add(factory.tuple("Test2$3").product(factory.tuple("5")));
x15_upper.add(factory.tuple("Test2$3").product(factory.tuple("6")));
x15_upper.add(factory.tuple("Test2$3").product(factory.tuple("7")));
bounds.bound(x15, x15_upper);

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

Variable x19=Variable.unary("Pred_this");
Decls x18=x19.oneOf(x6);
Expression x22=x19.join(x8);
Formula x21=x22.one();
Formula x23=x22.in(Expression.INTS);
Formula x20=x21.and(x23);
Formula x17=x20.forAll(x18);
Expression x26=x8.join(Expression.UNIV);
Formula x25=x26.in(x6);
Variable x30=Variable.unary("Pred_this");
Decls x29=x30.oneOf(x6);
Expression x33=x30.join(x9);
Formula x32=x33.one();
Formula x34=x33.in(Expression.INTS);
Formula x31=x32.and(x34);
Formula x28=x31.forAll(x29);
Expression x36=x9.join(Expression.UNIV);
Formula x35=x36.in(x6);
Variable x39=Variable.unary("Pred_this");
Decls x38=x39.oneOf(x6);
Expression x42=x39.join(x10);
Formula x41=x42.one();
Formula x43=x42.in(Expression.INTS);
Formula x40=x41.and(x43);
Formula x37=x40.forAll(x38);
Expression x45=x10.join(Expression.UNIV);
Formula x44=x45.in(x6);
Variable x48=Variable.unary("Pred_this");
Decls x47=x48.oneOf(x6);
Expression x51=x48.join(x11);
Formula x50=x51.one();
Formula x52=x51.in(Expression.INTS);
Formula x49=x50.and(x52);
Formula x46=x49.forAll(x47);
Expression x54=x11.join(Expression.UNIV);
Formula x53=x54.in(x6);
Variable x57=Variable.unary("Pred_this");
Decls x56=x57.oneOf(x6);
Expression x61=x57.join(x11);
Expression x66=x57.join(x8);
IntExpression x65=x66.sum();
Expression x68=x57.join(x9);
IntExpression x67=x68.sum();
IntExpression x64=x65.plus(x67);
Expression x70=x57.join(x10);
IntExpression x69=x70.sum();
IntExpression x63=x64.plus(x69);
Expression x62=x63.toExpression();
Formula x60=x61.eq(x62);
Expression x73=x57.join(x11);
IntExpression x72=x73.sum();
IntExpression x74=IntConstant.constant(4);
Formula x71=x72.lt(x74);
Formula x59=x60.and(x71);
Expression x77=x57.join(x11);
IntExpression x76=x77.sum();
IntExpression x78=IntConstant.constant(-2);
Formula x75=x76.gt(x78);
Formula x58=x59.and(x75);
Formula x55=x58.forAll(x56);
Variable x81=Variable.unary("Pred_this");
Decls x80=x81.oneOf(x7);
Expression x84=x81.join(x12);
Formula x83=x84.one();
Formula x85=x84.in(Expression.INTS);
Formula x82=x83.and(x85);
Formula x79=x82.forAll(x80);
Expression x87=x12.join(Expression.UNIV);
Formula x86=x87.in(x7);
Variable x90=Variable.unary("Pred_this");
Decls x89=x90.oneOf(x7);
Expression x93=x90.join(x13);
Formula x92=x93.one();
Formula x94=x93.in(Expression.INTS);
Formula x91=x92.and(x94);
Formula x88=x91.forAll(x89);
Expression x96=x13.join(Expression.UNIV);
Formula x95=x96.in(x7);
Variable x99=Variable.unary("Pred_this");
Decls x98=x99.oneOf(x7);
Expression x102=x99.join(x14);
Formula x101=x102.one();
Formula x103=x102.in(Expression.INTS);
Formula x100=x101.and(x103);
Formula x97=x100.forAll(x98);
Expression x105=x14.join(Expression.UNIV);
Formula x104=x105.in(x7);
Variable x108=Variable.unary("Pred_this");
Decls x107=x108.oneOf(x7);
Expression x111=x108.join(x15);
Formula x110=x111.one();
Formula x112=x111.in(Expression.INTS);
Formula x109=x110.and(x112);
Formula x106=x109.forAll(x107);
Expression x114=x15.join(Expression.UNIV);
Formula x113=x114.in(x7);
Variable x117=Variable.unary("Pred_this");
Decls x116=x117.oneOf(x7);
Expression x121=x117.join(x15);
Expression x126=x117.join(x12);
IntExpression x125=x126.sum();
Expression x128=x117.join(x13);
IntExpression x127=x128.sum();
IntExpression x124=x125.plus(x127);
Expression x130=x117.join(x14);
IntExpression x129=x130.sum();
IntExpression x123=x124.plus(x129);
Expression x122=x123.toExpression();
Formula x120=x121.eq(x122);
Expression x133=x117.join(x15);
IntExpression x132=x133.sum();
IntExpression x134=IntConstant.constant(4);
Formula x131=x132.lt(x134);
Formula x119=x120.and(x131);
Expression x137=x117.join(x15);
IntExpression x136=x137.sum();
IntExpression x138=IntConstant.constant(-2);
Formula x135=x136.gt(x138);
Formula x118=x119.and(x135);
Formula x115=x118.forAll(x116);
Formula x139=x0.eq(x0);
Formula x140=x1.eq(x1);
Formula x141=x2.eq(x2);
Formula x142=x3.eq(x3);
Formula x143=x4.eq(x4);
Formula x144=x5.eq(x5);
Formula x145=x6.eq(x6);
Formula x146=x7.eq(x7);
Formula x147=x8.eq(x8);
Formula x148=x9.eq(x9);
Formula x149=x10.eq(x10);
Formula x150=x11.eq(x11);
Formula x151=x12.eq(x12);
Formula x152=x13.eq(x13);
Formula x153=x14.eq(x14);
Formula x154=x15.eq(x15);
Formula x16=Formula.compose(FormulaOperator.AND, x17, x25, x28, x35, x37, x44, x46, x53, x55, x79, x86, x88, x95, x97, x104, x106, x113, x115, x139, x140, x141, x142, x143, x144, x145, x146, x147, x148, x149, x150, x151, x152, x153, x154);

Solver solver = new Solver();
solver.options().setSolver(SATFactory.DefaultSAT4J);
solver.options().setBitwidth(4);
solver.options().setIntEncoding(Options.IntEncoding.TWOSCOMPLEMENT);
solver.options().setSymmetryBreaking(20);
solver.options().setSkolemDepth(0);
System.out.println("Solving...");
System.out.flush();
Solution sol = solver.solve(x16,bounds);
System.out.println(sol.toString());

IntExprReduction ier = new IntExprReduction();
Formula[] formulas = ier.reduceIntExpressions(x17, x25, x28, x35, x37, x44, x46, x53, x55, x79, x86, x88, x95, x97, x104, x106, x113, x115, x139, x140, x141, x142, x143, x144, x145, x146, x147, x148, x149, x150, x151, x152, x153, x154);//x77, x78
 x16=Formula.compose(FormulaOperator.AND, formulas);
ier.solve(x16, bounds, factory, universe, 4); 

}}
