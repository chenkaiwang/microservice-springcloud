package com.study.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.study.cloud.entity.User;

@RestController
public class UserController {

	@Autowired
	private RestTemplate restTemplate;


	@GetMapping("/findUser/{id}")
	public User findUser(@PathVariable Long id) {
		return this.restTemplate.getForObject("http://microservice-provider-user/findUser/" + id, User.class);
	}
}
