package com.study.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.study.cloud.User;

@RestController
public class UserController {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${user.userServicePath}")
	private String userServicePath;

	@GetMapping("/findUser/{id}")
	public User findUser(@PathVariable Long id) {
		return this.restTemplate.getForObject(this.userServicePath + id, User.class);
	}
}
