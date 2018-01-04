package com.pmpa.scala.common

/**
 * Created by natty.ma on 2018/1/4.
 *  (1) 为类创建主构造函数，与java区别较大。Scala类的主构造函数包含：
 *        a.构造函数参数
 *        b.在类内部调用的方法
 *        c.在类内部执行的语句和表达式。
 *      类里边的方法是构造函数的一部分。age声明为var，scala会为它生成访问和修改方法。访问：p.age 修改：p.age=xxx
 *
 */

/**
 * 功能：创建类的主构造函数
 * @param firstName
 * @param lastName
 *    author:natty.ma  2018-01-04
 */
class Person(var firstName:String,var lastName:String) {

  println("The constructor begins...")
  //类似java中的private final 不可变的属性
  private val HOME = "ETL_HOME"
  var age = 0

  override def toString() = s"$firstName $lastName is $age years old."
  def printHome() = {
    println(s"HOME = $HOME")
  }
  def printFullname() = {
    println(this)
  }

  printHome()
  printFullname()
  println("Still in the constructor ...")
}
