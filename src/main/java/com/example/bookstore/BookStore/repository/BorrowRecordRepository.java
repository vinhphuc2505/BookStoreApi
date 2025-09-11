package com.example.bookstore.BookStore.repository;

import com.example.bookstore.BookStore.entity.Book;
import com.example.bookstore.BookStore.entity.BorrowRecord;
import com.example.bookstore.BookStore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Long> {
    boolean existsByUserAndBook(User user, Book book);

    List<BorrowRecord> findAllByUser(User user);
}
