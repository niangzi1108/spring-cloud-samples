package com.iphotowalking.business;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest (classes = ServiceAApplication.class)
public class ServiceAApplicationTests {

	@Test
	public void contextLoads() {
	}


	@Autowired
	RestTemplate restTemplate;

	@Test
	public void testRest(){
		String url = "http://localhost:7071/redis/get/springcloud_test";
		String s = restTemplate.getForObject(url,String.class);
		System.out.println(s);
	}
	
}
