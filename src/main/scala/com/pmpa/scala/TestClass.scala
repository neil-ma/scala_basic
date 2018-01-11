package com.pmpa.scala


import com.pmpa.scala.common.Hiking
import com.pmpa.scala.common.asia.HikingAsia
import com.pmpa.scala.common.asia.japan.HikingJapan
import com.pmpa.scala.itrait.Tiger

/**
 * Created by jay on 2018/1/6.
 * 测试类
 */
object TestClass extends App{

  Console.println("Hello World: " + (args mkString ", "))
  val tiger = new Tiger("月之女祭司")
  tiger.hurt()
  println(tiger.showSkills("跳跃","隐匿","射箭","星辰"))

  val hiking1 = new HikingJapan(10.2,"Tokyo")
  hiking1.callMe()
  val hiking2 = new HikingAsia(40.2,"Japan")
  val hiking3 = new Hiking(80.2,"Asia")

}
