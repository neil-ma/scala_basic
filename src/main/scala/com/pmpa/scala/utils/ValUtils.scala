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

}
