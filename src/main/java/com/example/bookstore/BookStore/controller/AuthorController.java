package com.example.bookstore.BookStore.controller;


import com.example.bookstore.BookStore.dto.request.author.CreateAuthor;
import com.example.bookstore.BookStore.dto.request.author.UpdateAuthor;
import com.example.bookstore.BookStore.dto.response.AuthorResponse;
import com.example.bookstore.BookStore.entity.Author;
import com.example.bookstore.BookStore.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @PostMapping
    public Author createAuthor(@RequestBody @Valid CreateAuthor request){
        Author author = authorService.createAuthor(request);
        return author;
    }

    @GetMapping
    public List<AuthorResponse> getAuthor(){
        List<AuthorResponse> authorList = authorList = authorService.getAuthor();
        return authorList;
    }

    @GetMapping("/{authorId}")
    public AuthorResponse findAuthor(@PathVariable("authorId") Long id){
        AuthorResponse authorResponse = authorService.findAuthor(id);
        return authorResponse;
    }

    @PutMapping("/{authorId}")
    public AuthorResponse updateAuthor(@PathVariable("authorId") Long id, UpdateAuthor request){
        AuthorResponse authorResponse = authorService.updateAuthor(id, request);
        return authorResponse;
    }

    @DeleteMapping("/{authorId}")
    public String deleteAuthor(@PathVariable("authorId") Long id){
        authorService.deleteAuthor(id);
        return "Author has been deleted";
    }
}
















