package com.study.cloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.study.cloud.entity.User;

@RestController
public class MovieController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private DiscoveryClient discoveryClient;

	@GetMapping("/user/{id}")
	public User findById(@PathVariable Long id) {
		return this.restTemplate.getForObject("" + id, User.class);
	}

	@GetMapping("/user-instance")
	public List<ServiceInstance> showInfo() {
		return discoveryClient.getInstances("microservice-provider-user-my-metadata");
	}
}
