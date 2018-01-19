package com.pmpa.scala.iset

/**
 * Created by natty.ma on 2018/1/19.
 */
@SerialVersionUID(184)
class Stock(var symbol: String,var price:BigDecimal) extends Serializable{
  override def toString() = {
    s"symbol:$symbol,price:$price"
  }
}


/*
测试序列化对象，将对象状态写入到文件系统中，然后从文件系统中读取文件到对象。
  val ow = new ObjectOutputStream(new FileOutputStream("resources/serioobj"))
  ow.writeObject(st)
  ow.close()
  val oread = new ObjectInputStream((new FileInputStream("resources/serioobj")))
  val st1 = oread.readObject()
  println(st1.toString)
 */
