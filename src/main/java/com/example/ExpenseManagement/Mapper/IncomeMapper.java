package com.example.ExpenseManagement.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.ExpenseManagement.DTO.IncomeDTO;
import com.example.ExpenseManagement.Entity.Income;

@Mapper(componentModel = "spring")
public interface IncomeMapper {
	//Chuyển từ entity sang dto
	@Mapping(source = "user.id", target = "userId") // Chuyển user.id sang userId trong DTO
	IncomeDTO toIncomeDTO(Income income);
	
	//Chuyển từ dto sang entiy
	@Mapping(source = "userId", target = "user.id") // Chuyển userId sang user.id
	Income toIncome(IncomeDTO incomeDTO);
}
