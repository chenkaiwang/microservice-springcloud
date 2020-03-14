package com.study.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

/**
 * 使用RibbonClient，为特定的Ribbon Client自定义配置。
 * 使用@RibbonClient的configuration属性，指定Ribbon的配置类
 * @author chenkaiwang
 *
 */
@Configuration
@RibbonClient(name = "microservice-provider-user", configuration = RibbonConfiguretion.class)
public class TestConfiguration {

}
