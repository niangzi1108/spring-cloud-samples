package com.iphotowalking.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@RefreshScope
public class ConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
        System.out.println("【ConfigClient】已启动");
    }

    @Value("${app.name}")
    String appName;

    @Value("${app.version}")
    String appVersion;

    @Value("${jdbc.driver}")
    String jdbcDriver;

    @RequestMapping(value = "/hi")
    public String hi(){
        return "appName:" + appName +";appVersion:"+ appVersion + "; jdbcDriver:" + jdbcDriver;
    }

}