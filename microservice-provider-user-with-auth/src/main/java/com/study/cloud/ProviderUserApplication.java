package com.study.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 在SpringCloud Edgware之前，要想将微服务注册到Eureka
 * Server或者其他发现组件上，必须在启动类上添加@EnableEurekaClient或@EnableDiscoveryClient。
 * 在SpringCloud Edgware以及更高版本中，只需要添加相关依赖，即可自动注册。
 * 
 * @author chenkaiwang
 *
 */
@SpringBootApplication
public class ProviderUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProviderUserApplication.class, args);
	}

}
