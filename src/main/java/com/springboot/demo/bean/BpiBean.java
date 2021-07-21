package com.springboot.demo.bean;

import com.google.gson.JsonObject;

import lombok.Data;

@Data
public class BpiBean {

	private BpiTimeBean time;
	private String disclaimer;
	private String chartName;
	private JsonObject bpi;

}
