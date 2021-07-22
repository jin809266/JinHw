package com.springboot.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		return repository.findAll().stream()
				.map(coinDesk -> CoinDeskBean.builder().coinCode(coinDesk.getCoinCode())
						.coinRate(coinDesk.getCoinRate()).createTime(coinDesk.getCreateTime())
						.updateTime(coinDesk.getUpdateTime()).build())
				.collect(Collectors.toList());
	}

	@Override
	public CoinDeskBean getByCoinCode(String coinCode) {
		CoinDesk coinDesk = repository.findByCoinCode(coinCode)
				.orElseThrow(() -> new RuntimeException("CoinDesk is not exists!"));
		CoinDeskBean coinDeskBean = CoinDeskBean.builder().build();
		BeanUtils.copyProperties(coinDesk, coinDeskBean);
		return coinDeskBean;
	}

	@Transactional
	@Override
	public void add(CoinDeskBean coinDeskBean) {
		CoinDesk coinDesk = new CoinDesk();
		coinDesk.setCoinCode(coinDeskBean.getCoinCode());
		coinDesk.setCoinRate(coinDeskBean.getCoinRate());
		repository.save(coinDesk);
	}

	@Transactional
	@Override
	public void update(String coinCode, CoinDeskBean coinDeskBean) {
		CoinDesk coinDesk = repository.findByCoinCode(coinCode).orElseThrow(() -> new RuntimeException("CoinDesk is not exists!"));
		coinDesk.setCoinRate(coinDeskBean.getCoinRate());
		repository.save(coinDesk);
	}

	@Transactional
	@Override
	public void deleteCoinDesk(String coinCode) {
		if (!repository.existsByCoinCode(coinCode)) {
			throw new ResourceNotFoundException("CoinDesk is not found");
		}
		repository.deleteByCoinCode(coinCode);
	}

}
