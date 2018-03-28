package com.dao;

import java.util.List;

import com.model.Cart;
import com.model.Goods;

public interface CartDao {
	public List<?> query();
	public Cart queryById(String id);
	public Boolean isExist(String id);
	public void delete(String id); 
	public void deleteAll();
	public void modify(String id, int newBuyNum);
	public void add(Cart cart);
}
