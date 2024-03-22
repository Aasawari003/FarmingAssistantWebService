package com.farming.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farming.models.User;
import com.farming.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	private final UserRepository userRepository;

    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(User user) {
        // Additional validation logic can be added here if needed
        return userRepository.save(user);
    }

    @Override
    public boolean isUserWithEmailExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
//    for login
    @Override
    public User getUserByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password).orElse(null);
    }

    @Override
    public String getUserRole(String email, String password) {
        User user = getUserByEmailAndPassword(email, password);
        if (user != null) {
            return user.getRole();
        } else {
            return null;
        }
    }
}
    
