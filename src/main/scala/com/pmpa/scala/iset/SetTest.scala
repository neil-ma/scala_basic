package com.pmpa.scala.iset

import scala.collection.mutable.ListBuffer

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
 *
 *
 * ListBuffer:
 *   使用ListBuffer创建可变List，可以随时转换为List。ListBuffer是一个基于列表的缓冲实现。前置和附加操作的开销都是常量时间。
 *   如果要随机访问，请使用ArrayBuffer，而不要使用ListBuffer。
     使用+=可以一次添加一个或者多个元素。使用-=可以一次删除一个或者多个元素。
     remove方法按位置删除元素，从0开始计数。
 */

object SetTest extends  App{

  /**
   * List            -----------------------------------------------------------------------
   */
  val list01 = List(1,2,3)
  val list02 = 4::5::6::Nil
  var list03 = List.range[Int](0,4)
  //11必须放在前边，::是List的一个方法，从右向左执行。
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
  //惰性计算
  println(stream02.filter(_>2000))
  //实际计算
  println(stream02.sum)

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
  val array01 = Array(56,12,30)
}
