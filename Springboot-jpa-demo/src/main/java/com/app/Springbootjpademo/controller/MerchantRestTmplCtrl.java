package com.app.Springbootjpademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MerchantRestTmplCtrl {
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${myrest.url}")
    private String restUrl;
	@GetMapping("rest")
	public void testRestTemplate() {
		
	}
}
