package com.pmpa.scala.itrait

/**
 * Created by natty.ma on 2018/1/9.
 */

/** *
  * 1. Scala中的特质(Trait)类似于Java中接口的概念，但是比接口的功能要强大。Scala的Trait可以多继承，并且可以像抽象类一样定义自己的方法。
        (1)如果一个类继承一个特质，使用extends
        (2)如果一个类继承多个特质，第一个特质使用extends，其余的特质使用with
        (3)如果一个类继承一个类（或者抽象类）和一个特质（或多个），继承类（或者抽象类）使用extends，继承特质使用with。

    3.子类继承Trait，使用或者覆写Trait的方法。
       wa_speak()方法，在Warcraft特质中有定义，在这里做了覆写。
    4.继承类，并继承Trait，简单混入特质。 class Tiger(name:String) extends Animal(name) with Warcraft with Orc 这里有继承和混入。
    8.对象创建时，给对象添加特质，而不是给整个类添加特质。
    9.在Scala程序中实现java接口。 Tiger类实现了java的接口 Attack。
  * @param name
  */
class Tiger(name:String) extends Animal(name) with Warcraft with Orc with Attack {
  val wa_type = "Orc"
  age = 13
  var life = 4500
  var agile = 7500
  var mana = 3000
  //覆写Trait中的方法
  override def wa_speak() = {
    println("Warriors of the night,Assemble!!")
  }

  def showSkills(skill:String*):String = {
    skill.toArray.toString
  }

  def hurt() = {
    println(s"Bow and arrow!!")
  }
}
