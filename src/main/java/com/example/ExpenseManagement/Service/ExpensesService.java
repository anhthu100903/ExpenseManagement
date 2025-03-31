package com.example.ExpenseManagement.Service;

import java.util.List;

import com.example.ExpenseManagement.DTO.ExpensesDTO;

public interface ExpensesService {
	public ExpensesDTO getExpensesById(int id);
	public ExpensesDTO addExpense(ExpensesDTO expensesDTO);
	public List<ExpensesDTO> getAllExpensesByUserId(int userId);
}
