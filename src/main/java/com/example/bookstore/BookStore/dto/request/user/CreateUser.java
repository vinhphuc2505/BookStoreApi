package com.example.bookstore.BookStore.dto.request.user;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateUser {
    @Email(message = "EMAIL_INVALID")
    private String email;

    @Size(min = 8, message = "PASSWORD_INVALID")
    private String password;

    private String firstname;

    private String lastname;

    private LocalDate dob;
}
