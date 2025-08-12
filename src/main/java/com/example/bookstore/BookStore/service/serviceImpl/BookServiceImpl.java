package com.example.bookstore.BookStore.service.serviceImpl;


import com.example.bookstore.BookStore.dto.request.book.CreateBook;
import com.example.bookstore.BookStore.dto.request.book.UpdateBook;
import com.example.bookstore.BookStore.dto.response.BookResponse;
import com.example.bookstore.BookStore.entity.Author;
import com.example.bookstore.BookStore.entity.Book;
import com.example.bookstore.BookStore.exception.AppException;
import com.example.bookstore.BookStore.exception.ErrorCode;
import com.example.bookstore.BookStore.mapper.BookMapper;
import com.example.bookstore.BookStore.repository.AuthorRepository;
import com.example.bookstore.BookStore.repository.BookRepository;
import com.example.bookstore.BookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private AuthorRepository authorRepository;


    @Override
    public BookResponse create(CreateBook request) {
        Author author = authorRepository.findById(request.getAuthorId())
                .orElseThrow(() -> new AppException(ErrorCode.AUTHOR_NOT_EXISTED));
        if(bookRepository.existsByTitleAndAuthorId(request.getTitle(), author)){
            throw new AppException(ErrorCode.BOOK_EXISTED);
        }
        Book book = bookMapper.toBook(request);
        bookRepository.save(book);
        return bookMapper.toBookResponse(book);
    }

    @Override
    public BookResponse findBookByTitle(String title) {
        return bookMapper.toBookResponse(bookRepository.findByTitle(title)
                .orElseThrow(() -> new AppException(ErrorCode.BOOK_NOT_EXISTED)));
    }

    @Override
    public List<BookResponse> getBook() {
        return bookMapper.toBookList(bookRepository.findAll());
    }

    @Override
    public BookResponse updateBook(Long id, UpdateBook request) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.BOOK_NOT_EXISTED));
        bookMapper.updateBook(book, request);
        return bookMapper.toBookResponse(bookRepository.save(book));
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.BOOK_NOT_EXISTED));

        bookRepository.deleteById(id);
    }
}



















