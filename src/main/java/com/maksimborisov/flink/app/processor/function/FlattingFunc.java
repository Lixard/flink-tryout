package com.maksimborisov.flink.app.processor.function;

import com.maksimborisov.flink.app.model.StudentModel;
import org.apache.flink.api.common.functions.MapFunction;

public class FlattingFunc implements MapFunction<StudentModel, String> {

    @Override
    public String map(StudentModel studentModel) throws Exception {
        return "";
    }
}
