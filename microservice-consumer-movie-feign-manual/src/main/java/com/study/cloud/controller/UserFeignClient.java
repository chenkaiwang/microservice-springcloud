package com.study.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.study.cloud.entity.User;

public interface UserFeignClient {
	
	/**
	 * TODO 1、GetMapping方法可以支持；2、PathVariable可以不用设置Value
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/user/{id}")
	public User findById(@PathVariable Long id);

}
