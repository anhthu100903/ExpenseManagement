package com.example.ExpenseManagement.Mapper;

import org.mapstruct.Mapper;

import com.example.ExpenseManagement.DTO.Request.UserRequest;
import com.example.ExpenseManagement.DTO.Response.UserResponse;
import com.example.ExpenseManagement.Entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponse toUserResponse(User user);
    User toUser(UserRequest dto);
}

