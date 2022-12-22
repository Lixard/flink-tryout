package com.maksimborisov.flink.app.model.flatted;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class FlattedBookModel {
    private UUID id;
    private String name;
    private String author;

}
