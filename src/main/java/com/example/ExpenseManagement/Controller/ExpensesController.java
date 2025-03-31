package com.example.ExpenseManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ExpenseManagement.DTO.ExpensesDTO;
import com.example.ExpenseManagement.Service.ExpensesService;


@RestController
@RequestMapping("expenses")
public class ExpensesController {
	private final ExpensesService expensesService;
	
	@Autowired
    public ExpensesController(ExpensesService expensesService) {
		this.expensesService = expensesService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ExpensesDTO> getExpensesById(@PathVariable Integer id) {
		 // Lấy chi tiêu theo ID và trả về DTO
        ExpensesDTO expensesDTO = expensesService.getExpensesById(id);
        return ResponseEntity.ok(expensesDTO);
	}
	
	// API để lấy tất cả chi tiêu của người dùng theo userId
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ExpensesDTO>> getAllExpensesByUserId(@PathVariable int userId) {
        // Gọi service để lấy tất cả chi tiêu của người dùng
        List<ExpensesDTO> expenses = expensesService.getAllExpensesByUserId(userId);
        
        // Trả về danh sách chi tiêu của người dùng dưới dạng DTO
        return ResponseEntity.ok(expenses);
    }
	
	@PostMapping("/add")
    public ResponseEntity<ExpensesDTO> addExpense(@RequestBody ExpensesDTO expensesDTO) {
        // Gọi service để thêm chi tiêu
        ExpensesDTO createdExpense = expensesService.addExpense(expensesDTO);
        return new ResponseEntity<>(createdExpense, HttpStatus.CREATED);
    }
}
