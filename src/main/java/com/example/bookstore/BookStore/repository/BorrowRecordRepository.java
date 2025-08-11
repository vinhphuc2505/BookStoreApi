package com.example.bookstore.BookStore.repository;

import com.example.bookstore.BookStore.entity.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Long> {
}
