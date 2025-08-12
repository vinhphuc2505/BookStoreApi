package com.example.bookstore.BookStore.service;


import com.example.bookstore.BookStore.dto.request.user.CreateUser;
import com.example.bookstore.BookStore.dto.request.user.UpdateUser;
import com.example.bookstore.BookStore.dto.response.UserResponse;
import java.util.List;

public interface UserService {
    public UserResponse create(CreateUser request);

    public List<UserResponse> getUser();

    public UserResponse findUserById(String id);

    public UserResponse findUserByEmail(String email);

    public UserResponse updateUser(String id, UpdateUser request);

    public void deleteUser(String id);
}
