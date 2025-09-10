package com.example.bookstore.BookStore.service;


import com.example.bookstore.BookStore.dto.request.user.AuthenticateRequest;
import com.example.bookstore.BookStore.dto.request.user.IntrospectRequest;
import com.example.bookstore.BookStore.dto.response.AuthenticateResponse;
import com.example.bookstore.BookStore.dto.response.IntrospectResponse;
import com.nimbusds.jose.JOSEException;

import java.text.ParseException;

public interface AuthenticateService {
    AuthenticateResponse login(AuthenticateRequest request);

    IntrospectResponse introspectResponse(IntrospectRequest request) throws JOSEException, ParseException;
}
