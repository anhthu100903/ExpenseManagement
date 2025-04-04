package com.example.ExpenseManagement.DTO.Request;


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
	boolean role;
}
