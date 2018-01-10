/**
 * 包和导入
 *
 * Created by natty.ma on 2018/1/10.
 *
 * 1.花括号风格的包记号法：可以在一个文件中放多个包。也可以用“花括号”方式定义嵌套的包。
 *    package PACKAGENAME {...}
 * 2.引入一个或多个成员
      可以使用花括号引入多个类，或者使用_表示所有类。可以随意放置import语句的位置。
 *
 * 3.在导入时重命名成员、隐藏类。
    在导入类时，重命名被导入的类。例如 import java.util.{ArrayList => JavaList} 。同时，如果将重命名的类名改为_,可以隐藏这个类。
    例如：import java.util.{ArrayList => _,_} 表示，引入java.util包内所有内容但是隐藏ArrayList类，这里第二个_表示所有，而且必须写在隐藏类的后边。
 *
 * 4.使用静态导入。import语句写好package名._ ，这样可以直接调用成员名。
 */
package com.pmpa.scala.common{
  class Hiking(var distance:Double,var place:String) {
      println(s"Hiking in $place for $distance km  all around the world!!")
  }
}
//花括号包记号法。
package com.pmpa.scala.common.asia{

  import java.lang.System.out.{println => pl}

class HikingAsia(var distance:Double,var place:String) {
    //使用_代表所有，和java中的*作用一致。
    import java.lang.Math._
    //静态导入：max函数可以直接静态调用，因为上边引入了java.lang.Math包的所有内容(import java.lang.Math._)。
    pl(s"Hiking in $place for ${max(distance,100000)} km  in Asia!!")
}
  package japan{

  class HikingJapan(var distance:Double,var place:String) {
          pl(s"Hiking in $place for $distance km  in Japan!!")
         //引入一个或多个成员,可以使用花括号引入多个类，或者使用_表示所有类。可以随意放置import语句的位置。
          import java.util.{ArrayList, HashMap => JavaMap}
          val cities = new ArrayList[String]()
          cities.add("Hokkaido")
          cities.add("Nara")
          cities.add("Osaka")

          //使用重命名的HashMap（JavaMap）
          val maps = new JavaMap[String,Int]()
          maps.put("Hokkaido",1)
          maps.put("Nara",2)
          maps.put("Osaka",3)

          def callMe() = {
            print("ArrayList of cities:")
            for(i<-cities.toArray()) print(s"$i,")
            pl("   ----")
            print("Maps of cities:")
            for(i<-maps.keySet().toArray()) print(s"$i -> ${maps.get(i)},")
            pl("   ----")
          }
      }
  }
}

/**
 * 测试语句：
 *  val hiking1 = new HikingJapan(10.2,"Tokyo")
    hiking1.callMe()
    val hiking2 = new HikingAsia(40.2,"Japan")
    val hiking3 = new Hiking(80.2,"Asia")
 */