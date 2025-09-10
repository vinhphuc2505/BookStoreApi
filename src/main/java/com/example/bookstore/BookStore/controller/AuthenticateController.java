package com.example.bookstore.BookStore.controller;


import com.example.bookstore.BookStore.dto.request.user.AuthenticateRequest;
import com.example.bookstore.BookStore.dto.request.user.IntrospectRequest;
import com.example.bookstore.BookStore.dto.response.ApiResponse;
import com.example.bookstore.BookStore.dto.response.AuthenticateResponse;
import com.example.bookstore.BookStore.dto.response.IntrospectResponse;
import com.example.bookstore.BookStore.service.AuthenticateService;
import com.nimbusds.jose.JOSEException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/auth")
public class AuthenticateController {
    @Autowired
    private AuthenticateService authenticateService;

    @PostMapping("/login")
    private ApiResponse<AuthenticateResponse> login(@RequestBody AuthenticateRequest request){
        return ApiResponse.<AuthenticateResponse>builder()
                .code(1000)
                .result(authenticateService.login(request))
                .build();
    }

    @PostMapping("/verify")
    private ApiResponse<IntrospectResponse> introspect(@RequestBody IntrospectRequest request)
            throws ParseException, JOSEException {
        return ApiResponse.<IntrospectResponse>builder()
                .code(1000)
                .result(authenticateService.introspectResponse(request))
                .build();
    }

}
