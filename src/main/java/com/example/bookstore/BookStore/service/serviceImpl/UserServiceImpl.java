package com.example.bookstore.BookStore.service.serviceImpl;


import com.example.bookstore.BookStore.dto.request.user.CreateUser;
import com.example.bookstore.BookStore.dto.request.user.UpdateUser;
import com.example.bookstore.BookStore.dto.response.UserResponse;
import com.example.bookstore.BookStore.entity.User;
import com.example.bookstore.BookStore.exception.AppException;
import com.example.bookstore.BookStore.exception.ErrorCode;
import com.example.bookstore.BookStore.mapper.UserMapper;
import com.example.bookstore.BookStore.repository.UserRepository;
import com.example.bookstore.BookStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserResponse create(CreateUser request) {
        User user = userMapper.toUser(request);

        if(userRepository.existsByEmail(user.getEmail())){
            throw new AppException(ErrorCode.EMAIL_EXISTED);
        }
        userRepository.save(user);
        return userMapper.toUserResponse(user);
    }

    @Override
    public List<UserResponse> getUser() {
        return userMapper.userResponseList(userRepository.findAll());
    }

    @Override
    public UserResponse findUserById(String id) {
        return userMapper.toUserResponse(userRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED)));
    }

    @Override
    public UserResponse findUserByEmail(String email){
        return userMapper.toUserResponse(userRepository.findByEmail(email)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED)));
    }

    @Override
    public UserResponse updateUser(String id, UpdateUser request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
        userMapper.updateUser(user, request);
        return userMapper.toUserResponse(userRepository.save(user));
    }

    @Override
    public void deleteUser(String id) {
        userRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
        userRepository.deleteById(id);
    }
}
