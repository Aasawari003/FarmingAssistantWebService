package com.farming.controller;
import java.util.HashMap;
import java.util.Map;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.farming.models.User;
import com.farming.repository.UserRepository;
import com.farming.service.UserService;

import jakarta.servlet.http.HttpServletResponse;
//import com.farming.service.UserService;
@RestController
public class UserController {
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserService userService;
	    public UserController(UserService userService) {
        this.userService = userService;
    } 
//	    registration form
	    @GetMapping("/register")
	    public String getRegisterPage() {
	        // Logic to return the registration page HTML
	       return "register"; // Assuming "register.html" is the name of your HTML file
	    }
	 // Endpoint to handle user registration
	    @RequestMapping(value = "/register", method = RequestMethod.POST,
	            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
	            produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Object> registerUser(@ModelAttribute User user) {
	        // Check if the user with this email already exists
	        if (userService.isUserWithEmailExists(user.getEmail())) {
	            return ResponseEntity.ok().build(); // Return empty response for existing user
	        }
	        // Register the user
	        userService.registerUser(user);
	        // Return success message
	        return ResponseEntity.ok().body("User register successfully");
	    }
	    
//	    login form
	    @GetMapping("/login")
	    public String getLoginPage() {
	        // Logic to return the login page HTML
	       return "login"; // Assuming "login.html" is the name of your HTML file
	    }
	 // Endpoint to handle user login
	    @RequestMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, 
	    		produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Object> loginUser(@RequestBody User userData) {
	        // Extract email and password from user data
	        String email = userData.getEmail();
	        String password = userData.getPassword();
	        String userRole = userService.getUserRole(email, password);
	        if (userRole != null) {
	            // Perform redirection based on the user's role
	            if (userRole.equals("customer")) {
	                return ResponseEntity.ok().body("/dashboard-customer.html");
	            } else
	            {
	                return ResponseEntity.ok().body("/dashboard-farmer.html");
	            }
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
	        }
	    }
}
