package com.pmpa.scala.utils

import scala.util.matching.Regex

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

  /**
   * 功能：挨个处理字符串的每个字符
   * 方法: (1)map方法 (2)for...yield (3)foreach方法
   * @param str
   *        (1) map将String当做一个字符序列的集合来处理，map方法有一个隐性的循环，每次循环给算法传一个字符。
   *        (2) 在for循环中添加yield，实际上是将每次循环的结果放在一个临时存放区。
   *        (3) map和for...yield 两种方式是将一个集合转化为另一个新的集合，foreach则是典型的对每个元素进行操作但是不返回结果。
   *
   *  >>> author: natty   2017-12-22
   */
  def cycle_deal(str:String) = {
      val map_str = str.filter(_!='L').map(_.toLower)
      val map_str1 = str.filter(_!='L').map(c=>c.toLower)
      val map_str2 = str.map(toLower)
      println(s"使用map方法生成新字符序列:$str => $map_str")
      println(s"使用map方法生成新字符序列（函数式）:$str => $map_str1")
      println(s"使用map方法生成新字符序列（自定义函数）:$str => $map_str2")

      val yield_str = for (c<-str) yield c.toLower
      //for循环可以添加语句块 ，大括号括起。
      val yield_str2 = for {
        c <- str
        if c != 'L'
      } yield c.toLower
      println(s"使用for...yield生成新字符序列:$str => $yield_str")
      println(s"使用for...yield生成新字符序列:$str => $yield_str2")

      //val foreach_str = str.foreach(c=>c.isLower)  //这种方式不可以
      str.foreach(print)
  }

  def toLower(c:Char):Char = {
    (c.toByte +32).toChar
  }

  /**
   * 功能：使用正则表达式匹配搜索和替换字符串
   * 方法：(1) 直接使用String.r 来生成正则表达式。
   *      (2) 使用Regex对象来生成正则表达式。
   *      (3) 正则表达式可以替换匹配上了的字符串。但是不是修改原来的字符串，而是产生一个新的字符串，所以需要赋给
   *          一个新的变量，这点需要注意。
   *      (4) 分组提取正则表达式匹配的部分
   *
   *      (1) findFirstIn返回第一次匹配(类型option[String])，findAllIn返回所有匹配(类型迭代器)。
   *      Option相当于一个容器，包含0或1个值的容器。如果有值的话，返回一个Some(xx) ，如果没有值返回None。
   *      (4)定义想要抽取的正则表达式，在他们周围加上括号，可以当做正则表达式组使用。
   *
   * >>> author: natty   2017-12-23
   */
  def regexFindReplace()={
    // 先使用String.r方式来显示匹配。
    //Regex： + 匹配前面的子表达式一次或多次(大于等于1次）。
    val pattern = "[0-9]+".r
    val str =  "123 Main Street No.892"
    //Option[String]
    val match1 = pattern.findFirstIn(str)
    //scala.util.matching.Regex.MatchIterator
    val match2 = pattern.findAllIn(str)
    match1.foreach(println)
    match2.foreach(println)
    //匹配的多个表达式，可以转化为Array
    println(s"多次匹配转换为Array：${match2.toArray}")
    //使用match表达式来处理Option[String]
    match1 match {
      case Some(s) => println(s"Found $s")
      case None =>
    }

    //使用Regex对象来创建正则表达式对象。实际应用中建议使用这种
    val patternObj = new Regex("([a-z]|[A-Z])+")
    print("使用Regex对象来匹配第一个字母：")
    patternObj.findFirstIn(str).foreach(println)
    print("使用Regex对象来匹配all字母：")
    patternObj.findAllIn(str).foreach(println)

    //使用正则表达式来实现替换,
    val patterObjReplace = new Regex("[1-9]+")
    val replaceOneTime = patterObjReplace.replaceFirstIn(str,"xxx")
    val replaceAll = patterObjReplace.replaceAllIn(str,"xxx")
    println(s"只替换第一次匹配上的字符串：$replaceOneTime")
    println(s"替换所有匹配上的字符串：$replaceAll")

    //提取分组匹配正则表达式的字符串。
    val groupPattern = "([0-9]+) ([A-Za-z]+) (%)".r
    //分组获取变量，更加清晰。这里同时处理了
    val groupPattern(num,alb,black) = "101 street %"
    println(s"分组匹配正则表达式的结果：num=$num,alb=$alb,black=$black")
  }
}
