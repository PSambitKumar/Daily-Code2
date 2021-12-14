package com.csm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.csm.bean.EmpDto;
import com.csm.entity.Employee;
import com.csm.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@GetMapping("addEmployee")
	public String addEmployee(Model model) {
		model.addAttribute("empDto", new EmpDto());
		return "addEmployee";
	}
	
	@PostMapping("addEmployee")
	public String addEmployee(@ModelAttribute("empDto")EmpDto empDto,Model model) {
		String res="";
		String resRes="";
		try {
			res=employeeService.saveEmployee(empDto);
			if(res.equals("sucess")){
				List<EmpDto> list=employeeService.getAllEmployee();
				model.addAttribute("empList", list);
				resRes= "viewEmployee";
			}else {
				resRes= "addEmployee";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return resRes;
	}
	/*
	 * @GetMapping("viewEmployee") public String viewEmployee(Model model) {
	 * List<EmpDto> list=null; try { list=employeeService.getAllEmployee();
	 * model.addAttribute("empList", list); }catch(Exception e) {
	 * e.printStackTrace(); } return "viewEmployee"; }
	 */
}