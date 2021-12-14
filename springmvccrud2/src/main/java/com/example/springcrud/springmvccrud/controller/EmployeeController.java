package com.example.springcrud.springmvccrud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.springcrud.springmvccrud.model.BranchMaster;
import com.example.springcrud.springmvccrud.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView get() {
		ModelAndView mav = new ModelAndView("employeesAdd");
		mav.addObject("addbatch", new BranchMaster());
		return mav;
	}
	
	@RequestMapping("/save")
	public ModelAndView save(@ModelAttribute("employee") BranchMaster employeeObj) {
		ModelAndView mav = new ModelAndView("employeesAdd");
		employeeService.save(employeeObj);
		System.out.println("Added");
		return mav;
	}
}