package com.example.bookstore.BookStore.service.serviceImpl;

import com.example.bookstore.BookStore.dto.request.author.CreateAuthor;
import com.example.bookstore.BookStore.dto.request.author.UpdateAuthor;
import com.example.bookstore.BookStore.dto.response.AuthorResponse;
import com.example.bookstore.BookStore.entity.Author;
import com.example.bookstore.BookStore.exception.AppException;
import com.example.bookstore.BookStore.exception.ErrorCode;
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
    public AuthorResponse createAuthor(CreateAuthor request) {
        if(authorRepository.existsByAuthorName(request.getAuthorName())){
            throw new AppException(ErrorCode.AUTHOR_EXISTED);
        }
        Author author = authorMapper.toAuthor(request);
        authorRepository.save(author);
        return authorMapper.toAuthorResponse(author);
    }

    @Override
    public List<AuthorResponse> getAuthor(){
        return authorMapper.toListAuthor(authorRepository.findAll());
    }

    @Override
    public AuthorResponse findAuthor(Long id) {
        return authorMapper.toAuthorResponse(authorRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.AUTHOR_NOT_EXISTED)));
    }

    @Override
    public AuthorResponse findAuthorByName(String name) {
        return authorMapper.toAuthorResponse(authorRepository.findByAuthorName(name)
                .orElseThrow(() -> new AppException(ErrorCode.AUTHOR_NOT_EXISTED)));
    }

    @Override
    public AuthorResponse updateAuthor(Long id, UpdateAuthor request) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.AUTHOR_NOT_EXISTED));
        authorMapper.updateAuthor(author, request);
        return authorMapper.toAuthorResponse(authorRepository.save(author));
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.AUTHOR_NOT_EXISTED));
        authorRepository.deleteById(id);
    }
}
