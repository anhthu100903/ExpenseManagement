package com.example.ExpenseManagement.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ExpenseManagement.DTO.Response.GroupResponse;
import com.example.ExpenseManagement.Service.GroupService;

@RestController
@RequestMapping("groups")
public class GroupController {
	private final GroupService groupService;
	
	public GroupController(GroupService groupService) {
		this.groupService = groupService;
	}
	
	@GetMapping("/{id}")
	public GroupResponse getGroupById(@PathVariable Integer id) {
		return groupService.getGroupById(id);
	}

}
