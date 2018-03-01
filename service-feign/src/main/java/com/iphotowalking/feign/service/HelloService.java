package com.iphotowalking.feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author jianglz
 * @since 2018/2/28.
 */
@FeignClient(value = "service-a",fallback = HelloServiceHystrixFallback.class)
//@FeignClient("service-a")
public interface HelloService {

//    @RequestMapping(value = "hi",method = RequestMethod.GET)
    @GetMapping("hi")
    String sayHiFromClinetOne(@RequestParam("name") String name);
}
