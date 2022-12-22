package com.maksimborisov.flink.app.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookModel {
    private String name;
    private String author;
    private List<BookReviewModel> reviews;
}
