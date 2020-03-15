package com.study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

/**
 * 该类为Ribbon的配置类
 * 注意：该类不应该在主应用程序上下文的@ComponentScan所扫描的包中
 * @author chenkaiwang
 *
 */
@Configuration
public class RibbonConfiguretion {
	@Bean
	public IRule ribbonRule() {
		// 负载均衡规则改为随机
		return new RandomRule();
	}
}