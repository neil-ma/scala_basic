package com.pmpa.scala.itrait

/**
 * Created by natty.ma on 2018/1/11.
 */

/**
  * 功能： 6.1 对象强制转换
          使用asInstanceOf方法（定义在Any类中，对所有对象有效）将一个实例转换为期望的类型。
          6.2 实现java中的“对象.class”功能，获取一个类。实现反射的方法
          使用Scala中的classOf方法来取代java中的.class，classOf方法定义在Scala的Predef对象中。
          6.3 确定对象所属类：
          想要了解Scala自动分配给对象的类型，可以调用对象的getClass方法。
          6.4 类似于java的main函数入口，在scala用object启动一个应用。
            第一种方法： 让object来继承App特质。（未提供例子）
            object obj extends App{
              ...
            }
            第二种方法： 在object手动实现一个拥有正确签名的main方法，类似于java：
            object obj {
                def main (args: Array[String]){
                  ...
                }
            }
           6.5 Object创建单例  方法printClass，调用方法：ObjTest.printClass(animal)
          使用object关键字创建Singleton对象，而且调用方法就像java类调用静态方法一样。

  */
object ObjTest {

  //确定对象所属类，getClass方法是对象的方法，任何对象。
  def printClass(x:Any) = {
    println(s"The class is ${x.getClass}")
  }

  def main(args:Array[String]) = {

    val owl = Owl("Reed",98.23)
    owl.fly()
    Owl.flyHeight(owl)
    println(s"包对象常量MAX_DATE:$MAX_DATE")
    //对象类型的强制转换
    val animal = owl.asInstanceOf[Animal]
    ObjTest.printClass(animal)
    //classOf[]方法接收的参数是一个类名。可以得到反射的效果
    classOf[Owl].getMethods.foreach(println(_))

    println(s"测试工厂方法：${TransportationFactory.getTransportation("bicycle")}")
  }
}
