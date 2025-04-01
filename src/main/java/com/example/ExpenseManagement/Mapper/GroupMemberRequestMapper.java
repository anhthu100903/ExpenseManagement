package com.example.ExpenseManagement.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.ExpenseManagement.DTO.Request.GroupMemberRequest;
import com.example.ExpenseManagement.Entity.GroupMember;

@Mapper(componentModel = "spring")
public interface GroupMemberRequestMapper {
	// Chuyển từ GroupMemberRequest sang GroupMember entity
    @Mapping(source = "userId", target = "user.id") // Ánh xạ userId vào user.id
    @Mapping(source = "groupId", target = "group.id") // Ánh xạ groupId vào group.id
    @Mapping(source = "role", target = "role") // Ánh xạ role vào Role enum
    GroupMember toGroupMember(GroupMemberRequest request);

    // Chuyển từ GroupMember entity sang GroupMemberRequest DTO
    @Mapping(source = "user.id", target = "userId") // Ánh xạ user.id vào userId
    @Mapping(source = "group.id", target = "groupId") // Ánh xạ group.id vào groupId
    @Mapping(source = "role", target = "role") // Ánh xạ role từ enum sang String
    GroupMemberRequest toGroupMemberRequest(GroupMember groupMember);
}
