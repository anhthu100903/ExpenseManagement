package com.example.ExpenseManagement.DTO.Request;

import com.example.ExpenseManagement.DTO.GroupMemberDTO;
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
public class GroupMemberRequest {
	int id;
	int userId;
	int groupId;
	String role;
}
