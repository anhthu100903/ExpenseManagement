package com.example.ExpenseManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ExpenseManagement.Entity.Income;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Integer>{

}
