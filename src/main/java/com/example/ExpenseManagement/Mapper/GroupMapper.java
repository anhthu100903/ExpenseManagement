package com.example.ExpenseManagement.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.ExpenseManagement.DTO.GroupMemberDTO;
import com.example.ExpenseManagement.DTO.Response.GroupResponse;
import com.example.ExpenseManagement.DTO.Response.UserResponse;
import com.example.ExpenseManagement.Entity.Group;
import com.example.ExpenseManagement.Entity.GroupMember;
import com.example.ExpenseManagement.Entity.User;

@Mapper(componentModel = "spring")
public interface GroupMapper {
	 // Ánh xạ từ Group entity sang GroupDTO
    @Mapping(source = "groupMember", target = "groupMember")  // Ánh xạ groupMember
    @Mapping(source = "createdBy", target = "createdBy")  // Ánh xạ createdBy
    GroupResponse toGroupDTO(Group group);

    // Ánh xạ từ GroupDTO sang Group entity
    @Mapping(source = "groupMember", target = "groupMember")  // Ánh xạ groupMember
    @Mapping(source = "createdBy", target = "createdBy")  // Ánh xạ createdBy
    Group toGroupEntity(GroupResponse groupResponse);

    // Ánh xạ User sang UserResponse (giả sử bạn đã có một mapper UserMapper)
    UserResponse toUserResponse(User user);

    // Ánh xạ GroupMember sang GroupMemberDTO (giả sử bạn đã có một mapper GroupMemberMapper)
    GroupMemberDTO toGroupMemberDTO(GroupMember groupMember);
}
