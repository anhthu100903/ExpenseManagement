package com.example.ExpenseManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ExpenseManagement.Entity.GroupExpenses;

@Repository
public interface GroupExpensesRepository extends JpaRepository<GroupExpenses, Integer>{

}
