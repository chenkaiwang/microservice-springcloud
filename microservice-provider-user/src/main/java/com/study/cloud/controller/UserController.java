package com.study.cloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.study.cloud.entity.User;
import com.study.cloud.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private EurekaClient eurekaClient;

	@Autowired
	private Registration registration; // 服务注册

	@Autowired
	private DiscoveryClient discoveryClient; // 服务发现客户端

	@GetMapping("/findUser/{id}")
	public User findUser(@PathVariable Long id) {
		return userService.findUser(id);
	}

	@GetMapping("/eureka-instance")
	public String serviceUrl() {
		InstanceInfo instanceInfo = this.eurekaClient.getNextServerFromEureka("microservice-provider-user", false);
		return instanceInfo.getHomePageUrl();
	}

	@GetMapping("/instance-info")
	public ServiceInstance showInfo() {
		List<ServiceInstance> instances = this.discoveryClient.getInstances(registration.getServiceId());
		for (ServiceInstance serviceInstance : instances) {
			if (serviceInstance.getPort() == 7900) {
				return serviceInstance;
			}
		}
		return null;
	}
}
