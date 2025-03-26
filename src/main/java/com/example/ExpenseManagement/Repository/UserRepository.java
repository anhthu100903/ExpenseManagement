package com.example.ExpenseManagement.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ExpenseManagement.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	boolean existsByUsername(String userName);

    boolean existsByEmail(String email);

    Optional<User> findByUsername(String username);
}
