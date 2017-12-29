package com.pmpa.scala.utils

/**
 * 关于Scala的控制结构。
 * Created by natty.ma on 2017/12/28.
 */
object ExprUtils {

  /**
   * 功能 ： 使用for 和foreach循环。
   *        (1) 使用for操作每一个元素。
   */
  def testFor() = {
    val a = Array("Japan","Germany","US")
    for(e<-a){
      val lgs = e.toUpperCase()
      println(lgs)
    }

    val newArray1 = for(e<-a) yield  e.toLowerCase()
    val newArray2 = for(e<-a) {
      val s = e.toLowerCase
      s
    }
    println(s"利用for循环返回值：$newArray1; $newArray2")
  }


}
