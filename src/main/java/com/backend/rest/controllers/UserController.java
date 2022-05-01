package com.backend.rest.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.rest.model.User;
import com.backend.rest.repository.UserRepository;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/")
	public String firstHi() {
		return "Welcome to Project 02 Backend";
	}

	@PostMapping("/user")
	public User signupUser(@RequestBody User user1) {
		return userRepository.save(user1);
	}
	
	@GetMapping("/user")
	public List<User> getUser(User user1) {
		return userRepository.findAll();
	}
	
	@GetMapping("/user/{email}")
	public List<User> getUserinfo(@PathVariable("email") String info) {
		return userRepository.findUserinfo(info);
	}
}
