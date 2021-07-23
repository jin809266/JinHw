package com.springboot.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
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

	@CreationTimestamp
	@Column
	private Date createTime;

	@UpdateTimestamp
	@Column
	private Date updateTime;
}
