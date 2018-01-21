package com.pmpa.scala.iset

import java.io.File

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

  /**
   * 返回该目录下的 文件或者子目录
   * @param directory
   * @return
   */
  def listFiles(directory:String,fileOrDir:String):List[File] = {
    var s:List[File] =List()
    val files = new File(directory).listFiles()
    for (f <- files) s ::= f
    if (fileOrDir == "file") s.filter(_.isFile)
      else s.filter(_.isDirectory)
  }

  /**
   * 执行外部命令需要使用scala.sys.process包的功能。
   * 1. 执行外部命令：
   *    a.  调用!方法，执行外部命令，返回退出状态
   *    b.  使用!!方法，返回命令输出
   *    c.  使用Lines方法在后台执行命令，并得到stream形式的结果。
   */
  def osCommand() = {
    import scala.sys.process._
    //
    val cmd1 = Process("pwd",new File("C:\\Users\\jay\\Downloads")) !
    val cmdstr2 = "dir".!!
    println(s"命令返回码：$cmd1")
    println(s"命令执行结果：$cmdstr2")
  }


}
