package com.maksimborisov.flink.app.model;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookReviewModel {
    private String review;
    private double grade;
    //todo add some date
}
