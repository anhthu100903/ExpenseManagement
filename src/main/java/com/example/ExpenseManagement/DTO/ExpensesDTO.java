package com.example.ExpenseManagement.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.example.ExpenseManagement.DTO.Response.UserResponse;
import com.example.ExpenseManagement.Entity.User;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExpensesDTO {
	int id;
	UserResponse user;
	Double amount;
	String category; 
	String description;
	LocalDate date;
	LocalDateTime createdAt;
}
