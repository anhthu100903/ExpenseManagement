package com.example.ExpenseManagement.DTO.Response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GroupResponse {
	int id;
	String name;
	boolean active;
//	Set<GroupMemberDTO> groupMember;
	UserResponse createdBy;
}
