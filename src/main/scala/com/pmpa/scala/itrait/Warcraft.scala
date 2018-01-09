package com.pmpa.scala.itrait

/**
 * Created by natty.ma on 2018/1/9.
 */
/**
 *  2. 在特质中定义抽象字段和实际字段。
      如果Trait中声明的字段赋了初始值那么就是实际字段，否则是抽象字段。
      Trait中字段可以声明为var或者val，子类覆写Trait中的val字段时，需要加override；
      覆写var字段，不需要加。同时，子类如果不给Trait中未赋值的字段赋值的话，那么该类必须是abstract的。

    5.通过继承来限制Trait的使用范围。
      限定一个Trait仅可以被那些继承了某个类，或者继承了某个特质的类使用。
      trait [TraitName] extends [SuperClass]
      如果这么定义Trait表示：此TraitName只可以被混入到继承了SuperClass的类中，SuperClass可以是类、特质、抽象类。 (不常用)

    6.限定特质只可用于指定类型的子类。  （更常用，与5的作用一样。）
      trait MyTrait{
        this:BaseType with Trait1 with Trait2 ...=>
      }
      表示MyTrait特质只能被那些继承了BaseType、Trait1、Trait2的类混入。

 */
trait Warcraft //extends Animal
{
  //限定只有继承了Animal类的子类才可以混入该Trait
  this:Animal =>

  //抽象字段
  val wa_type:String
  //实际字段
  var age:Int = 1
  def wa_speak() = {
    println("The Warcraft speaks!!")
  }
}
