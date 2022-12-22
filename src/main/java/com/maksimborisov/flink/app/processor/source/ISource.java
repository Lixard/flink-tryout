package com.maksimborisov.flink.app.processor.source;

import org.apache.flink.connector.kafka.source.KafkaSource;

public interface ISource<T> {
    KafkaSource<T> init();
}
