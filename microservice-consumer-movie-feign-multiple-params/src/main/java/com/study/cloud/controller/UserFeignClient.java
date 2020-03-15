package com.study.cloud.controller;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.cloud.entity.User;

@FeignClient(name = "microservice-provider-user")
public interface UserFeignClient {

	/**
	 * 报405错误，尽管指定了GET方法，Feign依然会使用POST方法发送请求
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/get0", method = RequestMethod.GET)
	public User get0(User user);

	/**
	 * 方法1：URL有几个参数，Feign接口中的方法就有几个参数
	 * 
	 * @param id
	 * @param username
	 * @return
	 */
	@RequestMapping(value = "/get1", method = RequestMethod.GET)
	public User get1(@RequestParam("id") Long id, @RequestParam("username") String username);

	/**
	 * 方法2：多参数的URL可使用Map来构建，参数非常多时，可使用这种方式简化Feign接口的编写
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/get2", method = RequestMethod.GET)
	public User get2(@RequestParam Map<String, Object> map);

	/**
	 * 使用POST请求
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping("/post")
	public User post(@RequestBody User user);
}
