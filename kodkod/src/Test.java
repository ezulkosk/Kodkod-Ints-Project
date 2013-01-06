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
      (this . this/Apache.total) = Int[int[this . this/Apache.base] + int[this . 
      this/Apache.HNL] + int[this . this/Apache.KA] + int[this . 
      this/Apache.enableSend] + int[this . this/Apache.followSym] + int[this . 
      this/Apache.accessLog] + int[this . this/Apache.ES] + int[this . 
      this/Apache.mem] + int[this . this/Apache.handle]]) && 
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
public final class Test {

public static void main(String[] args) throws Exception {

Relation x0 = Relation.unary("Int/min");
Relation x1 = Relation.unary("Int/zero");
Relation x2 = Relation.unary("Int/max");
Relation x3 = Relation.nary("Int/next", 2);
Relation x4 = Relation.unary("seq/Int");
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
 "-1", "-10", "-11", "-12", "-13",
 "-14", "-15", "-16", "-17", "-18", "-19",
 "-2", "-20", "-21", "-22", "-23", "-24",
 "-25", "-26", "-27", "-28", "-29", "-3",
 "-30", "-31", "-32", "-4", "-5", "-6",
 "-7", "-8", "-9", "0", "1", "10",
 "11", "12", "13", "14", "15", "16",
 "17", "18", "19", "2", "20", "21",
 "22", "23", "24", "25", "26", "27",
 "28", "29", "3", "30", "31", "4",
 "5", "6", "7", "8", "9", "Apache$0"
);

Universe universe = new Universe(atomlist);
TupleFactory factory = universe.factory();
Bounds bounds = new Bounds(universe);

TupleSet x0_upper = factory.noneOf(1);
x0_upper.add(factory.tuple("-32"));
bounds.boundExactly(x0, x0_upper);

TupleSet x1_upper = factory.noneOf(1);
x1_upper.add(factory.tuple("0"));
bounds.boundExactly(x1, x1_upper);

TupleSet x2_upper = factory.noneOf(1);
x2_upper.add(factory.tuple("31"));
bounds.boundExactly(x2, x2_upper);

TupleSet x3_upper = factory.noneOf(2);
x3_upper.add(factory.tuple("-32").product(factory.tuple("-31")));
x3_upper.add(factory.tuple("-31").product(factory.tuple("-30")));
x3_upper.add(factory.tuple("-30").product(factory.tuple("-29")));
x3_upper.add(factory.tuple("-29").product(factory.tuple("-28")));
x3_upper.add(factory.tuple("-28").product(factory.tuple("-27")));
x3_upper.add(factory.tuple("-27").product(factory.tuple("-26")));
x3_upper.add(factory.tuple("-26").product(factory.tuple("-25")));
x3_upper.add(factory.tuple("-25").product(factory.tuple("-24")));
x3_upper.add(factory.tuple("-24").product(factory.tuple("-23")));
x3_upper.add(factory.tuple("-23").product(factory.tuple("-22")));
x3_upper.add(factory.tuple("-22").product(factory.tuple("-21")));
x3_upper.add(factory.tuple("-21").product(factory.tuple("-20")));
x3_upper.add(factory.tuple("-20").product(factory.tuple("-19")));
x3_upper.add(factory.tuple("-19").product(factory.tuple("-18")));
x3_upper.add(factory.tuple("-18").product(factory.tuple("-17")));
x3_upper.add(factory.tuple("-17").product(factory.tuple("-16")));
x3_upper.add(factory.tuple("-16").product(factory.tuple("-15")));
x3_upper.add(factory.tuple("-15").product(factory.tuple("-14")));
x3_upper.add(factory.tuple("-14").product(factory.tuple("-13")));
x3_upper.add(factory.tuple("-13").product(factory.tuple("-12")));
x3_upper.add(factory.tuple("-12").product(factory.tuple("-11")));
x3_upper.add(factory.tuple("-11").product(factory.tuple("-10")));
x3_upper.add(factory.tuple("-10").product(factory.tuple("-9")));
x3_upper.add(factory.tuple("-9").product(factory.tuple("-8")));
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
x3_upper.add(factory.tuple("7").product(factory.tuple("8")));
x3_upper.add(factory.tuple("8").product(factory.tuple("9")));
x3_upper.add(factory.tuple("9").product(factory.tuple("10")));
x3_upper.add(factory.tuple("10").product(factory.tuple("11")));
x3_upper.add(factory.tuple("11").product(factory.tuple("12")));
x3_upper.add(factory.tuple("12").product(factory.tuple("13")));
x3_upper.add(factory.tuple("13").product(factory.tuple("14")));
x3_upper.add(factory.tuple("14").product(factory.tuple("15")));
x3_upper.add(factory.tuple("15").product(factory.tuple("16")));
x3_upper.add(factory.tuple("16").product(factory.tuple("17")));
x3_upper.add(factory.tuple("17").product(factory.tuple("18")));
x3_upper.add(factory.tuple("18").product(factory.tuple("19")));
x3_upper.add(factory.tuple("19").product(factory.tuple("20")));
x3_upper.add(factory.tuple("20").product(factory.tuple("21")));
x3_upper.add(factory.tuple("21").product(factory.tuple("22")));
x3_upper.add(factory.tuple("22").product(factory.tuple("23")));
x3_upper.add(factory.tuple("23").product(factory.tuple("24")));
x3_upper.add(factory.tuple("24").product(factory.tuple("25")));
x3_upper.add(factory.tuple("25").product(factory.tuple("26")));
x3_upper.add(factory.tuple("26").product(factory.tuple("27")));
x3_upper.add(factory.tuple("27").product(factory.tuple("28")));
x3_upper.add(factory.tuple("28").product(factory.tuple("29")));
x3_upper.add(factory.tuple("29").product(factory.tuple("30")));
x3_upper.add(factory.tuple("30").product(factory.tuple("31")));
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
x6_upper.add(factory.tuple("Apache$0"));
bounds.boundExactly(x6, x6_upper);

TupleSet x7_upper = factory.noneOf(2);
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("-32")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("-31")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("-30")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("-29")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("-28")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("-27")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("-26")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("-25")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("-24")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("-23")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("-22")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("-21")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("-20")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("-19")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("-18")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("-17")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("-16")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("-15")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("-14")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("-13")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("-12")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("-11")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("-10")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("-9")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("-8")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("-7")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("-6")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("-5")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("-4")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("-3")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("-2")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("-1")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("0")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("1")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("2")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("3")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("4")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("5")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("6")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("7")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("8")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("9")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("10")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("11")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("12")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("13")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("14")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("15")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("16")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("17")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("18")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("19")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("20")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("21")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("22")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("23")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("24")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("25")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("26")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("27")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("28")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("29")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("30")));
x7_upper.add(factory.tuple("Apache$0").product(factory.tuple("31")));
bounds.bound(x7, x7_upper);

TupleSet x8_upper = factory.noneOf(2);
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("-32")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("-31")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("-30")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("-29")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("-28")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("-27")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("-26")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("-25")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("-24")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("-23")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("-22")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("-21")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("-20")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("-19")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("-18")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("-17")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("-16")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("-15")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("-14")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("-13")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("-12")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("-11")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("-10")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("-9")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("-8")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("-7")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("-6")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("-5")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("-4")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("-3")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("-2")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("-1")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("0")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("1")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("2")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("3")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("4")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("5")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("6")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("7")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("8")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("9")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("10")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("11")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("12")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("13")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("14")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("15")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("16")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("17")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("18")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("19")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("20")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("21")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("22")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("23")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("24")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("25")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("26")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("27")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("28")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("29")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("30")));
x8_upper.add(factory.tuple("Apache$0").product(factory.tuple("31")));
bounds.bound(x8, x8_upper);

TupleSet x9_upper = factory.noneOf(2);
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("-32")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("-31")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("-30")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("-29")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("-28")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("-27")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("-26")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("-25")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("-24")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("-23")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("-22")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("-21")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("-20")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("-19")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("-18")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("-17")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("-16")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("-15")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("-14")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("-13")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("-12")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("-11")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("-10")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("-9")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("-8")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("-7")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("-6")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("-5")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("-4")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("-3")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("-2")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("-1")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("0")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("1")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("2")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("3")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("4")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("5")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("6")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("7")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("8")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("9")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("10")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("11")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("12")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("13")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("14")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("15")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("16")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("17")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("18")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("19")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("20")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("21")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("22")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("23")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("24")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("25")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("26")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("27")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("28")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("29")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("30")));
x9_upper.add(factory.tuple("Apache$0").product(factory.tuple("31")));
bounds.bound(x9, x9_upper);

TupleSet x10_upper = factory.noneOf(2);
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("-32")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("-31")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("-30")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("-29")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("-28")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("-27")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("-26")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("-25")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("-24")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("-23")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("-22")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("-21")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("-20")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("-19")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("-18")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("-17")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("-16")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("-15")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("-14")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("-13")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("-12")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("-11")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("-10")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("-9")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("-8")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("-7")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("-6")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("-5")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("-4")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("-3")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("-2")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("-1")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("0")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("1")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("2")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("3")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("4")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("5")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("6")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("7")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("8")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("9")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("10")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("11")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("12")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("13")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("14")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("15")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("16")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("17")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("18")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("19")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("20")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("21")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("22")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("23")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("24")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("25")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("26")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("27")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("28")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("29")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("30")));
x10_upper.add(factory.tuple("Apache$0").product(factory.tuple("31")));
bounds.bound(x10, x10_upper);

TupleSet x11_upper = factory.noneOf(2);
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("-32")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("-31")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("-30")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("-29")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("-28")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("-27")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("-26")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("-25")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("-24")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("-23")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("-22")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("-21")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("-20")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("-19")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("-18")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("-17")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("-16")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("-15")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("-14")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("-13")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("-12")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("-11")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("-10")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("-9")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("-8")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("-7")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("-6")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("-5")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("-4")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("-3")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("-2")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("-1")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("0")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("1")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("2")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("3")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("4")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("5")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("6")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("7")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("8")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("9")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("10")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("11")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("12")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("13")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("14")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("15")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("16")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("17")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("18")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("19")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("20")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("21")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("22")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("23")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("24")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("25")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("26")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("27")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("28")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("29")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("30")));
x11_upper.add(factory.tuple("Apache$0").product(factory.tuple("31")));
bounds.bound(x11, x11_upper);

TupleSet x12_upper = factory.noneOf(2);
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("-32")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("-31")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("-30")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("-29")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("-28")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("-27")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("-26")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("-25")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("-24")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("-23")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("-22")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("-21")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("-20")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("-19")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("-18")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("-17")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("-16")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("-15")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("-14")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("-13")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("-12")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("-11")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("-10")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("-9")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("-8")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("-7")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("-6")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("-5")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("-4")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("-3")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("-2")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("-1")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("0")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("1")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("2")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("3")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("4")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("5")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("6")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("7")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("8")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("9")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("10")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("11")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("12")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("13")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("14")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("15")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("16")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("17")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("18")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("19")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("20")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("21")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("22")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("23")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("24")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("25")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("26")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("27")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("28")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("29")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("30")));
x12_upper.add(factory.tuple("Apache$0").product(factory.tuple("31")));
bounds.bound(x12, x12_upper);

TupleSet x13_upper = factory.noneOf(2);
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("-32")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("-31")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("-30")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("-29")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("-28")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("-27")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("-26")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("-25")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("-24")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("-23")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("-22")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("-21")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("-20")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("-19")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("-18")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("-17")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("-16")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("-15")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("-14")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("-13")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("-12")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("-11")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("-10")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("-9")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("-8")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("-7")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("-6")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("-5")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("-4")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("-3")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("-2")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("-1")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("0")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("1")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("2")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("3")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("4")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("5")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("6")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("7")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("8")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("9")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("10")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("11")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("12")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("13")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("14")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("15")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("16")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("17")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("18")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("19")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("20")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("21")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("22")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("23")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("24")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("25")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("26")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("27")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("28")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("29")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("30")));
x13_upper.add(factory.tuple("Apache$0").product(factory.tuple("31")));
bounds.bound(x13, x13_upper);

TupleSet x14_upper = factory.noneOf(2);
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("-32")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("-31")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("-30")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("-29")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("-28")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("-27")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("-26")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("-25")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("-24")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("-23")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("-22")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("-21")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("-20")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("-19")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("-18")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("-17")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("-16")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("-15")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("-14")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("-13")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("-12")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("-11")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("-10")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("-9")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("-8")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("-7")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("-6")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("-5")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("-4")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("-3")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("-2")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("-1")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("0")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("1")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("2")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("3")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("4")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("5")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("6")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("7")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("8")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("9")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("10")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("11")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("12")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("13")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("14")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("15")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("16")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("17")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("18")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("19")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("20")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("21")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("22")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("23")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("24")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("25")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("26")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("27")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("28")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("29")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("30")));
x14_upper.add(factory.tuple("Apache$0").product(factory.tuple("31")));
bounds.bound(x14, x14_upper);

TupleSet x15_upper = factory.noneOf(2);
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("-32")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("-31")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("-30")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("-29")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("-28")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("-27")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("-26")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("-25")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("-24")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("-23")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("-22")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("-21")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("-20")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("-19")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("-18")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("-17")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("-16")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("-15")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("-14")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("-13")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("-12")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("-11")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("-10")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("-9")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("-8")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("-7")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("-6")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("-5")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("-4")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("-3")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("-2")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("-1")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("0")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("1")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("2")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("3")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("4")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("5")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("6")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("7")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("8")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("9")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("10")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("11")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("12")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("13")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("14")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("15")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("16")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("17")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("18")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("19")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("20")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("21")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("22")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("23")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("24")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("25")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("26")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("27")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("28")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("29")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("30")));
x15_upper.add(factory.tuple("Apache$0").product(factory.tuple("31")));
bounds.bound(x15, x15_upper);

TupleSet x16_upper = factory.noneOf(2);
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("-32")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("-31")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("-30")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("-29")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("-28")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("-27")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("-26")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("-25")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("-24")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("-23")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("-22")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("-21")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("-20")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("-19")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("-18")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("-17")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("-16")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("-15")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("-14")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("-13")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("-12")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("-11")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("-10")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("-9")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("-8")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("-7")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("-6")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("-5")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("-4")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("-3")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("-2")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("-1")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("0")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("1")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("2")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("3")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("4")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("5")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("6")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("7")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("8")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("9")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("10")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("11")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("12")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("13")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("14")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("15")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("16")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("17")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("18")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("19")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("20")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("21")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("22")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("23")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("24")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("25")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("26")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("27")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("28")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("29")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("30")));
x16_upper.add(factory.tuple("Apache$0").product(factory.tuple("31")));
bounds.bound(x16, x16_upper);

bounds.boundExactly(-32,factory.range(factory.tuple("-32"),factory.tuple("-32")));
bounds.boundExactly(-31,factory.range(factory.tuple("-31"),factory.tuple("-31")));
bounds.boundExactly(-30,factory.range(factory.tuple("-30"),factory.tuple("-30")));
bounds.boundExactly(-29,factory.range(factory.tuple("-29"),factory.tuple("-29")));
bounds.boundExactly(-28,factory.range(factory.tuple("-28"),factory.tuple("-28")));
bounds.boundExactly(-27,factory.range(factory.tuple("-27"),factory.tuple("-27")));
bounds.boundExactly(-26,factory.range(factory.tuple("-26"),factory.tuple("-26")));
bounds.boundExactly(-25,factory.range(factory.tuple("-25"),factory.tuple("-25")));
bounds.boundExactly(-24,factory.range(factory.tuple("-24"),factory.tuple("-24")));
bounds.boundExactly(-23,factory.range(factory.tuple("-23"),factory.tuple("-23")));
bounds.boundExactly(-22,factory.range(factory.tuple("-22"),factory.tuple("-22")));
bounds.boundExactly(-21,factory.range(factory.tuple("-21"),factory.tuple("-21")));
bounds.boundExactly(-20,factory.range(factory.tuple("-20"),factory.tuple("-20")));
bounds.boundExactly(-19,factory.range(factory.tuple("-19"),factory.tuple("-19")));
bounds.boundExactly(-18,factory.range(factory.tuple("-18"),factory.tuple("-18")));
bounds.boundExactly(-17,factory.range(factory.tuple("-17"),factory.tuple("-17")));
bounds.boundExactly(-16,factory.range(factory.tuple("-16"),factory.tuple("-16")));
bounds.boundExactly(-15,factory.range(factory.tuple("-15"),factory.tuple("-15")));
bounds.boundExactly(-14,factory.range(factory.tuple("-14"),factory.tuple("-14")));
bounds.boundExactly(-13,factory.range(factory.tuple("-13"),factory.tuple("-13")));
bounds.boundExactly(-12,factory.range(factory.tuple("-12"),factory.tuple("-12")));
bounds.boundExactly(-11,factory.range(factory.tuple("-11"),factory.tuple("-11")));
bounds.boundExactly(-10,factory.range(factory.tuple("-10"),factory.tuple("-10")));
bounds.boundExactly(-9,factory.range(factory.tuple("-9"),factory.tuple("-9")));
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
bounds.boundExactly(8,factory.range(factory.tuple("8"),factory.tuple("8")));
bounds.boundExactly(9,factory.range(factory.tuple("9"),factory.tuple("9")));
bounds.boundExactly(10,factory.range(factory.tuple("10"),factory.tuple("10")));
bounds.boundExactly(11,factory.range(factory.tuple("11"),factory.tuple("11")));
bounds.boundExactly(12,factory.range(factory.tuple("12"),factory.tuple("12")));
bounds.boundExactly(13,factory.range(factory.tuple("13"),factory.tuple("13")));
bounds.boundExactly(14,factory.range(factory.tuple("14"),factory.tuple("14")));
bounds.boundExactly(15,factory.range(factory.tuple("15"),factory.tuple("15")));
bounds.boundExactly(16,factory.range(factory.tuple("16"),factory.tuple("16")));
bounds.boundExactly(17,factory.range(factory.tuple("17"),factory.tuple("17")));
bounds.boundExactly(18,factory.range(factory.tuple("18"),factory.tuple("18")));
bounds.boundExactly(19,factory.range(factory.tuple("19"),factory.tuple("19")));
bounds.boundExactly(20,factory.range(factory.tuple("20"),factory.tuple("20")));
bounds.boundExactly(21,factory.range(factory.tuple("21"),factory.tuple("21")));
bounds.boundExactly(22,factory.range(factory.tuple("22"),factory.tuple("22")));
bounds.boundExactly(23,factory.range(factory.tuple("23"),factory.tuple("23")));
bounds.boundExactly(24,factory.range(factory.tuple("24"),factory.tuple("24")));
bounds.boundExactly(25,factory.range(factory.tuple("25"),factory.tuple("25")));
bounds.boundExactly(26,factory.range(factory.tuple("26"),factory.tuple("26")));
bounds.boundExactly(27,factory.range(factory.tuple("27"),factory.tuple("27")));
bounds.boundExactly(28,factory.range(factory.tuple("28"),factory.tuple("28")));
bounds.boundExactly(29,factory.range(factory.tuple("29"),factory.tuple("29")));
bounds.boundExactly(30,factory.range(factory.tuple("30"),factory.tuple("30")));
bounds.boundExactly(31,factory.range(factory.tuple("31"),factory.tuple("31")));

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
Expression x114=x112.join(x16);
Expression x125=x112.join(x7);
IntExpression x124=x125.sum();
Expression x127=x112.join(x8);
IntExpression x126=x127.sum();
IntExpression x123=x124.plus(x126);
Expression x129=x112.join(x9);
IntExpression x128=x129.sum();
IntExpression x122=x123.plus(x128);
Expression x131=x112.join(x10);
IntExpression x130=x131.sum();
IntExpression x121=x122.plus(x130);
Expression x133=x112.join(x11);
IntExpression x132=x133.sum();
IntExpression x120=x121.plus(x132);
Expression x135=x112.join(x12);
IntExpression x134=x135.sum();
IntExpression x119=x120.plus(x134);
Expression x137=x112.join(x13);
IntExpression x136=x137.sum();
IntExpression x118=x119.plus(x136);
Expression x139=x112.join(x14);
IntExpression x138=x139.sum();
IntExpression x117=x118.plus(x138);
Expression x141=x112.join(x15);
IntExpression x140=x141.sum();
IntExpression x116=x117.plus(x140);
Expression x115=x116.toExpression();
Formula x113=x114.eq(x115);
Formula x110=x113.forAll(x111);
Formula x142=x0.eq(x0);
Formula x143=x1.eq(x1);
Formula x144=x2.eq(x2);
Formula x145=x3.eq(x3);
Formula x146=x4.eq(x4);
Formula x147=x5.eq(x5);
Formula x148=x6.eq(x6);
Formula x149=x7.eq(x7);
Formula x150=x8.eq(x8);
Formula x151=x9.eq(x9);
Formula x152=x10.eq(x10);
Formula x153=x11.eq(x11);
Formula x154=x12.eq(x12);
Formula x155=x13.eq(x13);
Formula x156=x14.eq(x14);
Formula x157=x15.eq(x15);
Formula x158=x16.eq(x16);
Formula x17=Formula.compose(FormulaOperator.AND, x18, x26, x29, x36, x38, x45, x47, x54, x56, x63, x65, x72, x74, x81, x83, x90, x92, x99, x101, x108, x110, x142, x143, x144, x145, x146, x147, x148, x149, x150, x151, x152, x153, x154, x155, x156, x157, x158);

Solver solver = new Solver();
solver.options().setSolver(SATFactory.DefaultSAT4J);
solver.options().setBitwidth(6);
solver.options().setIntEncoding(Options.IntEncoding.TWOSCOMPLEMENT);
solver.options().setSymmetryBreaking(20);
solver.options().setSkolemDepth(0);
System.out.println("Solving...");
System.out.flush();
Solution sol = solver.solve(x17,bounds);
System.out.println(sol.toString());
}}
