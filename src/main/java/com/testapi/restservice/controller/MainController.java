package com.testapi.restservice.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.testapi.restservice.model.RestRequest;
import com.testapi.restservice.model.RestResponse;
import com.testapi.restservice.model.User;
import com.testapi.restservice.model.UserRequest;

@RestController
@RequestMapping("api")
public class MainController {
	
	@Autowired
	UserRequest userReq = new UserRequest();
		
	@Value("${url.request}")
	private String urlrequest;

	List<String> myList = new ArrayList<>();
	
	@GetMapping("/getdata")
	public RestResponse getDatos() {
		RestTemplate restTemplate = new RestTemplate();
		RestResponse data = restTemplate.getForObject(urlrequest, RestResponse.class);
		for(User user: data.getData()) {
			userReq.setId(user.getId());
			userReq.setEmail(user.getEmail());
			userReq.setLast_name(user.getLast_name());
			myList.add(userReq.toString());
		}
		return data;
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json",
			produces = "application/json", path = "/postdata")
	public @ResponseBody String postUsuario(@RequestBody RestRequest info) {
		Gson gson = new Gson();
		String content = gson.toJson(myList);
		return "data: " + content;
	}
	
}
