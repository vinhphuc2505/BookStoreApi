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
    BOOK_EXISTED(1007, "BOOK_EXISTED", "Book existed", HttpStatus.NOT_FOUND),
    BORROW_RECORD_NOT_EXISTED(1008, "BORROW_RECORD_NOT_EXISTED", "Borrow record not existed", HttpStatus.NOT_FOUND),
    AUTHOR_EXISTED(1009, "AUTHOR_EXISTED", "Author existed", HttpStatus.NOT_FOUND),
    AUTHOR_NOT_EXISTED(1010, "AUTHOR_NOT_EXISTED", "Author not existed", HttpStatus.NOT_FOUND),
    BOOK_UNAVAILABLE(1011, "BOOK_UNAVAILABLE","This book is unavailable.", HttpStatus.NOT_FOUND),
    YOU_HAVE_BORROWED(1012, "YOU_HAVE_BORROWED", "You have borrowed this book", HttpStatus.NOT_FOUND),
    CANNOT_CHANGE_STATUS(1013, "CANNOT_CHANGE_STATUS", "Can not change status", HttpStatus.NOT_FOUND)
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
