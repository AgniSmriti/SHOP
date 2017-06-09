package com.niit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.backendproject.Backend.DAO.CategoryDAO;
import com.niit.backendproject.Backend.DAO.ProductDAO;
import com.niit.backendproject.Backend.DAO.SupplierDAO;
import com.niit.backendproject.Backend.DAO.UserDAO;
import com.niit.backendproject.Backend.model.User;

@Controller
public class HomeController {
	
	@Autowired
	UserDAO userDAO;
	@Autowired
	SupplierDAO supplierDAO;
	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	ProductDAO productDAO;
	@Autowired
	HttpSession httpSession;	
	
	@RequestMapping(value={"/" , "index"})
	public String home(){
		httpSession.setAttribute("listSupplier",supplierDAO.getAllSupplier());
		httpSession.setAttribute("listCategory",categoryDAO.getAllCategory());
		httpSession.setAttribute("listProduct",productDAO.getAllProduct());
		
		
		
		
		return "index";
		
	}
	
	
	@RequestMapping( "/Login")
	public String log(Model model)
	{ 
		
		return "Login";
		
	}
	
	
	@RequestMapping("/adduser")
	public String addUser(@ModelAttribute("user") User u,Model model)
	{ 
		
		if(u.getUserid()==null || u.getUserid().isEmpty())
		{	
		
		
		if(userDAO.addUser(u))
				model.addAttribute("msg","successsfully register");
		else
		
			model.addAttribute("msg","not successsfully register");
		}
		
		
		
		return "signup";
		
	}
	

	

@RequestMapping("/signup")
public String signup(Model model)
{

	model.addAttribute("user",new User());
	model.addAttribute("userList", userDAO.getAllUser());

return "signup";
}


@RequestMapping("/LogOut")
public 	ModelAndView logout()
{
	ModelAndView mv=new ModelAndView("Login");
	mv.addObject("msg","successfully logout");
	return mv;
}
}
    


