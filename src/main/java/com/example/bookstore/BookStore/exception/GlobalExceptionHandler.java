package com.example.bookstore.BookStore.exception;


import com.example.bookstore.BookStore.dto.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    ResponseEntity<ApiResponse> handlerUncategorizedException(RuntimeException exception){

        ApiResponse apiResponse= new ApiResponse();

        apiResponse.setCode(ErrorCode.UNCATEGORIZED_EXCEPTION.getCode());
        apiResponse.setErrorCode(ErrorCode.UNCATEGORIZED_EXCEPTION.getErrorCode());
        apiResponse.setMessage(ErrorCode.UNCATEGORIZED_EXCEPTION.getMessage());;

        return ResponseEntity.badRequest().body(apiResponse);
    }

    @ExceptionHandler(value = AppException.class)
    ResponseEntity<ApiResponse> handlerRuntimeException(AppException exception){

        ErrorCode errorCode = exception.getErrorCode();
        ApiResponse apiResponse= new ApiResponse();

        apiResponse.setCode(errorCode.getCode());
        apiResponse.setErrorCode(errorCode.getErrorCode());
        apiResponse.setMessage(errorCode.getMessage());
        apiResponse.setHttpStatus(errorCode.getHttpStatus());

        return ResponseEntity.badRequest().body(apiResponse);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ApiResponse> handlerValidation(MethodArgumentNotValidException exception){

        String enumKey = exception.getFieldError().getDefaultMessage();
        ErrorCode errorCode = ErrorCode.KEY_INVALID;
        //Bắt lỗi khi nhập sai key
        try{
            errorCode = errorCode.valueOf(enumKey);
        }catch (IllegalArgumentException e){}

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(errorCode.getCode());
        apiResponse.setErrorCode(errorCode.getErrorCode());
        apiResponse.setMessage((errorCode.getMessage()));

        return ResponseEntity.badRequest().body(apiResponse);
    }
}
