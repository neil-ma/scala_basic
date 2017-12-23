package com.pmpa.scala.utils

/**
 * Created by jay on 2017/12/23.
 */
object ValUtils {
  /**
   * 功能: 将String类型转化为Scala数值类型
   * 方法：使用String的to*方法。
   *       (1)字符串可以转化成各种scala数值类型。转为Int则使用toInt，转为Float则使用toFloat，还有toDouble，toByte等等。
   *       (2) BigInt和BigDecimal可以直接使用字符串创建。
   *       (3) 使用java.lang.Integer.parseInt进行非十进制转换（String -> value）
   *
   *       author: natty  2017-12-23
   */
  def stringToValue()={
    val value_string = "100"
    val value_int = value_string.toInt
    val value_double = value_string.toDouble
    val value_float = value_string.toFloat
    val value_byte = value_string.toByte
    println(s"转为Int:$value_int,转为Double:$value_double,转为float:$value_float,转为byte:$value_byte.....")

    val bigint_new =  BigInt("2003")
    val bigdecimal_new =BigDecimal("30923")
    println(s"使用字符串创建bigint:$bigint_new,使用字符串创建bigdecimal:$bigdecimal_new")

    val str_special = "10"
    // 将10转化为二进制
    val value_2 = Integer.parseInt(str_special,2)
    // 将10转为八进制
    val value_8 = Integer.parseInt(str_special,8)
    println(s"10的二进制:$value_2,10的八进制:$value_8")
  }

  /**
   * 功能：重载默认的数据类型：
   * 方法：定义变量时候指定类型，即可完成重载。
   *      Scala在为数值变量赋值时，默认会把数据类型也传给该变量。例如: val num = 0  那么num也就是Int类型了。
   *      如果不想让其为Int，可以制定num的类型。
   *
   *      author:natty  2017-12-23
   */

  def overloadDefaultType()={
    val num1 = 10
    val num2:Float = 10
    println(s"将10赋值给变量时，默认的类型是：${num1.getClass.getName},值为:$num1 ；指定Float类型后，类型为：${num2.getClass.getName},值为:$num2 ")

    val v1 = "scala"
    //向上转换、类型归属。  最终类型还是String,没向上转为Object
    val v2 = v1: Object
    println(s"v2的类型是${v2.getClass.getName}")
  }


}
