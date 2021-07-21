package com.springboot.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;

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
