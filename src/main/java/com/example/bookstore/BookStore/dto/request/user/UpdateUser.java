package com.example.bookstore.BookStore.dto.request.user;

import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;


@Data
public class UpdateUser {

    @Size(min = 8, message = "PASSWORD_INVALID")
    private String password;

    private String firstname;

    private String lastname;

    private LocalDate dob;
}
