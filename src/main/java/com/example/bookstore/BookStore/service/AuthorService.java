package com.example.bookstore.BookStore.service;


import com.example.bookstore.BookStore.dto.request.author.CreateAuthor;
import com.example.bookstore.BookStore.dto.request.author.UpdateAuthor;
import com.example.bookstore.BookStore.dto.response.AuthorResponse;
import com.example.bookstore.BookStore.entity.Author;

import java.util.List;

public interface AuthorService {
    public Author createAuthor(CreateAuthor createAuthor);

    public List<AuthorResponse> getAuthor();

    public AuthorResponse findAuthor(Long id);

    public AuthorResponse updateAuthor(Long id, UpdateAuthor request);

    public void deleteAuthor(Long id);
}
