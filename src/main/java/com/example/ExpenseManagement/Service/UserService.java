package com.example.ExpenseManagement.Service;

import org.springframework.security.core.userdetails.UserDetails;

import com.example.ExpenseManagement.DTO.Request.UserRequest;
import com.example.ExpenseManagement.DTO.Response.UserResponse;

public interface UserService {
	public UserResponse getUserById(Integer id);
	public UserResponse getUserByUsername(String username);
	public UserResponse getUserByEmail(String email);
	public UserResponse createUser(UserRequest userDTO);
}
