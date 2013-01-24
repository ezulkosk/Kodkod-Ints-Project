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
    no (this/c4_Base & this/c10_HostnameLookups) && 
    no ((this/c4_Base + this/c10_HostnameLookups) & this/c17_KeepAlive) && 
    no ((this/c4_Base + this/c10_HostnameLookups + this/c17_KeepAlive) & 
    this/c23_EnableSendfile) && 
    no ((this/c4_Base + this/c10_HostnameLookups + this/c17_KeepAlive + 
    this/c23_EnableSendfile) & this/c29_FollowSymLinks) && 
    no ((this/c4_Base + this/c10_HostnameLookups + this/c17_KeepAlive + 
    this/c23_EnableSendfile + this/c29_FollowSymLinks) & this/c35_AccessLog) && 
    no ((this/c4_Base + this/c10_HostnameLookups + this/c17_KeepAlive + 
    this/c23_EnableSendfile + this/c29_FollowSymLinks + this/c35_AccessLog) & 
    this/c42_ExtendedStatus) && 
    no ((this/c4_Base + this/c10_HostnameLookups + this/c17_KeepAlive + 
    this/c23_EnableSendfile + this/c29_FollowSymLinks + this/c35_AccessLog + 
    this/c42_ExtendedStatus) & this/c49_InMemory) && 
    no ((this/c4_Base + this/c10_HostnameLookups + this/c17_KeepAlive + 
    this/c23_EnableSendfile + this/c29_FollowSymLinks + this/c35_AccessLog + 
    this/c42_ExtendedStatus + this/c49_InMemory) & this/c57_Handle) && 
    (all show_this: this/c4_Base | 
      one (this/c3_Apache.r_c4_Base . show_this) && 
      ((show_this . this/c1_IMeasurable.r_c2_performance) . 
      this/c2_performance.c2_performance_ref) = Int[150]) && 
    (all show_this: this/c10_HostnameLookups | 
      one (this/c3_Apache.r_c10_HostnameLookups . show_this) && 
      ((show_this . this/c1_IMeasurable.r_c2_performance) . 
      this/c2_performance.c2_performance_ref) = Int[-26]) && 
    (all show_this: this/c17_KeepAlive | 
      one (this/c3_Apache.r_c17_KeepAlive . show_this) && 
      ((show_this . this/c1_IMeasurable.r_c2_performance) . 
      this/c2_performance.c2_performance_ref) = Int[105]) && 
    (all show_this: this/c23_EnableSendfile | 
      one (this/c3_Apache.r_c23_EnableSendfile . show_this) && 
      ((show_this . this/c1_IMeasurable.r_c2_performance) . 
      this/c2_performance.c2_performance_ref) = Int[15]) && 
    (all show_this: this/c29_FollowSymLinks | 
      one (this/c3_Apache.r_c29_FollowSymLinks . show_this) && 
      ((show_this . this/c1_IMeasurable.r_c2_performance) . 
      this/c2_performance.c2_performance_ref) = Int[0]) && 
    (all show_this: this/c35_AccessLog | 
      one (this/c3_Apache.r_c35_AccessLog . show_this) && 
      ((show_this . this/c1_IMeasurable.r_c2_performance) . 
      this/c2_performance.c2_performance_ref) = Int[-15]) && 
    (all show_this: this/c42_ExtendedStatus | 
      one (this/c3_Apache.r_c42_ExtendedStatus . show_this) && 
      ((show_this . this/c1_IMeasurable.r_c2_performance) . 
      this/c2_performance.c2_performance_ref) = Int[-11]) && 
    (all show_this: this/c49_InMemory | 
      one (this/c3_Apache.r_c49_InMemory . show_this) && 
      no ((show_this . ~this/c3_Apache.r_c49_InMemory) . 
      this/c3_Apache.r_c57_Handle) && 
      ((show_this . this/c1_IMeasurable.r_c2_performance) . 
      this/c2_performance.c2_performance_ref) = Int[26]) && 
    (all show_this: this/c57_Handle | 
      one (this/c3_Apache.r_c57_Handle . show_this) && 
      ((show_this . this/c1_IMeasurable.r_c2_performance) . 
      this/c2_performance.c2_performance_ref) = Int[4]) && 
    (all show_this: this/c4_Base + this/c10_HostnameLookups + this/c17_KeepAlive + 
     this/c23_EnableSendfile + this/c29_FollowSymLinks + this/c35_AccessLog + 
     this/c42_ExtendedStatus + this/c49_InMemory + this/c57_Handle | 
      one (show_this . this/c1_IMeasurable.r_c2_performance) && 
      (show_this . this/c1_IMeasurable.r_c2_performance) in this/c2_performance) && 
    (this/c1_IMeasurable.r_c2_performance . univ) in (this/c4_Base + 
    this/c10_HostnameLookups + this/c17_KeepAlive + this/c23_EnableSendfile + 
    this/c29_FollowSymLinks + this/c35_AccessLog + this/c42_ExtendedStatus + 
    this/c49_InMemory + this/c57_Handle) && 
    (all show_this: this/c2_performance | 
      one (show_this . this/c2_performance.c2_performance_ref) && 
      (show_this . this/c2_performance.c2_performance_ref) in ints) && 
    (this/c2_performance.c2_performance_ref . univ) in this/c2_performance && 
    (all show_this: this/c2_performance | 
      one (this/c1_IMeasurable.r_c2_performance . show_this)) && 
    some (this/c101_simpleConfig . this/c3_Apache.r_c4_Base) && 
    no (this/c101_simpleConfig . this/c3_Apache.r_c10_HostnameLookups) && 
    some (this/c101_simpleConfig . this/c3_Apache.r_c49_InMemory) && 
    no (this/c101_simpleConfig . this/c3_Apache.r_c17_KeepAlive) && 
    (all show_this: this/c101_simpleConfig | 
      one (show_this . this/c3_Apache.r_c4_Base) && 
      (show_this . this/c3_Apache.r_c4_Base) in this/c4_Base) && 
    (this/c3_Apache.r_c4_Base . univ) in this/c101_simpleConfig && 
    (all show_this: this/c101_simpleConfig | 
      lone (show_this . this/c3_Apache.r_c10_HostnameLookups) && 
      (show_this . this/c3_Apache.r_c10_HostnameLookups) in 
      this/c10_HostnameLookups) && 
    (this/c3_Apache.r_c10_HostnameLookups . univ) in this/c101_simpleConfig && 
    (all show_this: this/c101_simpleConfig | 
      lone (show_this . this/c3_Apache.r_c17_KeepAlive) && 
      (show_this . this/c3_Apache.r_c17_KeepAlive) in this/c17_KeepAlive) && 
    (this/c3_Apache.r_c17_KeepAlive . univ) in this/c101_simpleConfig && 
    (all show_this: this/c101_simpleConfig | 
      lone (show_this . this/c3_Apache.r_c23_EnableSendfile) && 
      (show_this . this/c3_Apache.r_c23_EnableSendfile) in 
      this/c23_EnableSendfile) && 
    (this/c3_Apache.r_c23_EnableSendfile . univ) in this/c101_simpleConfig && 
    (all show_this: this/c101_simpleConfig | 
      lone (show_this . this/c3_Apache.r_c29_FollowSymLinks) && 
      (show_this . this/c3_Apache.r_c29_FollowSymLinks) in 
      this/c29_FollowSymLinks) && 
    (this/c3_Apache.r_c29_FollowSymLinks . univ) in this/c101_simpleConfig && 
    (all show_this: this/c101_simpleConfig | 
      lone (show_this . this/c3_Apache.r_c35_AccessLog) && 
      (show_this . this/c3_Apache.r_c35_AccessLog) in this/c35_AccessLog) && 
    (this/c3_Apache.r_c35_AccessLog . univ) in this/c101_simpleConfig && 
    (all show_this: this/c101_simpleConfig | 
      lone (show_this . this/c3_Apache.r_c42_ExtendedStatus) && 
      (show_this . this/c3_Apache.r_c42_ExtendedStatus) in 
      this/c42_ExtendedStatus) && 
    (this/c3_Apache.r_c42_ExtendedStatus . univ) in this/c101_simpleConfig && 
    (all show_this: this/c101_simpleConfig | 
      lone (show_this . this/c3_Apache.r_c49_InMemory) && 
      (show_this . this/c3_Apache.r_c49_InMemory) in this/c49_InMemory) && 
    (this/c3_Apache.r_c49_InMemory . univ) in this/c101_simpleConfig && 
    (all show_this: this/c101_simpleConfig | 
      lone (show_this . this/c3_Apache.r_c57_Handle) && 
      (show_this . this/c3_Apache.r_c57_Handle) in this/c57_Handle) && 
    (this/c3_Apache.r_c57_Handle . univ) in this/c101_simpleConfig && 
    (all show_this: this/c101_simpleConfig | 
      one (show_this . this/c3_Apache.r_c63_total_performance) && 
      (show_this . this/c3_Apache.r_c63_total_performance) in 
      this/c63_total_performance) && 
    (this/c3_Apache.r_c63_total_performance . univ) in this/c101_simpleConfig && 
    (all show_this: this/c63_total_performance | 
      one (show_this . this/c63_total_performance.c63_total_performance_ref) && 
      (show_this . this/c63_total_performance.c63_total_performance_ref) in ints
     ) && 
    (this/c63_total_performance.c63_total_performance_ref . univ) in 
    this/c63_total_performance && 
    (all show_this: this/c63_total_performance | 
      one (this/c3_Apache.r_c63_total_performance . show_this) && 
      (show_this . this/c63_total_performance.c63_total_performance_ref) = Int[
      int[(((show_this . ~this/c3_Apache.r_c63_total_performance) . 
      this/c3_Apache.r_c4_Base) . this/c1_IMeasurable.r_c2_performance) . 
      this/c2_performance.c2_performance_ref] + int[(((show_this . ~
      this/c3_Apache.r_c63_total_performance) . 
      this/c3_Apache.r_c10_HostnameLookups) . 
      this/c1_IMeasurable.r_c2_performance) . 
      this/c2_performance.c2_performance_ref] + int[(((show_this . ~
      this/c3_Apache.r_c63_total_performance) . this/c3_Apache.r_c17_KeepAlive) . 
      this/c1_IMeasurable.r_c2_performance) . 
      this/c2_performance.c2_performance_ref] + int[(((show_this . ~
      this/c3_Apache.r_c63_total_performance) . 
      this/c3_Apache.r_c23_EnableSendfile) . 
      this/c1_IMeasurable.r_c2_performance) . 
      this/c2_performance.c2_performance_ref] + int[(((show_this . ~
      this/c3_Apache.r_c63_total_performance) . 
      this/c3_Apache.r_c29_FollowSymLinks) . 
      this/c1_IMeasurable.r_c2_performance) . 
      this/c2_performance.c2_performance_ref] + int[(((show_this . ~
      this/c3_Apache.r_c63_total_performance) . this/c3_Apache.r_c35_AccessLog) . 
      this/c1_IMeasurable.r_c2_performance) . 
      this/c2_performance.c2_performance_ref] + int[(((show_this . ~
      this/c3_Apache.r_c63_total_performance) . 
      this/c3_Apache.r_c42_ExtendedStatus) . 
      this/c1_IMeasurable.r_c2_performance) . 
      this/c2_performance.c2_performance_ref] + int[(((show_this . ~
      this/c3_Apache.r_c63_total_performance) . this/c3_Apache.r_c49_InMemory) . 
      this/c1_IMeasurable.r_c2_performance) . 
      this/c2_performance.c2_performance_ref] + int[(((show_this . ~
      this/c3_Apache.r_c63_total_performance) . this/c3_Apache.r_c57_Handle) . 
      this/c1_IMeasurable.r_c2_performance) . 
      this/c2_performance.c2_performance_ref]]) && 
    Int/min = Int/min && 
    Int/zero = Int/zero && 
    Int/max = Int/max && 
    Int/next = Int/next && 
    seq/Int = seq/Int && 
    String = String && 
    this/c4_Base = this/c4_Base && 
    this/c10_HostnameLookups = this/c10_HostnameLookups && 
    this/c17_KeepAlive = this/c17_KeepAlive && 
    this/c23_EnableSendfile = this/c23_EnableSendfile && 
    this/c29_FollowSymLinks = this/c29_FollowSymLinks && 
    this/c35_AccessLog = this/c35_AccessLog && 
    this/c42_ExtendedStatus = this/c42_ExtendedStatus && 
    this/c49_InMemory = this/c49_InMemory && 
    this/c57_Handle = this/c57_Handle && 
    this/c2_performance = this/c2_performance && 
    this/c101_simpleConfig = this/c101_simpleConfig && 
    this/c63_total_performance = this/c63_total_performance && 
    this/c1_IMeasurable.r_c2_performance = this/c1_IMeasurable.r_c2_performance && 
    this/c2_performance.c2_performance_ref = 
    this/c2_performance.c2_performance_ref && 
    this/c3_Apache.r_c4_Base = this/c3_Apache.r_c4_Base && 
    this/c3_Apache.r_c10_HostnameLookups = this/c3_Apache.r_c10_HostnameLookups && 
    this/c3_Apache.r_c17_KeepAlive = this/c3_Apache.r_c17_KeepAlive && 
    this/c3_Apache.r_c23_EnableSendfile = this/c3_Apache.r_c23_EnableSendfile && 
    this/c3_Apache.r_c29_FollowSymLinks = this/c3_Apache.r_c29_FollowSymLinks && 
    this/c3_Apache.r_c35_AccessLog = this/c3_Apache.r_c35_AccessLog && 
    this/c3_Apache.r_c42_ExtendedStatus = this/c3_Apache.r_c42_ExtendedStatus && 
    this/c3_Apache.r_c49_InMemory = this/c3_Apache.r_c49_InMemory && 
    this/c3_Apache.r_c57_Handle = this/c3_Apache.r_c57_Handle && 
    this/c3_Apache.r_c63_total_performance = 
    this/c3_Apache.r_c63_total_performance && 
    this/c63_total_performance.c63_total_performance_ref = 
    this/c63_total_performance.c63_total_performance_ref
  ==================================================
*/
public final class ApacheUsingVajiys {

public static void main(String[] args) throws Exception {

Relation x0 = Relation.unary("Int/min");
Relation x1 = Relation.unary("Int/zero");
Relation x2 = Relation.unary("Int/max");
Relation x3 = Relation.nary("Int/next", 2);
Relation x4 = Relation.unary("seq/Int");
Relation x5 = Relation.unary("String");
Relation x6 = Relation.unary("this/c4_Base");
Relation x7 = Relation.unary("this/c10_HostnameLookups");
Relation x8 = Relation.unary("this/c17_KeepAlive");
Relation x9 = Relation.unary("this/c23_EnableSendfile");
Relation x10 = Relation.unary("this/c29_FollowSymLinks");
Relation x11 = Relation.unary("this/c35_AccessLog");
Relation x12 = Relation.unary("this/c42_ExtendedStatus");
Relation x13 = Relation.unary("this/c49_InMemory");
Relation x14 = Relation.unary("this/c57_Handle");
Relation x15 = Relation.unary("this/c2_performance");
Relation x16 = Relation.unary("this/c101_simpleConfig");
Relation x17 = Relation.unary("this/c63_total_performance");
Relation x18 = Relation.nary("this/c1_IMeasurable.r_c2_performance", 2);
Relation x19 = Relation.nary("this/c2_performance.c2_performance_ref", 2);
Relation x20 = Relation.nary("this/c3_Apache.r_c4_Base", 2);
Relation x21 = Relation.nary("this/c3_Apache.r_c10_HostnameLookups", 2);
Relation x22 = Relation.nary("this/c3_Apache.r_c17_KeepAlive", 2);
Relation x23 = Relation.nary("this/c3_Apache.r_c23_EnableSendfile", 2);
Relation x24 = Relation.nary("this/c3_Apache.r_c29_FollowSymLinks", 2);
Relation x25 = Relation.nary("this/c3_Apache.r_c35_AccessLog", 2);
Relation x26 = Relation.nary("this/c3_Apache.r_c42_ExtendedStatus", 2);
Relation x27 = Relation.nary("this/c3_Apache.r_c49_InMemory", 2);
Relation x28 = Relation.nary("this/c3_Apache.r_c57_Handle", 2);
Relation x29 = Relation.nary("this/c3_Apache.r_c63_total_performance", 2);
Relation x30 = Relation.nary("this/c63_total_performance.c63_total_performance_ref", 2);

List<String> atomlist = Arrays.asList(
 "-1", "-2", "-3", "-4", "-5",
 "-6", "-7", "-8", "0", "1", "2",
 "3", "4", "5", "6", "7", "c101_simpleConfig$0",
 "c2_performance$1", "c2_performance$2", "c49_InMemory$2", "c4_Base$2", "c63_total_performance$2", "unused0",
 "unused1", "unused10", "unused11", "unused12", "unused13", "unused14",
 "unused15", "unused16", "unused17", "unused18", "unused19", "unused2",
 "unused20", "unused21", "unused22", "unused23", "unused24", "unused25",
 "unused26", "unused27", "unused3", "unused4", "unused5", "unused6",
 "unused7", "unused8", "unused9"
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
x6_upper.add(factory.tuple("unused0"));
x6_upper.add(factory.tuple("unused1"));
x6_upper.add(factory.tuple("c4_Base$2"));
bounds.bound(x6, x6_upper);

TupleSet x7_upper = factory.noneOf(1);
x7_upper.add(factory.tuple("unused2"));
x7_upper.add(factory.tuple("unused3"));
x7_upper.add(factory.tuple("unused4"));
bounds.bound(x7, x7_upper);

TupleSet x8_upper = factory.noneOf(1);
x8_upper.add(factory.tuple("unused5"));
x8_upper.add(factory.tuple("unused6"));
x8_upper.add(factory.tuple("unused7"));
bounds.bound(x8, x8_upper);

TupleSet x9_upper = factory.noneOf(1);
x9_upper.add(factory.tuple("unused8"));
x9_upper.add(factory.tuple("unused9"));
x9_upper.add(factory.tuple("unused10"));
bounds.bound(x9, x9_upper);

TupleSet x10_upper = factory.noneOf(1);
x10_upper.add(factory.tuple("unused11"));
x10_upper.add(factory.tuple("unused12"));
x10_upper.add(factory.tuple("unused13"));
bounds.bound(x10, x10_upper);

TupleSet x11_upper = factory.noneOf(1);
x11_upper.add(factory.tuple("unused14"));
x11_upper.add(factory.tuple("unused15"));
x11_upper.add(factory.tuple("unused16"));
bounds.bound(x11, x11_upper);

TupleSet x12_upper = factory.noneOf(1);
x12_upper.add(factory.tuple("unused17"));
x12_upper.add(factory.tuple("unused18"));
x12_upper.add(factory.tuple("unused19"));
bounds.bound(x12, x12_upper);

TupleSet x13_upper = factory.noneOf(1);
x13_upper.add(factory.tuple("unused20"));
x13_upper.add(factory.tuple("unused21"));
x13_upper.add(factory.tuple("c49_InMemory$2"));
bounds.bound(x13, x13_upper);

TupleSet x14_upper = factory.noneOf(1);
x14_upper.add(factory.tuple("unused22"));
x14_upper.add(factory.tuple("unused23"));
x14_upper.add(factory.tuple("unused24"));
bounds.bound(x14, x14_upper);

TupleSet x15_upper = factory.noneOf(1);
x15_upper.add(factory.tuple("unused25"));
x15_upper.add(factory.tuple("c2_performance$1"));
x15_upper.add(factory.tuple("c2_performance$2"));
bounds.bound(x15, x15_upper);

TupleSet x16_upper = factory.noneOf(1);
x16_upper.add(factory.tuple("c101_simpleConfig$0"));
bounds.boundExactly(x16, x16_upper);

TupleSet x17_upper = factory.noneOf(1);
x17_upper.add(factory.tuple("unused26"));
x17_upper.add(factory.tuple("unused27"));
x17_upper.add(factory.tuple("c63_total_performance$2"));
bounds.bound(x17, x17_upper);

TupleSet x18_upper = factory.noneOf(2);
x18_upper.add(factory.tuple("unused0").product(factory.tuple("unused25")));
x18_upper.add(factory.tuple("unused0").product(factory.tuple("c2_performance$1")));
x18_upper.add(factory.tuple("unused0").product(factory.tuple("c2_performance$2")));
x18_upper.add(factory.tuple("unused1").product(factory.tuple("unused25")));
x18_upper.add(factory.tuple("unused1").product(factory.tuple("c2_performance$1")));
x18_upper.add(factory.tuple("unused1").product(factory.tuple("c2_performance$2")));
x18_upper.add(factory.tuple("c4_Base$2").product(factory.tuple("unused25")));
x18_upper.add(factory.tuple("c4_Base$2").product(factory.tuple("c2_performance$1")));
x18_upper.add(factory.tuple("c4_Base$2").product(factory.tuple("c2_performance$2")));
x18_upper.add(factory.tuple("unused2").product(factory.tuple("unused25")));
x18_upper.add(factory.tuple("unused2").product(factory.tuple("c2_performance$1")));
x18_upper.add(factory.tuple("unused2").product(factory.tuple("c2_performance$2")));
x18_upper.add(factory.tuple("unused3").product(factory.tuple("unused25")));
x18_upper.add(factory.tuple("unused3").product(factory.tuple("c2_performance$1")));
x18_upper.add(factory.tuple("unused3").product(factory.tuple("c2_performance$2")));
x18_upper.add(factory.tuple("unused4").product(factory.tuple("unused25")));
x18_upper.add(factory.tuple("unused4").product(factory.tuple("c2_performance$1")));
x18_upper.add(factory.tuple("unused4").product(factory.tuple("c2_performance$2")));
x18_upper.add(factory.tuple("unused5").product(factory.tuple("unused25")));
x18_upper.add(factory.tuple("unused5").product(factory.tuple("c2_performance$1")));
x18_upper.add(factory.tuple("unused5").product(factory.tuple("c2_performance$2")));
x18_upper.add(factory.tuple("unused6").product(factory.tuple("unused25")));
x18_upper.add(factory.tuple("unused6").product(factory.tuple("c2_performance$1")));
x18_upper.add(factory.tuple("unused6").product(factory.tuple("c2_performance$2")));
x18_upper.add(factory.tuple("unused7").product(factory.tuple("unused25")));
x18_upper.add(factory.tuple("unused7").product(factory.tuple("c2_performance$1")));
x18_upper.add(factory.tuple("unused7").product(factory.tuple("c2_performance$2")));
x18_upper.add(factory.tuple("unused8").product(factory.tuple("unused25")));
x18_upper.add(factory.tuple("unused8").product(factory.tuple("c2_performance$1")));
x18_upper.add(factory.tuple("unused8").product(factory.tuple("c2_performance$2")));
x18_upper.add(factory.tuple("unused9").product(factory.tuple("unused25")));
x18_upper.add(factory.tuple("unused9").product(factory.tuple("c2_performance$1")));
x18_upper.add(factory.tuple("unused9").product(factory.tuple("c2_performance$2")));
x18_upper.add(factory.tuple("unused10").product(factory.tuple("unused25")));
x18_upper.add(factory.tuple("unused10").product(factory.tuple("c2_performance$1")));
x18_upper.add(factory.tuple("unused10").product(factory.tuple("c2_performance$2")));
x18_upper.add(factory.tuple("unused11").product(factory.tuple("unused25")));
x18_upper.add(factory.tuple("unused11").product(factory.tuple("c2_performance$1")));
x18_upper.add(factory.tuple("unused11").product(factory.tuple("c2_performance$2")));
x18_upper.add(factory.tuple("unused12").product(factory.tuple("unused25")));
x18_upper.add(factory.tuple("unused12").product(factory.tuple("c2_performance$1")));
x18_upper.add(factory.tuple("unused12").product(factory.tuple("c2_performance$2")));
x18_upper.add(factory.tuple("unused13").product(factory.tuple("unused25")));
x18_upper.add(factory.tuple("unused13").product(factory.tuple("c2_performance$1")));
x18_upper.add(factory.tuple("unused13").product(factory.tuple("c2_performance$2")));
x18_upper.add(factory.tuple("unused14").product(factory.tuple("unused25")));
x18_upper.add(factory.tuple("unused14").product(factory.tuple("c2_performance$1")));
x18_upper.add(factory.tuple("unused14").product(factory.tuple("c2_performance$2")));
x18_upper.add(factory.tuple("unused15").product(factory.tuple("unused25")));
x18_upper.add(factory.tuple("unused15").product(factory.tuple("c2_performance$1")));
x18_upper.add(factory.tuple("unused15").product(factory.tuple("c2_performance$2")));
x18_upper.add(factory.tuple("unused16").product(factory.tuple("unused25")));
x18_upper.add(factory.tuple("unused16").product(factory.tuple("c2_performance$1")));
x18_upper.add(factory.tuple("unused16").product(factory.tuple("c2_performance$2")));
x18_upper.add(factory.tuple("unused17").product(factory.tuple("unused25")));
x18_upper.add(factory.tuple("unused17").product(factory.tuple("c2_performance$1")));
x18_upper.add(factory.tuple("unused17").product(factory.tuple("c2_performance$2")));
x18_upper.add(factory.tuple("unused18").product(factory.tuple("unused25")));
x18_upper.add(factory.tuple("unused18").product(factory.tuple("c2_performance$1")));
x18_upper.add(factory.tuple("unused18").product(factory.tuple("c2_performance$2")));
x18_upper.add(factory.tuple("unused19").product(factory.tuple("unused25")));
x18_upper.add(factory.tuple("unused19").product(factory.tuple("c2_performance$1")));
x18_upper.add(factory.tuple("unused19").product(factory.tuple("c2_performance$2")));
x18_upper.add(factory.tuple("unused20").product(factory.tuple("unused25")));
x18_upper.add(factory.tuple("unused20").product(factory.tuple("c2_performance$1")));
x18_upper.add(factory.tuple("unused20").product(factory.tuple("c2_performance$2")));
x18_upper.add(factory.tuple("unused21").product(factory.tuple("unused25")));
x18_upper.add(factory.tuple("unused21").product(factory.tuple("c2_performance$1")));
x18_upper.add(factory.tuple("unused21").product(factory.tuple("c2_performance$2")));
x18_upper.add(factory.tuple("c49_InMemory$2").product(factory.tuple("unused25")));
x18_upper.add(factory.tuple("c49_InMemory$2").product(factory.tuple("c2_performance$1")));
x18_upper.add(factory.tuple("c49_InMemory$2").product(factory.tuple("c2_performance$2")));
x18_upper.add(factory.tuple("unused22").product(factory.tuple("unused25")));
x18_upper.add(factory.tuple("unused22").product(factory.tuple("c2_performance$1")));
x18_upper.add(factory.tuple("unused22").product(factory.tuple("c2_performance$2")));
x18_upper.add(factory.tuple("unused23").product(factory.tuple("unused25")));
x18_upper.add(factory.tuple("unused23").product(factory.tuple("c2_performance$1")));
x18_upper.add(factory.tuple("unused23").product(factory.tuple("c2_performance$2")));
x18_upper.add(factory.tuple("unused24").product(factory.tuple("unused25")));
x18_upper.add(factory.tuple("unused24").product(factory.tuple("c2_performance$1")));
x18_upper.add(factory.tuple("unused24").product(factory.tuple("c2_performance$2")));
bounds.bound(x18, x18_upper);

TupleSet x19_upper = factory.noneOf(2);
x19_upper.add(factory.tuple("unused25").product(factory.tuple("-8")));
x19_upper.add(factory.tuple("unused25").product(factory.tuple("-7")));
x19_upper.add(factory.tuple("unused25").product(factory.tuple("-6")));
x19_upper.add(factory.tuple("unused25").product(factory.tuple("-5")));
x19_upper.add(factory.tuple("unused25").product(factory.tuple("-4")));
x19_upper.add(factory.tuple("unused25").product(factory.tuple("-3")));
x19_upper.add(factory.tuple("unused25").product(factory.tuple("-2")));
x19_upper.add(factory.tuple("unused25").product(factory.tuple("-1")));
x19_upper.add(factory.tuple("unused25").product(factory.tuple("0")));
x19_upper.add(factory.tuple("unused25").product(factory.tuple("1")));
x19_upper.add(factory.tuple("unused25").product(factory.tuple("2")));
x19_upper.add(factory.tuple("unused25").product(factory.tuple("3")));
x19_upper.add(factory.tuple("unused25").product(factory.tuple("4")));
x19_upper.add(factory.tuple("unused25").product(factory.tuple("5")));
x19_upper.add(factory.tuple("unused25").product(factory.tuple("6")));
x19_upper.add(factory.tuple("unused25").product(factory.tuple("7")));
x19_upper.add(factory.tuple("c2_performance$1").product(factory.tuple("-8")));
x19_upper.add(factory.tuple("c2_performance$1").product(factory.tuple("-7")));
x19_upper.add(factory.tuple("c2_performance$1").product(factory.tuple("-6")));
x19_upper.add(factory.tuple("c2_performance$1").product(factory.tuple("-5")));
x19_upper.add(factory.tuple("c2_performance$1").product(factory.tuple("-4")));
x19_upper.add(factory.tuple("c2_performance$1").product(factory.tuple("-3")));
x19_upper.add(factory.tuple("c2_performance$1").product(factory.tuple("-2")));
x19_upper.add(factory.tuple("c2_performance$1").product(factory.tuple("-1")));
x19_upper.add(factory.tuple("c2_performance$1").product(factory.tuple("0")));
x19_upper.add(factory.tuple("c2_performance$1").product(factory.tuple("1")));
x19_upper.add(factory.tuple("c2_performance$1").product(factory.tuple("2")));
x19_upper.add(factory.tuple("c2_performance$1").product(factory.tuple("3")));
x19_upper.add(factory.tuple("c2_performance$1").product(factory.tuple("4")));
x19_upper.add(factory.tuple("c2_performance$1").product(factory.tuple("5")));
x19_upper.add(factory.tuple("c2_performance$1").product(factory.tuple("6")));
x19_upper.add(factory.tuple("c2_performance$1").product(factory.tuple("7")));
x19_upper.add(factory.tuple("c2_performance$2").product(factory.tuple("-8")));
x19_upper.add(factory.tuple("c2_performance$2").product(factory.tuple("-7")));
x19_upper.add(factory.tuple("c2_performance$2").product(factory.tuple("-6")));
x19_upper.add(factory.tuple("c2_performance$2").product(factory.tuple("-5")));
x19_upper.add(factory.tuple("c2_performance$2").product(factory.tuple("-4")));
x19_upper.add(factory.tuple("c2_performance$2").product(factory.tuple("-3")));
x19_upper.add(factory.tuple("c2_performance$2").product(factory.tuple("-2")));
x19_upper.add(factory.tuple("c2_performance$2").product(factory.tuple("-1")));
x19_upper.add(factory.tuple("c2_performance$2").product(factory.tuple("0")));
x19_upper.add(factory.tuple("c2_performance$2").product(factory.tuple("1")));
x19_upper.add(factory.tuple("c2_performance$2").product(factory.tuple("2")));
x19_upper.add(factory.tuple("c2_performance$2").product(factory.tuple("3")));
x19_upper.add(factory.tuple("c2_performance$2").product(factory.tuple("4")));
x19_upper.add(factory.tuple("c2_performance$2").product(factory.tuple("5")));
x19_upper.add(factory.tuple("c2_performance$2").product(factory.tuple("6")));
x19_upper.add(factory.tuple("c2_performance$2").product(factory.tuple("7")));
bounds.bound(x19, x19_upper);

TupleSet x20_upper = factory.noneOf(2);
x20_upper.add(factory.tuple("c101_simpleConfig$0").product(factory.tuple("unused0")));
x20_upper.add(factory.tuple("c101_simpleConfig$0").product(factory.tuple("unused1")));
x20_upper.add(factory.tuple("c101_simpleConfig$0").product(factory.tuple("c4_Base$2")));
bounds.bound(x20, x20_upper);

TupleSet x21_upper = factory.noneOf(2);
x21_upper.add(factory.tuple("c101_simpleConfig$0").product(factory.tuple("unused2")));
x21_upper.add(factory.tuple("c101_simpleConfig$0").product(factory.tuple("unused3")));
x21_upper.add(factory.tuple("c101_simpleConfig$0").product(factory.tuple("unused4")));
bounds.bound(x21, x21_upper);

TupleSet x22_upper = factory.noneOf(2);
x22_upper.add(factory.tuple("c101_simpleConfig$0").product(factory.tuple("unused5")));
x22_upper.add(factory.tuple("c101_simpleConfig$0").product(factory.tuple("unused6")));
x22_upper.add(factory.tuple("c101_simpleConfig$0").product(factory.tuple("unused7")));
bounds.bound(x22, x22_upper);

TupleSet x23_upper = factory.noneOf(2);
x23_upper.add(factory.tuple("c101_simpleConfig$0").product(factory.tuple("unused8")));
x23_upper.add(factory.tuple("c101_simpleConfig$0").product(factory.tuple("unused9")));
x23_upper.add(factory.tuple("c101_simpleConfig$0").product(factory.tuple("unused10")));
bounds.bound(x23, x23_upper);

TupleSet x24_upper = factory.noneOf(2);
x24_upper.add(factory.tuple("c101_simpleConfig$0").product(factory.tuple("unused11")));
x24_upper.add(factory.tuple("c101_simpleConfig$0").product(factory.tuple("unused12")));
x24_upper.add(factory.tuple("c101_simpleConfig$0").product(factory.tuple("unused13")));
bounds.bound(x24, x24_upper);

TupleSet x25_upper = factory.noneOf(2);
x25_upper.add(factory.tuple("c101_simpleConfig$0").product(factory.tuple("unused14")));
x25_upper.add(factory.tuple("c101_simpleConfig$0").product(factory.tuple("unused15")));
x25_upper.add(factory.tuple("c101_simpleConfig$0").product(factory.tuple("unused16")));
bounds.bound(x25, x25_upper);

TupleSet x26_upper = factory.noneOf(2);
x26_upper.add(factory.tuple("c101_simpleConfig$0").product(factory.tuple("unused17")));
x26_upper.add(factory.tuple("c101_simpleConfig$0").product(factory.tuple("unused18")));
x26_upper.add(factory.tuple("c101_simpleConfig$0").product(factory.tuple("unused19")));
bounds.bound(x26, x26_upper);

TupleSet x27_upper = factory.noneOf(2);
x27_upper.add(factory.tuple("c101_simpleConfig$0").product(factory.tuple("unused20")));
x27_upper.add(factory.tuple("c101_simpleConfig$0").product(factory.tuple("unused21")));
x27_upper.add(factory.tuple("c101_simpleConfig$0").product(factory.tuple("c49_InMemory$2")));
bounds.bound(x27, x27_upper);

TupleSet x28_upper = factory.noneOf(2);
x28_upper.add(factory.tuple("c101_simpleConfig$0").product(factory.tuple("unused22")));
x28_upper.add(factory.tuple("c101_simpleConfig$0").product(factory.tuple("unused23")));
x28_upper.add(factory.tuple("c101_simpleConfig$0").product(factory.tuple("unused24")));
bounds.bound(x28, x28_upper);

TupleSet x29_upper = factory.noneOf(2);
x29_upper.add(factory.tuple("c101_simpleConfig$0").product(factory.tuple("unused26")));
x29_upper.add(factory.tuple("c101_simpleConfig$0").product(factory.tuple("unused27")));
x29_upper.add(factory.tuple("c101_simpleConfig$0").product(factory.tuple("c63_total_performance$2")));
bounds.bound(x29, x29_upper);

TupleSet x30_upper = factory.noneOf(2);
x30_upper.add(factory.tuple("unused26").product(factory.tuple("-8")));
x30_upper.add(factory.tuple("unused26").product(factory.tuple("-7")));
x30_upper.add(factory.tuple("unused26").product(factory.tuple("-6")));
x30_upper.add(factory.tuple("unused26").product(factory.tuple("-5")));
x30_upper.add(factory.tuple("unused26").product(factory.tuple("-4")));
x30_upper.add(factory.tuple("unused26").product(factory.tuple("-3")));
x30_upper.add(factory.tuple("unused26").product(factory.tuple("-2")));
x30_upper.add(factory.tuple("unused26").product(factory.tuple("-1")));
x30_upper.add(factory.tuple("unused26").product(factory.tuple("0")));
x30_upper.add(factory.tuple("unused26").product(factory.tuple("1")));
x30_upper.add(factory.tuple("unused26").product(factory.tuple("2")));
x30_upper.add(factory.tuple("unused26").product(factory.tuple("3")));
x30_upper.add(factory.tuple("unused26").product(factory.tuple("4")));
x30_upper.add(factory.tuple("unused26").product(factory.tuple("5")));
x30_upper.add(factory.tuple("unused26").product(factory.tuple("6")));
x30_upper.add(factory.tuple("unused26").product(factory.tuple("7")));
x30_upper.add(factory.tuple("unused27").product(factory.tuple("-8")));
x30_upper.add(factory.tuple("unused27").product(factory.tuple("-7")));
x30_upper.add(factory.tuple("unused27").product(factory.tuple("-6")));
x30_upper.add(factory.tuple("unused27").product(factory.tuple("-5")));
x30_upper.add(factory.tuple("unused27").product(factory.tuple("-4")));
x30_upper.add(factory.tuple("unused27").product(factory.tuple("-3")));
x30_upper.add(factory.tuple("unused27").product(factory.tuple("-2")));
x30_upper.add(factory.tuple("unused27").product(factory.tuple("-1")));
x30_upper.add(factory.tuple("unused27").product(factory.tuple("0")));
x30_upper.add(factory.tuple("unused27").product(factory.tuple("1")));
x30_upper.add(factory.tuple("unused27").product(factory.tuple("2")));
x30_upper.add(factory.tuple("unused27").product(factory.tuple("3")));
x30_upper.add(factory.tuple("unused27").product(factory.tuple("4")));
x30_upper.add(factory.tuple("unused27").product(factory.tuple("5")));
x30_upper.add(factory.tuple("unused27").product(factory.tuple("6")));
x30_upper.add(factory.tuple("unused27").product(factory.tuple("7")));
x30_upper.add(factory.tuple("c63_total_performance$2").product(factory.tuple("-8")));
x30_upper.add(factory.tuple("c63_total_performance$2").product(factory.tuple("-7")));
x30_upper.add(factory.tuple("c63_total_performance$2").product(factory.tuple("-6")));
x30_upper.add(factory.tuple("c63_total_performance$2").product(factory.tuple("-5")));
x30_upper.add(factory.tuple("c63_total_performance$2").product(factory.tuple("-4")));
x30_upper.add(factory.tuple("c63_total_performance$2").product(factory.tuple("-3")));
x30_upper.add(factory.tuple("c63_total_performance$2").product(factory.tuple("-2")));
x30_upper.add(factory.tuple("c63_total_performance$2").product(factory.tuple("-1")));
x30_upper.add(factory.tuple("c63_total_performance$2").product(factory.tuple("0")));
x30_upper.add(factory.tuple("c63_total_performance$2").product(factory.tuple("1")));
x30_upper.add(factory.tuple("c63_total_performance$2").product(factory.tuple("2")));
x30_upper.add(factory.tuple("c63_total_performance$2").product(factory.tuple("3")));
x30_upper.add(factory.tuple("c63_total_performance$2").product(factory.tuple("4")));
x30_upper.add(factory.tuple("c63_total_performance$2").product(factory.tuple("5")));
x30_upper.add(factory.tuple("c63_total_performance$2").product(factory.tuple("6")));
x30_upper.add(factory.tuple("c63_total_performance$2").product(factory.tuple("7")));
bounds.bound(x30, x30_upper);

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

Expression x33=x6.intersection(x7);
Formula x32=x33.no();
Expression x36=x6.union(x7);
Expression x35=x36.intersection(x8);
Formula x34=x35.no();
Expression x39=x36.union(x8);
Expression x38=x39.intersection(x9);
Formula x37=x38.no();
Expression x42=x39.union(x9);
Expression x41=x42.intersection(x10);
Formula x40=x41.no();
Expression x45=x42.union(x10);
Expression x44=x45.intersection(x11);
Formula x43=x44.no();
Expression x48=x45.union(x11);
Expression x47=x48.intersection(x12);
Formula x46=x47.no();
Expression x51=x48.union(x12);
Expression x50=x51.intersection(x13);
Formula x49=x50.no();
Expression x54=x51.union(x13);
Expression x53=x54.intersection(x14);
Formula x52=x53.no();
Variable x57=Variable.unary("show_this");
Decls x56=x57.oneOf(x6);
Expression x60=x20.join(x57);
Formula x59=x60.one();
Expression x63=x57.join(x18);
Expression x62=x63.join(x19);
IntExpression x65=IntConstant.constant(150);
Expression x64=x65.toExpression();
Formula x61=x62.eq(x64);
Formula x58=x59.and(x61);
Formula x55=x58.forAll(x56);
Variable x68=Variable.unary("show_this");
Decls x67=x68.oneOf(x7);
Expression x71=x21.join(x68);
Formula x70=x71.one();
Expression x74=x68.join(x18);
Expression x73=x74.join(x19);
IntExpression x76=IntConstant.constant(-26);
Expression x75=x76.toExpression();
Formula x72=x73.eq(x75);
Formula x69=x70.and(x72);
Formula x66=x69.forAll(x67);
Variable x79=Variable.unary("show_this");
Decls x78=x79.oneOf(x8);
Expression x82=x22.join(x79);
Formula x81=x82.one();
Expression x85=x79.join(x18);
Expression x84=x85.join(x19);
IntExpression x87=IntConstant.constant(105);
Expression x86=x87.toExpression();
Formula x83=x84.eq(x86);
Formula x80=x81.and(x83);
Formula x77=x80.forAll(x78);
Variable x90=Variable.unary("show_this");
Decls x89=x90.oneOf(x9);
Expression x93=x23.join(x90);
Formula x92=x93.one();
Expression x96=x90.join(x18);
Expression x95=x96.join(x19);
IntExpression x98=IntConstant.constant(15);
Expression x97=x98.toExpression();
Formula x94=x95.eq(x97);
Formula x91=x92.and(x94);
Formula x88=x91.forAll(x89);
Variable x101=Variable.unary("show_this");
Decls x100=x101.oneOf(x10);
Expression x104=x24.join(x101);
Formula x103=x104.one();
Expression x107=x101.join(x18);
Expression x106=x107.join(x19);
IntExpression x109=IntConstant.constant(0);
Expression x108=x109.toExpression();
Formula x105=x106.eq(x108);
Formula x102=x103.and(x105);
Formula x99=x102.forAll(x100);
Variable x112=Variable.unary("show_this");
Decls x111=x112.oneOf(x11);
Expression x115=x25.join(x112);
Formula x114=x115.one();
Expression x118=x112.join(x18);
Expression x117=x118.join(x19);
IntExpression x120=IntConstant.constant(-15);
Expression x119=x120.toExpression();
Formula x116=x117.eq(x119);
Formula x113=x114.and(x116);
Formula x110=x113.forAll(x111);
Variable x123=Variable.unary("show_this");
Decls x122=x123.oneOf(x12);
Expression x126=x26.join(x123);
Formula x125=x126.one();
Expression x129=x123.join(x18);
Expression x128=x129.join(x19);
IntExpression x131=IntConstant.constant(-11);
Expression x130=x131.toExpression();
Formula x127=x128.eq(x130);
Formula x124=x125.and(x127);
Formula x121=x124.forAll(x122);
Variable x134=Variable.unary("show_this");
Decls x133=x134.oneOf(x13);
Expression x138=x27.join(x134);
Formula x137=x138.one();
Expression x142=x27.transpose();
Expression x141=x134.join(x142);
Expression x140=x141.join(x28);
Formula x139=x140.no();
Formula x136=x137.and(x139);
Expression x145=x134.join(x18);
Expression x144=x145.join(x19);
IntExpression x147=IntConstant.constant(26);
Expression x146=x147.toExpression();
Formula x143=x144.eq(x146);
Formula x135=x136.and(x143);
Formula x132=x135.forAll(x133);
Variable x150=Variable.unary("show_this");
Decls x149=x150.oneOf(x14);
Expression x153=x28.join(x150);
Formula x152=x153.one();
Expression x156=x150.join(x18);
Expression x155=x156.join(x19);
IntExpression x158=IntConstant.constant(4);
Expression x157=x158.toExpression();
Formula x154=x155.eq(x157);
Formula x151=x152.and(x154);
Formula x148=x151.forAll(x149);
Variable x161=Variable.unary("show_this");
Expression x162=x54.union(x14);
Decls x160=x161.oneOf(x162);
Expression x165=x161.join(x18);
Formula x164=x165.one();
Formula x166=x165.in(x15);
Formula x163=x164.and(x166);
Formula x159=x163.forAll(x160);
Expression x168=x18.join(Expression.UNIV);
Formula x167=x168.in(x162);
Variable x172=Variable.unary("show_this");
Decls x171=x172.oneOf(x15);
Expression x175=x172.join(x19);
Formula x174=x175.one();
Formula x176=x175.in(Expression.INTS);
Formula x173=x174.and(x176);
Formula x170=x173.forAll(x171);
Expression x179=x19.join(Expression.UNIV);
Formula x178=x179.in(x15);
Variable x182=Variable.unary("show_this");
Decls x181=x182.oneOf(x15);
Expression x184=x18.join(x182);
Formula x183=x184.one();
Formula x180=x183.forAll(x181);
Expression x188=x16.join(x20);
Formula x187=x188.some();
Expression x191=x16.join(x21);
Formula x190=x191.no();
Expression x193=x16.join(x27);
Formula x192=x193.some();
Formula x189=x190.and(x192);
Formula x186=x187.and(x189);
Expression x195=x16.join(x22);
Formula x194=x195.no();
Formula x185=x186.and(x194);
Variable x198=Variable.unary("show_this");
Decls x197=x198.oneOf(x16);
Expression x201=x198.join(x20);
Formula x200=x201.one();
Formula x202=x201.in(x6);
Formula x199=x200.and(x202);
Formula x196=x199.forAll(x197);
Expression x204=x20.join(Expression.UNIV);
Formula x203=x204.in(x16);
Variable x207=Variable.unary("show_this");
Decls x206=x207.oneOf(x16);
Expression x210=x207.join(x21);
Formula x209=x210.lone();
Formula x211=x210.in(x7);
Formula x208=x209.and(x211);
Formula x205=x208.forAll(x206);
Expression x213=x21.join(Expression.UNIV);
Formula x212=x213.in(x16);
Variable x216=Variable.unary("show_this");
Decls x215=x216.oneOf(x16);
Expression x219=x216.join(x22);
Formula x218=x219.lone();
Formula x220=x219.in(x8);
Formula x217=x218.and(x220);
Formula x214=x217.forAll(x215);
Expression x222=x22.join(Expression.UNIV);
Formula x221=x222.in(x16);
Variable x225=Variable.unary("show_this");
Decls x224=x225.oneOf(x16);
Expression x228=x225.join(x23);
Formula x227=x228.lone();
Formula x229=x228.in(x9);
Formula x226=x227.and(x229);
Formula x223=x226.forAll(x224);
Expression x231=x23.join(Expression.UNIV);
Formula x230=x231.in(x16);
Variable x234=Variable.unary("show_this");
Decls x233=x234.oneOf(x16);
Expression x237=x234.join(x24);
Formula x236=x237.lone();
Formula x238=x237.in(x10);
Formula x235=x236.and(x238);
Formula x232=x235.forAll(x233);
Expression x240=x24.join(Expression.UNIV);
Formula x239=x240.in(x16);
Variable x243=Variable.unary("show_this");
Decls x242=x243.oneOf(x16);
Expression x246=x243.join(x25);
Formula x245=x246.lone();
Formula x247=x246.in(x11);
Formula x244=x245.and(x247);
Formula x241=x244.forAll(x242);
Expression x249=x25.join(Expression.UNIV);
Formula x248=x249.in(x16);
Variable x252=Variable.unary("show_this");
Decls x251=x252.oneOf(x16);
Expression x255=x252.join(x26);
Formula x254=x255.lone();
Formula x256=x255.in(x12);
Formula x253=x254.and(x256);
Formula x250=x253.forAll(x251);
Expression x258=x26.join(Expression.UNIV);
Formula x257=x258.in(x16);
Variable x261=Variable.unary("show_this");
Decls x260=x261.oneOf(x16);
Expression x264=x261.join(x27);
Formula x263=x264.lone();
Formula x265=x264.in(x13);
Formula x262=x263.and(x265);
Formula x259=x262.forAll(x260);
Expression x267=x27.join(Expression.UNIV);
Formula x266=x267.in(x16);
Variable x270=Variable.unary("show_this");
Decls x269=x270.oneOf(x16);
Expression x273=x270.join(x28);
Formula x272=x273.lone();
Formula x274=x273.in(x14);
Formula x271=x272.and(x274);
Formula x268=x271.forAll(x269);
Expression x276=x28.join(Expression.UNIV);
Formula x275=x276.in(x16);
Variable x279=Variable.unary("show_this");
Decls x278=x279.oneOf(x16);
Expression x282=x279.join(x29);
Formula x281=x282.one();
Formula x283=x282.in(x17);
Formula x280=x281.and(x283);
Formula x277=x280.forAll(x278);
Expression x285=x29.join(Expression.UNIV);
Formula x284=x285.in(x16);
Variable x288=Variable.unary("show_this");
Decls x287=x288.oneOf(x17);
Expression x291=x288.join(x30);
Formula x290=x291.one();
Formula x292=x291.in(Expression.INTS);
Formula x289=x290.and(x292);
Formula x286=x289.forAll(x287);
Expression x294=x30.join(Expression.UNIV);
Formula x293=x294.in(x17);
Variable x297=Variable.unary("show_this");
Decls x296=x297.oneOf(x17);
Expression x300=x29.join(x297);
Formula x299=x300.one();
Expression x302=x297.join(x30);
Expression x317=x29.transpose();
Expression x316=x297.join(x317);
Expression x315=x316.join(x20);
Expression x314=x315.join(x18);
Expression x313=x314.join(x19);
IntExpression x312=x313.sum();
Expression x323=x29.transpose();
Expression x322=x297.join(x323);
Expression x321=x322.join(x21);
Expression x320=x321.join(x18);
Expression x319=x320.join(x19);
IntExpression x318=x319.sum();
IntExpression x311=x312.plus(x318);
Expression x329=x29.transpose();
Expression x328=x297.join(x329);
Expression x327=x328.join(x22);
Expression x326=x327.join(x18);
Expression x325=x326.join(x19);
IntExpression x324=x325.sum();
IntExpression x310=x311.plus(x324);
Expression x335=x29.transpose();
Expression x334=x297.join(x335);
Expression x333=x334.join(x23);
Expression x332=x333.join(x18);
Expression x331=x332.join(x19);
IntExpression x330=x331.sum();
IntExpression x309=x310.plus(x330);
Expression x341=x29.transpose();
Expression x340=x297.join(x341);
Expression x339=x340.join(x24);
Expression x338=x339.join(x18);
Expression x337=x338.join(x19);
IntExpression x336=x337.sum();
IntExpression x308=x309.plus(x336);
Expression x347=x29.transpose();
Expression x346=x297.join(x347);
Expression x345=x346.join(x25);
Expression x344=x345.join(x18);
Expression x343=x344.join(x19);
IntExpression x342=x343.sum();
IntExpression x307=x308.plus(x342);
Expression x353=x29.transpose();
Expression x352=x297.join(x353);
Expression x351=x352.join(x26);
Expression x350=x351.join(x18);
Expression x349=x350.join(x19);
IntExpression x348=x349.sum();
IntExpression x306=x307.plus(x348);
Expression x359=x29.transpose();
Expression x358=x297.join(x359);
Expression x357=x358.join(x27);
Expression x356=x357.join(x18);
Expression x355=x356.join(x19);
IntExpression x354=x355.sum();
IntExpression x305=x306.plus(x354);
Expression x365=x29.transpose();
Expression x364=x297.join(x365);
Expression x363=x364.join(x28);
Expression x362=x363.join(x18);
Expression x361=x362.join(x19);
IntExpression x360=x361.sum();
IntExpression x304=x305.plus(x360);
Expression x303=x304.toExpression();
Formula x301=x302.eq(x303);
Formula x298=x299.and(x301);
Formula x295=x298.forAll(x296);
Formula x366=x0.eq(x0);
Formula x367=x1.eq(x1);
Formula x368=x2.eq(x2);
Formula x369=x3.eq(x3);
Formula x370=x4.eq(x4);
Formula x371=x5.eq(x5);
Formula x372=x6.eq(x6);
Formula x373=x7.eq(x7);
Formula x374=x8.eq(x8);
Formula x375=x9.eq(x9);
Formula x376=x10.eq(x10);
Formula x377=x11.eq(x11);
Formula x378=x12.eq(x12);
Formula x379=x13.eq(x13);
Formula x380=x14.eq(x14);
Formula x381=x15.eq(x15);
Formula x382=x16.eq(x16);
Formula x383=x17.eq(x17);
Formula x384=x18.eq(x18);
Formula x385=x19.eq(x19);
Formula x386=x20.eq(x20);
Formula x387=x21.eq(x21);
Formula x388=x22.eq(x22);
Formula x389=x23.eq(x23);
Formula x390=x24.eq(x24);
Formula x391=x25.eq(x25);
Formula x392=x26.eq(x26);
Formula x393=x27.eq(x27);
Formula x394=x28.eq(x28);
Formula x395=x29.eq(x29);
Formula x396=x30.eq(x30);
Formula old=Formula.compose(FormulaOperator.AND, x32,x34,x37,x40,x43,x46,x49,x52,x55,x66,x77,x88,x99,x110,x121,x132,x148,x159,x167,x170,x178,x180,x185,x196,x203,x205,x212,x214,x221,x223,x230,x232,x239,x241,x248,x250,x257,x259,x266,x268,x275,x277,x284,x286,x293,x295,x366,x367,x368,x369,x370,x371,x372,x373,x374,x375,x376,x377,x378,x379,x380,x381,x382,x383,x384,x385,x386,x387,x388,x389,x390,x391,x392,x393,x394,x395,x396); 
IntExprReduction ier = new IntExprReduction();
Formula[] formulas = ier.reduceIntExpressions(x32,x34,x37,x40,x43,x46,x49,x52,x55,x66,x77,x88,x99,x110,x121,x132,x148,x159,x167,x170,x178,x180,x185,x196,x203,x205,x212,x214,x221,x223,x230,x232,x239,x241,x248,x250,x257,x259,x266,x268,x275,x277,x284,x286,x293,x295,x366,x367,x368,x369,x370,x371,x372,x373,x374,x375,x376,x377,x378,x379,x380,x381,x382,x383,x384,x385,x386,x387,x388,x389,x390,x391,x392,x393,x394,x395,x396);
Formula newFormula=Formula.compose(FormulaOperator.AND, formulas);
ier.solve(newFormula, bounds, factory, universe, 32);
Solver solver = new Solver();
solver.options().setSolver(SATFactory.DefaultSAT4J);
solver.options().setBitwidth(32);
solver.options().setFlatten(false);
solver.options().setIntEncoding(Options.IntEncoding.TWOSCOMPLEMENT);
solver.options().setSymmetryBreaking(20);
solver.options().setSkolemDepth(0);
System.out.println("Solving...");
System.out.flush();
Solution sol = solver.solve(old,bounds);
System.out.println(sol.toString());
}}
