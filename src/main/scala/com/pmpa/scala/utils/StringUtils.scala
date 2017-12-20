package com.pmpa.scala.utils

/**
 * Created by natty.ma on 2017/12/20.
 */
object StringUtils {

  /**
   * 功能：比较str1和str2两个字符串是否相等
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
   * 使用三个双引号创建多行字符串。
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

}
