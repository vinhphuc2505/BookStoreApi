package com.example.bookstore.BookStore.service;


import com.example.bookstore.BookStore.dto.request.author.CreateAuthor;
import com.example.bookstore.BookStore.dto.request.author.UpdateAuthor;
import com.example.bookstore.BookStore.dto.response.AuthorResponse;

import java.util.List;

public interface AuthorService {
    AuthorResponse createAuthor(CreateAuthor createAuthor);

    List<AuthorResponse> getAuthor();

    AuthorResponse findAuthor(Long id);

    AuthorResponse findAuthorByName(String name);

    AuthorResponse updateAuthor(Long id, UpdateAuthor request);

    void deleteAuthor(Long id);
}
