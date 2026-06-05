package com.example.aibackend.service;

import com.example.aibackend.domain.Book;
import com.example.aibackend.dto.BookResponse;
import com.example.aibackend.error.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
@RequiredArgsConstructor
public class BookService {


    private final Map<Long, Book> storage = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong(1);


    public List<BookResponse> getList() {
        List<BookResponse> bookList = storage.values().stream().map(BookResponse::from).toList();
        return bookList;
    }

    public BookResponse get(Long id) {

        Book book = storage.get(id);
        if (book == null) {
            throw new NotFoundException("책이 존재하지 않습니다.");
        }
        return BookResponse.from(book);
    }
}
