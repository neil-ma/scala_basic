package com.pmpa.scala.common

/**
 * Created by natty.ma on 2018/1/4.
 *  (1) 为类创建主构造函数
 *  (2) 控制构造函数字段的可见性
 */

/**
 * 功能：创建类的主构造函数
 *      为类创建主构造函数，与java区别较大。Scala类的主构造函数包含：
 *        a.构造函数参数
 *        b.在类内部调用的方法
 *        c.在类内部执行的语句和表达式。
 *      类里边的方法是构造函数的一部分。age声明为var，scala会为它生成访问和修改方法。访问：p.age 修改：p.age=xxx
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


/** *
  * 功能： 控制构造函数字段的可见性
  * 方法： (1) 如果一个字段被声明为var，表示可变的，scala会为该字段自动生成getter和setter方法。
  *        (2) 如果字段声明为val，表示不可以改变的（类似java的final），scala只生成getter方法。
  *        (3) 如果字段没有val或者var声明，scala将不生成getter和setter方法。
  *        (4) 可以给var或者val修饰的字段添加private关键字。private阻止生成getter和setter，该字段只能被类内部成员使用
  *        (5) case类的构造函数参数默认是 val
  *
  *   author:natty  2018-01-05
  */

/**
     声明为var。 可以get，可以set
        val p = new Person1("Lily")
        println(p.name)
        p.name = "Jim"
        println(p.name)
 */
class Person1(var name:String){}

/**
    声明为val，测试方法，可以get，不可以set
    val p = new Person2("Lily")
    println(p.name)
    p.name = "Jim"   //报错
 */
class Person2(val name:String){}

/**
 *  没有val或者var修饰，不生成getter和setter
    val p = new Person3("Lily")
    println(p.name)   //报错
    p.name = "Jim"   //报错
 */
class Person3(name:String){}

/**
 * private修饰val或者var变量，阻止生成getter和setter，但是类内部成员可用
    val p = new Person4("Lily")
    p.getName()
    println(p.name)   //报错
    p.name = "Jim"   //报错
 */
class Person4(private var name:String){
  def getName()={
    println(name)
  }
}

/**
 * case类不添加val或者var时，默认是val
 *  val p = new Person5("Lily")
    println(p.name)   //可读，默认是val
    p.name = "Jim"   //报错，默认是val
 */
case class Person5(name:String){}