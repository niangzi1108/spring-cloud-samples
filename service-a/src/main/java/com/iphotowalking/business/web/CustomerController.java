package com.iphotowalking.business.web;

import com.iphotowalking.business.mybatis.model.Customer;
import com.iphotowalking.business.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jianglz
 * @since 2018/3/2.
 */
@RestController
@RequestMapping("/user")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/get/{openid}")
    public Map<String,Object> findByOpenid(@PathVariable("openid") String openid){

       Customer customer =  customerService.queryByOpenid(openid);
        Map<String,Object> retMap = new HashMap<>();
        retMap.put("name",customer.getNickname());
        return retMap;
    }
}
