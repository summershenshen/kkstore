package com.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cart {
	private String id;
	private int buyNum;
	
	@Id
	@Column(name = "id", nullable = false, length = 10)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	@Basic
	@Column(name = "buyNum", nullable = true)
	public int getBuyNum() {
		return buyNum;
	}
	public void setBuyNum(int buyNum) {
		this.buyNum = buyNum;
	}
	
}
