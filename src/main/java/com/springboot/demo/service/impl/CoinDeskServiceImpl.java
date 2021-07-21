package com.springboot.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.demo.bean.CoinDeskBean;
import com.springboot.demo.entity.CoinDesk;
import com.springboot.demo.repository.CoinDeskRepository;
import com.springboot.demo.service.CoinDeskService;

@Service
public class CoinDeskServiceImpl implements CoinDeskService {

    @Autowired
    private CoinDeskRepository repository;

    @Override
    public List<CoinDeskBean> getAll() {
        return repository
                .findAll()
                .stream()
                .map(coinDesk->CoinDeskBean.builder()
                        .id(coinDesk.getId())
                        .coinCode(coinDesk.getCoinCode())
                        .coinRate(coinDesk.getCoinRate())
                        .createTime(coinDesk.getCreateTime())
                        .updateTime(coinDesk.getUpdateTime())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public CoinDesk getByCoinCode(String coinCode) {
        CoinDesk coinDesk = repository.findByCoinCode(coinCode).orElseThrow(()->new RuntimeException("CoinDesk is not exists!"));
        return coinDesk;
    }

    @Override
    public void add(CoinDeskBean coinDeskBean) {

    }

    @Override
    public void update(CoinDeskBean coinDeskBean) {

    }

}
