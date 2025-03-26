package com.example.ExpenseManagement.Service.Impl;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.ExpenseManagement.DTO.Response.UserResponse;
import com.example.ExpenseManagement.Mapper.UserMapper;
import com.example.ExpenseManagement.Repository.UserRepository;
import com.example.ExpenseManagement.Service.UserService;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService{
	UserRepository userRepository;
	UserMapper userMapper;

	@Override
    @PostAuthorize("returnObject.username == authentication.name")
    public UserResponse getUserById(Integer id) {
        return userMapper.toUserResponse(
                userRepository.findById(id).orElseThrow(() 
                		-> new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found"))
                );
    }
}
