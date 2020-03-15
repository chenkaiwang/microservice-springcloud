package com.study.cloud.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.cloud.entity.User;

@RestController
public class UserController {

	@GetMapping(value = "/get0")
	public User get0(User user) {
		return user;
	}

	@RequestMapping(value = "/get1", method = RequestMethod.GET)
	public User get1(@RequestParam("id") Long id, @RequestParam("username") String username) {
		User user = new User();
		user.setId(id);
		user.setUsername(username);
		return user;
	}

	@RequestMapping(value = "/get2", method = RequestMethod.GET)
	public User get2(@RequestParam Map<String, Object> map) {
		User user = new User();
		user.setId(Long.parseLong(map.get("id").toString()));
		user.setUsername((String) map.get("username"));
		return user;
	}

	@PostMapping("/post")
	public User post(@RequestBody User user) {
		return user;
	}

}
