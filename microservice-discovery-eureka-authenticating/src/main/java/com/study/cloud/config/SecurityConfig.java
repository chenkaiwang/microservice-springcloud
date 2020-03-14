package com.study.cloud.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 使用security.basic.enable=false 可以禁用Security默认认证，但是Spring Boot2.0以上版本集成Security
 * 配置security.basic.enable已经过时了。
 * 
 * @author chenkaiwang
 *
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 如果我们想禁用默认的表单登录可以通过代码方式解决:
		// http.authorizeRequests().antMatchers("/**").permitAll();

		// Security提供了两种默认的认证方式，formLogin是现在新版本默认的。
		// 如果我们想使用httpBasic认证，只要修改代码：
		// TODO 使用这种方式，为什么客户端无法注册到eureka
		// http.httpBasic().and().authorizeRequests().anyRequest().authenticated();
		http.csrf().disable();
		super.configure(http);
	}
}
