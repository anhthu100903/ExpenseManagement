package com.example.ExpenseManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ExpenseManagement.Entity.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {

}
