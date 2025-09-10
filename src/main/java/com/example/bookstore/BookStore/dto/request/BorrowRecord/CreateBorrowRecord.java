package com.example.bookstore.BookStore.dto.request.BorrowRecord;



import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateBorrowRecord {

    private Long bookId;

    private LocalDate returnDate;
}
