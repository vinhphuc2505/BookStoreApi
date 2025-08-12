package com.example.bookstore.BookStore.dto.request.book;
import lombok.Data;


import java.time.LocalDate;

@Data
public class CreateBook {

    private String title;

    private int quantity;

    private LocalDate publishedDate;

    private Long authorId;
}
