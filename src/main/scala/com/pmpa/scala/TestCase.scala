package com.pmpa.scala

import com.pmpa.scala.common._
import com.pmpa.scala.utils.{ExprUtils, ValUtils}
import com.pmpa.scala.utils.StringUtils._

/**
 * Created by natty.ma on 2017/12/20.
 */
object TestCase {

  def main (args: Array[String]){

//  Testing for  Object  String Utils:
//    val str1 = "hello"
//    val str2 = "Hello"
//    println(StringUtils.testEquals(str1,str2))
//    println(StringUtils.testEqualsNoMatter(str1,str2))
//
//    println(StringUtils.multilineString())
//
//    val splitString = "eggs, bread, milk, fork"
//    StringUtils.splitString(splitString)
//
//    StringUtils.valReplaceStr()

//    StringUtils.cycle_deal("HELLO,WORLD!")

//    隐式转化类
//      StringUtils.regexFindReplace()
//      val psg = "SGEW"
//      print(psg.increment)



    //Testing for object ValUtils
//    ValUtils.stringToValue()
//      ValUtils.overloadDefaultType()
//    ValUtils.valueToValue()

//    val a:Double = 0.1
//    val b:Double = 0.2
//    val dgs = ValUtils.~=(a+b,0.3,0.001)
//    println(s"约等于结果：$dgs,等于结果：${0.3 == (a+b)}")
//    ValUtils.handleBigNum()
//      ValUtils.randomNum()
//      ValUtils.createValueList()
//      ValUtils.formatValueAmount()

//    ExprUtils.testFor()
//    ExprUtils.breakContinueTest()
//      ExprUtils.testSwitchExpr()
//      val p = new Person("Jim","Green")

//    val car =  new Car("Suzuki")
//    val car1 =  new Car("Suzuki",123456)
//    val car2 =  new Car(123456)
//    val car3 =  new Car()
//    println(car.toString())
//    println(car1.toString())
//    println(car2.toString())
//    println(car3.toString())

     val p = new PersonSingle()          //报错：constructor PersonSingle in class PersonSingle cannot be accessed
     val p1 = PersonSingle.getInstance()
     println(p1)
  }

}
