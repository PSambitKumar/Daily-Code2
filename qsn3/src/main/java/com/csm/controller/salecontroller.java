package com.csm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.csm.entity.product;
import com.csm.entity.sale;
import com.csm.entity.shop;
import com.csm.service.productservice;
import com.csm.service.saleservice;
import com.csm.service.shopservice;

@Controller
public class salecontroller {
	
	@Autowired
	saleservice saleservice1;
	@Autowired
	shopservice shopservice1;
	@Autowired
	productservice productservice1;
	
	@RequestMapping(value = "AddSale")
	public ModelAndView addBatch() {
		ModelAndView mav = new ModelAndView("AddSale");
		List<shop> list = shopservice1.get();
		List<product> list1 = productservice1.get();
		mav.addObject("list", list);
		mav.addObject("list1", list1);
		mav.addObject("addsale", new sale());
		return mav;
	}
	
	@PostMapping(value = "AddSale1")
	public ModelAndView save(@ModelAttribute("addsale") sale sale1) {
		ModelAndView mav = new ModelAndView("Home");
		saleservice1.save(sale1);
		System.out.println("Sale Successfully!!");
		return mav;
	}
	
	@RequestMapping(value = "ViewSale")
	public ModelAndView viewBatch() {
		ModelAndView mav = new ModelAndView("ViewSale");
		List<sale> list = saleservice1.get();
		mav.addObject("list", list);
		return mav;
	}
}
