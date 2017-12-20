package com.pmpa.scala.utils

/**
 * Created by natty.ma on 2017/12/20.
 */
object StringUtils {

  /**
   * 功能：比较str1和str2两个字符串是否相等
   * 方法：使用==
   * @param str1
   * @param str2
   * @return
   * 2017-12-20
   *   Scala中可以使用 == 测试对象的相等性。(Java中需要用equals方法，==比较2个对象的地址)
   *   在scala中，定义在AnyRef类中的==方法首先校验是否为null，之后会调用第一个对象的equals方法。
   */
  def testEquals(str1:String,str2:String):Boolean = {
    str1 == str2
  }

  /**
   * 功能：比较str1和str2两个字符串是否相等，不区分大小写。
   * 方法：使用字符串的toUpperCase方法转化（或者直接使用java.lang.String.equalsIgnoreCase）
   * @param str1
   * @param str2
   * @return
   * 2017-12-20
   */
  def testEqualsNoMatter(str1:String,str2:String):Boolean = {
    str1.toUpperCase() == str2.toUpperCase()
    //这是使用java中的方法。
    //str1.equalsIgnoreCase(str2)
  }

  /**
   * 功能：创建多行字符串
   * 方法： 使用三个双引号创建多行字符串。
   * 为了去掉从第二行开始的开头的空格，需要在字符串尾部添加stripMargin方法，并且第一行后的所有行以管道符(|)开头
   * @return
   */
  def multilineString():String={
    val foo =
      """It is only
        |a private
        |conversation
      """.stripMargin
    foo
  }

  /**
   * 功能：分隔字符串
   * 方法：使用split方法
   * split方法会返回以字符串为元素的一个数组。Array[String]
   * split可以接受正则表达式作为参数(所以可以处理复杂的字符串分隔)。为了防止空格等出现，最好trim每一个字符串。
   * @param str
   */
  def splitString(str:String) = {
    str.split(',').map(_.trim).foreach(println)
  }

}
