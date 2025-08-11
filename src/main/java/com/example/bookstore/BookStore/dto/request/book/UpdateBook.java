package com.example.bookstore.BookStore.dto.request.book;


import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdateBook {
    private String title;

    private int quantity;

    private LocalDate publishedDate;

    private Long authorId;

    public UpdateBook() {}

    public UpdateBook(String title, int quantity, LocalDate publishedDate, Long authorId) {
        this.title = title;
        this.quantity = quantity;
        this.publishedDate = publishedDate;
        this.authorId = authorId;
    }
}
