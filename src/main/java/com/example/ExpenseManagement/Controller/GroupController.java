package com.example.ExpenseManagement.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ExpenseManagement.DTO.Request.GroupRequest;
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
	
	@GetMapping("/createdBy/{userId}")
	public ResponseEntity<GroupResponse> getGroupByCreatedById(@PathVariable Integer userId) {
		return ResponseEntity.ok(groupService.getGroupByCreatedById(userId));
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<GroupResponse>> getGroupByUserId(@PathVariable Integer userId) {
		return ResponseEntity.ok(groupService.getGroupByUserId(userId));
	}
	

	@PostMapping("/add")
    public ResponseEntity<GroupResponse> createGroup(@RequestBody GroupRequest groupRequest) {
        // Gọi service để thêm nhóm
        GroupResponse createGroup = groupService.createGroup(groupRequest);
        return new ResponseEntity<>(createGroup, HttpStatus.CREATED);
    }

}
