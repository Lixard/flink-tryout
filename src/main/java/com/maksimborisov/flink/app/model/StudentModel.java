package com.maksimborisov.flink.app.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentModel {
    private String name;
    private double age;
    private List<BookModel> books;
}
