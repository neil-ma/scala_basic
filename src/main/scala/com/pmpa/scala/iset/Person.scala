package com.pmpa.scala.iset

/**
 * Created by natty.ma on 2018/1/15.
 */

/**
 *  如果想排序一个类，只需要把Ordered特质混入对应的类，然后实现一个比较的方法（compare）即可。
    (1)如果两个对象相等返回0，
    (2)如果this小于that返回负数，
    (3)如果this大于that返回正数。
    如果一个类混入了Ordered特质并且实现了compare方法，就可以把对象用>，<比较了。
 *
 */
class Person(var name:String,var age:Int,var job:String = "SE") extends Ordered[Person]{
  //实现对象的对比
  override def compare(that: Person): Int = {
    if (this.age == that.age) 0
    else if (this.age > that.age) 1
    else -1
  }
}

/*
测试语句（对象的比较）：
  val p1 = new Person("Lily",12)
  val p2 = new Person("John",13)
  val p3 = new Person("Tom",14)

  if (p1>p2) println(s"${p1.name}年龄比${p2.name}年龄大")
  if (p2>p1) println(s"${p2.name}年龄比${p1.name}年龄大")
  if (p3>p2) println(s"${p3.name}年龄比${p2.name}年龄大")
 */
