package com.example.bookstore.BookStore.service.serviceImpl;

import com.example.bookstore.BookStore.dto.request.author.CreateAuthor;
import com.example.bookstore.BookStore.dto.request.author.UpdateAuthor;
import com.example.bookstore.BookStore.dto.response.AuthorResponse;
import com.example.bookstore.BookStore.entity.Author;
import com.example.bookstore.BookStore.mapper.AuthorMapper;
import com.example.bookstore.BookStore.repository.AuthorRepository;
import com.example.bookstore.BookStore.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private AuthorMapper authorMapper;

    @Override
    public Author createAuthor(CreateAuthor request) {
        Author author = authorMapper.toAuthor(request);
        return authorRepository.save(author);
    }

    @Override
    public List<AuthorResponse> getAuthor(){
        List<AuthorResponse> authorList = authorMapper.toListAuthor(authorRepository.findAll());
        return authorList;
    }

    @Override
    public AuthorResponse findAuthor(Long id) {
        return authorMapper.toAuthorResponse(authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException()));
    }

    @Override
    public AuthorResponse updateAuthor(Long id, UpdateAuthor request) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException());
        authorMapper.updateAuthor(author, request);
        return authorMapper.toAuthorResponse(authorRepository.save(author));
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
