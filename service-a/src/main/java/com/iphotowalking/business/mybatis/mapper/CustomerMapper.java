package com.iphotowalking.business.mybatis.mapper;

import com.iphotowalking.business.mybatis.model.Customer;

import java.util.List;

public interface CustomerMapper {
    Customer selectByPrimaryKey(Integer customer_id);

    Customer selectByOpenid(String openid);

    List<Customer> selectAllCustomers();
}