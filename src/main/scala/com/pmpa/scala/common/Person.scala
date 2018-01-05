package com.pmpa.scala.common

import javax.xml.bind.annotation.XmlType.DEFAULT

/**
 * Created by natty.ma on 2018/1/4.
 *  (1) 为类创建主构造函数
 *  (2) 控制构造函数字段的可见性
 *  (3) 定义辅助构造函数
 */

/**
 * 功能：创建类的主构造函数
 *      为类创建主构造函数，与java区别较大。Scala类的主构造函数包含：
 *        a.构造函数参数
 *        b.在类内部调用的方法
 *        c.在类内部执行的语句和表达式。
 *      类里边的方法是构造函数的一部分。age声明为var，scala会为它生成访问和修改方法。访问：p.age 修改：p.age=xxx
 * @param firstName
 * @param lastName
 *    author:natty.ma  2018-01-04
 */
class Person(var firstName:String,var lastName:String) {

  println("The constructor begins...")
  //类似java中的private final 不可变的属性
  private val HOME = "ETL_HOME"
  var age = 0

  override def toString() = s"$firstName $lastName is $age years old."
  def printHome() = {
    println(s"HOME = $HOME")
  }
  def printFullname() = {
    println(this)
  }

  printHome()
  printFullname()
  println("Still in the constructor ...")
}

/** *
  * 功能： 控制构造函数字段的可见性
  * 方法： (1) 如果一个字段被声明为var，表示可变的，scala会为该字段自动生成getter和setter方法。
  *        (2) 如果字段声明为val，表示不可以改变的（类似java的final），scala只生成getter方法。
  *        (3) 如果字段没有val或者var声明，scala将不生成getter和setter方法。
  *        (4) 可以给var或者val修饰的字段添加private关键字。private阻止生成getter和setter，该字段只能被类内部成员使用
  *        (5) case类的构造函数参数默认是 val
  *
  *   author:natty  2018-01-05
  */
/**
     声明为var。 可以get，可以set
        val p = new Person1("Lily")
        println(p.name)
        p.name = "Jim"
        println(p.name)
 */
class Person1(var name:String){}
/**
    声明为val，测试方法，可以get，不可以set
    val p = new Person2("Lily")
    println(p.name)
    p.name = "Jim"   //报错
 */
class Person2(val name:String){}
/**
 *  没有val或者var修饰，不生成getter和setter
    val p = new Person3("Lily")
    println(p.name)   //报错
    p.name = "Jim"   //报错
 */
class Person3(name:String){}
/**
 * private修饰val或者var变量，阻止生成getter和setter，但是类内部成员可用
    val p = new Person4("Lily")
    p.getName()
    println(p.name)   //报错
    p.name = "Jim"   //报错
 */
class Person4(private var name:String){
  def getName()={
    println(name)
  }
}
/**
 * case类不添加val或者var时，默认是val
 *  val p = new Person5("Lily")
    println(p.name)   //可读，默认是val
    p.name = "Jim"   //报错，默认是val
 */
case class Person5(name:String){}

/**
 * 功能： 实现构造方法的多态（java概念），定义多个辅助构造方法。
 * 方法： (1)辅助构造函数（方法）必须用this命名创建。
 *        (2)每个辅助构造函数必须用之前定义的构造函数（不一定非要调用主构造函数）。
 *        (3)每个辅助构造函数，必须有不同的签名（参数列表）
 *        (4)一个构造函数通过this调用另一个不同的构造函数。
 *
 *        (5)Case类是一个会自动生成很多模板代码的特殊类。在case类中添加辅助构造函数不同于一般类，它们是类的伴生对象中的apply方法。
 *           如果想要给case类加一个新的构造函数，那么需要在case class对应的伴生对象提供新签名的apply方法（返回类型是case class类型）
 * @param brand
 * @param price
 *    author:natty  2018-01-05
 *
 *  测试：
 *  val car =  new Car("Suzuki")
    val car1 =  new Car("Suzuki",123456)
    val car2 =  new Car(123456)
    val car3 =  new Car()
    println(car.toString())
    println(car1.toString())
    println(car2.toString())
    println(car3.toString())
 */
//主构造方法
class Car(var brand:String,var price:Double) {
  //在this方法的参数中，不可以再定义变量为var、val了。
  //第一个辅助构造函数
  def this(price:Double)  {
    this(Car.DEFAULT_BRAND,price)
  }
  //第二个辅助构造函数，调用第一个辅助构造函数
  def this(brand:String){
    this(Car.DEFAULT_PRICE)
    this.brand = brand
  }
  //第三个辅助构造函数
  def this()={
    this(Car.DEFAULT_BRAND,Car.DEFAULT_PRICE)
  }
  override def toString()={
    s"Car Brand:$brand , Car Price:$price"
  }
}
object Car {
  val DEFAULT_PRICE = 18934560.00
  val DEFAULT_BRAND = "FORD"
}

/**
 *  测试语句：
 *  val carcase = Carcase("TOYOTA",1827834)
    val carcase1 = Carcase.apply("HONDA",81728834)
    println(carcase)
    println(carcase1)

 * case class 不需要new关键字就可以创建对象，val carcase = Carcase("TOYOTA",1827834) Scala会编译成：
 *   val carcase = Carcase.apply("TOYOTA",1827834)  这是一种工厂方法，调用的是Carcase类的伴生对象中的apply方法。
 *
 */
//case class
case class Carcase (var brand:String,var price:Double){
  override def toString() = {
    s"Car Brand:$brand , Car Price:$price"
  }
}
//case class对应的伴生对象
object Carcase {
  def apply():Carcase ={
    new Carcase("NO NAME",0)
  }
  def apply(price:Double):Carcase = {
    new Carcase("defaultName",price)
  }
}

/**
 * 功能：定义私有的主构造函数。
 * 方法：(1)在类名和构造函数接收的任意参数之间插入private关键字，就可以创建私有主构造函数。无法通过new创建该类实例。
 *       (2)可以使用该方法来创建单例模式。
 * @param name
 * @param age
 *   测试语句：
 *   val p = new PersonSingle()          //报错：constructor PersonSingle in class PersonSingle cannot be accessed
     val p1 = PersonSingle.getInstance()
     println(p1)


     author:natty  2018-01-05
 */
case class PersonSingle private (var name:String,var age:Int) {
    override def toString() = {
      s"$name is $age years old!"
    }
}
object PersonSingle{
    val person = new PersonSingle("Lily",14)
    def getInstance() = {person}
}
