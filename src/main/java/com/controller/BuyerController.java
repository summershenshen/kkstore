package com.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.dao.AlreadyBuyGoodsDao;
import com.daoimp.AlreadyBuyGoodsImp;
import com.daoimp.CartImp;
import com.daoimp.GoodsImp;
import com.form.Users;
import com.model.AlreadyBuyGoods;
import com.model.Cart;
import com.model.CartGoods;
import com.model.Goods;

@Controller
public class BuyerController {
	@Autowired
	private GoodsImp goodsDao;
	@Autowired
	private CartImp cartDao;
	@Autowired
	private AlreadyBuyGoodsImp alreadyBuyGoodsDao;
	
	@RequestMapping(value = "/buyerGoodsDetail{id}.html")
    public String showGoodsDetail(ModelMap model, @PathVariable String id) {
        Goods goods = goodsDao.queryById(id); 
        model.addAttribute("goods", goods);
        return "buyerGoodsDetail";
    }
	
	@RequestMapping(value = "/addToCart{id}.html")	
	public String addToCart(ModelMap model, @PathVariable String id, @RequestParam("amount") String amount) {
		int buyNum = Integer.valueOf(amount);
		Cart newCart = new Cart();
		if (cartDao.isExist(id)) {
			cartDao.modify(id, (buyNum + cartDao.queryById(id).getBuyNum()));
		} else {
		newCart.setId(id);
		newCart.setBuyNum(buyNum);
		cartDao.add(newCart);
		}
		Goods goods = goodsDao.queryById(id); 
        model.addAttribute("goods", goods);
        return "buyerGoodsDetail";
	}
	
	@RequestMapping(value = "/shoppingcart.html")
	public String showCart(ModelMap model, HttpSession session) {
		if (session.getAttribute("id") != null) {
			List cartList = cartDao.query();
			List cartGoodsList = new ArrayList();
			for(int i = 0; i < cartList.size(); i++) {
				Cart cart = (Cart)cartList.get(i);
				Goods goods = goodsDao.queryById(cart.getId());
				cartGoodsList.add(new CartGoods(goods, cart.getBuyNum()));
			}
			model.addAttribute("cartGoodsList", cartGoodsList);
			return "cart";
		}
		else {
			model.addAttribute("users", new Users());
	        return "login";
		}
	}
	
	@RequestMapping(value = "/buyAllCartGoods.html")
	public String buyAllCartGoods(ModelMap model) {
		List cartList = cartDao.query();
		for(int i = 0; i < cartList.size(); i++) {
			Cart cart = (Cart)cartList.get(i);
			Goods goods = goodsDao.queryById(cart.getId());
			goods.setStore(goods.getStore() - cart.getBuyNum());
			goodsDao.modify(goods.getId(), goods);
			AlreadyBuyGoods alreadyBuyGoods = new AlreadyBuyGoods();
			alreadyBuyGoods.setId(goods.getId());
			alreadyBuyGoods.setName(goods.getName());
			alreadyBuyGoods.setNum(cart.getBuyNum());
			alreadyBuyGoods.setPrice(goods.getPrice());
			alreadyBuyGoods.setDate(new Date());
			alreadyBuyGoods.setImage(goods.getImage());
			alreadyBuyGoodsDao.add(alreadyBuyGoods);
			goods.setAlreadyBuy((byte)1);
			goodsDao.modify(goods.getId(), goods);
}
		cartDao.deleteAll();
		return "buySuccess";
	}
	
	@RequestMapping(value = "/cartRemove{id}.html")
	public String cartRemove(ModelMap model, @PathVariable String id) {
		cartDao.delete(id);
		List cartList = cartDao.query();
		List cartGoodsList = new ArrayList();
		for(int i = 0; i < cartList.size(); i++) {
			Cart cart = (Cart)cartList.get(i);
			Goods goods = goodsDao.queryById(cart.getId());
			cartGoodsList.add(new CartGoods(goods, cart.getBuyNum()));
		}
		model.addAttribute("cartGoodsList", cartGoodsList);
		return "cart";
		}
	
	@RequestMapping(value = "/deals.html")
	public String showDeals(ModelMap model, HttpSession session) {
		if (session.getAttribute("id") != null) {
			model.addAttribute("dealsList", alreadyBuyGoodsDao.query());
			return "deals";
		}
		else {
			model.addAttribute("users", new Users());
	        return "login";
		}
	}
	
	@RequestMapping(value = {"/buyer.html"})
    public String showToBuyer(ModelMap model) {
		model.addAttribute("goodsList", goodsDao.query());
		return "buyer";
    }
	
	@RequestMapping(value = {"/buyerType=1.html"})
    public String showToBuyerType1(ModelMap model) {
		List goodsList = goodsDao.query();
		List notBuyGoodsList = new ArrayList();
		for(int i = 0; i < goodsList.size(); i++) {
			Goods goods= (Goods)goodsList.get(i);
			if (goods.getAlreadyBuy() == null)
				notBuyGoodsList.add(goods);
		}
		model.addAttribute("goodsList", notBuyGoodsList);
		return "buyer";
    }
	
}
