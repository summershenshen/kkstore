package com.model;

import java.awt.Image;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AlreadyBuyGoods {
	private String id;
	private String name;
	private double price;
	private int num;
	private Date date;
	private String image;

	@Id
	@Column(name = "id", nullable = false, length = 10)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Basic
	@Column(name = "name", nullable = true, length = 45)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Basic
	@Column(name = "price", nullable = true)
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Basic
	@Column(name = "num", nullable = true)
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Basic
	@Column(name = "date", nullable = true)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Basic
	@Column(name = "image", nullable = true, length = 100)
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	

}
