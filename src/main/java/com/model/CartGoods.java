package com.model;

public class CartGoods {
	private Goods goods; 
	private int buyNum;
	
	public CartGoods(Goods goods, int buyNum) {
		super();
		this.goods = goods;
		this.buyNum = buyNum;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public int getBuyNum() {
		return buyNum;
	}
	public void setBuyNum(int buyNum) {
		this.buyNum = buyNum;
	}
	
	
	
}
