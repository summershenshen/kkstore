package com.dao;

import java.util.List;

import com.model.Goods;

public interface GoodsDao {
	public List<?> query();
	public Goods queryById(String id);
	public Boolean idExist(String id);
	public List<?> queryWantToBuy();
	public void delete(String id); 
	public void modify(String id, Goods newGoods);
	public void add(Goods goods);
}
