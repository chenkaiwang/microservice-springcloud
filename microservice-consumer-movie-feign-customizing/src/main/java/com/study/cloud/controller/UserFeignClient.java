package com.study.cloud.controller;

import org.springframework.cloud.openfeign.FeignClient;

import com.study.cloud.config.FeignConfiguration;
import com.study.cloud.config.FooConfiguration;
import com.study.cloud.entity.User;

import feign.Param;
import feign.RequestLine;

/**
 * 使用@FeignClient的configuration属性，指定feign的配置类
 * 
 * @author chenkaiwang
 *
 */
@FeignClient(name = "microservice-provider-user", configuration = { FeignConfiguration.class, FooConfiguration.class })
public interface UserFeignClient {

	/**
	 * 使用feign自带的注解@RequestLine
	 * 
	 * @param id
	 * @return
	 */
	@RequestLine("GET /user/{id}")
	public User findById(@Param("id") Long id);

}
