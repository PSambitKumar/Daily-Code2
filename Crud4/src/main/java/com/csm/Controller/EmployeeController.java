package com.csm.Controller;
		
		

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csm.Bean.EmployeeBean;
import com.csm.Service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("Login")
	public String home(Model model){
		model.addAttribute("empBean", new EmployeeBean());
		return "login";
	}
	
	@RequestMapping("/AddBatch")
	public String register(Model model){
		model.addAttribute("empBean", new EmployeeBean());
		return "register";
	}
	
	/*
	 * @PostMapping("Register") public String register1(@ModelAttribute
	 * ("empBean")EmployeeBean empBean, Model model) { String result; try { result =
	 * employeeService.saveEmployee(empBean); System.out.println(result); }catch
	 * (Exception e) { e.printStackTrace(); } return "Inserted!!"; }
	 */
	
}
