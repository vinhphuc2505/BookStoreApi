package com.example.bookstore.BookStore.repository;

import com.example.bookstore.BookStore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, String> {
    boolean existsByEmail(String email);
}
