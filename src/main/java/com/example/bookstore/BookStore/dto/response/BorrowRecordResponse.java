package com.example.bookstore.BookStore.dto.response;


import com.example.bookstore.BookStore.entity.Book;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BorrowRecordResponse {

    private UserResponse user;

    private Book book;

    private LocalDate borrowDate;

    private LocalDate returnDate;

    private boolean returned;
}
