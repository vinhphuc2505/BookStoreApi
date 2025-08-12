package com.example.bookstore.BookStore.repository;


import com.example.bookstore.BookStore.entity.Author;
import com.example.bookstore.BookStore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface BookRepository extends JpaRepository<Book, Long> {
    boolean existsByTitleAndAuthorId(String title, Author authorId);

    Optional<Book> findByTitle(String title);


}
