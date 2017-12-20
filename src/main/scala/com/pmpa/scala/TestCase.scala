package com.pmpa.scala

import com.pmpa.scala.utils.StringUtils

/**
 * Created by natty.ma on 2017/12/20.
 */
object TestCase {

  def main (args: Array[String]){
    val str1 = "hello"
    val str2 = "Hello"
    println(StringUtils.testEquals(str1,str2))
    println(StringUtils.testEqualsNoMatter(str1,str2))

    println(StringUtils.multilineString())

    val splitString = "eggs, bread, milk, fork"
    StringUtils.splitString(splitString)






  }

}
