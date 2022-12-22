package com.maksimborisov.flink.app.processor.sink;

import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.connector.base.DeliveryGuarantee;
import org.apache.flink.connector.kafka.sink.KafkaRecordSerializationSchema;
import org.apache.flink.connector.kafka.sink.KafkaSink;

import static com.maksimborisov.flink.app.Constants.BOOTSTRAP_SERVER;
import static com.maksimborisov.flink.app.Constants.JSON_TOPIC;

public class JsonKafkaSink implements ISink<String> {

    @Override
    public KafkaSink<String> init() {
        return KafkaSink.<String>builder()
                .setBootstrapServers(BOOTSTRAP_SERVER)
                .setRecordSerializer(KafkaRecordSerializationSchema.builder()
                                             .setTopic(JSON_TOPIC)
                                             .setValueSerializationSchema(new SimpleStringSchema())
                                             .build()
                )
                .build();
    }
}
