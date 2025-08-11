package com.example.bookstore.BookStore.mapper;

import com.example.bookstore.BookStore.dto.request.author.CreateAuthor;
import com.example.bookstore.BookStore.dto.request.author.UpdateAuthor;
import com.example.bookstore.BookStore.dto.response.AuthorResponse;
import com.example.bookstore.BookStore.entity.Author;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Component
public class AuthorMapper {
    public Author toAuthor(CreateAuthor createAuthor){
        Author author = new Author();
        author.setAuthorName(createAuthor.getAuthorName());
        author.setDob(createAuthor.getDob());
        return author;
    }

    public AuthorResponse toAuthorResponse(Author author){
        if(author == null){
            return null;
        }
        AuthorResponse authorResponse = new AuthorResponse();
        authorResponse.setAuthorName(author.getAuthorName());
        authorResponse.setDob(author.getDob());
//        authorResponse.setBooks(author.getBooks());

        return authorResponse;
    }

    public List<AuthorResponse> toListAuthor(List<Author> authorList){
        if(authorList.isEmpty()){
            return Collections.emptyList();
        }

        List<AuthorResponse> authorResponseList = new ArrayList<>();
        for(Author author : authorList){
            authorResponseList.add(toAuthorResponse(author));
        }
        return authorResponseList;
    }

    public void updateAuthor(Author author, UpdateAuthor request){
        author.setAuthorName(request.getAuthorName());
        author.setDob(request.getDob());
    }
}
