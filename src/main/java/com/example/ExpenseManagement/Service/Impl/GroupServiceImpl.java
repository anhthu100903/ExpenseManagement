package com.example.ExpenseManagement.Service.Impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.ExpenseManagement.DTO.Response.GroupResponse;
import com.example.ExpenseManagement.Mapper.GroupMapper;
import com.example.ExpenseManagement.Repository.GroupRepository;
import com.example.ExpenseManagement.Service.GroupService;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GroupServiceImpl implements GroupService{
	
	GroupRepository groupRepository;
	GroupMapper groupMapper;

	@Override
	public GroupResponse getGroupById(int id) {
		return groupMapper.toGroupDTO(groupRepository.findById(id).orElseThrow(()
				-> new ResponseStatusException(HttpStatus.NOT_FOUND, "group not found")));
	}
	

}
