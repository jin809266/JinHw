package com.springboot.demo.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Table(name = "COINDESK")
@Data
@Entity
public class CoinDesk {
	
	@Id
	@Column(updatable = false, nullable = false)
	private String coinCode;

	@Column
	private BigDecimal coinRate;

	@CreationTimestamp
	@Column
	private Date createTime;

	@UpdateTimestamp
	@Column
	private Date updateTime;
}
