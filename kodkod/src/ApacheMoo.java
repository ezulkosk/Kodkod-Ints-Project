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
    no (this/c101_simpleConfig . this/c3_Apache.r_c23_EnableSendfile) && 
    some (this/c101_simpleConfig . this/c3_Apache.r_c29_FollowSymLinks) && 
    some (this/c101_simpleConfig . this/c3_Apache.r_c17_KeepAlive) && 
    some (this/c101_simpleConfig . this/c3_Apache.r_c42_ExtendedStatus) && 
    no (this/c101_simpleConfig . this/c3_Apache.r_c49_InMemory) && 
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
    (all show_this: this/c101_simpleConfig | 
      ((show_this . this/c3_Apache.r_c63_total_performance) . 
      this/c63_total_performance.c63_total_performance_ref) = Int[int[((
      show_this . this/c3_Apache.r_c4_Base) . 
      this/c1_IMeasurable.r_c2_performance) . 
      this/c2_performance.c2_performance_ref] + int[((show_this . 
      this/c3_Apache.r_c10_HostnameLookups) . 
      this/c1_IMeasurable.r_c2_performance) . 
      this/c2_performance.c2_performance_ref] + int[((show_this . 
      this/c3_Apache.r_c17_KeepAlive) . this/c1_IMeasurable.r_c2_performance) . 
      this/c2_performance.c2_performance_ref] + int[((show_this . 
      this/c3_Apache.r_c23_EnableSendfile) . 
      this/c1_IMeasurable.r_c2_performance) . 
      this/c2_performance.c2_performance_ref] + int[((show_this . 
      this/c3_Apache.r_c29_FollowSymLinks) . 
      this/c1_IMeasurable.r_c2_performance) . 
      this/c2_performance.c2_performance_ref] + int[((show_this . 
      this/c3_Apache.r_c35_AccessLog) . this/c1_IMeasurable.r_c2_performance) . 
      this/c2_performance.c2_performance_ref] + int[((show_this . 
      this/c3_Apache.r_c42_ExtendedStatus) . 
      this/c1_IMeasurable.r_c2_performance) . 
      this/c2_performance.c2_performance_ref] + int[((show_this . 
      this/c3_Apache.r_c49_InMemory) . this/c1_IMeasurable.r_c2_performance) . 
      this/c2_performance.c2_performance_ref] + int[((show_this . 
      this/c3_Apache.r_c57_Handle) . this/c1_IMeasurable.r_c2_performance) . 
      this/c2_performance.c2_performance_ref]]) && 
    (all show_this: this/c63_total_performance | 
      one (show_this . this/c63_total_performance.c63_total_performance_ref) && 
      (show_this . this/c63_total_performance.c63_total_performance_ref) in ints
     ) && 
    (this/c63_total_performance.c63_total_performance_ref . univ) in 
    this/c63_total_performance && 
    (all show_this: this/c63_total_performance | 
      one (this/c3_Apache.r_c63_total_performance . show_this)) && 
    (all show_this: this/bag_extra_ints | 
      (show_this . this/bag_extra_ints.extra_ints) in ints) && 
    (this/bag_extra_ints.extra_ints . univ) in this/bag_extra_ints && 
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
    this/bag_extra_ints = this/bag_extra_ints && 
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
    this/c63_total_performance.c63_total_performance_ref && 
    this/bag_extra_ints.extra_ints = this/bag_extra_ints.extra_ints
  ==================================================
*/
public final class ApacheMoo {

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
Relation x18 = Relation.unary("this/bag_extra_ints");
Relation x19 = Relation.nary("this/c1_IMeasurable.r_c2_performance", 2);
Relation x20 = Relation.nary("this/c2_performance.c2_performance_ref", 2);
Relation x21 = Relation.nary("this/c3_Apache.r_c4_Base", 2);
Relation x22 = Relation.nary("this/c3_Apache.r_c10_HostnameLookups", 2);
Relation x23 = Relation.nary("this/c3_Apache.r_c17_KeepAlive", 2);
Relation x24 = Relation.nary("this/c3_Apache.r_c23_EnableSendfile", 2);
Relation x25 = Relation.nary("this/c3_Apache.r_c29_FollowSymLinks", 2);
Relation x26 = Relation.nary("this/c3_Apache.r_c35_AccessLog", 2);
Relation x27 = Relation.nary("this/c3_Apache.r_c42_ExtendedStatus", 2);
Relation x28 = Relation.nary("this/c3_Apache.r_c49_InMemory", 2);
Relation x29 = Relation.nary("this/c3_Apache.r_c57_Handle", 2);
Relation x30 = Relation.nary("this/c3_Apache.r_c63_total_performance", 2);
Relation x31 = Relation.nary("this/c63_total_performance.c63_total_performance_ref", 2);
Relation x32 = Relation.nary("this/bag_extra_ints.extra_ints", 2);

List<String> atomlist = Arrays.asList(
 "-1", "-11", "-15", "-18", "-2",
 "-22", "-26", "-3", "-33", "-37", "-4",
 "-41", "-48", "-5", "-52", "-6", "-7",
 "-8", "0", "1", "102", "105", "109",
 "11", "113", "116", "117", "120", "124",
 "128", "131", "132", "135", "139", "143",
 "146", "15", "150", "154", "158", "161",
 "165", "169", "176", "180", "184", "19",
 "191", "195", "2", "203", "207", "214",
 "218", "222", "229", "233", "237", "240",
 "244", "248", "255", "259", "26", "263",
 "266", "270", "274", "281", "285", "289",
 "296", "3", "30", "300", "34", "4",
 "41", "45", "5", "53", "57", "6",
 "64", "68", "7", "72", "79", "8",
 "83", "87", "90", "94", "98", "c101_simpleConfig$0",
 "c63_total_performance$0", "concrete_int_bag%", "partial_c17_KeepAlive%", "partial_c29_FollowSymLinks%", "partial_c42_ExtendedStatus%", "partial_c4_Base%",
 "partial_c57_Handle%", "performance_for_c17_KeepAlive_of_105%", "performance_for_c29_FollowSymLinks_of_0%", "performance_for_c42_ExtendedStatus_of_minus11%", "performance_for_c4_Base_of_150%", "performance_for_c57_Handle_of_4%",
 "unused0", "unused1", "unused2", "unused3", "unused4", "unused5",
 "unused6", "unused7"
);
String[] test = new String[]{
"-1", "-11", "-15", "-18", "-2",
"-22", "-26", "-3", "-33", "-37", "-4",
"-41", "-48", "-5", "-52", "-6", "-7",
"-8", "0", "1", "102", "105", "109",
"11", "113", "116", "117", "120", "124",
"128", "131", "132", "135", "139", "143",
"146", "15", "150", "154", "158", "161",
"165", "169", "176", "180", "184", "19",
"191", "195", "2", "203", "207", "214",
"218", "222", "229", "233", "237", "240",
"244", "248", "255", "259", "26", "263",
"266", "270", "274", "281", "285", "289",
"296", "3", "30", "300", "34", "4",
"41", "45", "5", "53", "57", "6",
"64", "68", "7", "72", "79", "8",
"83", "87", "90", "94", "98"
};
System.out.println(test.length);
Universe universe = new Universe(atomlist);
TupleFactory factory = universe.factory();
Bounds bounds = new Bounds(universe);

TupleSet x0_upper = factory.noneOf(1);
x0_upper.add(factory.tuple("-52"));
bounds.boundExactly(x0, x0_upper);

TupleSet x1_upper = factory.noneOf(1);
x1_upper.add(factory.tuple("0"));
bounds.boundExactly(x1, x1_upper);

TupleSet x2_upper = factory.noneOf(1);
x2_upper.add(factory.tuple("300"));
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
x3_upper.add(factory.tuple("7").product(factory.tuple("8")));
x3_upper.add(factory.tuple("-52").product(factory.tuple("-48")));
x3_upper.add(factory.tuple("-48").product(factory.tuple("-41")));
x3_upper.add(factory.tuple("-41").product(factory.tuple("-37")));
x3_upper.add(factory.tuple("-37").product(factory.tuple("-33")));
x3_upper.add(factory.tuple("-33").product(factory.tuple("-26")));
x3_upper.add(factory.tuple("-26").product(factory.tuple("-22")));
x3_upper.add(factory.tuple("-22").product(factory.tuple("-18")));
x3_upper.add(factory.tuple("-18").product(factory.tuple("-15")));
x3_upper.add(factory.tuple("-15").product(factory.tuple("-11")));
x3_upper.add(factory.tuple("-11").product(factory.tuple("-8")));
x3_upper.add(factory.tuple("8").product(factory.tuple("11")));
x3_upper.add(factory.tuple("11").product(factory.tuple("15")));
x3_upper.add(factory.tuple("15").product(factory.tuple("19")));
x3_upper.add(factory.tuple("19").product(factory.tuple("26")));
x3_upper.add(factory.tuple("26").product(factory.tuple("30")));
x3_upper.add(factory.tuple("30").product(factory.tuple("34")));
x3_upper.add(factory.tuple("34").product(factory.tuple("41")));
x3_upper.add(factory.tuple("41").product(factory.tuple("45")));
x3_upper.add(factory.tuple("45").product(factory.tuple("53")));
x3_upper.add(factory.tuple("53").product(factory.tuple("57")));
x3_upper.add(factory.tuple("57").product(factory.tuple("64")));
x3_upper.add(factory.tuple("64").product(factory.tuple("68")));
x3_upper.add(factory.tuple("68").product(factory.tuple("72")));
x3_upper.add(factory.tuple("72").product(factory.tuple("79")));
x3_upper.add(factory.tuple("79").product(factory.tuple("83")));
x3_upper.add(factory.tuple("83").product(factory.tuple("87")));
x3_upper.add(factory.tuple("87").product(factory.tuple("90")));
x3_upper.add(factory.tuple("90").product(factory.tuple("94")));
x3_upper.add(factory.tuple("94").product(factory.tuple("98")));
x3_upper.add(factory.tuple("98").product(factory.tuple("102")));
x3_upper.add(factory.tuple("102").product(factory.tuple("105")));
x3_upper.add(factory.tuple("105").product(factory.tuple("109")));
x3_upper.add(factory.tuple("109").product(factory.tuple("113")));
x3_upper.add(factory.tuple("113").product(factory.tuple("116")));
x3_upper.add(factory.tuple("116").product(factory.tuple("117")));
x3_upper.add(factory.tuple("117").product(factory.tuple("120")));
x3_upper.add(factory.tuple("120").product(factory.tuple("124")));
x3_upper.add(factory.tuple("124").product(factory.tuple("128")));
x3_upper.add(factory.tuple("128").product(factory.tuple("131")));
x3_upper.add(factory.tuple("131").product(factory.tuple("132")));
x3_upper.add(factory.tuple("132").product(factory.tuple("135")));
x3_upper.add(factory.tuple("135").product(factory.tuple("139")));
x3_upper.add(factory.tuple("139").product(factory.tuple("143")));
x3_upper.add(factory.tuple("143").product(factory.tuple("146")));
x3_upper.add(factory.tuple("146").product(factory.tuple("150")));
x3_upper.add(factory.tuple("150").product(factory.tuple("154")));
x3_upper.add(factory.tuple("154").product(factory.tuple("158")));
x3_upper.add(factory.tuple("158").product(factory.tuple("161")));
x3_upper.add(factory.tuple("161").product(factory.tuple("165")));
x3_upper.add(factory.tuple("165").product(factory.tuple("169")));
x3_upper.add(factory.tuple("169").product(factory.tuple("176")));
x3_upper.add(factory.tuple("176").product(factory.tuple("180")));
x3_upper.add(factory.tuple("180").product(factory.tuple("184")));
x3_upper.add(factory.tuple("184").product(factory.tuple("191")));
x3_upper.add(factory.tuple("191").product(factory.tuple("195")));
x3_upper.add(factory.tuple("195").product(factory.tuple("203")));
x3_upper.add(factory.tuple("203").product(factory.tuple("207")));
x3_upper.add(factory.tuple("207").product(factory.tuple("214")));
x3_upper.add(factory.tuple("214").product(factory.tuple("218")));
x3_upper.add(factory.tuple("218").product(factory.tuple("222")));
x3_upper.add(factory.tuple("222").product(factory.tuple("229")));
x3_upper.add(factory.tuple("229").product(factory.tuple("233")));
x3_upper.add(factory.tuple("233").product(factory.tuple("237")));
x3_upper.add(factory.tuple("237").product(factory.tuple("240")));
x3_upper.add(factory.tuple("240").product(factory.tuple("244")));
x3_upper.add(factory.tuple("244").product(factory.tuple("248")));
x3_upper.add(factory.tuple("248").product(factory.tuple("255")));
x3_upper.add(factory.tuple("255").product(factory.tuple("259")));
x3_upper.add(factory.tuple("259").product(factory.tuple("263")));
x3_upper.add(factory.tuple("263").product(factory.tuple("266")));
x3_upper.add(factory.tuple("266").product(factory.tuple("270")));
x3_upper.add(factory.tuple("270").product(factory.tuple("274")));
x3_upper.add(factory.tuple("274").product(factory.tuple("281")));
x3_upper.add(factory.tuple("281").product(factory.tuple("285")));
x3_upper.add(factory.tuple("285").product(factory.tuple("289")));
x3_upper.add(factory.tuple("289").product(factory.tuple("296")));
x3_upper.add(factory.tuple("296").product(factory.tuple("300")));
bounds.boundExactly(x3, x3_upper);

TupleSet x4_upper = factory.noneOf(1);
x4_upper.add(factory.tuple("0"));
bounds.boundExactly(x4, x4_upper);

TupleSet x5_upper = factory.noneOf(1);
bounds.boundExactly(x5, x5_upper);

TupleSet x6_upper = factory.noneOf(1);
x6_upper.add(factory.tuple("partial_c4_Base%"));
bounds.bound(x6, x6_upper);

TupleSet x7_upper = factory.noneOf(1);
x7_upper.add(factory.tuple("unused0"));
bounds.bound(x7, x7_upper);

TupleSet x8_upper = factory.noneOf(1);
x8_upper.add(factory.tuple("partial_c17_KeepAlive%"));
bounds.bound(x8, x8_upper);

TupleSet x9_upper = factory.noneOf(1);
x9_upper.add(factory.tuple("unused1"));
bounds.bound(x9, x9_upper);

TupleSet x10_upper = factory.noneOf(1);
x10_upper.add(factory.tuple("partial_c29_FollowSymLinks%"));
bounds.bound(x10, x10_upper);

TupleSet x11_upper = factory.noneOf(1);
x11_upper.add(factory.tuple("unused2"));
bounds.bound(x11, x11_upper);

TupleSet x12_upper = factory.noneOf(1);
x12_upper.add(factory.tuple("partial_c42_ExtendedStatus%"));
bounds.bound(x12, x12_upper);

TupleSet x13_upper = factory.noneOf(1);
x13_upper.add(factory.tuple("unused3"));
bounds.bound(x13, x13_upper);

TupleSet x14_upper = factory.noneOf(1);
x14_upper.add(factory.tuple("partial_c57_Handle%"));
bounds.bound(x14, x14_upper);

TupleSet x15_upper = factory.noneOf(1);
x15_upper.add(factory.tuple("performance_for_c4_Base_of_150%"));
x15_upper.add(factory.tuple("unused4"));
x15_upper.add(factory.tuple("performance_for_c17_KeepAlive_of_105%"));
x15_upper.add(factory.tuple("unused5"));
x15_upper.add(factory.tuple("performance_for_c29_FollowSymLinks_of_0%"));
x15_upper.add(factory.tuple("unused6"));
x15_upper.add(factory.tuple("performance_for_c42_ExtendedStatus_of_minus11%"));
x15_upper.add(factory.tuple("unused7"));
x15_upper.add(factory.tuple("performance_for_c57_Handle_of_4%"));
bounds.bound(x15, x15_upper);

TupleSet x16_upper = factory.noneOf(1);
x16_upper.add(factory.tuple("c101_simpleConfig$0"));
bounds.boundExactly(x16, x16_upper);

TupleSet x17_upper = factory.noneOf(1);
x17_upper.add(factory.tuple("c63_total_performance$0"));
bounds.bound(x17, x17_upper);

TupleSet x18_upper = factory.noneOf(1);
x18_upper.add(factory.tuple("concrete_int_bag%"));
bounds.boundExactly(x18, x18_upper);

TupleSet x19_upper = factory.noneOf(2);
x19_upper.add(factory.tuple("partial_c4_Base%").product(factory.tuple("performance_for_c4_Base_of_150%")));
x19_upper.add(factory.tuple("unused0").product(factory.tuple("unused4")));
x19_upper.add(factory.tuple("partial_c17_KeepAlive%").product(factory.tuple("performance_for_c17_KeepAlive_of_105%")));
x19_upper.add(factory.tuple("unused1").product(factory.tuple("unused5")));
x19_upper.add(factory.tuple("partial_c29_FollowSymLinks%").product(factory.tuple("performance_for_c29_FollowSymLinks_of_0%")));
x19_upper.add(factory.tuple("unused2").product(factory.tuple("unused6")));
x19_upper.add(factory.tuple("partial_c42_ExtendedStatus%").product(factory.tuple("performance_for_c42_ExtendedStatus_of_minus11%")));
x19_upper.add(factory.tuple("unused3").product(factory.tuple("unused7")));
x19_upper.add(factory.tuple("partial_c57_Handle%").product(factory.tuple("performance_for_c57_Handle_of_4%")));
bounds.bound(x19, x19_upper);

TupleSet x20_upper = factory.noneOf(2);
x20_upper.add(factory.tuple("performance_for_c4_Base_of_150%").product(factory.tuple("150")));
x20_upper.add(factory.tuple("unused4").product(factory.tuple("-26")));
x20_upper.add(factory.tuple("performance_for_c17_KeepAlive_of_105%").product(factory.tuple("105")));
x20_upper.add(factory.tuple("unused5").product(factory.tuple("15")));
x20_upper.add(factory.tuple("performance_for_c29_FollowSymLinks_of_0%").product(factory.tuple("0")));
x20_upper.add(factory.tuple("unused6").product(factory.tuple("-15")));
x20_upper.add(factory.tuple("performance_for_c42_ExtendedStatus_of_minus11%").product(factory.tuple("-11")));
x20_upper.add(factory.tuple("unused7").product(factory.tuple("26")));
x20_upper.add(factory.tuple("performance_for_c57_Handle_of_4%").product(factory.tuple("4")));
bounds.bound(x20, x20_upper);

TupleSet x21_upper = factory.noneOf(2);
x21_upper.add(factory.tuple("c101_simpleConfig$0").product(factory.tuple("partial_c4_Base%")));
bounds.bound(x21, x21_upper);

TupleSet x22_upper = factory.noneOf(2);
x22_upper.add(factory.tuple("c101_simpleConfig$0").product(factory.tuple("unused0")));
bounds.bound(x22, x22_upper);

TupleSet x23_upper = factory.noneOf(2);
x23_upper.add(factory.tuple("c101_simpleConfig$0").product(factory.tuple("partial_c17_KeepAlive%")));
bounds.bound(x23, x23_upper);

TupleSet x24_upper = factory.noneOf(2);
x24_upper.add(factory.tuple("c101_simpleConfig$0").product(factory.tuple("unused1")));
bounds.bound(x24, x24_upper);

TupleSet x25_upper = factory.noneOf(2);
x25_upper.add(factory.tuple("c101_simpleConfig$0").product(factory.tuple("partial_c29_FollowSymLinks%")));
bounds.bound(x25, x25_upper);

TupleSet x26_upper = factory.noneOf(2);
x26_upper.add(factory.tuple("c101_simpleConfig$0").product(factory.tuple("unused2")));
bounds.bound(x26, x26_upper);

TupleSet x27_upper = factory.noneOf(2);
x27_upper.add(factory.tuple("c101_simpleConfig$0").product(factory.tuple("partial_c42_ExtendedStatus%")));
bounds.bound(x27, x27_upper);

TupleSet x28_upper = factory.noneOf(2);
x28_upper.add(factory.tuple("c101_simpleConfig$0").product(factory.tuple("unused3")));
bounds.bound(x28, x28_upper);

TupleSet x29_upper = factory.noneOf(2);
x29_upper.add(factory.tuple("c101_simpleConfig$0").product(factory.tuple("partial_c57_Handle%")));
bounds.bound(x29, x29_upper);

TupleSet x30_upper = factory.noneOf(2);
x30_upper.add(factory.tuple("c101_simpleConfig$0").product(factory.tuple("c63_total_performance$0")));
bounds.bound(x30, x30_upper);

TupleSet x31_upper = factory.noneOf(2);
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("-8")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("-7")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("-6")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("-5")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("-4")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("-3")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("-2")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("-1")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("0")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("1")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("2")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("3")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("4")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("5")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("6")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("7")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("-52")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("-48")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("-41")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("-37")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("-33")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("-26")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("-22")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("-18")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("-15")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("-11")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("8")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("11")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("15")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("19")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("26")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("30")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("34")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("41")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("45")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("53")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("57")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("64")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("68")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("72")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("79")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("83")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("87")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("90")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("94")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("98")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("102")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("105")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("109")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("113")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("116")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("117")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("120")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("124")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("128")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("131")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("132")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("135")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("139")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("143")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("146")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("150")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("154")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("158")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("161")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("165")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("169")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("176")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("180")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("184")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("191")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("195")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("203")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("207")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("214")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("218")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("222")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("229")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("233")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("237")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("240")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("244")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("248")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("255")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("259")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("263")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("266")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("270")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("274")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("281")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("285")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("289")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("296")));
x31_upper.add(factory.tuple("c63_total_performance$0").product(factory.tuple("300")));
bounds.bound(x31, x31_upper);

TupleSet x32_upper = factory.noneOf(2);
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("-7")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("-52")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("-48")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("-41")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("-37")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("-33")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("-22")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("-18")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("8")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("11")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("19")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("30")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("34")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("41")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("45")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("53")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("57")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("64")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("68")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("72")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("79")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("83")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("87")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("90")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("94")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("98")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("102")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("109")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("113")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("116")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("117")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("120")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("124")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("128")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("131")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("132")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("135")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("139")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("143")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("146")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("154")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("158")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("161")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("165")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("169")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("176")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("180")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("184")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("191")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("195")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("203")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("207")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("214")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("218")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("222")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("229")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("233")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("237")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("240")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("244")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("248")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("255")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("259")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("263")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("266")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("270")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("274")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("281")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("285")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("289")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("296")));
x32_upper.add(factory.tuple("concrete_int_bag%").product(factory.tuple("300")));
bounds.boundExactly(x32, x32_upper);

bounds.boundExactly(-52,factory.range(factory.tuple("-52"),factory.tuple("-52")));
bounds.boundExactly(-48,factory.range(factory.tuple("-48"),factory.tuple("-48")));
bounds.boundExactly(-41,factory.range(factory.tuple("-41"),factory.tuple("-41")));
bounds.boundExactly(-37,factory.range(factory.tuple("-37"),factory.tuple("-37")));
bounds.boundExactly(-33,factory.range(factory.tuple("-33"),factory.tuple("-33")));
bounds.boundExactly(-26,factory.range(factory.tuple("-26"),factory.tuple("-26")));
bounds.boundExactly(-22,factory.range(factory.tuple("-22"),factory.tuple("-22")));
bounds.boundExactly(-18,factory.range(factory.tuple("-18"),factory.tuple("-18")));
bounds.boundExactly(-15,factory.range(factory.tuple("-15"),factory.tuple("-15")));
bounds.boundExactly(-11,factory.range(factory.tuple("-11"),factory.tuple("-11")));
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
bounds.boundExactly(11,factory.range(factory.tuple("11"),factory.tuple("11")));
bounds.boundExactly(15,factory.range(factory.tuple("15"),factory.tuple("15")));
bounds.boundExactly(19,factory.range(factory.tuple("19"),factory.tuple("19")));
bounds.boundExactly(26,factory.range(factory.tuple("26"),factory.tuple("26")));
bounds.boundExactly(30,factory.range(factory.tuple("30"),factory.tuple("30")));
bounds.boundExactly(34,factory.range(factory.tuple("34"),factory.tuple("34")));
bounds.boundExactly(41,factory.range(factory.tuple("41"),factory.tuple("41")));
bounds.boundExactly(45,factory.range(factory.tuple("45"),factory.tuple("45")));
bounds.boundExactly(53,factory.range(factory.tuple("53"),factory.tuple("53")));
bounds.boundExactly(57,factory.range(factory.tuple("57"),factory.tuple("57")));
bounds.boundExactly(64,factory.range(factory.tuple("64"),factory.tuple("64")));
bounds.boundExactly(68,factory.range(factory.tuple("68"),factory.tuple("68")));
bounds.boundExactly(72,factory.range(factory.tuple("72"),factory.tuple("72")));
bounds.boundExactly(79,factory.range(factory.tuple("79"),factory.tuple("79")));
bounds.boundExactly(83,factory.range(factory.tuple("83"),factory.tuple("83")));
bounds.boundExactly(87,factory.range(factory.tuple("87"),factory.tuple("87")));
bounds.boundExactly(90,factory.range(factory.tuple("90"),factory.tuple("90")));
bounds.boundExactly(94,factory.range(factory.tuple("94"),factory.tuple("94")));
bounds.boundExactly(98,factory.range(factory.tuple("98"),factory.tuple("98")));
bounds.boundExactly(102,factory.range(factory.tuple("102"),factory.tuple("102")));
bounds.boundExactly(105,factory.range(factory.tuple("105"),factory.tuple("105")));
bounds.boundExactly(109,factory.range(factory.tuple("109"),factory.tuple("109")));
bounds.boundExactly(113,factory.range(factory.tuple("113"),factory.tuple("113")));
bounds.boundExactly(116,factory.range(factory.tuple("116"),factory.tuple("116")));
bounds.boundExactly(117,factory.range(factory.tuple("117"),factory.tuple("117")));
bounds.boundExactly(120,factory.range(factory.tuple("120"),factory.tuple("120")));
bounds.boundExactly(124,factory.range(factory.tuple("124"),factory.tuple("124")));
bounds.boundExactly(128,factory.range(factory.tuple("128"),factory.tuple("128")));
bounds.boundExactly(131,factory.range(factory.tuple("131"),factory.tuple("131")));
bounds.boundExactly(132,factory.range(factory.tuple("132"),factory.tuple("132")));
bounds.boundExactly(135,factory.range(factory.tuple("135"),factory.tuple("135")));
bounds.boundExactly(139,factory.range(factory.tuple("139"),factory.tuple("139")));
bounds.boundExactly(143,factory.range(factory.tuple("143"),factory.tuple("143")));
bounds.boundExactly(146,factory.range(factory.tuple("146"),factory.tuple("146")));
bounds.boundExactly(150,factory.range(factory.tuple("150"),factory.tuple("150")));
bounds.boundExactly(154,factory.range(factory.tuple("154"),factory.tuple("154")));
bounds.boundExactly(158,factory.range(factory.tuple("158"),factory.tuple("158")));
bounds.boundExactly(161,factory.range(factory.tuple("161"),factory.tuple("161")));
bounds.boundExactly(165,factory.range(factory.tuple("165"),factory.tuple("165")));
bounds.boundExactly(169,factory.range(factory.tuple("169"),factory.tuple("169")));
bounds.boundExactly(176,factory.range(factory.tuple("176"),factory.tuple("176")));
bounds.boundExactly(180,factory.range(factory.tuple("180"),factory.tuple("180")));
bounds.boundExactly(184,factory.range(factory.tuple("184"),factory.tuple("184")));
bounds.boundExactly(191,factory.range(factory.tuple("191"),factory.tuple("191")));
bounds.boundExactly(195,factory.range(factory.tuple("195"),factory.tuple("195")));
bounds.boundExactly(203,factory.range(factory.tuple("203"),factory.tuple("203")));
bounds.boundExactly(207,factory.range(factory.tuple("207"),factory.tuple("207")));
bounds.boundExactly(214,factory.range(factory.tuple("214"),factory.tuple("214")));
bounds.boundExactly(218,factory.range(factory.tuple("218"),factory.tuple("218")));
bounds.boundExactly(222,factory.range(factory.tuple("222"),factory.tuple("222")));
bounds.boundExactly(229,factory.range(factory.tuple("229"),factory.tuple("229")));
bounds.boundExactly(233,factory.range(factory.tuple("233"),factory.tuple("233")));
bounds.boundExactly(237,factory.range(factory.tuple("237"),factory.tuple("237")));
bounds.boundExactly(240,factory.range(factory.tuple("240"),factory.tuple("240")));
bounds.boundExactly(244,factory.range(factory.tuple("244"),factory.tuple("244")));
bounds.boundExactly(248,factory.range(factory.tuple("248"),factory.tuple("248")));
bounds.boundExactly(255,factory.range(factory.tuple("255"),factory.tuple("255")));
bounds.boundExactly(259,factory.range(factory.tuple("259"),factory.tuple("259")));
bounds.boundExactly(263,factory.range(factory.tuple("263"),factory.tuple("263")));
bounds.boundExactly(266,factory.range(factory.tuple("266"),factory.tuple("266")));
bounds.boundExactly(270,factory.range(factory.tuple("270"),factory.tuple("270")));
bounds.boundExactly(274,factory.range(factory.tuple("274"),factory.tuple("274")));
bounds.boundExactly(281,factory.range(factory.tuple("281"),factory.tuple("281")));
bounds.boundExactly(285,factory.range(factory.tuple("285"),factory.tuple("285")));
bounds.boundExactly(289,factory.range(factory.tuple("289"),factory.tuple("289")));
bounds.boundExactly(296,factory.range(factory.tuple("296"),factory.tuple("296")));
bounds.boundExactly(300,factory.range(factory.tuple("300"),factory.tuple("300")));

Expression x35=x6.intersection(x7);
Formula x34=x35.no();
Expression x38=x6.union(x7);
Expression x37=x38.intersection(x8);
Formula x36=x37.no();
Expression x41=x38.union(x8);
Expression x40=x41.intersection(x9);
Formula x39=x40.no();
Expression x44=x41.union(x9);
Expression x43=x44.intersection(x10);
Formula x42=x43.no();
Expression x47=x44.union(x10);
Expression x46=x47.intersection(x11);
Formula x45=x46.no();
Expression x50=x47.union(x11);
Expression x49=x50.intersection(x12);
Formula x48=x49.no();
Expression x53=x50.union(x12);
Expression x52=x53.intersection(x13);
Formula x51=x52.no();
Expression x56=x53.union(x13);
Expression x55=x56.intersection(x14);
Formula x54=x55.no();
Variable x59=Variable.unary("show_this");
Decls x58=x59.oneOf(x6);
Expression x62=x21.join(x59);
Formula x61=x62.one();
Expression x65=x59.join(x19);
Expression x64=x65.join(x20);
IntExpression x67=IntConstant.constant(150);
Expression x66=x67.toExpression();
Formula x63=x64.eq(x66);
Formula x60=x61.and(x63);
Formula x57=x60.forAll(x58);
Variable x70=Variable.unary("show_this");
Decls x69=x70.oneOf(x7);
Expression x73=x22.join(x70);
Formula x72=x73.one();
Expression x76=x70.join(x19);
Expression x75=x76.join(x20);
IntExpression x78=IntConstant.constant(-26);
Expression x77=x78.toExpression();
Formula x74=x75.eq(x77);
Formula x71=x72.and(x74);
Formula x68=x71.forAll(x69);
Variable x81=Variable.unary("show_this");
Decls x80=x81.oneOf(x8);
Expression x84=x23.join(x81);
Formula x83=x84.one();
Expression x87=x81.join(x19);
Expression x86=x87.join(x20);
IntExpression x89=IntConstant.constant(105);
Expression x88=x89.toExpression();
Formula x85=x86.eq(x88);
Formula x82=x83.and(x85);
Formula x79=x82.forAll(x80);
Variable x92=Variable.unary("show_this");
Decls x91=x92.oneOf(x9);
Expression x95=x24.join(x92);
Formula x94=x95.one();
Expression x98=x92.join(x19);
Expression x97=x98.join(x20);
IntExpression x100=IntConstant.constant(15);
Expression x99=x100.toExpression();
Formula x96=x97.eq(x99);
Formula x93=x94.and(x96);
Formula x90=x93.forAll(x91);
Variable x103=Variable.unary("show_this");
Decls x102=x103.oneOf(x10);
Expression x106=x25.join(x103);
Formula x105=x106.one();
Expression x109=x103.join(x19);
Expression x108=x109.join(x20);
IntExpression x111=IntConstant.constant(0);
Expression x110=x111.toExpression();
Formula x107=x108.eq(x110);
Formula x104=x105.and(x107);
Formula x101=x104.forAll(x102);
Variable x114=Variable.unary("show_this");
Decls x113=x114.oneOf(x11);
Expression x117=x26.join(x114);
Formula x116=x117.one();
Expression x120=x114.join(x19);
Expression x119=x120.join(x20);
IntExpression x122=IntConstant.constant(-15);
Expression x121=x122.toExpression();
Formula x118=x119.eq(x121);
Formula x115=x116.and(x118);
Formula x112=x115.forAll(x113);
Variable x125=Variable.unary("show_this");
Decls x124=x125.oneOf(x12);
Expression x128=x27.join(x125);
Formula x127=x128.one();
Expression x131=x125.join(x19);
Expression x130=x131.join(x20);
IntExpression x133=IntConstant.constant(-11);
Expression x132=x133.toExpression();
Formula x129=x130.eq(x132);
Formula x126=x127.and(x129);
Formula x123=x126.forAll(x124);
Variable x136=Variable.unary("show_this");
Decls x135=x136.oneOf(x13);
Expression x140=x28.join(x136);
Formula x139=x140.one();
Expression x144=x28.transpose();
Expression x143=x136.join(x144);
Expression x142=x143.join(x29);
Formula x141=x142.no();
Formula x138=x139.and(x141);
Expression x147=x136.join(x19);
Expression x146=x147.join(x20);
IntExpression x149=IntConstant.constant(26);
Expression x148=x149.toExpression();
Formula x145=x146.eq(x148);
Formula x137=x138.and(x145);
Formula x134=x137.forAll(x135);
Variable x152=Variable.unary("show_this");
Decls x151=x152.oneOf(x14);
Expression x155=x29.join(x152);
Formula x154=x155.one();
Expression x158=x152.join(x19);
Expression x157=x158.join(x20);
IntExpression x160=IntConstant.constant(4);
Expression x159=x160.toExpression();
Formula x156=x157.eq(x159);
Formula x153=x154.and(x156);
Formula x150=x153.forAll(x151);
Variable x163=Variable.unary("show_this");
Expression x164=x56.union(x14);
Decls x162=x163.oneOf(x164);
Expression x167=x163.join(x19);
Formula x166=x167.one();
Formula x168=x167.in(x15);
Formula x165=x166.and(x168);
Formula x161=x165.forAll(x162);
Expression x170=x19.join(Expression.UNIV);
Formula x169=x170.in(x164);
Variable x174=Variable.unary("show_this");
Decls x173=x174.oneOf(x15);
Expression x177=x174.join(x20);
Formula x176=x177.one();
Formula x178=x177.in(Expression.INTS);
Formula x175=x176.and(x178);
Formula x172=x175.forAll(x173);
Expression x181=x20.join(Expression.UNIV);
Formula x180=x181.in(x15);
Variable x184=Variable.unary("show_this");
Decls x183=x184.oneOf(x15);
Expression x186=x19.join(x184);
Formula x185=x186.one();
Formula x182=x185.forAll(x183);
Expression x190=x16.join(x21);
Formula x189=x190.some();
Expression x194=x16.join(x22);
Formula x193=x194.no();
Expression x196=x16.join(x24);
Formula x195=x196.no();
Formula x192=x193.and(x195);
Expression x198=x16.join(x25);
Formula x197=x198.some();
Formula x191=x192.and(x197);
Formula x188=x189.and(x191);
Expression x202=x16.join(x23);
Formula x201=x202.some();
Expression x204=x16.join(x27);
Formula x203=x204.some();
Formula x200=x201.and(x203);
Expression x206=x16.join(x28);
Formula x205=x206.no();
Formula x199=x200.and(x205);
Formula x187=x188.and(x199);
Variable x209=Variable.unary("show_this");
Decls x208=x209.oneOf(x16);
Expression x212=x209.join(x21);
Formula x211=x212.one();
Formula x213=x212.in(x6);
Formula x210=x211.and(x213);
Formula x207=x210.forAll(x208);
Expression x215=x21.join(Expression.UNIV);
Formula x214=x215.in(x16);
Variable x218=Variable.unary("show_this");
Decls x217=x218.oneOf(x16);
Expression x221=x218.join(x22);
Formula x220=x221.lone();
Formula x222=x221.in(x7);
Formula x219=x220.and(x222);
Formula x216=x219.forAll(x217);
Expression x224=x22.join(Expression.UNIV);
Formula x223=x224.in(x16);
Variable x227=Variable.unary("show_this");
Decls x226=x227.oneOf(x16);
Expression x230=x227.join(x23);
Formula x229=x230.lone();
Formula x231=x230.in(x8);
Formula x228=x229.and(x231);
Formula x225=x228.forAll(x226);
Expression x233=x23.join(Expression.UNIV);
Formula x232=x233.in(x16);
Variable x236=Variable.unary("show_this");
Decls x235=x236.oneOf(x16);
Expression x239=x236.join(x24);
Formula x238=x239.lone();
Formula x240=x239.in(x9);
Formula x237=x238.and(x240);
Formula x234=x237.forAll(x235);
Expression x242=x24.join(Expression.UNIV);
Formula x241=x242.in(x16);
Variable x245=Variable.unary("show_this");
Decls x244=x245.oneOf(x16);
Expression x248=x245.join(x25);
Formula x247=x248.lone();
Formula x249=x248.in(x10);
Formula x246=x247.and(x249);
Formula x243=x246.forAll(x244);
Expression x251=x25.join(Expression.UNIV);
Formula x250=x251.in(x16);
Variable x254=Variable.unary("show_this");
Decls x253=x254.oneOf(x16);
Expression x257=x254.join(x26);
Formula x256=x257.lone();
Formula x258=x257.in(x11);
Formula x255=x256.and(x258);
Formula x252=x255.forAll(x253);
Expression x260=x26.join(Expression.UNIV);
Formula x259=x260.in(x16);
Variable x263=Variable.unary("show_this");
Decls x262=x263.oneOf(x16);
Expression x266=x263.join(x27);
Formula x265=x266.lone();
Formula x267=x266.in(x12);
Formula x264=x265.and(x267);
Formula x261=x264.forAll(x262);
Expression x269=x27.join(Expression.UNIV);
Formula x268=x269.in(x16);
Variable x272=Variable.unary("show_this");
Decls x271=x272.oneOf(x16);
Expression x275=x272.join(x28);
Formula x274=x275.lone();
Formula x276=x275.in(x13);
Formula x273=x274.and(x276);
Formula x270=x273.forAll(x271);
Expression x278=x28.join(Expression.UNIV);
Formula x277=x278.in(x16);
Variable x281=Variable.unary("show_this");
Decls x280=x281.oneOf(x16);
Expression x284=x281.join(x29);
Formula x283=x284.lone();
Formula x285=x284.in(x14);
Formula x282=x283.and(x285);
Formula x279=x282.forAll(x280);
Expression x287=x29.join(Expression.UNIV);
Formula x286=x287.in(x16);
Variable x290=Variable.unary("show_this");
Decls x289=x290.oneOf(x16);
Expression x293=x290.join(x30);
Formula x292=x293.one();
Formula x294=x293.in(x17);
Formula x291=x292.and(x294);
Formula x288=x291.forAll(x289);
Expression x296=x30.join(Expression.UNIV);
Formula x295=x296.in(x16);
Variable x299=Variable.unary("show_this");
Decls x298=x299.oneOf(x16);
Expression x302=x299.join(x30);
Expression x301=x302.join(x31);
Expression x315=x299.join(x21);
Expression x314=x315.join(x19);
Expression x313=x314.join(x20);
IntExpression x312=x313.sum();
Expression x319=x299.join(x22);
Expression x318=x319.join(x19);
Expression x317=x318.join(x20);
IntExpression x316=x317.sum();
IntExpression x311=x312.plus(x316);
Expression x323=x299.join(x23);
Expression x322=x323.join(x19);
Expression x321=x322.join(x20);
IntExpression x320=x321.sum();
IntExpression x310=x311.plus(x320);
Expression x327=x299.join(x24);
Expression x326=x327.join(x19);
Expression x325=x326.join(x20);
IntExpression x324=x325.sum();
IntExpression x309=x310.plus(x324);
Expression x331=x299.join(x25);
Expression x330=x331.join(x19);
Expression x329=x330.join(x20);
IntExpression x328=x329.sum();
IntExpression x308=x309.plus(x328);
Expression x335=x299.join(x26);
Expression x334=x335.join(x19);
Expression x333=x334.join(x20);
IntExpression x332=x333.sum();
IntExpression x307=x308.plus(x332);
Expression x339=x299.join(x27);
Expression x338=x339.join(x19);
Expression x337=x338.join(x20);
IntExpression x336=x337.sum();
IntExpression x306=x307.plus(x336);
Expression x343=x299.join(x28);
Expression x342=x343.join(x19);
Expression x341=x342.join(x20);
IntExpression x340=x341.sum();
IntExpression x305=x306.plus(x340);
Expression x347=x299.join(x29);
Expression x346=x347.join(x19);
Expression x345=x346.join(x20);
IntExpression x344=x345.sum();
IntExpression x304=x305.plus(x344);
Expression x303=x304.toExpression();
Formula x300=x301.eq(x303);
Formula x297=x300.forAll(x298);
Variable x350=Variable.unary("show_this");
Decls x349=x350.oneOf(x17);
Expression x353=x350.join(x31);
Formula x352=x353.one();
Formula x354=x353.in(Expression.INTS);
Formula x351=x352.and(x354);
Formula x348=x351.forAll(x349);
Expression x356=x31.join(Expression.UNIV);
Formula x355=x356.in(x17);
Variable x359=Variable.unary("show_this");
Decls x358=x359.oneOf(x17);
Expression x361=x30.join(x359);
Formula x360=x361.one();
Formula x357=x360.forAll(x358);
Variable x364=Variable.unary("show_this");
Decls x363=x364.oneOf(x18);
Expression x366=x364.join(x32);
Formula x365=x366.in(Expression.INTS);
Formula x362=x365.forAll(x363);
Expression x368=x32.join(Expression.UNIV);
Formula x367=x368.in(x18);
Formula x369=x0.eq(x0);
Formula x370=x1.eq(x1);
Formula x371=x2.eq(x2);
Formula x372=x3.eq(x3);
Formula x373=x4.eq(x4);
Formula x374=x5.eq(x5);
Formula x375=x6.eq(x6);
Formula x376=x7.eq(x7);
Formula x377=x8.eq(x8);
Formula x378=x9.eq(x9);
Formula x379=x10.eq(x10);
Formula x380=x11.eq(x11);
Formula x381=x12.eq(x12);
Formula x382=x13.eq(x13);
Formula x383=x14.eq(x14);
Formula x384=x15.eq(x15);
Formula x385=x16.eq(x16);
Formula x386=x17.eq(x17);
Formula x387=x18.eq(x18);
Formula x388=x19.eq(x19);
Formula x389=x20.eq(x20);
Formula x390=x21.eq(x21);
Formula x391=x22.eq(x22);
Formula x392=x23.eq(x23);
Formula x393=x24.eq(x24);
Formula x394=x25.eq(x25);
Formula x395=x26.eq(x26);
Formula x396=x27.eq(x27);
Formula x397=x28.eq(x28);
Formula x398=x29.eq(x29);
Formula x399=x30.eq(x30);
Formula x400=x31.eq(x31);
Formula x401=x32.eq(x32);
Formula x33=Formula.compose(FormulaOperator.AND, x34, x36, x39, x42, x45, x48, x51, x54, x57, x68, x79, x90, x101, x112, x123, x134, x150, x161, x169, x172, x180, x182, x187, x207, x214, x216, x223, x225, x232, x234, x241, x243, x250, x252, x259, x261, x268, x270, x277, x279, x286, x288, x295, x297, x348, x355, x357, x362, x367, x369, x370, x371, x372, x373, x374, x375, x376, x377, x378, x379, x380, x381, x382, x383, x384, x385, x386, x387, x388, x389, x390, x391, x392, x393, x394, x395, x396, x397, x398, x399, x400, x401);

Solver solver = new Solver();
solver.options().setSolver(SATFactory.DefaultSAT4J);
solver.options().setBitwidth(4);
solver.options().setIntEncoding(Options.IntEncoding.TWOSCOMPLEMENT);
solver.options().setSymmetryBreaking(20);
solver.options().setSkolemDepth(0);
System.out.println("Solving...");
System.out.flush();
Solution sol = solver.solve(x33,bounds);
System.out.println(sol.toString());
}}
