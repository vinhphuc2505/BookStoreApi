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
        ApiResponse<BorrowRecordResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(borrowRecordService.create(request));
        return apiResponse;
    }

    @GetMapping()
    public ApiResponse<List<BorrowRecordResponse>> getBorrowRecord(){
        ApiResponse<List<BorrowRecordResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(borrowRecordService.getBorrowRecord());
        return apiResponse;
    }

    @GetMapping("/{id}")
    public ApiResponse<BorrowRecordResponse> findBorrowRecord(@PathVariable("id") Long id){
        ApiResponse<BorrowRecordResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(borrowRecordService.findBorrowRecord(id));
        return apiResponse;
    }

    @PutMapping("/{id}")
    public ApiResponse<BorrowRecordResponse> updateBorrowRecord(@PathVariable("id") Long id, UpdateBorrowRecord request){
        ApiResponse<BorrowRecordResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(borrowRecordService.updateBorrowRecord(id, request));
        return apiResponse;
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














