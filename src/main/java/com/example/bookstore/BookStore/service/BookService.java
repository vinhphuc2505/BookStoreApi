package com.example.bookstore.BookStore.service;


import com.example.bookstore.BookStore.dto.request.book.CreateBook;
import com.example.bookstore.BookStore.dto.request.book.UpdateBook;
import com.example.bookstore.BookStore.dto.response.BookResponse;
import java.util.List;

public interface BookService {
    BookResponse create(CreateBook request);

    BookResponse findBookByTitle(String title);

    List<BookResponse> getBook();

    BookResponse updateBook(Long id, UpdateBook request);

    void deleteBook(Long id);
}
