package com.testapi.restservice.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class RestResponse implements Serializable{

	private static final long serialVersionUID = -3636041662014102079L;

	private List<User> data;
	
	public List<User> getData() {
		return data;
	}
	public void setData(List<User> data) {
		this.data = data;
	}

}
