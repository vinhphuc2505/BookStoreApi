package com.example.bookstore.BookStore.dto.response;

import lombok.Data;
import java.time.LocalDate;


@Data
public class AuthorResponse {

    private String authorName;

    private LocalDate dob;

//    private List<Book> books = new ArrayList<>();
}
