package com.springboot.demo.service;

import java.util.List;

import com.springboot.demo.bean.CoinDeskBean;
import com.springboot.demo.entity.CoinDesk;

public interface CoinDeskService {
	List<CoinDeskBean> getAll();

	CoinDeskBean getByCoinCode(String coinCode);

	void add(CoinDeskBean coinDeskBean);

	void update(String coinCode, CoinDeskBean coinDeskBean);

	void deleteCoinDesk(String CoinCode);
}
