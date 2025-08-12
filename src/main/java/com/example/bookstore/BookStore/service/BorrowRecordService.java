package com.example.bookstore.BookStore.service;


import com.example.bookstore.BookStore.dto.request.BorrowRecord.CreateBorrowRecord;
import com.example.bookstore.BookStore.dto.request.BorrowRecord.UpdateBorrowRecord;
import com.example.bookstore.BookStore.dto.response.BorrowRecordResponse;
import java.util.List;

public interface BorrowRecordService {
    public BorrowRecordResponse create(CreateBorrowRecord request);

    public List<BorrowRecordResponse> getBorrowRecord();

    public BorrowRecordResponse findBorrowRecord(Long id);

    public BorrowRecordResponse updateBorrowRecord(Long id, UpdateBorrowRecord request);

    public void deleteBorrowRecord(Long id);
}
