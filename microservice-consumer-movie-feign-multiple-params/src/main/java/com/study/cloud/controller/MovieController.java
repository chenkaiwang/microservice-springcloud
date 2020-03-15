package com.study.cloud.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.cloud.entity.User;

@RestController
public class MovieController {

	@Autowired
	private UserFeignClient userFeignClient;

	@GetMapping("/user/{id}")
	public User findById(@PathVariable Long id) {
		User user = new User();
		user.setId(id);
		return this.userFeignClient.get0(user);
	}

	@GetMapping("/user/{id}/{username}")
	public User findByIdAndUserName(@PathVariable Long id, @PathVariable String username) {
		return this.userFeignClient.get1(id, username);
	}

	@GetMapping("/findByMap")
	public User findByMap(@RequestParam Map<String, Object> map) {
		return this.userFeignClient.get2(map);
	}

	@PostMapping("/post")
	public User post(@RequestBody User user) {
		return this.userFeignClient.post(user);
	}
}
