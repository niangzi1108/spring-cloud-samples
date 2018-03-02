package com.iphotowalking.business;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.iphotowalking.business.mybatis.mapper")
public class ServiceAApplication {
    private static final Logger logger = LoggerFactory.getLogger(ServiceAApplication.class);
    
	public static void main(String[] args) {
		SpringApplication.run(ServiceAApplication.class, args);
        logger.info("【服务A】已启动");
    }
}
