package com.example.bookstore.BookStore.dto.response;


import com.example.bookstore.BookStore.entity.Author;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BookResponse {
    private String title;

    private int quantity;

    private LocalDate publishedDate;

    private boolean isAvailable = true;

    private AuthorResponse authorId;
}
