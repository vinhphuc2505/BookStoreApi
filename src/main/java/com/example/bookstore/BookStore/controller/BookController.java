package com.example.bookstore.BookStore.controller;


import com.example.bookstore.BookStore.dto.request.book.CreateBook;
import com.example.bookstore.BookStore.dto.request.book.UpdateBook;
import com.example.bookstore.BookStore.dto.response.ApiResponse;
import com.example.bookstore.BookStore.dto.response.BookResponse;
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
    public ApiResponse<BookResponse> create(@RequestBody @Valid CreateBook request){
        return ApiResponse.<BookResponse>builder()
                .code(1000)
                .result(bookService.create(request))
                .build();
    }

    @GetMapping
    public ApiResponse<List<BookResponse>> getBook(){
        return ApiResponse.<List<BookResponse>>builder()
                .code(1000)
                .result(bookService.getBook())
                .build();
    }

    @GetMapping("/{title}")
    private ApiResponse<BookResponse> findById(@PathVariable("title") String title){
        return ApiResponse.<BookResponse>builder()
                .code(1000)
                .result(bookService.findBookByTitle(title))
                .build();
    }

    @PutMapping("/{id}")
    private ApiResponse<BookResponse> update(@PathVariable("id") Long id, UpdateBook request){
        return ApiResponse.<BookResponse>builder()
                .code(1000)
                .result(bookService.updateBook(id, request))
                .build();
    }

    @DeleteMapping("/{id}")
    private ApiResponse<String> delete(@PathVariable("bookId") Long id){
        bookService.deleteBook(id);
        return ApiResponse.<String>builder()
                .code(1000)
                .result("Book has been deleted")
                .build();
    }
}














