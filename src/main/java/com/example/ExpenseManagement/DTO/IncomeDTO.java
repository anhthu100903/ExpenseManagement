package com.example.ExpenseManagement.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class IncomeDTO {
    int id;
    int userId;
    Double amount;
    String source;
    LocalDate date;
    LocalDateTime createdAt;
}
