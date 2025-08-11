package com.example.bookstore.BookStore.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "UNCATEGORIZED_EXCEPTION", "Uncategorized error"),
    KEY_INVALID(1001, "KEY_INVALID", "Key invalid", HttpStatus.BAD_REQUEST),
    PASSWORD_INVALID(1002, "PASSWORD_INVALID", "Password must be at least 8 characters"),
    EMAIL_INVALID(1003, "EMAIL_INVALID", "Email invalid", HttpStatus.BAD_REQUEST),
    EMAIL_EXISTED(1004, "EMAIL_EXISTED", "Email existed", HttpStatus.NOT_FOUND),
    USER_NOT_EXISTED(1005, "USER_NOT_EXISTED", "User not existed", HttpStatus.NOT_FOUND),
    BOOK_NOT_EXISTED(1006, "BOOK_NOT_EXISTED", "Book not existed", HttpStatus.NOT_FOUND),
    BORROW_RECORD_NOT_EXISTED(1007, "BORROW_RECORD_NOT_EXISTED", "Borrow record not existed", HttpStatus.NOT_FOUND),

    ;

    ErrorCode(int code, String errorCode, String message, HttpStatus httpStatus) {
        this.code = code;
        this.errorCode = errorCode;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    ErrorCode(int code, String errorCode, String message) {
        this.code = code;
        this.errorCode = errorCode;
        this.message = message;
    }

    private int code;
    private String errorCode;
    private String message;
    private HttpStatus httpStatus;
}
