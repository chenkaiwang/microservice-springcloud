package com.study.cloud.controller;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.study.cloud.entity.User;
import com.study.cloud.repository.UserRepository;

@RestController
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/user/{id}")
	public User findById(@PathVariable Long id) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			UserDetails userDetails = (UserDetails) principal;
			Collection<? extends GrantedAuthority> collection = userDetails.getAuthorities();
			for (GrantedAuthority c : collection) {
				LOGGER.info("当前用户是{}，角色是{}", userDetails.getUsername(), c.getAuthority());
			}
		}else {
			
		}
		
		return userRepository.findById(id).get();
	}

}
