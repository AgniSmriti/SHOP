package com.niit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

	
	@RequestMapping("/adminHome")
	
	public ModelAndView adminHome()
	{
		
		ModelAndView mv=new ModelAndView("admin/AdminHome");
		
		return mv;
		
	}
	
}
