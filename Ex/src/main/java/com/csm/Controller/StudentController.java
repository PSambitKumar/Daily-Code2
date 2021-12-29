package com.csm.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.csm.Entity.Student;
import com.csm.Service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("home");
		return mav;
	}
	
	@RequestMapping("/AddStudent")
	public ModelAndView addStudent() {
		ModelAndView mav = new ModelAndView("addStudent");
		mav.addObject("addstudent", new Student());
		return mav;
	}
	
	@RequestMapping("/SaveStudent")
	public ModelAndView saveStudent (@ModelAttribute("addstudent") Student student) {
		ModelAndView mav = new ModelAndView("home");
		studentService.save(student);
		return mav;
	}

}
