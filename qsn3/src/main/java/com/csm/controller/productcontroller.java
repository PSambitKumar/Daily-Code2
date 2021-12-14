package com.csm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.csm.entity.product;
import com.csm.entity.shop;
import com.csm.service.productservice;
@Controller
public class productcontroller {
	
	@Autowired
	productservice productservice1;
	
	@RequestMapping(value = "AddProduct") public ModelAndView addproduct() {
		  ModelAndView mav = new ModelAndView("AddProduct");
		  mav.addObject("addproduct", new product());  
		  return mav;
		  }
	
	@RequestMapping(value = "AddPoduct1")
	public ModelAndView save(@ModelAttribute("addproduct") product product1) {
		ModelAndView mav = new ModelAndView("Home");
			mav.addObject("addproduct", new product());
			productservice1.save(product1);
			System.out.println("Product Added/Updated Successfully!!");
		return mav;
	}
	
	@RequestMapping(value = "ViewProduct")
	public ModelAndView viewStudent() {
		ModelAndView mav = new ModelAndView("ViewProduct");
			List<product> list = productservice1.get();
			mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping(value = "edit/{productid}")
	public ModelAndView get(@PathVariable("productid") int productid) {
		ModelAndView mav = new ModelAndView("AddShop1");
		product product1 = productservice1.get(productid);
			if(product1 == null) {
				throw new RuntimeException("Product not found"+productid);
			}
			mav.addObject("addproduct", product1);
		return mav;
	}
	
	@RequestMapping(value = "delete/{productid}")
	public ModelAndView delete(@PathVariable("productid") int productid) {
		ModelAndView mav = new ModelAndView("ViewProduct");
			productservice1.delete(productid);
			List<product> list = productservice1.get();
			mav.addObject("list", list);
		return mav;
	}

}
