package com.csm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.csm.bean.BatchMasterDto;
import com.csm.service.BatchMasterService;

@Controller
public class MainController {
	
	@Autowired
	BatchMasterService employeeService;

	@GetMapping("addEmployee")
	public String addEmployee(Model model) {
		model.addAttribute("empDto", new BatchMasterDto());
		return "addEmployee";
	}
	
	@PostMapping("addEmployee")
	public String addEmployee(@ModelAttribute("empDto")BatchMasterDto empDto,Model model) {
		String res="";
		String resRes="";
		try {
			res=employeeService.saveEmployee(empDto);
			if(res.equals("sucess")){
				List<BatchMasterDto> list=employeeService.getAllEmployee();
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

}