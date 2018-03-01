package com.iphotowalking.feign.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author jianglz
 * @since 2018/2/28.
 */
@Component
public class HelloServiceHystrixFallback implements HelloService{
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public String sayHiFromClinetOne(String name) {
        logger.error("发生了异常，参数：name={}",name);
        return "sorry, "+name + ", error";
    }
}
