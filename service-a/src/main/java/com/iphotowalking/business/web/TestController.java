package com.iphotowalking.business.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 * @author jianglz
 * @since 2018/2/28.
 */
@RefreshScope
@RestController
public class TestController {
   

    @Value("${spring.application.name}")
    String springAppName;
    @Value("${server.port}")
    String port;

//  @GetMapping ==   @RequestMapping(value = "/hi",method = RequestMethod.GET)
    @GetMapping("/hi")
    public String home(@RequestParam String name) {
        return "hi "+name+",this is :" +springAppName + ";from port:" + port;
    }

    @Value("${app.name}")
    String appName;

    @Value("${app.version}")
    String appVersion;


    @RequestMapping(value = "/props")
    public String hi() {
        return "appName:" + appName + ";appVersion:" + appVersion;
    }
}
