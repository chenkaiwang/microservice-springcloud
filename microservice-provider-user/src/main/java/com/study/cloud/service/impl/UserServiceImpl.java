package com.study.cloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.cloud.entity.User;
import com.study.cloud.repository.UserRepository;
import com.study.cloud.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public User findUser(Long id) {
		return userRepository.getOne(id);
	}
}
