package com.testapi.restservice.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class RestRequest {

private List<String> data;
	
	public List<String> getData() {
		return data;
	}
	public void setData(List<String> myList) {
		this.data = myList;
	}
	
}