package com.example.ExpenseManagement.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ExpenseManagement.DTO.IncomeDTO;
import com.example.ExpenseManagement.Service.IncomeService;

@RestController
@RequestMapping("incomes")
public class IncomeController {
	public final IncomeService incomeService;
	
	public IncomeController(IncomeService incomeService) {
		this.incomeService = incomeService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<IncomeDTO> getIncomeById(@PathVariable Integer id) {
		return ResponseEntity.ok(incomeService.getIncomeById(id));
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<IncomeDTO>> getIncomeByUserId(@PathVariable Integer userId){
		return ResponseEntity.ok(incomeService.getIncomeByUserId(userId));
	}
	
	@PostMapping("/add")
	public ResponseEntity<IncomeDTO> createIncome(@RequestBody IncomeDTO incomeDto){
        IncomeDTO createdIncome = incomeService.createIncome(incomeDto);
        return new ResponseEntity<>(createdIncome, HttpStatus.CREATED);
	}
}
