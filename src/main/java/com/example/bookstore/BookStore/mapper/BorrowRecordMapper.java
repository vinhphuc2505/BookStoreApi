package com.example.bookstore.BookStore.mapper;


import com.example.bookstore.BookStore.dto.request.BorrowRecord.CreateBorrowRecord;
import com.example.bookstore.BookStore.dto.request.BorrowRecord.UpdateBorrowRecord;
import com.example.bookstore.BookStore.dto.response.BorrowRecordResponse;
import com.example.bookstore.BookStore.dto.response.UserResponse;
import com.example.bookstore.BookStore.entity.Book;
import com.example.bookstore.BookStore.entity.BorrowRecord;
import com.example.bookstore.BookStore.exception.AppException;
import com.example.bookstore.BookStore.exception.ErrorCode;
import com.example.bookstore.BookStore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class BorrowRecordMapper {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserMapper userMapper;

    public BorrowRecord toBorrowRecord(CreateBorrowRecord request){
        if(request == null){
            return null;
        }

        Book book = bookRepository.findById(request.getBookId())
                .orElseThrow(() -> new AppException(ErrorCode.BOOK_NOT_EXISTED));

        BorrowRecord borrowRecord = new BorrowRecord();
        borrowRecord.setBook(book);
        borrowRecord.setReturnDate(request.getReturnDate());

        return borrowRecord;
    }

    public BorrowRecordResponse toBorrowRecordResponse(BorrowRecord request){
        if (request == null){
            return null;
        }

        UserResponse userResponse = userMapper.toUserResponse(request.getUser());

        BorrowRecordResponse borrowRecordResponse = new BorrowRecordResponse();

        borrowRecordResponse.setUser(userResponse);
        borrowRecordResponse.setBook(request.getBook());
        borrowRecordResponse.setBorrowDate(request.getBorrowDate());
        borrowRecordResponse.setReturnDate(request.getReturnDate());
        borrowRecordResponse.setReturned(request.isReturned());

        return borrowRecordResponse;
    }

    public List<BorrowRecordResponse> toborrowRecordResponseList(List<BorrowRecord> borrowRecordList){
        if(borrowRecordList.isEmpty()){
            return Collections.emptyList();
        }

        List<BorrowRecordResponse> borrowRecordResponseList = new ArrayList<>();
        for(BorrowRecord borrowRecord : borrowRecordList){
            borrowRecordResponseList.add(toBorrowRecordResponse(borrowRecord));
        }

        return borrowRecordResponseList;
    }

    public void updateBorrowRecord(BorrowRecord borrowRecord, UpdateBorrowRecord request){
        if(request == null){
            return;
        }

        borrowRecord.setReturnDate(request.getReturnDate());
        borrowRecord.setReturned(request.isReturned());
    }

}











