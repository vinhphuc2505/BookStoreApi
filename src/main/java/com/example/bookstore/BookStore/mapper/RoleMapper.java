package com.example.bookstore.BookStore.mapper;

import com.example.bookstore.BookStore.dto.response.RoleResponse;
import com.example.bookstore.BookStore.entity.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {
    public RoleResponse toRoleResponse(Role role){
        RoleResponse roleResponse = new RoleResponse();
        roleResponse.setRole(role.getRole());
        return roleResponse;
    }
}
