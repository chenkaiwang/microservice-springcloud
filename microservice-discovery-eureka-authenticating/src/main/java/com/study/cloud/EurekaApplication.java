package com.study.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {

	/**
	 * TODO 暂时没起作用
	 * 
	 * @return
	 */
//	@Bean
//	public DiscoveryClientOptionalArgs discoveryClientOptionalArgs() {
//		DiscoveryClientOptionalArgs discoveryClientOptionalArgs = new DiscoveryClientOptionalArgs();
//		List<ClientFilter> list = new ArrayList<>();
//		list.add(new HTTPBasicAuthFilter("user", "password123"));
//		discoveryClientOptionalArgs.setAdditionalFilters(list);
//		return discoveryClientOptionalArgs;
//	}

	public static void main(String[] args) {
		SpringApplication.run(EurekaApplication.class, args);
	}

}
