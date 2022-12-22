package com.maksimborisov.flink.app.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.maksimborisov.flink.app.model.BookModel;
import com.maksimborisov.flink.app.model.BookReviewModel;
import com.maksimborisov.flink.app.model.StudentModel;
import net.datafaker.Faker;

import java.util.List;
import java.util.function.Supplier;

public class RandomDataGenerator {

    private final Faker faker = new Faker();
    private final XmlMapper mapper = new XmlMapper();

    public String generate() {
        return tryParseToXml(genStudent());
    }

    private String tryParseToXml(StudentModel model) {
        try {
            return mapper.writeValueAsString(model);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to map Java object to XML", e);
        }
    }

    private StudentModel genStudent() {
        return StudentModel.builder()
                .name(faker.name().name())
                .age(faker.random().nextInt(18, 55))
                .books(genBooks())
                .build();
    }

    private List<BookModel> genBooks() {
        return faker.collection(bookSupplier())
                .minLen(3)
                .maxLen(10)
                .generate();
    }

    private Supplier<BookModel> bookSupplier() {
        return () -> BookModel.builder()
                .name(faker.book().title())
                .author(faker.book().author())
                .reviews(genReviews())
                .build();
    }

    private List<BookReviewModel> genReviews() {
        return faker.collection(reviewSupplier())
                .minLen(3)
                .maxLen(10)
                .generate();
    }

    private Supplier<BookReviewModel> reviewSupplier() {
        return () -> BookReviewModel.builder()
                .review(faker.community().quote())
                .grade(faker.random().nextDouble(0, 10))
                .build();
    }
}
