package com.example.bookstore.BookStore.config;


import com.example.bookstore.BookStore.entity.Role;
import com.example.bookstore.BookStore.entity.User;
import com.example.bookstore.BookStore.exception.AppException;
import com.example.bookstore.BookStore.exception.ErrorCode;
import com.example.bookstore.BookStore.repository.RoleRepository;
import com.example.bookstore.BookStore.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

@Slf4j
@Configuration
public class ApplicationInitConfig {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    ApplicationRunner applicationRunner() {
        return args -> {
            if (roleRepository.findById("ADMIN").isEmpty()) {
                Role role = new Role();
                role.setRole("ADMIN");
                roleRepository.save(role);
            }

            if(roleRepository.findById("OWNER").isEmpty()){
                Role role = new Role();
                role.setRole("OWNER");
                roleRepository.save(role);
            }

            Role role = roleRepository.findById("ADMIN")
                    .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

            if (userRepository.findByRole(role).isEmpty()) {
                User user = User.builder()
                        .email("admin@example.com")
                        .role(role)
                        .firstname("admin")
                        .lastname("admin")
                        .password(passwordEncoder.encode("admin123"))
                        .dob(LocalDate.now())
                        .build();
                userRepository.save(user);
                log.warn("admin user has been created with default password: admin, please change it");
            }
            log.info("Application initialization completed .....");
        };
    }

}
