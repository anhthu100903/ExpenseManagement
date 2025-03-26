package com.example.ExpenseManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ExpenseManagement.Entity.Expenses;

@Repository
public interface ExpensesRepository extends JpaRepository<Expenses, Integer>{

}
