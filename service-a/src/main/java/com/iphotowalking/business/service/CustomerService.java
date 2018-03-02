package com.iphotowalking.business.service;

import com.iphotowalking.business.mybatis.mapper.CustomerMapper;
import com.iphotowalking.business.mybatis.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jianglz
 * @since 2018/3/2.
 */
@Service
public class CustomerService {

    public static Logger logger = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    CustomerMapper customerMapper;

    private Customer queryByOpenid(String openid) {
        return customerMapper.selectByOpenid(openid);
    }
}
