package com.example.ExpenseManagement.Repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ExpenseManagement.Entity.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {
	
	//Truy vấn lấy các group người dùng tạo
	@Query("SELECT g FROM Group g WHERE g.createdBy.id = :userID")
    Group findByCreatedBy_Id(int userID);
	
	// Truy vấn lấy Group của người dùng với user id
	@Query("SELECT g FROM Group g " +
	           "JOIN GroupMember gm ON gm.group.id = g.id " +
	           "WHERE gm.user.id = :userID")
	List<Group> findByGroupMember_User_Id(int userID);
    
}
