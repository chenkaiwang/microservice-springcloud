package com.study.cloud.config;

import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * 为指定Feign客户端禁用Hystrix：借助Feign的自定义配置，可轻松为指定名称的Feign客户端禁用Hystrix
 * 想要禁用Hystrix的@FeignClient，引用该配置类即可
 */
@Configuration
public class FeignDisableHystrixConfiguration {
    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder() {
        return Feign.builder();
    }
}
