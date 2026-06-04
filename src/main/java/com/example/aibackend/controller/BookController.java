package com.example.aibackend.controller;

import com.example.aibackend.domain.Book;
import com.example.aibackend.dto.BookRequest;
import com.example.aibackend.dto.BookResponse;
import com.example.aibackend.error.NotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final Map<Long, Book> storage = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong(1);

    @GetMapping
    public ResponseEntity<List<BookResponse>> getList() {
        List<BookResponse> bookList = storage.values().stream().map(BookResponse::from).toList();
        return ResponseEntity.ok().body(bookList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> get(@PathVariable Long id) {
        Book book = storage.get(id);
        if (book == null) {
            throw new NotFoundException("책이 존재하지 않습니다.");
        }
        return ResponseEntity.ok().body(BookResponse.from(book));
    }

    @PostMapping
    public ResponseEntity<BookResponse> createBook(@Valid @RequestBody BookRequest req) {
        Long id = sequence.getAndIncrement();
        Book book = Book.builder()
                .id(id)
                .author(req.author())
                .title(req.title())
                .publisher(req.publisher())
                .price(req.price())
                .build();

        storage.put(id, book);
        return ResponseEntity.ok()
                .body(BookResponse.from(book));
    }

    @PutMapping("/{id}")
    public BookResponse update(@PathVariable Long id,
                               @Valid @RequestBody BookRequest req) {
        Book book = storage.get(id);
        if (book == null) {
            throw new NotFoundException("책이 존재하지 않습니다.");
        }
        book.setAuthor(req.author());
        book.setTitle(req.title());
        book.setPublisher(req.publisher());
        book.setPrice(req.price());

        return BookResponse.from(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        storage.remove(id);
        return ResponseEntity.noContent().build();
    }
}
