package com.springboot.demo.bean;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Builder;
import lombok.Data;

/*
 * Invoke CoinDesk API convert to the POJO
 */

@Builder
@Data
public class ExchangeBean {
	private String coinCode;
	private String coinSymbol;
	private String rate;
	private String description;
	private BigDecimal rateFloat;
	private Date updateTime;

}