package com.iphotowalking.feign.web;

import com.iphotowalking.feign.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author jianglz
 * @since 2018/2/28.
 */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

//    @RequestMapping(value = "hi",method = RequestMethod.GET)
    @GetMapping("hi")
    public String sayHi(@RequestParam String name){
         return helloService.sayHiFromClinetOne(name);
    }
}
