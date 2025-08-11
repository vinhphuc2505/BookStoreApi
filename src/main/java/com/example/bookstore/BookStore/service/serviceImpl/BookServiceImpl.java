package com.example.bookstore.BookStore.service.serviceImpl;


import com.example.bookstore.BookStore.dto.request.book.CreateBook;
import com.example.bookstore.BookStore.dto.request.book.UpdateBook;
import com.example.bookstore.BookStore.dto.response.BookResponse;
import com.example.bookstore.BookStore.entity.Book;
import com.example.bookstore.BookStore.mapper.BookMapper;
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



    @Override
    public Book create(CreateBook request) {
        Book book = bookMapper.toBook(request);
        return bookRepository.save(book);
    }

    @Override
    public BookResponse findById(Long id) {
        return bookMapper.toBookResponse(bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book id invalid")));
    }

    @Override
    public List<BookResponse> getBook() {
        return bookMapper.toBookList(bookRepository.findAll());
    }

    @Override
    public BookResponse updateBook(Long id, UpdateBook request) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Id invalid"));
        bookMapper.updateBook(book, request);
        return bookMapper.toBookResponse(bookRepository.save(book));
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Id invalid"));

        bookRepository.deleteById(id);
    }
}



















