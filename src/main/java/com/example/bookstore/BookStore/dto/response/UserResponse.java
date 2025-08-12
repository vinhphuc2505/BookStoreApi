package com.example.bookstore.BookStore.dto.response;


import lombok.Data;
import java.time.LocalDate;

@Data
public class UserResponse {
    private String userId;

    private String email;

    private String firstname;

    private String lastname;

    private LocalDate dob;
}
