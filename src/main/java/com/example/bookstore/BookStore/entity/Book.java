package com.example.bookstore.BookStore.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Book")
public class Book {
    @Id
    @Column(name = "bookId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @Column(name = "title")
    private String title;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "publishedDate")
    private LocalDate publishedDate;

    @Column(name = "isAvailable")
    private boolean isAvailable = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "authorId", nullable = false)
    @JsonBackReference
    private Author authorId;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bookId", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<BorrowRecord> borrowRecordList = new ArrayList<>();

    public Book() {}

    public Book(Long bookId, String title, int quantity, LocalDate publishedDate, boolean isAvailable, Author authorId, List<BorrowRecord> borrowRecordList) {
        this.bookId = bookId;
        this.title = title;
        this.quantity = quantity;
        this.publishedDate = publishedDate;
        this.isAvailable = isAvailable;
        this.authorId = authorId;
        this.borrowRecordList = borrowRecordList;
    }

    public Book(Long bookId, String title, int quantity, LocalDate publishedDate, boolean isAvailable, Author authorId) {
        this.bookId = bookId;
        this.title = title;
        this.quantity = quantity;
        this.publishedDate = publishedDate;
        this.isAvailable = isAvailable;
        this.authorId = authorId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Author getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Author authorId) {
        this.authorId = authorId;
    }

    public List<BorrowRecord> getBorrowRecordList() {
        return borrowRecordList;
    }

    public void setBorrowRecordList(List<BorrowRecord> borrowRecordList) {
        this.borrowRecordList = borrowRecordList;
    }
}
