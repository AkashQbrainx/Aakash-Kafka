package com.qbrainx.model


import spray.json.DefaultJsonProtocol._
import spray.json.RootJsonFormat

case class Student(section:Char,name:String,rollNumber:Int,mobile:Option[Long])

object Student1{
  implicit val rootJsonFormat: RootJsonFormat[Student] = jsonFormat4(Student)
}


