package com.example.bookstore.BookStore.repository;


import com.example.bookstore.BookStore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


@Component
public interface BookRepository extends JpaRepository<Book, Long> {
}
