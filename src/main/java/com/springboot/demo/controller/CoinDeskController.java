package com.springboot.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.bean.BpiBean;
import com.springboot.demo.bean.CoinDeskBean;
import com.springboot.demo.service.BpiService;
import com.springboot.demo.service.CoinDeskService;

@RestController
public class CoinDeskController {

	@Autowired
	private CoinDeskService service;
	@Autowired
	private BpiService bpiService;

	// get coinDesk All datas
	@GetMapping("/coinDesks")
	public List<CoinDeskBean> getAll() {
		return service.getAll();
	}

	// get coinDesk by coinCode
	@GetMapping("/coinDesks/{coinCode}")
	public CoinDeskBean getByCoinCode(@PathVariable("coinCode") String coinCode) {
		return service.getByCoinCode(coinCode);
	}

	// add CoinDesk
	@PostMapping("/coinDesk")
	@ResponseStatus(HttpStatus.CREATED)
	public void addCoinDesk(@RequestBody CoinDeskBean coinDeskBean) {
		service.add(coinDeskBean);
	}

	// update CoinDesk by coinCode
	@PutMapping("coinDesk/{coinCode}")
	@ResponseStatus(HttpStatus.OK)
	public CoinDeskBean updateCoinDesk(@PathVariable(required = true) String coinCode, @RequestBody CoinDeskBean coinDeskBean) {
		coinDeskBean.setCoinCode(coinCode);
		return service.update(coinCode,coinDeskBean);
	}

	// delete coinDesk by coinCode
	@DeleteMapping("/coinDesk/{coinCode}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteCoinDesk(@PathVariable("coinCode") String coinCode) {
		service.deleteCoinDesk(coinCode);
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
