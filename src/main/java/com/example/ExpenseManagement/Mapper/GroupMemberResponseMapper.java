package com.example.ExpenseManagement.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.ExpenseManagement.DTO.Response.GroupMemberResponse;
import com.example.ExpenseManagement.DTO.Response.GroupResponse;
import com.example.ExpenseManagement.DTO.Response.UserResponse;
import com.example.ExpenseManagement.Entity.Group;
import com.example.ExpenseManagement.Entity.GroupMember;
import com.example.ExpenseManagement.Entity.User;

@Mapper(componentModel = "spring")
public interface GroupMemberResponseMapper {
	// Chuyển từ entity sang DTO
    @Mapping(source = "role", target = "role") // Map enum Role sang String
    GroupMemberResponse toGroupMemberResponse(GroupMember groupMember);

    // Chuyển từ DTO sang entity
    @Mapping(source = "role", target = "role") // Chuyển String về enum Role
    GroupMember toGroupMemberEntity(GroupMemberResponse groupMemberResponse);
    
    // Các ánh xạ phụ (nếu cần), ví dụ ánh xạ User và Group từ entity sang DTO
    UserResponse toUserResponse(User user);
    GroupResponse toGroupDTO(Group group);
}
