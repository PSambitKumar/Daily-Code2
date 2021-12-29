package com.csm.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.csm.Entity.Registration;
import com.csm.Service.RegistrationService;
@Controller
public class RegistrationController {
	
	@Autowired
	RegistrationService registrationService;
	
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("Home");
		return mav;
	}
	
	@RequestMapping(value = "Registration")
	public ModelAndView registration() {
		ModelAndView mav = new ModelAndView("Registration");
		mav.addObject("registration", new Registration());
		return mav;
	}
	
	@RequestMapping(value = "SaveRegistration")
	public ModelAndView saveRegistration(@ModelAttribute("registration") Registration registration ) {
		ModelAndView mav = new ModelAndView("Home");
		registrationService.save(registration);
		System.out.println("Registration Successfull!!");
		return mav;
	}
}
