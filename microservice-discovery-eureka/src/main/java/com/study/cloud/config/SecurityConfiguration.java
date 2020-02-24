package com.study.cloud.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 新版本的springcloud在安全认证中添加了csrf过滤，这会影响到服务的注册，可能会导致服务的注册信息也会被过滤掉，所以需要新建一个配置类将其关闭
 * 
 * @author chenkaiwang
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	private static Logger logger = LoggerFactory.getLogger(SecurityConfiguration.class);

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		logger.info("设置csrf校验关闭");
		super.configure(http);
		http.csrf().disable();
	}
	
}
