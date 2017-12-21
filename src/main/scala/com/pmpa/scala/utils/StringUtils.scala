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
    str1.equalsIgnoreCase(str2)
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

  /**
   * 功能：将一个变量代换进字符串中（类似C语言中的printf）
   * 方法：(1)Scala中的字符串插值就是在字符串前加字母's'，即 s字符串。
   *       (2)使用f字符串格式化
   *       (3)使用raw : 不会对字符串中的字符做转义
   * (1)在字符串前加s，然后在字符串中放入变量，每个变量都以'$'开头。同时，还可以使用${} 将表达式包入其中，可以内嵌任何表达式。
   *    's'实际上是一个方法
   * (2)需要做：a.在字符串前加'f'; b.在变量之后使用格式化操作符。
   * >>> author: natty   2017-12-20
   */
  def valReplaceStr() = {
    val name = "Fred"
    val age = 30
    val weight = 200.00

    val s1 = s"$name is $age years old, and weighs $weight pound!!"
    println(s"s字符串读入变量：$s1")
    val s2 = s"$name is ${age+2} years old, and weighs $weight pound!!"
    println(s"s字符串读入表达式：$s2")
    val s3 = f"$name is $age years old, and weighs $weight%.0f pound!!"
    println(s"f字符串读入格式化表达符：$s3")

    val t1 = "milk\nbread"
    val t2 = raw"milk\nbread"
    println(s"普通字符串测试结果：\n$t1 \nraw字符串测试结果：\n$t2")
  }

}
