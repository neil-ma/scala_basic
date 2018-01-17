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
  println(dimarray04(2)(1))   //访问多维数组元素


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

  //如果查不到Key "MT"，则返回"Not Found -- getOrElse"
  map02.getOrElse("MT","Not Found -- getOrElse")
  //返回一个Option对象
  map02.get("MT")

  map02.valuesIterator

}
