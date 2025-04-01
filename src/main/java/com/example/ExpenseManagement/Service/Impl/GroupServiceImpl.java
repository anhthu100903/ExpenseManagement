package com.example.ExpenseManagement.Service.Impl;

import java.util.List;
import java.util.stream.Collectors;

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
	
	@Transactional
    public GroupResponse getGroupByCreatedById(int userID) {
        // Truy vấn Group theo userID (dựa vào mối quan hệ createdBy)
        Group group = groupRepository.findByCreatedBy_Id(userID);
        if (group == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Group not found for user id " + userID);
        }
        return groupMapper.toGroupDTO(group);  // Ánh xạ từ entity Group sang DTO GroupResponse
    }
	
	@Transactional
    public List<GroupResponse> getGroupByUserId(int userID) {
        // Truy vấn ds Group theo userID (dựa vào mối quan hệ group member)
        List<Group> groups = groupRepository.findByGroupMember_User_Id(userID);
        
        // Nếu không tìm thấy nhóm, trả về lỗi 404
        if (groups.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No groups found for user id " + userID);
        }

        // Ánh xạ từ entity Group sang DTO GroupResponse
        return groups.stream()
                     .map(groupMapper::toGroupDTO)
                     .collect(Collectors.toList());
    }

}
