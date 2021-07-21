package com.springboot.demo.service;

import java.util.List;

import com.springboot.demo.bean.CoinDeskBean;
import com.springboot.demo.entity.CoinDesk;

public interface CoinDeskService {
    List<CoinDeskBean> getAll();
    CoinDesk getByCoinCode(String coinCode);
    void add(CoinDeskBean coinDeskBean);
    void update(CoinDeskBean coinDeskBean);
}
