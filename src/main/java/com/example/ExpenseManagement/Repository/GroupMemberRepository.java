package com.example.ExpenseManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ExpenseManagement.Entity.GroupMember;

@Repository
public interface GroupMemberRepository extends JpaRepository<GroupMember, Integer>{

}
