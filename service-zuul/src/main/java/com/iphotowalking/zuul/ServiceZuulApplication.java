package com.iphotowalking.zuul;

import com.iphotowalking.zuul.filter.DidiFilterProcessor;
import com.netflix.zuul.FilterProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ServiceZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceZuulApplication.class, args);
        FilterProcessor.setProcessor(new DidiFilterProcessor());  //启动自定义过滤器处理器
        System.out.println("【Zuul服务】已启动");
	}
}
