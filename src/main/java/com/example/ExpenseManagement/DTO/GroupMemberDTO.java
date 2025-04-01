package com.example.ExpenseManagement.DTO;

import com.example.ExpenseManagement.DTO.Response.GroupResponse;
import com.example.ExpenseManagement.DTO.Response.UserResponse;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GroupMemberDTO {
	int id;
	UserResponse user;
	GroupResponse group;
	String role;
}
