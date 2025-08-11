package com.example.bookstore.BookStore.mapper;


import com.example.bookstore.BookStore.dto.request.user.CreateUser;
import com.example.bookstore.BookStore.dto.request.user.UpdateUser;
import com.example.bookstore.BookStore.dto.response.UserResponse;
import com.example.bookstore.BookStore.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {
    public User toUser(CreateUser request){
        if(request == null){
            return null;
        }
        User user = new User();

        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setLastname(request.getLastname());
        user.setFirstname(request.getFirstname());
        user.setDob(request.getDob());

        return user;
    }

    public UserResponse toUserResponse(User user){
        if(user ==null){
            return null;
        }else{
            UserResponse userResponse = new UserResponse();
            userResponse.setUserId(user.getUserId());
            userResponse.setEmail(user.getEmail());
            userResponse.setFirstname(user.getFirstname());
            userResponse.setLastname(user.getLastname());
            userResponse.setDob(user.getDob());
            return userResponse;
        }
    }

    public List<UserResponse> userResponseList (List<User> userList){
        if(userList.isEmpty()){
            return null;
        }
        List<UserResponse> userResponseList = new ArrayList<>();
        for(User user : userList){
            userResponseList.add(toUserResponse(user));
        }
        return userResponseList;
    }

    public void updateUser(User user, UpdateUser request){
        if(request == null){
            return;
        }
        user.setPassword(request.getPassword());
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setDob(request.getDob());
    }
}
