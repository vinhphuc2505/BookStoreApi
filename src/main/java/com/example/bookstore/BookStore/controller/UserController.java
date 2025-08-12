package com.example.bookstore.BookStore.controller;


import com.example.bookstore.BookStore.dto.request.user.CreateUser;
import com.example.bookstore.BookStore.dto.request.user.UpdateUser;
import com.example.bookstore.BookStore.dto.response.ApiResponse;
import com.example.bookstore.BookStore.dto.response.UserResponse;
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
    ApiResponse<UserResponse> createUser(@RequestBody @Valid CreateUser request){
        return ApiResponse.<UserResponse>builder()
                .code(1000)
                .result(userService.create(request))
                .build();
    }


    @GetMapping()
    public ApiResponse<List<UserResponse>> getUser(){
        return ApiResponse.<List<UserResponse>>builder()
                .code(1000)
                .result(userService.getUser())
                .build();
    }

    @GetMapping("/id/{id}")
    public ApiResponse<UserResponse> findUserById(@PathVariable("id") String id){
        return ApiResponse.<UserResponse>builder()
                .code(1000)
                .result(userService.findUserById(id))
                .build();
    }

    @GetMapping("/email/{email}")
    public ApiResponse<UserResponse> findUserByName(@PathVariable("name") String email){
        return ApiResponse.<UserResponse>builder()
                .code(1000)
                .result(userService.findUserByEmail(email))
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<UserResponse> updateUser(@PathVariable("id") String id, UpdateUser request){
        return ApiResponse.<UserResponse>builder()
                .code(1000)
                .result(userService.updateUser(id, request))
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteUser(@PathVariable("userId") String id){
        userService.deleteUser(id);
        return ApiResponse.<String>builder()
                .code(1000)
                .result("User has been deleted")
                .build();
    }
}


















