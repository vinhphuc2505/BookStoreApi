package com.example.bookstore.BookStore.mapper;


import com.example.bookstore.BookStore.dto.request.book.CreateBook;
import com.example.bookstore.BookStore.dto.request.book.UpdateBook;
import com.example.bookstore.BookStore.dto.response.AuthorResponse;
import com.example.bookstore.BookStore.dto.response.BookResponse;
import com.example.bookstore.BookStore.entity.Author;
import com.example.bookstore.BookStore.entity.Book;
import com.example.bookstore.BookStore.repository.AuthorRepository;
import com.example.bookstore.BookStore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class BookMapper {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private AuthorMapper authorMapper;
    @Autowired
    private BookRepository bookRepository;

    public Book toBook(CreateBook request){
        Author author = authorRepository.findById(request.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Author id invalid"));

        if (request != null){
            Book book = new Book();
            book.setTitle(request.getTitle());
            book.setQuantity(request.getQuantity());
            book.setPublishedDate(request.getPublishedDate());
            book.setAuthorId(author);
            return book;
        }
        return null;
    }

    public BookResponse toBookResponse(Book request){
        if(request == null){
            return null;
        }
        // Lấy thông tin tác giả từ đối tượng Book
        Author author = request.getAuthorId();

        // Ánh xạ thông tin tác giả sang AuthorResponse
        AuthorResponse authorResponse = authorMapper.toAuthorResponse(author);

        BookResponse bookResponse = new BookResponse();
        bookResponse.setTitle(request.getTitle());
        bookResponse.setQuantity(request.getQuantity());
        bookResponse.setPublishedDate(request.getPublishedDate());
        bookResponse.setAvailable(request.isAvailable());
        // Gán thông tin tác giả vào BookResponse
        bookResponse.setAuthorId(authorResponse);

        return bookResponse;
    }

    public List<BookResponse> toBookList(List<Book> bookList){
        if (bookList.isEmpty()){
            return Collections.emptyList();
        }

        List<BookResponse> bookResponseList = new ArrayList<>();
        for (Book book : bookList){
            bookResponseList.add(toBookResponse(book));
        }
        return bookResponseList;
    }

    public void updateBook(Book book, UpdateBook request) {
        if (request == null || book == null) {
            return;
        }

        book.setTitle(request.getTitle());
        book.setQuantity(request.getQuantity());
        book.setPublishedDate(request.getPublishedDate());


        if (request.getAuthorId() != null) {
            Author author = authorRepository.findById(request.getAuthorId())
                    .orElseThrow(() -> new RuntimeException("Author id is invalid"));
            book.setAuthorId(author);
        }
    }

}













