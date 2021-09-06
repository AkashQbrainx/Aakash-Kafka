package com.qbrainx.util
import java.util. Properties

object ConsumerProperties {
  val properties = new Properties()
  properties.put("bootstrap.servers", "localhost:9092,localhost:9093")
  properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  properties.put("group.id", "consumer-group-1")


}