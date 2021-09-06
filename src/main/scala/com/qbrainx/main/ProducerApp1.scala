package com.qbrainx.main


import com.qbrainx.util.ProducerProperties1.properties
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

import scala.io.StdIn

object ProducerApp1 extends App{
  val producer: KafkaProducer[String, String] = new KafkaProducer[String, String](properties)

  val topic = "test-topic-7"
  println(s"Sending Records in Kafka Topic [$topic]")
  val key: String = "student"

  def read(input: Int): Any = {
    val msg: String = StdIn.readLine()
    val record: ProducerRecord[String, String] = new ProducerRecord(topic, s"$input", msg)
    producer.send(record)
    read(input + 1)
  }

  read(0)

}
