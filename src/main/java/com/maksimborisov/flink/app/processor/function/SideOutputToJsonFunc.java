package com.maksimborisov.flink.app.processor.function;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maksimborisov.flink.app.model.StudentModel;
import lombok.AllArgsConstructor;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.util.OutputTag;

public class SideOutputToJsonFunc implements MapFunction<StudentModel, String> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String map(StudentModel studentModel) throws Exception {
        return objectMapper.writeValueAsString(studentModel);
    }


}
