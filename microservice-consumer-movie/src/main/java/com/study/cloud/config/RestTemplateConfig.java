package com.study.cloud.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @description RestTemplate配置模板
 * @author KWCHEN
 * @version v1.0
 * @date 2019年6月6日
 */
@Configuration
public class RestTemplateConfig {
	@Value("${restTemplate.readTimeout}")
	Integer readTimeout = 5000;
	@Value("${restTemplate.connectTimeout}")
	Integer connectTimeout = 5000;

	@Bean
	public RestTemplate restTemplate() {
		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
		requestFactory.setConnectTimeout(connectTimeout);
		requestFactory.setReadTimeout(readTimeout);
		return new RestTemplate(requestFactory);
	}
}
