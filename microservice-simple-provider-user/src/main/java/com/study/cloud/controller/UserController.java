package com.study.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.cloud.entity.User;
import com.study.cloud.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/{id}")
	public User findById(@PathVariable Long id) {
		//User user = userRepository.getOne(id);
		User user = userRepository.findById(id).get();
		return user;
		
	}

}
