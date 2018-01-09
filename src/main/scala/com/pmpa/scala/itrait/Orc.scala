package com.pmpa.scala.itrait

/**
 * 特质： 兽族
 * Created by natty.ma on 2018/1/9.
 *
 * 7.允许特质混入到一个有给定签名的方法的类型中
    trait MyTrait{
      this{def myMethod(name String,age Int):Boolean } =>
    }
    任何继承了MyTrait特质的类，必须有一个myMethod方法，同时，这个方法有2个参数，返回Boolean类型。
 *
 */
trait Orc {
  this: {def showSkills(skill:String*):String} =>
  var life:Int
  var agile:Int
  var mana:Int
}
