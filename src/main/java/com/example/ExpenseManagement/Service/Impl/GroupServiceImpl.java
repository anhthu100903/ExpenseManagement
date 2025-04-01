package com.example.ExpenseManagement.Service.Impl;

import org.hibernate.Hibernate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.ExpenseManagement.DTO.Response.GroupResponse;
import com.example.ExpenseManagement.Entity.Group;
import com.example.ExpenseManagement.Mapper.GroupMapper;
import com.example.ExpenseManagement.Repository.GroupRepository;
import com.example.ExpenseManagement.Service.GroupService;

import jakarta.transaction.Transactional;
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
	@Transactional
	public GroupResponse getGroupById(int id) {
		Group group = groupRepository.findById(id).orElseThrow(() ->
        new ResponseStatusException(HttpStatus.NOT_FOUND, "group not found"));
		
		// Đảm bảo rằng các mối quan hệ được tải trước khi ánh xạ
	    Hibernate.initialize(group.getGroupMember());  // Tải groupMember

	    // Ánh xạ từ entity sang DTO
	    return groupMapper.toGroupDTO(group);
	}
	

}
