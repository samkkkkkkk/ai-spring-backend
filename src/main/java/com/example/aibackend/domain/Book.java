package com.example.aibackend.domain;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Book {

    private Long id;
    private String author;
    private String title;
    private String publisher;
    private int price;

}
