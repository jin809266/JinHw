package com.springboot.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Table(name = "COINDESKMAP")
@Data
@Entity
public class CoinDeskMap {

	@Id
	@Column
	private String coinCode;

	@Column
	private String coinName;

	@CreatedDate
	@Column
	private Date createTime;

	@LastModifiedDate
	@Column
	private Date updateTime;
}
