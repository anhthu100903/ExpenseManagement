package com.example.ExpenseManagement.Service.Impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.ExpenseManagement.DTO.Request.GroupMemberRequest;
import com.example.ExpenseManagement.DTO.Response.GroupMemberResponse;
import com.example.ExpenseManagement.Mapper.GroupMemberResponseMapper;
import com.example.ExpenseManagement.Repository.GroupMemberRepository;
import com.example.ExpenseManagement.Service.GroupMemberService;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GroupMemberServiceImpl implements GroupMemberService{
	
	GroupMemberRepository groupMemberRepository;
	GroupMemberResponseMapper groupMemberResponseMapper;

	@Override
	public GroupMemberResponse getGroupMemberById(int id) {
		return groupMemberResponseMapper.toGroupMemberResponse(groupMemberRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "group member not found")));
	}

	@Override
	public GroupMemberResponse createGroupMember(GroupMemberRequest groupMemberRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GroupMemberResponse updateActive(boolean active) {
		// TODO Auto-generated method stub
		return null;
	}

}
