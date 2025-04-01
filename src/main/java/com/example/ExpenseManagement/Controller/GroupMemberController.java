package com.example.ExpenseManagement.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ExpenseManagement.DTO.Response.GroupMemberResponse;
import com.example.ExpenseManagement.Service.GroupMemberService;

@RestController
@RequestMapping("group-members")
public class GroupMemberController {
	private final GroupMemberService groupMemberService;
	
	public GroupMemberController(GroupMemberService groupMemberService) {
		this.groupMemberService = groupMemberService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<GroupMemberResponse> getGroupMemberById(@PathVariable Integer id){
		return ResponseEntity.ok(groupMemberService.getGroupMemberById(id));
	}
}
