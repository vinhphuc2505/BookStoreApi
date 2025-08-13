package com.example.bookstore.BookStore.controller;


import com.example.bookstore.BookStore.dto.request.BorrowRecord.CreateBorrowRecord;
import com.example.bookstore.BookStore.dto.request.BorrowRecord.UpdateBorrowRecord;
import com.example.bookstore.BookStore.dto.response.ApiResponse;
import com.example.bookstore.BookStore.dto.response.BorrowRecordResponse;
import com.example.bookstore.BookStore.service.BorrowRecordService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrowRecord")
public class BorrowRecordController {
    @Autowired
    private BorrowRecordService borrowRecordService;

    @PostMapping()
    public ApiResponse<BorrowRecordResponse> createBorrowRecord(@RequestBody @Valid CreateBorrowRecord request){
        return ApiResponse.<BorrowRecordResponse>builder()
                .code(1000)
                .result(borrowRecordService.create(request))
                .build();
    }

    @GetMapping()
    public ApiResponse<List<BorrowRecordResponse>> getBorrowRecord(){
        return ApiResponse.<List<BorrowRecordResponse>>builder()
                .code(1000)
                .result(borrowRecordService.getBorrowRecord())
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<BorrowRecordResponse> findBorrowRecord(@PathVariable("id") Long id){
        return ApiResponse.<BorrowRecordResponse>builder()
                .code(1000)
                .result(borrowRecordService.findBorrowRecord(id))
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<BorrowRecordResponse> updateBorrowRecord(@PathVariable("id") Long id, UpdateBorrowRecord request){
        return ApiResponse.<BorrowRecordResponse>builder()
                .code(1000)
                .result(borrowRecordService.updateBorrowRecord(id, request))
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteBorrowRecord(@PathVariable("id") Long id){
        borrowRecordService.deleteBorrowRecord(id);
        return ApiResponse.<String>builder()
                .code(1000)
                .result("Bill has been deleted")
                .build();
    }

}














