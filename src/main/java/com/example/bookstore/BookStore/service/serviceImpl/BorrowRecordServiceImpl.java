package com.example.bookstore.BookStore.service.serviceImpl;

import com.example.bookstore.BookStore.dto.request.BorrowRecord.CreateBorrowRecord;
import com.example.bookstore.BookStore.dto.request.BorrowRecord.UpdateBorrowRecord;
import com.example.bookstore.BookStore.dto.response.BorrowRecordResponse;
import com.example.bookstore.BookStore.entity.BorrowRecord;
import com.example.bookstore.BookStore.exception.AppException;
import com.example.bookstore.BookStore.exception.ErrorCode;
import com.example.bookstore.BookStore.mapper.BorrowRecordMapper;
import com.example.bookstore.BookStore.repository.BorrowRecordRepository;
import com.example.bookstore.BookStore.service.BorrowRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BorrowRecordServiceImpl implements BorrowRecordService {
    @Autowired
    private BorrowRecordRepository borrowRecordRepository;
    @Autowired
    private BorrowRecordMapper borrowRecordMapper;


    @Override
    public BorrowRecordResponse create(CreateBorrowRecord request) {

        BorrowRecord borrowRecord = borrowRecordMapper.toBorrowRecord(request);
        borrowRecordRepository.save(borrowRecord);
        return borrowRecordMapper.toBorrowRecordResponse(borrowRecord);

    }

    @Override
    public List<BorrowRecordResponse> getBorrowRecord() {
        return borrowRecordMapper.toborrowRecordResponseList(borrowRecordRepository.findAll());
    }

    @Override
    public BorrowRecordResponse findBorrowRecord(Long id) {
        return borrowRecordMapper.toBorrowRecordResponse(borrowRecordRepository
                .findById(id).orElseThrow(() -> new AppException(ErrorCode.BORROW_RECORD_NOT_EXISTED)));
    }

    @Override
    public BorrowRecordResponse updateBorrowRecord(Long id, UpdateBorrowRecord request) {
        BorrowRecord borrowRecord = borrowRecordRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.BORROW_RECORD_NOT_EXISTED));
        borrowRecordMapper.updateBorrowRecord(borrowRecord, request);

        return borrowRecordMapper.toBorrowRecordResponse(borrowRecordRepository.save(borrowRecord));
    }

    @Override
    public void deleteBorrowRecord(Long id) {
        borrowRecordRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.BORROW_RECORD_NOT_EXISTED));
        borrowRecordRepository.deleteById(id);
    }
}
