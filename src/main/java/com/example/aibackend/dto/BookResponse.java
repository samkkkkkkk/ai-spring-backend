package com.example.aibackend.dto;

import com.example.aibackend.domain.Book;

public record BookResponse(
        Long id,
        String author,
        String title,
        String publisher,
        int price
) {

    public static BookResponse from(Book book) {
        return new BookResponse(book.getId(), book.getAuthor(), book.getTitle(), book.getPublisher(), book.getPrice());
    }
}
