package com.example.bookstore.BookStore.dto.request.author;



import java.time.LocalDate;


public class CreateAuthor {

    private String authorName;

    private LocalDate dob;


    public CreateAuthor(){}

    public CreateAuthor(String authorName, LocalDate dob) {
        this.authorName = authorName;
        this.dob = dob;
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
}
