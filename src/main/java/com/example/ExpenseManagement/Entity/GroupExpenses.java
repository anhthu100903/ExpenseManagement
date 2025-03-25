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
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Table(name = "group_expenses")
public class GroupExpenses {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;
	
	@ManyToOne
    @JoinColumn(name = "paid_by", nullable = false)
    private User paidBy;  // Người đã thanh toán

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private String category; // Ví dụ: Ăn uống, Giải trí, Đi lại

    @Column
    private String description;  // Chi tiết về chi tiêu

    @Column
    private LocalDate date;  // Ngày chi tiêu

    @Column(nullable = false)
    private LocalDateTime createdAt; // Cột để lưu thời gian tạo
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
