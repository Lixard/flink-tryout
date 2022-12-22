package com.maksimborisov.flink.app.processor.sink;

import org.apache.flink.connector.kafka.sink.KafkaSink;

public interface ISink<T> {

    KafkaSink<T> init();
}
