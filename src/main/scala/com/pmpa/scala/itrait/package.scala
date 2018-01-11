package com.pmpa.scala

/**
 * Created by natty.ma on 2018/1/11.
 * 包对象（IDEA自动生成）
 * 6.7  通用代码放入包对象（可以在IDEA中自动生成）。
    不需要import，而让函数、字段和其他代码在包级别可用。将要在所有类中共享的代码放在一个包对象中。按惯例，将代码放在名为package.scala的文件中，
    再将文件放在想要共享的类的同级目录中。
    1.在想要共享的类的同级目录中，创建一个object文件，命名为package.scala
    2.将包声明的最后一级（itrait）去掉，接着用包的名字(itrait)作为包对象名称。
 */
package object itrait {
  val MAX_DATE:String = "2018-01-11"
  val MIN_DATE:String = "1923-01-11"
  val CITY:String = "Shanghai"
}
