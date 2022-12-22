package com.maksimborisov.flink.app.processor;

import com.maksimborisov.flink.app.model.StudentModel;
import com.maksimborisov.flink.app.processor.function.ParseToJavaObjFunc;
import com.maksimborisov.flink.app.processor.function.SideOutputToJsonFunc;
import com.maksimborisov.flink.app.processor.sink.JsonKafkaSink;
import com.maksimborisov.flink.app.processor.source.DefaultKafkaSource;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.connector.kafka.sink.KafkaSink;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;


public class DataProcessor {

    public void process() {
        try {
            final var env = StreamExecutionEnvironment.getExecutionEnvironment();

            //inputs
            final KafkaSource<String> source = new DefaultKafkaSource().init();
            //outputs
            final KafkaSink<String> jsonSink = new JsonKafkaSink().init();

            final SingleOutputStreamOperator<StudentModel> operator =
                    env.fromSource(source,
                                   WatermarkStrategy.noWatermarks(),
                                   "Kafka Source")
                            .map(new ParseToJavaObjFunc());

            operator.map(new SideOutputToJsonFunc())
                    .sinkTo(jsonSink);

            env.execute("from-xml-to-json");
        } catch (Throwable e) {
            throw new RuntimeException("Failed to process", e);
        }
    }

}
