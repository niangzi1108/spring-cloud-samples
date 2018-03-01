package com.iphotowalking.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author jianglz
 * @since 2018/2/28.
 */
@Service
public class HelloService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name){
        return restTemplate.getForObject("http://service-a/hi?name="+name,String.class);
    }
    
    public String hiError(String name){
        logger.error("hiService发生了异常，参数：name={}",name);
      return "hi," + name + ",sorrry,error";
    }
}
