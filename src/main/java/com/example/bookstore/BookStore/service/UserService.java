package com.example.bookstore.BookStore.service;


import com.example.bookstore.BookStore.dto.request.user.CreateUser;
import com.example.bookstore.BookStore.dto.request.user.UpdateUser;
import com.example.bookstore.BookStore.dto.response.UserResponse;
import com.example.bookstore.BookStore.entity.User;

import java.util.List;

public interface UserService {
    public User Create(CreateUser request);

    public List<UserResponse> getUser();

    public UserResponse findUser(String id);

    public UserResponse updateUser(String id, UpdateUser request);

    public void deleteUser(String id);
}
