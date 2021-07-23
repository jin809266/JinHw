package com.springboot.demo.service;

import java.util.List;

import com.springboot.demo.bean.CoinDeskBean;

public interface CoinDeskService {
	
	List<CoinDeskBean> getAll();

	CoinDeskBean getByCoinCode(String coinCode);

	void add(CoinDeskBean coinDeskBean);

	CoinDeskBean update(String coinCode, CoinDeskBean coinDeskBean);

	void deleteCoinDesk(String CoinCode);
}
