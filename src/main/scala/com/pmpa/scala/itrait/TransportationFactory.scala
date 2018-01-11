package com.pmpa.scala.itrait

/**
 * Created by natty.ma on 2018/1/11.
 */

/**
 * 6.9 在scala中用apply方法实现工厂方法
    在scala中实现工厂方法，让子类声明哪种对象应该创建，保持对象创建在同一位置。通过实现伴生类中的apply方法来实现工厂。
 */
class TransportationFactory {
  def goSpeed() = {println("Transportation")}
}

object TransportationFactory{
  private class Bicycle extends TransportationFactory{
    println("get a bicycle")
  }
  private class Car extends TransportationFactory{
    println("get a car")
  }

  def getTransportation(name:String):TransportationFactory = {
    if (name == "bicycle") new Bicycle
      else new Car
  }
}