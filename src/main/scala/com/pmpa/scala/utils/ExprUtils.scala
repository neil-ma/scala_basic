package com.pmpa.scala.utils

import scala.util.control.Breaks

/**
 * 关于Scala的控制结构。
 * Created by natty.ma on 2017/12/28.
 */
object ExprUtils {

  /**
   * 功能 ： 使用for 和foreach循环。
   *        (1) 使用for操作每一个元素。
   *        (2) 使用for/yield 返回值。
   * author: natty   2017-12-31
   */
  def testFor() = {
    val a = Array("Japan","Germany","US")
    for(e<-a){
      val lgs = e.toUpperCase()
      println(lgs)
    }

    val newArray1 = for(e<-a) yield  e.toLowerCase()
    val newArray2 = for(e<-a) {
      val s = e.toLowerCase
      s
    }
    println(s"利用for循环返回值：$newArray1; $newArray2")
  }

  /**
   * 功能： for 循环计数器 ，for循环的i j 等。
   * 方法： (1) 使用一个for循环计数器。
   *        (2) 使用多个for循环计数器
   *        (3) 创建和使用多维数组。
   *        多维数组的访问方法：dim(i)(j)  ，初始化空的多维数组：  Array.ofDim[T](i,j)
   *  author: natty   2017-12-31
   */
  def forNumTest() = {

    //创建和使用多维数组
    val dim2 = Array.ofDim[Int](2,2)
    dim2(0)(0) = 0
    dim2(0)(1) = 1
    dim2(1)(0) = 2
    dim2(1)(1) = 3

    for {
      i <- 0 to 1
      j <- 0 to 1
    }
      println(s"($i,$j):${dim2(i)(j)}")
  }

  /**
   * 功能： 在for循环中添加if条件（卫语句）
   * 方法： for循环添加语句块，可以对for循环进行条件筛选，只循环符合条件的数。
   *        在for循环中使用卫语句，可以使得代码更简洁、可读（循环、业务逻辑分离），推荐使用大括号的风格来编写
   *   author: natty   2018-01-02
   */
  def forIfTest() = {
    for {
      i <- 1 to 10
      if i % 2 == 0
    }
      {
      println("guard sent")
      println(i)
      }
  }

  /**
   * 功能： 使用for表达式 （for...yield）
   * 方法： (1) 除极个别的特殊情况外，for推导不会改变集合的类型。 例如输入是vector，返回也是vector，输入为List返回也为List。
   *              Scala 的list的最后一个值是Nil
   *        (2) 不带卫语句的for/yield表达式，相当于调用map方法。
   *      author: natty   2018-01-02
   */
  def forExprTest() = {
    val fruitList = "apples" :: "bananas" :: "mongo" :: "grape" :: Nil
    val af = for(i<-fruitList) yield i.capitalize
    val af1 = af.map(_.capitalize)
    println(af)
    println(af1)
  }

  /**
   * 功能 ： Scala中没有break和continue关键字，实现break和continue功能
   * 方法： (1) 使用scala.util.control.Breaks类实现break和continue功能。
   *             I. break和breakable是Breaks类中的两个方法。II. break会抛出异常，结束for循环。
   *             III. breakable定义break的范围。breakable方法捕获异常，控制流继续执行被打断的代码块后的其他代码。
   *        (2) 标记break语句实现嵌套的break语句（break到哪一层）
   *            val Inner = new Breaks
   *            Inner.breakable{... Inner.break ...}
   *   author: natty   2018-01-03
   */
  def breakContinueTest() = {
    //break实现
    println("==========Test for break!!======")
    val test_str = "Congratulations"
    scala.util.control.Breaks.breakable {
      for(i<- 0 to 10)
      {
        if (i > 4) scala.util.control.Breaks.break
        else print(test_str(i))
      }
    }
    //continue实现
    println("==========Test for continue!!======")
    val test_str2 = "There was a time when the owners of shops and businesses in Chicago"
    var num = 0
    for(a <- test_str2)
      {
        scala.util.control.Breaks.breakable{
            if (a!='s') scala.util.control.Breaks.break()
            else num += 1
        }
      }
    println(s"Find s $num times!!")
    //嵌套循环和有标签的break
    val inner = new Breaks;
    val outer = new Breaks;
    outer.breakable{
      for (i<- 0 to 5) {
        inner.breakable{
          for(j<- 'a' to 'f')
            {
                if( i<4 && j == 'e') inner.break()
                else if (i>=4) outer.break()
                else println(s"$i , $j")
            }
        }
      }
    }
  }

  /**
   * 功能： 在scala中使用三元运算符
   * 方法： scala无三元运算符， 使用if语句作为返回值来替代
   * @param x
   * @return
   *    author: natty   2018-01-03
   */
  def abs(x:Int):Int = {
    if(x<0) -x else x
  }

  /**
   * 功能： 模仿java中的switch语句。
   * 方法： (1) 处理缺省的情况：
   *           a. 如果不关心缺省匹配的值，可以使用通配符_，例如：case _=> println("Got default value")
   *           b. 如果关心缺省匹配的值，给它指定一个变量（可以是任意名称的变量）就可以在右侧使用了。
   *                case default => println(default)
   *           c. 如果不处理缺省值会抛出MatchError
   *        (2) @switch注解，使用@switch注解时，如果switch语句不能被编译成tableswitch或者lookupswitch，该注解会引发警告。
   *            a. 编译成tableswitch或者lookupswitch的switch语句性能更好。
   *            b. 编译成为tableswitch或者lookupswitch的条件：
   *               <1>匹配的值是一个已知整数
   *               <2>匹配必须“简单”。不能包含类型检测，if语句
   *               <3>保证表达式在编译时的值可用。
   *               <4>至少有2个case语句
   *    author: natty   2018-01-03
   */
  def testSwitchExpr() = {
    val i = 7
    val swit = i match {
      case 1 => "January"
      case 2 => "February"
      case 3 => "March"
      case 4 => "April"
      case 5 => "May"
      case whoa => s"your inputs error: $whoa"
    }
    println(s"match结果：$swit")

    //用Switch来匹配数据类型（java只能匹配数字）。
    val test_obj:Any = new SeqCharSequence("sg")
    test_obj match {
      case a:Int => println("This is an Int Obj!!")
      case b:String => println("This is an String Obj!!")
      case c:Float => println("This is an Float Obj!!")
      case d:SeqCharSequence => println("This is an SeqCharSequence Obj!!")
      case _ => println("Unknown Type!!")
    }
  }



  /**
   * 功能 ： 在try/catch语句块中捕获一个或者更多的异常。
   * 方法:  (1) scala的try/catch/finally与java类似，但是在catch语句中需要使用case匹配表达式方法，
   *        为了捕获多个异常，只需要添加异常类型作为不同的case语句。
   *
   */
  def tryCatchExcpetion() = {
  }


}
