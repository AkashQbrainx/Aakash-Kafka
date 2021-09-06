package com.qbrainx.util

import com.qbrainx.config.SlickConfig
import com.qbrainx.model.Student
import com.qbrainx.util.StudentDataBaseImplementation.schema
import slick.lifted.ProvenShape
import slick.lifted.ProvenShape._

import scala.concurrent.Future
class StudentDataBaseImplementation {
  import SlickConfig.jdbcProfile.api._
  val db=SlickConfig.db
  private val query: TableQuery[schema] =TableQuery(new schema(_))
   def insert(student:Student):Future[Int]=db.run(query+=student)
}
object StudentDataBaseImplementation{

  import SlickConfig.jdbcProfile.api._
  val tableName="Student"
  final class schema(tag:Tag) extends Table[Student](tag,tableName) {
    private def section=column[Char]("section")
    private def name=column[String]("name")
    private def rollNumber=column[Int]("rollNumber",O.PrimaryKey)
    private def mobile=column[Long]("mobile")

    override def * : ProvenShape[Student] = (section,name,rollNumber,mobile.?)<>(Student.tupled,Student.unapply)
  }
}
