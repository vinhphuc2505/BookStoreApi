package com.example.bookstore.BookStore.service.serviceImpl;


import com.example.bookstore.BookStore.dto.request.user.AuthenticateRequest;
import com.example.bookstore.BookStore.dto.request.user.IntrospectRequest;
import com.example.bookstore.BookStore.dto.response.AuthenticateResponse;
import com.example.bookstore.BookStore.dto.response.IntrospectResponse;
import com.example.bookstore.BookStore.entity.User;
import com.example.bookstore.BookStore.exception.AppException;
import com.example.bookstore.BookStore.exception.ErrorCode;
import com.example.bookstore.BookStore.repository.UserRepository;
import com.example.bookstore.BookStore.service.AuthenticateService;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;

@Service
public class AuthenticateServiceImpl implements AuthenticateService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @NonFinal
    @Value("${jwt.signerKey}")
    protected String SIGNER_KEY;

    @Override
    public AuthenticateResponse login(AuthenticateRequest request) {
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        boolean authenticate = passwordEncoder.matches(request.getPassword(), user.getPassword());


        if(!authenticate){
            throw new AppException(ErrorCode.USER_NOT_EXISTED);
        }

        AuthenticateResponse authenticateResponse = new AuthenticateResponse();
        authenticateResponse.setAuthenticate(true);
        authenticateResponse.setToken(generateToken(user));

        return authenticateResponse;
    }

    @Override
    public IntrospectResponse introspectResponse(IntrospectRequest request) throws JOSEException, ParseException {
        var token = request.getToken();
        // Xác thực token bằng SIGNER_KEY
        JWSVerifier jwsVerifier = new MACVerifier(SIGNER_KEY.getBytes());
        // Giải mã token
        SignedJWT signedJWT = SignedJWT.parse(token);
        // Lấy thời gian hết hạn của token
        Date expiryTime = signedJWT.getJWTClaimsSet().getExpirationTime();
        // Kiểm tra tính hợp lệ của token
        var verified = signedJWT.verify(jwsVerifier);

        boolean valid = verified && expiryTime.after(new Date());
        IntrospectResponse introspectResponse = new IntrospectResponse();
        introspectResponse.setValid(valid);

        return introspectResponse;
    }


    private String generateToken(User user)  {
        JWSHeader jwsHeader = new JWSHeader(JWSAlgorithm.HS512);

        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(user.getUserId())
                .jwtID(UUID.randomUUID().toString())
                .issuer("book.com")
                .issueTime(new Date())
                .expirationTime(Date.from(Instant.now().plus(1, ChronoUnit.HOURS)))
                .claim("scope", buildScope(user))
                .build();

        Payload payload = new Payload(jwtClaimsSet.toJSONObject());

        JWSObject jwsObject = new JWSObject(jwsHeader, payload);

        try{
            jwsObject.sign(new MACSigner(SIGNER_KEY.getBytes()));
            return  jwsObject.serialize();
        }catch (JOSEException e){
            throw new RuntimeException("Error while signing JWT", e);
        }
    }

    private String buildScope(User user){
        return user.getRole().getRole().toUpperCase();
    }
}
