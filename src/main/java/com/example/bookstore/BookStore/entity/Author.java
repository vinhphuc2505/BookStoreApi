package com.example.bookstore.BookStore.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Author")
public class Author {
    @Id
    @Column(name = "authorId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorId;

    @Column(name = "authorName")
    private String authorName;

    @Column(name = "dob")
    private LocalDate dob;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "authorId", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Book> books = new ArrayList<>();

    public Author(){}

    public Author(Long authorId, String authorName, LocalDate dob, List<Book> books) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.dob = dob;
        this.books = books;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
