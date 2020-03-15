package com.study.cloud.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.study.cloud.config.FeignLogConfiguration;
import com.study.cloud.entity.User;

@FeignClient(name = "microservice-provider-user",configuration = FeignLogConfiguration.class)
public interface UserFeignClient {
	
	/**
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/user/{id}")
	public User findById(@PathVariable Long id);

}
