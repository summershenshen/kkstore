package com.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.daoimp.GoodsImp;
import com.model.Goods;

@Controller
public class SellerController {
	@Autowired
	private GoodsImp goodsDao;
	@RequestMapping(value = "/sellerGoodsDetail{id}.html")
    public String showGoodsDetail(ModelMap model, @PathVariable String id) {
        Goods goods = goodsDao.queryById(id); 
        model.addAttribute("goods", goods);
        return "sellerGoodsDetail";
    }
	
	@RequestMapping(value = "/edit{id}.html")
	public String editGoods(ModelMap model, @PathVariable String id, Goods goods) {
	    goods = goodsDao.queryById(id);
	    model.addAttribute("goods", goods);
	    return "sellerGoodsEditForm";
	}

	@RequestMapping(value = "/addNewGoods.html")
	public String addNewGoods(ModelMap model) {
	    Goods goods = new Goods();
	    model.addAttribute("goods", goods);
	    return "addNewGoodsForm";
	}
	
	@RequestMapping(value = "/editResult.html")
	public String editResult(ModelMap model, Goods newGoods, MultipartFile file) throws InterruptedException {
		try {
		    String add = "/Users/summer/eclipse-workspace/kkstore/src/main/webapp/img/";
		    File newfile = new File(add + newGoods.getId() + ".png");
		    InputStream input = file.getInputStream();
		    OutputStream output = new FileOutputStream(newfile);
		    byte[] date = new byte[input.available()];
		    int temp = 0;
		    while ((temp = input.read(date)) != -1) {
		        output.write(date, 0, temp);
		    }
		    input.close();
		    output.close();
		} catch (Exception e) {
		    e.printStackTrace();
		}
		newGoods.setImage("img/" + newGoods.getId()+".png");
	    goodsDao.modify(newGoods.getId(), newGoods);
	    model.addAttribute("goods", goodsDao.queryById(newGoods.getId()));
	    model.addAttribute("message", "修改成功");
	    return "sellerGoodsDetail";
	}
	
	@RequestMapping(value = "/addNewGoodsResult.html")
	public String addNewGoodsResult(ModelMap model, Goods newGoods, MultipartFile file) throws InterruptedException {
		if (goodsDao.idExist(newGoods.getId())) {
			model.addAttribute("message", "已有该商品！");
			newGoods.setId("");
		    model.addAttribute("goods", 	newGoods);
			return "addNewGoodsForm";
		}
		try {
		    String add = "/Users/summer/eclipse-workspace/kkstore/src/main/webapp/img/";
		    File newfile = new File(add + newGoods.getId() + ".png");
		    InputStream input = file.getInputStream();
		    OutputStream output = new FileOutputStream(newfile);
		    byte[] date = new byte[input.available()];
		    int temp = 0;
		    while ((temp = input.read(date)) != -1) {
		        output.write(date, 0, temp);
		    }
		    input.close();
		    output.close();
		} catch (Exception e) {
		    e.printStackTrace();
		}
		newGoods.setImage("img/" + newGoods.getId()+".png");
	    goodsDao.add(newGoods);
	    model.addAttribute("goods", goodsDao.queryById(newGoods.getId()));
	    model.addAttribute("message", "发布成功");
	    return "sellerGoodsDetail";
	}
	
	@RequestMapping(value = "/goodsRemove{id}.html")
	public String editResult(ModelMap model, @PathVariable String id) throws InterruptedException {
		goodsDao.delete(id);
		model.addAttribute("goodsList", goodsDao.query());
		return "seller";
	}
	
	@RequestMapping(value = {"/seller.html"})
    public String sellerIndex(ModelMap model) {
		model.addAttribute("goodsList", goodsDao.query());
		return "seller";
    }
}
