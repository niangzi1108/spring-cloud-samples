package com.iphotowalking.business.web;

import com.iphotowalking.business.utils.MapUtil;
import com.iphotowalking.business.utils.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author jianglz
 * @since 2018/2/28.
 */
@RefreshScope
@RestController
public class TestController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    RedisUtils redisUtils;
    @Autowired
    RestTemplate restTemplate;

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



    @GetMapping("/redis/set/{key}/{value}")
    public String testRedisSet(@PathVariable("key") String key,@PathVariable("value") String value){

        boolean suc =  redisUtils.set(key,value);
        if(suc){
            return "Success";
        }else{
            return "Fail";
        }
    }

    @GetMapping("/redis/get/{key}")
    public Map testRedisGet(@PathVariable("key") String key){
        String value = (String) redisUtils.get(key);
        logger.info(key + ":" + value);
        return MapUtil.convert2HashMap(key,value);
    }


}
