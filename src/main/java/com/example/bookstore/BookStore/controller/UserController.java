package com.example.bookstore.BookStore.controller;


import com.example.bookstore.BookStore.dto.request.user.CreateUser;
import com.example.bookstore.BookStore.dto.request.user.UpdateUser;
import com.example.bookstore.BookStore.dto.response.ApiResponse;
import com.example.bookstore.BookStore.dto.response.UserResponse;
import com.example.bookstore.BookStore.entity.User;
import com.example.bookstore.BookStore.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping()
    ApiResponse<User> createUser(@RequestBody @Valid CreateUser request){
        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.Create(request));
        return apiResponse;
    }


    @GetMapping()
    public List<UserResponse> getUser(){
        return userService.getUser();
    }

    @GetMapping("/{userId}")
    public UserResponse findUser(@PathVariable("userId") String id){
        return userService.findUser(id);
    }

    @PutMapping("/{userId}")
    public UserResponse updateUser(@PathVariable("userId") String id, UpdateUser request){
        return userService.updateUser(id, request);
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable("userId") String id){
        userService.deleteUser(id);
        return "User has been deleted";
    }
}


















