package com.example.bookstore.BookStore.service.serviceImpl;

import com.example.bookstore.BookStore.dto.request.BorrowRecord.CreateBorrowRecord;
import com.example.bookstore.BookStore.dto.request.BorrowRecord.UpdateBorrowRecord;
import com.example.bookstore.BookStore.dto.response.BorrowRecordResponse;
import com.example.bookstore.BookStore.entity.Book;
import com.example.bookstore.BookStore.entity.BorrowRecord;
import com.example.bookstore.BookStore.entity.User;
import com.example.bookstore.BookStore.exception.AppException;
import com.example.bookstore.BookStore.exception.ErrorCode;
import com.example.bookstore.BookStore.mapper.BorrowRecordMapper;
import com.example.bookstore.BookStore.repository.BookRepository;
import com.example.bookstore.BookStore.repository.BorrowRecordRepository;
import com.example.bookstore.BookStore.repository.UserRepository;
import com.example.bookstore.BookStore.service.BorrowRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Objects;


@Service
public class BorrowRecordServiceImpl implements BorrowRecordService {
    @Autowired
    private BorrowRecordRepository borrowRecordRepository;
    @Autowired
    private BorrowRecordMapper borrowRecordMapper;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;


    @Override
    @Transactional
    public BorrowRecordResponse create(CreateBorrowRecord request) {

        Book book = bookRepository.findById(request.getBookId())
                .orElseThrow(() -> new AppException(ErrorCode.BOOK_NOT_EXISTED));

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        if(borrowRecordRepository.existsByUserIdAndBookId(user, book)){
            throw new AppException(ErrorCode.YOU_HAVE_BORROWED);
        }

        if(book.getQuantity() <= 0 || !book.isAvailable()){
            throw new AppException(ErrorCode.BOOK_UNAVAILABLE);
        }
        int count = book.getQuantity() - 1;
        book.setQuantity(count);

        if(book.getQuantity() == 0){
            book.setAvailable(false);
        }

        bookRepository.save(book);

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
    @Transactional
    public BorrowRecordResponse updateBorrowRecord(Long id, UpdateBorrowRecord request) {
        BorrowRecord borrowRecord = borrowRecordRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.BORROW_RECORD_NOT_EXISTED));

        Book book = borrowRecord.getBookId();
        boolean currentReturned = borrowRecord.isReturned();
        boolean newReturned = request.isReturned();
        System.out.println(request.isReturned());
        System.out.println(request.getReturnDate());

        if(!currentReturned && !newReturned && !Objects.equals(borrowRecord.getReturnDate(), request.getReturnDate())){

            borrowRecordMapper.updateBorrowRecord(borrowRecord, request);
            return borrowRecordMapper.toBorrowRecordResponse(borrowRecordRepository.save(borrowRecord));

        }else if(currentReturned && !newReturned){
            throw new AppException(ErrorCode.CANNOT_CHANGE_STATUS);
        }else {

            int newQuantity = book.getQuantity() + 1;
            book.setQuantity(newQuantity);
            book.setAvailable(newQuantity > 0);
            bookRepository.save(book);

            borrowRecordMapper.updateBorrowRecord(borrowRecord, request);

            return borrowRecordMapper.toBorrowRecordResponse(borrowRecordRepository.save(borrowRecord));
        }
    }

    @Override
    public void deleteBorrowRecord(Long id) {
        borrowRecordRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.BORROW_RECORD_NOT_EXISTED));
        borrowRecordRepository.deleteById(id);
    }
}
