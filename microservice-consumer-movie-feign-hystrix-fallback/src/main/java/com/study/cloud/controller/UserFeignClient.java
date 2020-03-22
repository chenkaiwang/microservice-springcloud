package com.study.cloud.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.study.cloud.entity.User;

/**
 * feign的fallback支持
 * 使用@FeignClient的fallback属性指定回退类
 */
@FeignClient(name = "microservice-provider-user", fallback = FeignClientFallBack.class)
public interface UserFeignClient {

    /**
     * TODO 1、GetMapping方法可以支持；2、PathVariable可以不用设置Value
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/user/{id}")
    public User findById(@PathVariable Long id);
}

@Component
class FeignClientFallBack implements UserFeignClient {
    @Override
    public User findById(Long id) {
        User user = new User();
        user.setId(-1L);
        user.setName("默认用户");
        return user;
    }
}
