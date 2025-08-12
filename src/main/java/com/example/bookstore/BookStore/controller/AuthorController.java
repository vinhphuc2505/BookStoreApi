package com.example.bookstore.BookStore.controller;


import com.example.bookstore.BookStore.dto.request.author.CreateAuthor;
import com.example.bookstore.BookStore.dto.request.author.UpdateAuthor;
import com.example.bookstore.BookStore.dto.response.ApiResponse;
import com.example.bookstore.BookStore.dto.response.AuthorResponse;
import com.example.bookstore.BookStore.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @PostMapping
    public ApiResponse<AuthorResponse> createAuthor(@RequestBody @Valid CreateAuthor request){
        authorService.createAuthor(request);
        return ApiResponse.<AuthorResponse>builder()
                .code(1000)
                .result(authorService.createAuthor(request))
                .build();
    }

    @GetMapping
    public ApiResponse<List<AuthorResponse>> getAuthor(){
        return ApiResponse.<List<AuthorResponse>>builder()
                .code(1000)
                .result(authorService.getAuthor())
                .build();
    }


    @GetMapping("/id/{id}")
    public ApiResponse<AuthorResponse> findAuthorById(@PathVariable("id") Long id){
        return ApiResponse.<AuthorResponse>builder()
                .code(1000)
                .result(authorService.findAuthor(id))
                .build();
    }

    @GetMapping("/name/{name}")
    public ApiResponse<AuthorResponse> findAuthorByName(@PathVariable("name") String name){
        return ApiResponse.<AuthorResponse>builder()
                .code(1000)
                .result(authorService.findAuthorByName(name))
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<AuthorResponse> updateAuthor(@PathVariable("id") Long id, UpdateAuthor request){
        return ApiResponse.<AuthorResponse>builder()
                .code(1000)
                .result(authorService.updateAuthor(id, request))
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteAuthor(@PathVariable("id") Long id){
        authorService.deleteAuthor(id);
        return ApiResponse.<String>builder()
                .code(1000)
                .result("Author has been deleted")
                .build();
    }
}
















