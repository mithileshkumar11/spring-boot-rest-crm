package com.crm.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
	Optional<User> findByEmail(String email);
}
