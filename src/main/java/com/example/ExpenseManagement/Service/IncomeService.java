package com.example.ExpenseManagement.Service;

import java.util.List;

import com.example.ExpenseManagement.DTO.IncomeDTO;

public interface IncomeService {
	public IncomeDTO getIncomeById(int id);
	public List<IncomeDTO> getIncomeByUserId(int userID);
	public IncomeDTO createIncome(IncomeDTO incomeDTO);
}
