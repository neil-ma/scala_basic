package com.pmpa.scala.utils

/**
 * 关于Scala的控制结构。
 * Created by natty.ma on 2017/12/28.
 */
object ExprUtils {

  /**
   * 功能 ： 使用for 和foreach循环。
   *        (1) 使用for操作每一个元素。
   *        (2) 使用for/yield 返回值。
   * author: natty   2017-12-31
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

  /**
   * 功能： for 循环计数器 ，for循环的i j 等。
   * 方法： (1) 使用一个for循环计数器。
   *        (2) 使用多个for循环计数器
   *        (3) 创建和使用多维数组。
   *        多维数组的访问方法：dim(i)(j)  ，初始化空的多维数组：  Array.ofDim[T](i,j)
   *  author: natty   2017-12-31
   */
  def forNumTest() = {

    //创建和使用多维数组
    val dim2 = Array.ofDim[Int](2,2)
    dim2(0)(0) = 0
    dim2(0)(1) = 1
    dim2(1)(0) = 2
    dim2(1)(1) = 3

    for {
      i <- 0 to 1
      j <- 0 to 1
    }
      println(s"($i,$j):${dim2(i)(j)}")
  }

  /**
   * 功能： 在for循环中添加if条件（卫语句）
   * 方法： for循环添加语句块，可以对for循环进行条件筛选，只循环符合条件的数。
   *        在for循环中使用卫语句，可以使得代码更简洁、可读（业务逻辑分离）
   */
  def forIfTest() = {

  }

  /**
   * 功能： 使用for表达式 （for...yield）
   * 方法： (1) 除极个别的特殊情况外，for推导不会改变集合的类型。 例如输入是vector，返回也是vector，输入为List返回也为List。
   *        (2) 不带卫语句的for/yield表达式，相当于调用map方法。
   */
  def forExprTest() = {


  }

  /**
   * 功能 ： Scala中没有break和continue关键字，实现break和continue功能
   * 方法： (1) 使用scala.util.control.Breaks类实现break和continue功能。
   *             I. break和breakable是Breaks类中的两个方法。II. break会抛出异常，结束for循环。
   *             III. breakable定义break的范围。breakable方法捕获异常，控制流继续执行被打断的代码块后的其他代码。
   *        (2) 标记break语句实现嵌套的break语句（break到哪一层）
   *            val Inner = new Breaks
   *            Inner.breakable{... Inner.break ...}
   */
  def breakContinueTest() = {


  }


}
