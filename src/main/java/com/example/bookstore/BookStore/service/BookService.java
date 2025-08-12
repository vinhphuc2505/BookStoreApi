package com.example.bookstore.BookStore.service;


import com.example.bookstore.BookStore.dto.request.book.CreateBook;
import com.example.bookstore.BookStore.dto.request.book.UpdateBook;
import com.example.bookstore.BookStore.dto.response.BookResponse;
import java.util.List;

public interface BookService {
    public BookResponse create(CreateBook request);

    public BookResponse findBookByTitle(String title);

    public List<BookResponse> getBook();

    public BookResponse updateBook(Long id, UpdateBook request);

    public void deleteBook(Long id);
}
