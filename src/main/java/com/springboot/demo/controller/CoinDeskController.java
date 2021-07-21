package com.springboot.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.bean.BpiBean;
import com.springboot.demo.bean.CoinDeskBean;
import com.springboot.demo.entity.CoinDesk;
import com.springboot.demo.service.BpiService;
import com.springboot.demo.service.CoinDeskService;

@RestController
public class CoinDeskController {

	@Autowired
	private CoinDeskService service;
	@Autowired
	private BpiService bpiService;

	// query coinDesk All datas
	@GetMapping("/coinDesks")
	public List<CoinDeskBean> getAll() {
		return service.getAll();
	}

	// query coinDesk by coinCode
	@GetMapping("/coinDesks/{coinCode}")
	public CoinDesk getByCoinCode(@PathVariable("coinCode") String coinCode) {
		return service.getByCoinCode(coinCode);
	}

	// call coinDesk API
	@GetMapping("/coinDesk")
	public BpiBean getBpiJsonObject() {
		return bpiService.getBpiJsonObject();
	}

	// call coinDesk API and exchange data
	@GetMapping("/coinDesk/exchange")
	public Map<String, Object> getExchangeObject() {
		return bpiService.getExchangeObject();
	}
}
