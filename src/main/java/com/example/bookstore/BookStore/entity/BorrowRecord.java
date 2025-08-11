package com.example.bookstore.BookStore.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "BorrowRecord")
public class BorrowRecord {
    @Id
    @Column(name = "BorrowRecordId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long borrowRecordId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    @JsonManagedReference
    private User userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookId", nullable = false)
    @JsonManagedReference
    private Book bookId;

    @Column(name = "borrowDate", nullable = false)
    private LocalDate borrowDate = LocalDate.now();

    @Column(name = "returnDate")
    private LocalDate returnDate;

    @Column(name = "returned", nullable = false)
    private boolean returned = false;

    public BorrowRecord(){}

    public BorrowRecord(Long borrowRecordId, User userId, Book bookId, LocalDate borrowDate, LocalDate returnDate, boolean returned) {
        this.borrowRecordId = borrowRecordId;
        this.userId = userId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.returned = returned;
    }

    public Long getBorrowRecordId() {
        return borrowRecordId;
    }

    public void setBorrowRecordId(Long borrowRecordId) {
        this.borrowRecordId = borrowRecordId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Book getBookId() {
        return bookId;
    }

    public void setBookId(Book bookId) {
        this.bookId = bookId;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }


}
