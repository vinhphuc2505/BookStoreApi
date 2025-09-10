package com.example.bookstore.BookStore.repository;

import com.example.bookstore.BookStore.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
}
