package com.example.ExpenseManagement.Service;

import com.example.ExpenseManagement.DTO.Request.GroupMemberRequest;
import com.example.ExpenseManagement.DTO.Response.GroupMemberResponse;

public interface GroupMemberService {
	public GroupMemberResponse getGroupMemberById(int id);
	public GroupMemberResponse createGroupMember(GroupMemberRequest groupMemberRequest);
	public GroupMemberResponse updateActive(boolean active);
}
