package com.example.ExpenseManagement.Entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "groups")
public class Group {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(unique = true, nullable = false)
	String name;
	
	@Column(nullable = false, columnDefinition = "boolean default true")
	boolean active; //trạng thái hoạt động của group
	
	@OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference  // Ánh xạ phía "cha", giúp tránh vòng lặp
	List<GroupMember> groupMember = new ArrayList<>();
	
	@ManyToOne
    @JoinColumn(name = "created_by", nullable = false)
    User createdBy;
}

