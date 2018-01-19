package com.pmpa.scala.iset

import java.io._

/**
 * Created by natty.ma on 2018/1/18.
 */
/**
 *
 */

object FileTest extends App{
  /*
  1.读取文件
   */
  val file01 = "resources/files4read"
  for (i <- scala.io.Source.fromFile(file01).getLines())
    println(i)

  /*
  2.写入文件
   */
  //PrintWriter写入文件
  val pw = new PrintWriter(new File("resources/test.io"))
  pw.write("Hello file")
  pw.close()
  //FileWriter写入文件
  val fw = new FileWriter("resources/test.io")
  fw.write("Hello FileWriter")
  fw.write("My God")
  fw.close()

//  /*
//  3.读写二进制文件
//  */
//  val in = new FileInputStream(new File("resources/test.binary"))
//  val out = new FileOutputStream(new File("resources/test.binary"))

//  FileUtil.csvDemo("resources/getme.csv",8,3)
  FileUtil.presoString("jason\nsfg\nlets")

  val st = new Stock("costa",23.24)


}
