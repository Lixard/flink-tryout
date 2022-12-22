package com.maksimborisov.flink.app.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

import static com.maksimborisov.flink.app.Constants.BOOTSTRAP_SERVER;
import static com.maksimborisov.flink.app.Constants.RAW_TOPIC;

public class ProducerApp {

    private final static Logger logger = LoggerFactory.getLogger(ProducerApp.class);

    public static void main(String[] args) {
        try (KafkaProducer<String, String> producer = new KafkaProducer<>(buildProperties())) {
            final RandomDataGenerator generator = new RandomDataGenerator();
            while (true) {
                ProducerRecord<String, String> record = new ProducerRecord<>(RAW_TOPIC, generator.generate());
                producer.send(record);
                Thread.sleep(1000);
                logger.info("The record was sent");
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to send the record");
        }
    }

    private static Properties buildProperties() {
        final var properties = new Properties();

        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        return properties;
    }
}
