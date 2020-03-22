package com.study.cloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableHystrixDashboard
public class DashboardApplication {

    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registration = new ServletRegistrationBean(streamServlet);
        registration.setLoadOnStartup(1);//系统启动时加载顺序
        registration.addUrlMappings("/hystrix.stream");
        registration.setName("HystrixMetricsStreamServlet");
        return registration;
    }

    public static void main(String[] args) {
        SpringApplication.run(DashboardApplication.class, args);
    }

}
