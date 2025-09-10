package com.example.bookstore.BookStore.service;


import com.example.bookstore.BookStore.dto.request.user.CreateUser;
import com.example.bookstore.BookStore.dto.request.user.UpdateUser;
import com.example.bookstore.BookStore.dto.response.UserResponse;
import java.util.List;

public interface UserService {
    UserResponse create(CreateUser request);

    List<UserResponse> getUser();

    UserResponse findUserById(String id);

    UserResponse getMyInfo();

    UserResponse findUserByEmail(String email);

    UserResponse updateUser(UpdateUser request);

    void deleteUser(String id);
}
