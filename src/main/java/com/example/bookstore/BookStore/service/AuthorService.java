package com.example.bookstore.BookStore.service;


import com.example.bookstore.BookStore.dto.request.author.CreateAuthor;
import com.example.bookstore.BookStore.dto.request.author.UpdateAuthor;
import com.example.bookstore.BookStore.dto.response.AuthorResponse;

import java.util.List;

public interface AuthorService {
    public AuthorResponse createAuthor(CreateAuthor createAuthor);

    public List<AuthorResponse> getAuthor();

    public AuthorResponse findAuthor(Long id);

    public AuthorResponse findAuthorByName(String name);

    public AuthorResponse updateAuthor(Long id, UpdateAuthor request);

    public void deleteAuthor(Long id);
}
