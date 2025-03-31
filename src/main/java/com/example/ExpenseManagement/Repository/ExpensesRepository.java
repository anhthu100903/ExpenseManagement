package com.example.ExpenseManagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ExpenseManagement.Entity.Expenses;

@Repository
public interface ExpensesRepository extends JpaRepository<Expenses, Integer>{
	// Tìm tất cả chi tiêu của người dùng theo userId
    List<Expenses> findByUserId(int userId);
}
