package com.example.aibackend.dto;

import com.example.aibackend.domain.Book;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record BookRequest(
        @NotBlank
        String author,
        @NotBlank
        String title,
        @NotBlank
        String publisher,
        @Min(0)
        int price
) {

        public Book toEntity() {
                return Book
                        .builder()
                        .author(author)
                        .title(title)
                        .publisher(publisher)
                        .price(price)
                        .build();
        }
}
