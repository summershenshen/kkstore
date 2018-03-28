package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dao.GoodsDao;
import com.daoimp.GoodsImp;
import com.form.Users;
import com.model.Goods;

@Controller
public class IndexController {
	@Autowired
	private GoodsImp goods;
	@RequestMapping(value = {"/", "index.html"})
    public String index(ModelMap model) {
		model.addAttribute("goodsList", goods.query());
        return "index";
    }

}
