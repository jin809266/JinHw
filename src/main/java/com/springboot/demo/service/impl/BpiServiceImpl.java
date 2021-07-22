package com.springboot.demo.service.impl;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.springboot.demo.bean.BpiBean;
import com.springboot.demo.repository.CoinDeskMapRepository;
import com.springboot.demo.service.BpiService;
@Service
public class BpiServiceImpl implements BpiService {

    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private CoinDeskMapRepository repository;

    @Autowired
    private Gson gson;

    private final String bpiUrl = "https://api.coindesk.com/v1/bpi/currentprice.json";

	@Override
	public BpiBean getBpiJsonObject() {
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(bpiUrl, String.class);
        BpiBean bpiBean = gson.fromJson(responseEntity.getBody(), BpiBean.class);
        return bpiBean;
	}

	@Override
	public Map<String, Object> getExchangeObject() {
		
		 ResponseEntity<String> responseEntity = restTemplate.getForEntity(bpiUrl, String.class);
	        if(responseEntity.getStatusCode().isError()){
	            return Collections.EMPTY_MAP;
	        }
		 BpiBean bpiBean = gson.fromJson(responseEntity.getBody(), BpiBean.class);
		 Map<String, Object> result = new LinkedHashMap<>();
		 result.put("updateTime", Date.from(LocalDateTime.parse(bpiBean.getTime().getUpdatedISO(), DateTimeFormatter.ISO_OFFSET_DATE_TIME)
				 .atZone(ZoneId.systemDefault()).toInstant()));
	        Map<String, Object> exchangeResultMap = bpiBean.getBpi()
            .entrySet()
            .stream()
            .map(Map.Entry::getValue)
            .map(exchange->{
            		JsonObject exchangeObject = exchange.getAsJsonObject();
            		String coinCode = exchangeObject.get("code").getAsString();
            		Map<String, Object> exchangeMap = new HashMap<>();
            		exchangeMap.put("code", coinCode);
            		exchangeMap.put("coinName", repository.findByCoinCode(coinCode).get().getCoinName());
            		exchangeMap.put("rate", exchangeObject.get("rate_float").getAsBigDecimal());
            		return exchangeMap;
            })
            .collect(Collectors.toMap(exchangeMap->(String)exchangeMap.get("code"), exchangeMap->exchangeMap));
	        result.putAll(exchangeResultMap);
	        return result;
	}
}
