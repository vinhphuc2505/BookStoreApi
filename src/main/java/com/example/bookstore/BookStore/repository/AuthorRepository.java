package com.example.bookstore.BookStore.repository;


import com.example.bookstore.BookStore.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface AuthorRepository extends JpaRepository<Author, Long> {
    boolean existsByAuthorName(String authorName);

    Optional<Author> findByAuthorName(String name);
}
