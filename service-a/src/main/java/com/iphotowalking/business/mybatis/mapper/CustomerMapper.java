package com.iphotowalking.business.mybatis.mapper;

import com.iphotowalking.business.mybatis.model.Customer;

public interface CustomerMapper {
    Customer selectByPrimaryKey(Integer customer_id);

    Customer selectByOpenid(String openid);
}