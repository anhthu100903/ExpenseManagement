package com.example.ExpenseManagement.Service.Impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.ExpenseManagement.DTO.Request.GroupMemberRequest;
import com.example.ExpenseManagement.DTO.Response.GroupMemberResponse;
import com.example.ExpenseManagement.Entity.Group;
import com.example.ExpenseManagement.Entity.GroupMember;
import com.example.ExpenseManagement.Entity.User;
import com.example.ExpenseManagement.Mapper.GroupMemberRequestMapper;
import com.example.ExpenseManagement.Mapper.GroupMemberResponseMapper;
import com.example.ExpenseManagement.Repository.GroupMemberRepository;
import com.example.ExpenseManagement.Repository.GroupRepository;
import com.example.ExpenseManagement.Repository.UserRepository;
import com.example.ExpenseManagement.Service.GroupMemberService;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GroupMemberServiceImpl implements GroupMemberService{
	
	GroupMemberRepository groupMemberRepository;
	UserRepository userRepository;
	GroupRepository groupRepository;
	GroupMemberResponseMapper groupMemberResponseMapper;
	GroupMemberRequestMapper groupMemberRequestMapper;

	@Override
	public GroupMemberResponse getGroupMemberById(int id) {
		return groupMemberResponseMapper.toGroupMemberResponse(groupMemberRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "group member not found")));
	}

	@Override
	public GroupMemberResponse createGroupMember(GroupMemberRequest groupMemberRequest) {
		// Lấy thông tin người dùng theo ID
		User user = userRepository.findById(groupMemberRequest.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
    	
    	// Lấy thông tin nhóm theo ID
    	Group group = groupRepository.findById(groupMemberRequest.getGroupId()).orElseThrow(()
    			-> new RuntimeException("Group not found"));
    	
    	// Chuyển đổi GroupMemberRequest thành GroupMember entity
    	GroupMember groupMember = groupMemberRequestMapper.toGroupMember(groupMemberRequest);
    	
    	// Gán nhóm và người dùng cho GroupMember
    	groupMember.setGroup(group);
    	groupMember.setUser(user);
    	
    	// Lưu GroupMember
        GroupMember savedGroupMember = groupMemberRepository.save(groupMember);
    	
		return groupMemberResponseMapper.toGroupMemberResponse(savedGroupMember);
	}

	@Override
	public GroupMemberResponse updateActive(int id, boolean active) {
		GroupMember groupMember = groupMemberRepository.findById(id).orElseThrow(()
				-> new ResponseStatusException(HttpStatus.NOT_FOUND, "group member not found"));
		
		groupMember.setActive(active);
		return groupMemberResponseMapper.toGroupMemberResponse(groupMember);
	}

}
