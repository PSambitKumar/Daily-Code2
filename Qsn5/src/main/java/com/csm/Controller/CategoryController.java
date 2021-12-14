package com.csm.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.csm.Entity.Category;
import com.csm.Service.CategoryService;


@Controller
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;

	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("Home");
		return mav;
	}
	
	@RequestMapping(value = "AddCategory")
	public ModelAndView ViewCategory() {
		ModelAndView mav = new ModelAndView("ViewCategory");
		List<Category> list = categoryService.get();
		mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping(value = "AddCategory1")
	public ModelAndView addCategory() {
		ModelAndView mav = new ModelAndView("AddCategory");
		mav.addObject("addcategory", new Category());
		return mav;
	}
	
	@RequestMapping(value = "SaveCategory")
	public ModelAndView saveCategory(@ModelAttribute("addcategory") Category category ) {
		ModelAndView mav = new ModelAndView("ViewCategory");
		categoryService.save(category);
		List<Category> list = categoryService.get();
		mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping("/EditCategory/{catid}")
	public ModelAndView editCategory(@PathVariable int catid) {
		ModelAndView mav = new ModelAndView("AddCategory");
		Category category = categoryService.get(catid);
		if(category == null) {
			throw new RuntimeException("Category not found"+catid);
		}
		mav.addObject("addcategory", category);
		return mav;
	}
	
	@RequestMapping("/DeleteCategory/{catid}")
	public ModelAndView deleteCategory(@PathVariable int catid) {
		ModelAndView mav = new ModelAndView("ViewCategory");
		categoryService.delete(catid);
		List<Category> list = categoryService.get();
		mav.addObject("list",list);
		return mav;
	}
	
	
	
	
	
	
}
