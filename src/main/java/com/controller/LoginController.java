package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.daoimp.GoodsImp;
import com.form.Users;
import com.model.Goods;

@Controller
public class LoginController {
	@Autowired
	private GoodsImp goodsDao;
	@RequestMapping(value = {"login.html"})
    public String login(ModelMap model) {
		model.addAttribute("users", new Users());
        return "login";
    }
	
	@RequestMapping(value = "/login_validate.html")
	public String loginvalidate(ModelMap model, Users users, HttpSession session) {
	    if (users.getId().equals("seller")) {
	    		if (users.getPassword().equals("relles")) {
	    			session.setAttribute("id", users.getId());
	    			model.addAttribute("goodsList", goodsDao.query());
	    			return "seller";
	    		} else {
	    			model.addAttribute("error", "密码错误");
	    			return "login";
	    		}
	    }
	    if (users.getId().equals("buyer")) {
    		if (users.getPassword().equals("reyub")) {
    			session.setAttribute("id", users.getId());
    			model.addAttribute("goodsList", goodsDao.query());
    			return "buyer";
    		} else {
    			model.addAttribute("error", "密码错误");
    			return "login";
    		}
	    }
	    model.addAttribute("error", "用户不存在");
	    return "login";
	}
	
	@RequestMapping(value = {"loginExit.html"})
    public String loginExit(ModelMap model, HttpSession session) {
		model.addAttribute("goodsList", goodsDao.query());
		session.removeAttribute("id");
        return "index";
    }
}
