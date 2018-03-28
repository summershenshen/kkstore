package com.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Goods {
	private String id;
	private String name;
	private String abstract1;
	private String introduction;
	private double price;
	private Byte alreadyBuy;
	private String image;
	private Byte wantToBuy;
	private int store;
	
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
	@Column(name = "abstract", nullable = true, length = 45)
	public String getAbstract1() {
		return abstract1;
	}
	public void setAbstract1(String abstract1) {
		this.abstract1 = abstract1;
	}
	
	@Basic
	@Column(name = "introduction", nullable = true, length = 200)
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
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
	@Column(name = "alreadyBuy", nullable = true)
	public Byte getAlreadyBuy() {
		return alreadyBuy;
	}
	public void setAlreadyBuy(Byte alreadyBuy) {
		this.alreadyBuy = alreadyBuy;
	}
	
	@Basic
	@Column(name = "image", nullable = true, length = 100)
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	@Basic
	@Column(name = "wantToBuy", nullable = true)
	public Byte isWanttoBuy() {
		return wantToBuy;
	}
	public void setWanttoBuy(Byte wantToBuy) {
		this.wantToBuy = wantToBuy;
	}

	@Basic
	@Column(name = "store", nullable = true)
	public int getStore() {
		return store;
	}
	public void setStore(int store) {
		this.store = store;
	}
	
}
