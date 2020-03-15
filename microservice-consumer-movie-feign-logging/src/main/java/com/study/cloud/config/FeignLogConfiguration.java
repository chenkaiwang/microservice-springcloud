package com.study.cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;
import feign.Logger.Level;

@Configuration
public class FeignLogConfiguration {
	@Bean
	Logger.Level feignLoggerLevel() {
		return Level.FULL;
	}
}
