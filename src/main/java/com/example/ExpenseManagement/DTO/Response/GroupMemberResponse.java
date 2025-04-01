package com.example.ExpenseManagement.DTO.Response;

import com.example.ExpenseManagement.DTO.GroupMemberDTO;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GroupMemberResponse {
	int id;
	UserResponse user;
	GroupResponse group;
	String role;
}
