package com.example.bookstore.BookStore.service;


import com.example.bookstore.BookStore.dto.request.BorrowRecord.CreateBorrowRecord;
import com.example.bookstore.BookStore.dto.request.BorrowRecord.UpdateBorrowRecord;
import com.example.bookstore.BookStore.dto.response.BorrowRecordResponse;
import java.util.List;

public interface BorrowRecordService {
    BorrowRecordResponse create(CreateBorrowRecord request);

    List<BorrowRecordResponse> getBorrowRecord();

    List<BorrowRecordResponse> getByUser();

    BorrowRecordResponse findBorrowRecord(Long id);

    BorrowRecordResponse updateBorrowRecord(Long id, UpdateBorrowRecord request);

    void deleteBorrowRecord(Long id);
}
