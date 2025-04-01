package com.example.ExpenseManagement.Service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.ExpenseManagement.DTO.ExpensesDTO;
import com.example.ExpenseManagement.Entity.Expenses;
import com.example.ExpenseManagement.Entity.User;
import com.example.ExpenseManagement.Mapper.ExpensesMapper;
import com.example.ExpenseManagement.Repository.ExpensesRepository;
import com.example.ExpenseManagement.Repository.UserRepository;
import com.example.ExpenseManagement.Service.ExpensesService;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ExpensesServiceImpl implements ExpensesService{
	
	ExpensesRepository expensesRepository;
	UserRepository userRepository;
	ExpensesMapper expensesMapper;

	@Override
	public ExpensesDTO getExpensesById(int id) {
		return expensesMapper.toExpensesDTO(expensesRepository.findById(id).orElseThrow(()
				-> new ResponseStatusException(HttpStatus.NOT_FOUND, "expenses not found"))
				);
	}
	
	
	
	// Thêm chi tiêu mới
    @Override
    public ExpensesDTO addExpense(ExpensesDTO expensesDTO) {
    	User user = userRepository.findById(expensesDTO.getUser().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));
    	
        Expenses expenses = expensesMapper.toExpenses(expensesDTO);  // Chuyển đổi DTO thành entity
        
        // Liên kết người dùng với chi tiêu
        expenses.setUser(user);
        
        // Lưu chi tiêu vào cơ sở dữ liệu
        Expenses savedExpense = expensesRepository.save(expenses);  // Lưu vào cơ sở dữ liệu
        
        // Trả về chi tiêu mới dưới dạng ExpensesDTO
        return expensesMapper.toExpensesDTO(savedExpense);  // Trả về chi tiêu vừa được thêm dưới dạng DTO
    }



	@Override
	public List<ExpensesDTO> getAllExpensesByUserId(int userId) {
		// Lấy tất cả chi tiêu của người dùng theo userId từ cơ sở dữ liệu
        List<Expenses> expensesList = expensesRepository.findByUserId(userId);
        
        // Chuyển đổi danh sách chi tiêu từ Entity thành DTO
        return expensesList.stream()
                .map(expensesMapper::toExpensesDTO)
                .collect(Collectors.toList());
	}

}
