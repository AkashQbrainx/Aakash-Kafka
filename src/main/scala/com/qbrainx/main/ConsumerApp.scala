package com.qbrainx.main

import com.qbrainx.model.Student
import com.qbrainx.util.ConsumerProperties.properties
import com.qbrainx.util.StudentDataBaseImplementation
import org.apache.kafka.clients.consumer.{ConsumerRecord, ConsumerRecords, KafkaConsumer}

import java.{lang, util}
import scala.collection.mutable.ListBuffer
import scala.jdk.CollectionConverters.IterableHasAsScala
import spray.json._
import com.qbrainx.model.Student1._

import scala.util.{Failure, Success, Try}


object ConsumerApp extends App {
  val consumer: KafkaConsumer[String, String] = new KafkaConsumer[String, String](properties)

  val topic = "test-topic-5"
  val topic1 = "test-topic-7"
  val studentList = scala.collection.mutable.ListBuffer[Student]()
  val studentDataBaseImplementation = new StudentDataBaseImplementation

  def add(student: Student): Unit = {
    studentList += student
  }

  consumer.subscribe(util.Arrays.asList(topic, topic1))
  while (true) {

    val records: ConsumerRecords[String, String] = consumer.poll(1)
    for (record <- records.asScala) {
      val input: String = record.value()
      record.topic() match {
        case _ if record.topic().equals(topic) =>
          println(s"receiving inputs from topic[$topic]")

          Try(input.parseJson.convertTo[Student]) match {
            case Success(_) =>
              val student = input.parseJson.convertTo[Student]
              add(student)
              println(student)
            case Failure(_) =>
              println("invalid input")
          }

            case _ if record.value().equals(topic1) =>

            case _ if(input.charAt(0)=='A') =>
                    val a: ListBuffer[Student] = studentList.filter(f => f.section == 'A')
                    println(a)
                    for (ele <- a) {
                      studentDataBaseImplementation.insert(ele)
                    }

            case _ if(input.charAt(0)=='B') =>
                    val b: ListBuffer[Student] = studentList.filter(f => f.section == 'B')
                    println(b)
                    for (ele <- b) {
                      studentDataBaseImplementation.insert(ele)
                    }

            case _ if(input.charAt(0)=='C')=>
                    val c: ListBuffer[Student] = studentList.filter(f => f.section == 'C')
                    println(c)
                    for (ele <- c) {
                      studentDataBaseImplementation.insert(ele)
                    }
                }

              }
          }





}