package com.example.bookstore.BookStore.repository;


import com.example.bookstore.BookStore.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface AuthorRepository extends JpaRepository<Author, Long> {
    
}
