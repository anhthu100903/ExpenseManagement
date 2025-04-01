package com.example.ExpenseManagement.Service;

import java.util.List;

import com.example.ExpenseManagement.DTO.Response.GroupResponse;

public interface GroupService {
	public GroupResponse getGroupById(int id);
	public GroupResponse getGroupByCreatedById(int userID);
	public List<GroupResponse> getGroupByUserId(int userID);
}
