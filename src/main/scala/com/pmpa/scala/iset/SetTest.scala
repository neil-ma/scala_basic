package com.pmpa.scala.iset

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

/**
 * Created by natty.ma on 2018/1/16.
 */

/**
 *
 * List:
 *   Scala的List是不可变的，大小和其中的元素都不可以更改。由链表实现，包含head、tail、isEmpty等方法。
 *   ::方法接收2个参数，一个头元素，必须是单个的元素，一个是尾元素，是另一个list，结尾必须是Nil。::方法是从右向左构造的。
 *   任何以:号结尾的方法，都是从右向左执行。
 *   List不可变，但是可以通过filter、take、partition、splitAt等方法过滤元素后赋给一个新List
 *   使用 ::: 、++ 、concat方法合并两个列表
 *   Stream和List很像，不同之处是Stream是惰性计算的，和view类似，只有元素被访问时才会计算。Stream用#::方法构建，结尾使用Stream.empty
 *
 * ListBuffer:
 *   使用ListBuffer创建可变List，可以随时转换为List。ListBuffer是一个基于列表的缓冲实现。前置和附加操作的开销都是常量时间。
 *   如果要随机访问，请使用ArrayBuffer，而不要使用ListBuffer。
     使用+=可以一次添加一个或者多个元素。使用-=可以一次删除一个或者多个元素。
     remove方法按位置删除元素，从0开始计数。

  Array和ArrayBuffer：
     Scala的数组比较有趣，它的可变因为内在的元素可以修改，它的不可变是因为它的大小不可变（不能增减元素）。
     ArrayBuffer是可变序列，-=、--=、remove和clear方法都可以删除ArrayBuffer中的元素。
     数组排序：使用scala.util.Sorting.quickSort方法对数组排序
     多维数组：创建方法 ： 1：使用Array.ofDim来创建（最多五维）。方法2：创建数组的数组 ；访问方法：dimarray02(1)(1)

  Map：
     创建可变和不可变映射：使用scala.collection.mutable.Map来创建可变映射；直接使用Map创建不可变映射。
     使用+= 添加一个或者多个元素，使用++= 合并另一个map；使用 -= 或者 --=来删除map中的元素。注意删除时候，只提供key。
     使用put向映射添加元素。retain保留符合谓词的元素。remove去掉某个key的元素。clear清空映射。
     对于定义为var类型的不可变Map，向其中添加新的元素是可以的，但是update某一个元素确实不行的。如果不可变映射定义为val型，则也不可以增加元素
     查询一个不存在的key，会返回异常：java.util.NoSuchElementException
     使用keySet方法获得Map的Key的集合（返回一个Set）。使用keysIterator方法返回一个基于key的迭代器。使用keys方法获得一个Iterable。同样地，要获取values都有相应的方法，valuesIterator方法和values方法。
     遍历Map： for语句，foreach语句，
 */

object SetTest extends  App{

  /**
   * List            -----------------------------------------------------------------------
   */
  //创建List的各种方法
  val list01 = List(1,2,3)
  val list02 = 4::5::6::Nil
  var list03 = List.range[Int](0,4)
  //List添加元素： 11必须放在前边，::是List的一个方法，从右向左执行。
  val list04 = 11 :: list01
  list03 = 12::list03
  //在尾部添加元素13
  list03 = list03 :+ 13
  //在首部添加元素14
  list03 =  14 +: list03
  //使用filter方法过滤List，过滤后的值赋给一个新的List
  val list05 = list04.filter(_>2)
  //列表的合并：
  val list06 = list01 ::: list05
  val list07 = list01 ++ list05
  val list08 = List.concat(list01,list05,list02)
  //测试Stream，惰性List，只在计算时候才载入数据（例如：sum、max、size等）
  val stream01 = 72 #:: 98 #:: 187 #:: Stream.empty
  val stream02 = (1 to 1000000).toStream
//  println(stream02.filter(_>2000)) //惰性计算
//  println(stream02.sum)  //实际计算

  /**
   * ListBuffer       -----------------------------------------------------------------------
   */
  val listbuffer01 = new ListBuffer[String]()
  listbuffer01 += "orange"
  listbuffer01 += ("banana","mango")
  listbuffer01 += ("apple","mango")
  //删除一个或者多个元素
  listbuffer01 -= ("orange","mango")
  //按位置移去第3个元素（从序号0开始计数）
  listbuffer01.remove(2)

  /**
   * Array            -----------------------------------------------------------------------
   */
  //创建数组的多种方式：
  val array01 = Array(56,12,30)
  val array02 = Array.range(0,11)
  /*
    Array方法：def tabulate[T]( n: Int )(f: (Int)=> T): Array[T]
    返回指定长度数组，每个数组元素为指定函数的返回值，默认从 0 开始。
   */
  val array03 = Array.tabulate(5)(i=>i*2)
  val array04 = Array.fill(3)("fool")
  val array05 = List(1,2,3,45,6).toArray
  val array06 = "FOOL".toArray
//  println(array03(2))   //数组访问方法

  //排序Array
  scala.util.Sorting.quickSort(array01)
//  println(array01.mkString(","))

  /**
   * ArrayBuffer       -----------------------------------------------------------------------
   */
  //ArrayBuffer增加和删除元素：
  var arraybuffer01 = new ArrayBuffer[String]()
  arraybuffer01 += "John"
  arraybuffer01.append("Tony")
  arraybuffer01 += "Ara"
  arraybuffer01 -= "John"
  arraybuffer01.clear

  val arraybuffer02 = ArrayBuffer("Tommy","Cercei")
  arraybuffer02 += ("Tony","Ara")
  arraybuffer02.remove(0)
  arraybuffer02 --= Array("Cercei","Tony")
//  println(arraybuffer01.mkString(","))
//  println(arraybuffer02.mkString(","))

  /**
   * 多维数组       -----------------------------------------------------------------------
   */
  val dimarray01 = Array.ofDim[String](2,3)
  val dimarray02 = Array(Array('a','c'),Array('g','o','l'))

  val dimarray03 = Array(Array('b','f'),Array('z','c'))
  val dimarray04 = dimarray02 ++ dimarray03
//  println(dimarray04(2)(1))   //访问多维数组元素


  /**
   * 映射Map  -----------------------------------------------------------------------
   */
  //不可变映射
  val map01 = Map("AL" -> "ALIBABA","TX" -> "TENCENT","BD" -> "BAIDU")
  //如果查询不存在的key，会返回withDefaultValue方法定义的值，即："Not Found"
  var map02 = Map(("AL","ALIBABA"),("TX","TENCENT"),("BD","BAIDU")).withDefaultValue("Not Found")
  //可变映射
  var map03 = scala.collection.mutable.Map("AL" -> "ALIBABA","TX" -> "TENCENT","BD" -> "BAIDU")
  //使用+= 添加一个或者多个元素，使用++= 合并另一个map
  map03 += ("JD" ->"JINGDONG")
  map03 ++= List("TT" -> "TOUTIAO","MT" -> "MEITUAN")
  //使用 -= 或者 --=来删除map中的元素。注意删除时候，只提供key
  map03 -= ("TT","BD","TX")

  //使用put向映射添加元素。retain保留符合谓词的元素。remove去掉某个key的元素。clear清空映射。
  map03.put("QN" , "QUNA")
  map03.retain((k,v) => k=="QN")
  map03.remove("QN")
  map03.clear
  //对于定义为var类型的不可变Map，向其中添加新的元素是可以的，但是update某一个元素确实不行的。如果不可变映射定义为val型，则也不可以增加元素
  map02 += ("HW" -> "HUAWEI")
  //map02("AL") = "TAOBAO"   //error

  //1.如果查不到Key "MT"，则返回"Not Found -- getOrElse"
  map02.getOrElse("MT","Not Found -- getOrElse")
  //返回一个Option对象
  map02.get("MT")
  //使用keySet方法获得Map的Key的集合（返回一个Set）。使用keysIterator方法返回一个基于key的迭代器。使用keys方法获得一个Iterable。
  val s1 = map02.keySet
//  for (i <- map02.keysIterator) println(i)
//  for (j <- map02.keys) println(j)
  //遍历Map映射的方法：
  for((key,value) <- map02) println(s"$key -> $value")
  map02.foreach{
    case (k,v) => println(s"$k -> $v")
    case _ => Unit
  }
  map02.foreach(x=>println(s"${x._1} -> ${x._2}"))
  //2.映射反转
  val map02Re = for((k,v)<-map02) yield (v,k)
  //测试key、value是否包含某个值。
  map02.contains("AL")
  map02.valuesIterator.exists(_.contains("ALI"))

  //3.过滤map：
  //可变映射，可以通过retain方法来过滤map。retain方法会改变map本身。这里包含匿名函数：(k,v) => ...
  var map05 = scala.collection.mutable.Map(1->"bj",4->"gz",3->"sz",2->"sh",5->"cd")
  map05.retain((k,v) => k>2 )
  //transform方法可以改变映射
  map05.transform((k,v) => v.toUpperCase())

  // 不可变映射和可变映射通用方法,使用filterKeys方法需要将结果赋给一个新的map；filter方法、take方法（获取前几个）
  var map06 = Map(1->"bj",4->"gz",3->"sz",2->"sh",5->"cd")
  val map07 = map06.filterKeys(_>=2)
  val map08 = map06.filterKeys(Set(2,3))
  val map09 = map06.filter(t=>t._1>2)
  val map10 = map06.take(2)   //取map中的前2个元素。

  //4.按照map的key 或者 value排序
  //1. map06.toSeq 转化为元组的集合。 2.sortBy(_._1)按照结合中每个tuple的第二个元素排序 3.排序完成后，存放到一个ListMap里
  //关于_* ： 将数据转换（一个集合转为多个参数），并且作为多个参数传给ListMap或者LinkedHashMap。 不能直接用元组序列构建LinkedHashMap，LinkedHashMap的伴生对象接受一个Tuple2的变长参数
  //按key从小到大
  val map11 = scala.collection.mutable.LinkedHashMap(map06.toSeq.sortBy(_._1):_*)
  //按key从大到小
  val map12 = scala.collection.mutable.LinkedHashMap(map06.toSeq.sortWith(_._1>_._1):_*)

  //5.按照key或者value取最大的。
  //将按照map06的key取一个最大的元素，是一个元组(key,value)。
  map06.max
  //获得最大的key
  map06.keysIterator.max
  map06.keysIterator.reduce((x,y) => if (x>y) x else y)

  /**
   * 集合Set  -----------------------------------------------------------------------
   * 1.给集合添加元素（可变集合和不可变集合）
   *    可变集添加或删除元素，推荐使用+=、++=、-=、--=来实现
   * 2.删除集合元素：
   *    可以使用retain，clear，remove等方法。
   *    remove 实际操作是去掉参数的元素（不是第4个元素）。
   * 3.使用可排序集合 ：
   *   用SortedSet获得有序集合；用LinkedHashSet获取按插入顺序排序的集合。
   *
   */
   val set01 = Set(1)
   var set02 = scala.collection.mutable.Set[Int]()
   set02 += 4
   set02 ++= Seq(3,4,5,6)
   set02 ++= List(8,6)
   //不可变Set添加元素后，赋给一个新的Set。
   val set03 = set01 + (2,3,4,4,5,6,7)

   set02 --= Vector(1,2,3)
  //一定注意，set.remove 实际操作是去掉参数的元素（不是第4个元素）。下面是在Set中去掉元素"4"，如果set中有4，则删掉该元素，并返回true，否则返回false
   set02.remove(4)
  //保留谓词为True的元素
   set02.retain(_>6)
   set02.clear

  //按照元素值的顺序排序的set
   val set04 = scala.collection.mutable.SortedSet[String]("zoo","lexus","max","bee")
   val set05 = scala.collection.mutable.LinkedHashSet[String]("zoo","lexus","max","bee")

  /**
   * 队列 和 栈 -----------------------------------------------------------------------
   * 1.队列是一种先进先出(FIFO)的数据结构。有可变和不可变的队列
   *   使用+= ， ++= 或者 enqueue方法来增加元素
   * 2. 栈是一种后进先出（LIFO）数据结构。用push加入元素、用pop弹出元素
   */

  var queue01 = scala.collection.mutable.Queue("zoo","lexus","max","bee")
  queue01 += "keeper"
  queue01 ++= Vector("last","must")
  queue01.enqueue("min")
  //dequeue从队列取出元素。
  val next = queue01.dequeue()

  val stack01 = scala.collection.mutable.Stack(5,0,2)
  stack01.push(8)
  stack01.push(123)
  val s03 = stack01.pop()
}
