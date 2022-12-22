package com.maksimborisov.flink.app.processor.source;

import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.connector.kafka.source.enumerator.initializer.OffsetsInitializer;

import static com.maksimborisov.flink.app.Constants.BOOTSTRAP_SERVER;
import static com.maksimborisov.flink.app.Constants.RAW_TOPIC;

public class DefaultKafkaSource implements ISource<String> {
    @Override
    public KafkaSource<String> init() {
        return KafkaSource.<String>builder()
                .setBootstrapServers(BOOTSTRAP_SERVER)
                .setTopics(RAW_TOPIC)
                .setStartingOffsets(OffsetsInitializer.latest())
                .setValueOnlyDeserializer(new SimpleStringSchema())
                .build();
    }
}
