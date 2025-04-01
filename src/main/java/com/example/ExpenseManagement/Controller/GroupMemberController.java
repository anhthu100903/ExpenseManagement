package com.example.ExpenseManagement.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ExpenseManagement.DTO.Request.GroupMemberRequest;
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
	
	@PostMapping
	public ResponseEntity<GroupMemberResponse> createGroupMemmber(@RequestBody GroupMemberRequest groupMemberRequest) {
		return ResponseEntity.ok(groupMemberService.createGroupMember(groupMemberRequest));
	}
	
	@PutMapping("/{id}/active")
    public ResponseEntity<GroupMemberResponse>  updateActive(
            @PathVariable int id,  // Lấy ID từ đường dẫn URL
            @RequestParam boolean active) {  // Lấy giá trị 'active' từ tham số truy vấn (query parameter)
        
        return ResponseEntity.ok(groupMemberService.updateActive(id, active));  // Gọi phương thức service để cập nhật
    }
}
