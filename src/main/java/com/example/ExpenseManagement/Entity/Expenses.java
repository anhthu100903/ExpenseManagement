package com.example.ExpenseManagement.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Table(name = "expenses")
public class Expenses {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;
	
	@Column(nullable = false)
    Double amount;

    @Column
    String category; // Ví dụ: Ăn uống, Giải trí, Đi lại

    @Column
    String description;  // Chi tiết về khoản chi tiêu

    @Column
    LocalDate date;  // Ngày chi tiêu

    @Column(nullable = false)
    LocalDateTime createdAt; // Cột để lưu thời gian tạo
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
