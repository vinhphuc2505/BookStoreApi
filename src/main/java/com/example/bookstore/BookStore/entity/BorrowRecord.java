package com.example.bookstore.BookStore.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "BorrowRecord")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BorrowRecord {
    @Id
    @Column(name = "BorrowRecordId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long borrowRecordId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId", nullable = false)
    @JsonManagedReference
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bookId", nullable = false)
    @JsonManagedReference
    private Book book;

    @Column(name = "borrowDate", nullable = false)
    private LocalDate borrowDate = LocalDate.now();

    @Column(name = "returnDate")
    private LocalDate returnDate;

    @Column(name = "returned", nullable = false)
    private boolean returned = false;

}
