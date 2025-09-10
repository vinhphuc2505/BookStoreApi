package com.example.bookstore.BookStore.repository;

import com.example.bookstore.BookStore.entity.Book;
import com.example.bookstore.BookStore.entity.BorrowRecord;
import com.example.bookstore.BookStore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Long> {
    boolean existsByUserIdAndBookId(User userId, Book bookId);

    List<BorrowRecord> findAllByUserId(User user);
}
