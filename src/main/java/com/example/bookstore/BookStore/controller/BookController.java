package com.example.bookstore.BookStore.controller;


import com.example.bookstore.BookStore.dto.request.book.CreateBook;
import com.example.bookstore.BookStore.dto.request.book.UpdateBook;
import com.example.bookstore.BookStore.dto.response.BookResponse;
import com.example.bookstore.BookStore.entity.Book;
import com.example.bookstore.BookStore.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public Book create(@RequestBody @Valid CreateBook request){
        Book book = bookService.create(request);
        return book;
    }

    @GetMapping
    public List<BookResponse> getBook(){
        return bookService.getBook();
    }

    @GetMapping("/{bookId}")
    private BookResponse findById(@PathVariable("bookId") Long id){
        BookResponse bookResponse = bookService.findById(id);
        return bookResponse;
    }

    @PutMapping("/{bookId}")
    private BookResponse update(@PathVariable("bookId") Long id, UpdateBook request){
        BookResponse bookResponse = bookService.updateBook(id, request);
        return bookResponse;
    }

    @DeleteMapping("/{bookId}")
    private String delete(@PathVariable("bookId") Long id){
        bookService.deleteBook(id);
        return "Book has been deleted";
    }

}














