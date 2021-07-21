package com.springboot.demo.bean;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CoinDeskBean {

	private int id;
	private String coinCode;
	private String coinName;
	private BigDecimal coinRate;
	private Date createTime;
	private Date updateTime;

}