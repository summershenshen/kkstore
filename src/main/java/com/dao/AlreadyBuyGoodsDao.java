package com.dao;

import java.util.List;

import com.model.AlreadyBuyGoods;

public interface AlreadyBuyGoodsDao {
	public List<?> query();
	public void delete(String id); 
	public void add(AlreadyBuyGoods goods);
}
