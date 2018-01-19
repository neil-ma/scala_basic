package com.pmpa.scala.iset

import scala.io.Source

/**
 * Created by natty.ma on 2018/1/19.
 */
object FileUtil {

  /**
   *
   * 将csv文件，读入到一个二维数组中。
   * @param csv文件路径String
   * @param 二维数组行数
   * @param 二位数字列数
   */
  def csvDemo(file:String,rows:Int,cols:Int):Unit = {
    val bufferedFile = scala.io.Source.fromFile(file)
    val dimArray = Array.ofDim[String](rows,cols)
    var j = 0
    for (i<-bufferedFile.getLines())
      {
        dimArray(j) = i.split(",").map(_.trim)
        j = j + 1
      }
    bufferedFile.close()
  }

  /**
   * 将str伪装为一个文件，使用Source类处理。
   * @param str
   */
  def presoString(str:String):Unit = {
    for (i <- Source.fromString(str).getLines())
        println(i.toUpperCase())
  }

}
