package com.farming.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farming.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByEmail(String email);
//	for login

	Optional<User> findByEmailAndPassword(String email, String password);	
}