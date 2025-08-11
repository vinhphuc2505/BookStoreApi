package com.example.bookstore.BookStore.dto.response;


import com.example.bookstore.BookStore.entity.Book;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class AuthorResponse {

    private String authorName;

    private LocalDate dob;

//    private List<Book> books = new ArrayList<>();
}
