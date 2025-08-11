package com.example.bookstore.BookStore.dto.request.BorrowRecord;


import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdateBorrowRecord {

    private LocalDate returnDate;

    private boolean returned;

}
