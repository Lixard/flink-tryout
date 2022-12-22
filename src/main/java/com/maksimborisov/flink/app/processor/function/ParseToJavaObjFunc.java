package com.maksimborisov.flink.app.processor.function;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.maksimborisov.flink.app.model.StudentModel;
import org.apache.flink.api.common.functions.MapFunction;

public class ParseToJavaObjFunc implements MapFunction<String, StudentModel> {

    private final XmlMapper xmlMapper = new XmlMapper();

    @Override
    public StudentModel map(String s) throws Exception {
        return xmlMapper.readValue(s, StudentModel.class);
    }
}
