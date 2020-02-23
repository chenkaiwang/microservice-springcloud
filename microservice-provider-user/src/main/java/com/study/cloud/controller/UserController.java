package com.study.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.study.cloud.entity.User;
import com.study.cloud.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	

	@GetMapping("/findUser/{id}")
	public User findUser(@PathVariable Long id) {
		return userService.findUser(id);
	}
}
