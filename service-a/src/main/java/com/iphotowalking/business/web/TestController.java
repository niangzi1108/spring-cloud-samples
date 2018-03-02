package com.iphotowalking.business.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.iphotowalking.business.common.WResponse;
import com.iphotowalking.business.utils.MapUtil;
import com.iphotowalking.business.utils.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
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
        return "hi " + name + ",this is :" + springAppName + ";from port:" + port;
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
    public String testRedisSet(@PathVariable("key") String key, @PathVariable("value") String value) {

        boolean suc = redisUtils.set(key, value);
        if (suc) {
            return "Success";
        } else {
            return "Fail";
        }
    }

    @GetMapping("/redis/get/{key}")
    public String testRedisGet(@PathVariable("key") String key) {
        String value = (String) redisUtils.get(key);
        logger.info(key + ":" + value);
        return value;
    }

    @GetMapping("/rest/wx_token")
    public WResponse testRest() {
        // "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
        String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type={grant_type}&appid={appid}&secret={secret}";
        Map<String, Object> params = new HashMap<>();
        params.put("grant_type", "client_credential");
        params.put("appid", "wx8e9c7ee8d8953b17");
        params.put("secret", "5876b1563785d0138d22c9b2614de79b");
        Map resp = restTemplate.getForObject(ACCESS_TOKEN_URL , Map.class,params);
        return new WResponse(resp);
//        ResponseEntity<Map> responseEntity = restTemplate.getForEntity(ACCESS_TOKEN_URL,Map.class,params);
//        System.out.println(responseEntity.getBody());
//        return new WResponse(responseEntity.getBody());
    }

}
