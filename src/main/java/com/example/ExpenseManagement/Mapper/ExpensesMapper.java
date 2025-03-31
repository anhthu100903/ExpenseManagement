package com.example.ExpenseManagement.Mapper;

import org.mapstruct.Mapper;

import com.example.ExpenseManagement.DTO.ExpensesDTO;
import com.example.ExpenseManagement.DTO.Response.UserResponse;
import com.example.ExpenseManagement.Entity.Expenses;
import com.example.ExpenseManagement.Entity.User;

@Mapper(componentModel = "spring")
public interface ExpensesMapper {
	 // Chuyển đổi từ Expenses entity thành ExpensesDTO
    ExpensesDTO toExpensesDTO(Expenses expenses);

    // Chuyển đổi từ ExpensesDTO thành Expenses entity
    Expenses toExpenses(ExpensesDTO expensesDTO);

    // Chuyển đổi từ User entity thành UserResponse DTO
    UserResponse toUserResponse(User user);
}
