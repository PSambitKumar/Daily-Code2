package com.csm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.csm.entity.shop;
import com.csm.service.shopservice;

@Controller
public class shopcontroller {

	@Autowired
	shopservice shopService1;
	
	@RequestMapping(value = { "/", "/home","Home"})
	public ModelAndView get() {
		ModelAndView mav = new ModelAndView("Home");
		return mav;
	}
	
	
	  @RequestMapping(value = "AddShop") public ModelAndView addshop() {
	  ModelAndView mav = new ModelAndView("AddShop");
	  mav.addObject("addshop", new shop());  
	  return mav;
	  }
	  
	  @RequestMapping(value = "AddShop1")
		public ModelAndView save(@ModelAttribute("addshop") shop shop1) {
			ModelAndView mav = new ModelAndView("Home");
				mav.addObject("addshop", new shop());
				shopService1.save(shop1);
				System.out.println("Shop Added/Updated Successfully!!");
			return mav;
		}
	  
		@RequestMapping(value = "ViewShop")
		public ModelAndView viewStudent() {
			ModelAndView mav = new ModelAndView("ViewShop");
				List<shop> list = shopService1.get();
				mav.addObject("list", list);
			return mav;
		}
		
		@RequestMapping(value = "edit/{shopid}")
		public ModelAndView get(@PathVariable("shopid") int shopid) {
			ModelAndView mav = new ModelAndView("AddShop1");
				shop shop1 = shopService1.get(shopid);
				if(shop1 == null) {
					throw new RuntimeException("Shop not found"+shopid);
				}
				mav.addObject("addshop", shop1);
			return mav;
		}
		
		@RequestMapping(value = "delete/{shopid}")
		public ModelAndView delete(@PathVariable("shopid") int shopid) {
			ModelAndView mav = new ModelAndView("ViewShopt");
				shopService1.delete(shopid);
				List<shop> list = shopService1.get();
				mav.addObject("list", list);
			return mav;
		}
	 
}
