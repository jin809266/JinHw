package com.springboot.demo.service;

import java.util.Map;

import com.springboot.demo.bean.BpiBean;

public interface BpiService {

	BpiBean getBpiJsonObject();
	
	Map<String, Object> getExchangeObject();
}
