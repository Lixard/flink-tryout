package com.maksimborisov.flink.app.model.flatted;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class FlattedBookReviewModel {
    private UUID id;
    private UUID bookId;
    private String review;
    private double grade;
}
