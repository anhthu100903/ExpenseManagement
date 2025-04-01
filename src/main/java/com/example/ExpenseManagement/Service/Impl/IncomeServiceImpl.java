package com.example.ExpenseManagement.Service.Impl;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.ExpenseManagement.DTO.IncomeDTO;
import com.example.ExpenseManagement.Entity.Income;
import com.example.ExpenseManagement.Entity.User;
import com.example.ExpenseManagement.Mapper.IncomeMapper;
import com.example.ExpenseManagement.Repository.IncomeRepository;
import com.example.ExpenseManagement.Repository.UserRepository;
import com.example.ExpenseManagement.Service.IncomeService;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class IncomeServiceImpl implements IncomeService{

	IncomeRepository incomeRepository;
	UserRepository userRepository;
	IncomeMapper incomeMapper;
	
	@Override
	public IncomeDTO getIncomeById(int id) {
		return incomeMapper.toIncomeDTO(incomeRepository.findById(id).orElseThrow(()
				-> new ResponseStatusException(HttpStatus.NOT_FOUND, "income not found"))
				);
	}

	@Override
	public List<IncomeDTO> getIncomeByUserId(int userID) {
		// Lấy tất cả chi tiêu của người dùng theo userId từ cơ sở dữ liệu
        List<Income> incomeList = incomeRepository.findByUserId(userID);
        
        // Chuyển đổi danh sách chi tiêu từ Entity thành DTO
        return incomeList.stream()
                .map(incomeMapper::toIncomeDTO)
                .collect(Collectors.toList());
	}

	@Override
	public IncomeDTO createIncome(IncomeDTO incomeDTO) {
		//kiểm tra xem thông tin user đã đúng chưa
    	User user = userRepository.findById(incomeDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
		
    	//Chuyển đổi dto sang entity
		Income income = incomeMapper.toIncome(incomeDTO);
		
		//set user cho incom
		income.setUser(user);
		
		//Lưu income vào db
		return incomeMapper.toIncomeDTO(incomeRepository.save(income));
	}

}
