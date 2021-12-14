package com.example.springcrud.springmvccrud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.springcrud.springmvccrud.model.BatchMaster;
import com.example.springcrud.springmvccrud.service.BatchMasterService;

@Controller
public class MainController {

	@Autowired
	private BatchMasterService batchMasterService;

	@RequestMapping(value = { "/", "/home"})
	public ModelAndView get() {
		ModelAndView mav = new ModelAndView("Home");
		return mav;
	}
	
	@RequestMapping(value = "AddBatch")
	public ModelAndView addBatch() {
		ModelAndView mav = new ModelAndView("AddBatch");
		mav.addObject("addbatch", new BatchMaster());
		return mav;
	}
	
	@PostMapping("Add")
	public ModelAndView save(@ModelAttribute("addbatch") BatchMaster batch) {
		ModelAndView mav = new ModelAndView("Home");
		mav.addObject("addbatch", new BatchMaster());
		batchMasterService.save(batch);
		System.out.println("Batch Added Successfully!!");
		return mav;
	}
	


	/*
	 * @RequestMapping("/openEmployeeView") public ModelAndView
	 * openEmployeeAddView() { ModelAndView mav = new ModelAndView("employeesAdd");
	 * mav.addObject("employee", new Employee()); return mav; }
	 * 
	 * @RequestMapping("/save") public ModelAndView save(@ModelAttribute("employee")
	 * Employee employeeObj) { ModelAndView mav = new ModelAndView("employeesList");
	 * employeeService.save(employeeObj); List<Employee> list =
	 * employeeService.get(); mav.addObject("list", list); return mav; }
	 */
}