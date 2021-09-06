package com.qbrainx.util

import java.util.Properties

object ProducerProperties1 {
  val properties = new Properties()
  properties.put("bootstrap.servers", "localhost:9093")
  properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  properties.put("group.id", "consumer-group-1")

}
