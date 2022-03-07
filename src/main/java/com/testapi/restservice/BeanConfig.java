package com.testapi.restservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.testapi.restservice.model.RestRequest;
import com.testapi.restservice.model.UserRequest;

@Configuration
public class BeanConfig {
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public UserRequest userRequest() {
		return new UserRequest();
	}
	

}
