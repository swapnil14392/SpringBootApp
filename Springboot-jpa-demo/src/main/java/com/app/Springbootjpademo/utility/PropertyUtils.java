package com.app.Springbootjpademo.utility;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:message.properties")
public class PropertyUtils {
	
	private static Environment env;
	
	@Autowired
	private Environment envtmp;

	public static String getProperty(String key) {
		return env.getProperty(key);
	}
	
	@PostConstruct
	public void afterInit() {
		PropertyUtils.env=envtmp;
	}

}
