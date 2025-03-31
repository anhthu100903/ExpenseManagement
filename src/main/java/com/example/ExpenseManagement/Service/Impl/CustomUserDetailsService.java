package com.example.ExpenseManagement.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.ExpenseManagement.Entity.User;
import com.example.ExpenseManagement.Repository.UserRepository;
import com.example.ExpenseManagement.Security.auth.UserPrincipal;
import com.example.ExpenseManagement.Service.UserDetailsService;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) {
		User user = userRepository.findByUsername(username).orElseThrow(() 
				-> new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found")
				);
		return UserPrincipal.create(user);
	}
}
