package com.farming.service;
//
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//
import com.farming.models.User;
//
import com.farming.repository.UserRepository;

@Service
public interface UserService {
	public User registerUser(User user);
//	for login
boolean isUserWithEmailExists(String email);
User getUserByEmailAndPassword(String email, String password);
String getUserRole(String email, String password);
}