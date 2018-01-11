package com.pmpa.scala.itrait

/**
 * Created by natty.ma on 2018/1/11.
 */

/**
 * 功能：  6.6 伴生类，创建静态成员。
            在一个文件中创建一个class，在该class中定义非静态的实例成员，然后在同一个文件中，定义一个和class同名的object（其中可创建静态实例成员），
            这个对象成为伴生类。类和伴生类能互相访问对方的私有成员。
              静态方法flyHeight，访问了类中私有成员height。
           6.8 不使用new来创建对象：
              1.为类创建伴生类，并在伴生类中按照所需的构造函数定义一个apply方法
              2.将类定义为case类。
              apply方法和case类提供多个构造函数
 * @param name
 * @param speed
 */
class Owl(name:String,var speed:Double) extends Animal(name){

  private val height:Double = 30.9
  def fly() = {
    println(s"$name flying speed is $speed")
  }
}

object Owl {
  //不使用new来创建对象
  def apply(name:String,speed:Double):Owl = {
    val owl = new Owl(name,speed)
    owl
  }
  //重载的构造方法，伴生类apply方法实现。
  def apply(name:String):Owl = {
    val speed:Double = 2002;
    val owl = new Owl(name,speed)
    owl
  }
  //实例成员可以访问Owl类的私有成员。
  def flyHeight(x:Owl) = {
    println(s"${x.name} flying height is ${x.height}")
  }
}
