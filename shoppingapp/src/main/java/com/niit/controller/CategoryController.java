		package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.backendproject.Backend.DAO.CategoryDAO;
import com.niit.backendproject.Backend.model.Category;

@Controller
public class CategoryController {

	
   @Autowired
   CategoryDAO categoryDAO;
   

	
	@RequestMapping("/CategoryAdd")
	public String AddCat(Model model)
	{ 
	model.addAttribute("category",new Category());

	model.addAttribute("listCategory",categoryDAO.getAllCategory());
			return "CategoryAdd";//PAGE
	}
	
	
	@RequestMapping("/manage_category")
	public String addCategory(@ModelAttribute("category") Category c,Model model)
	{ 
		
		if(c.getCatId()==null || c.getCatId().isEmpty())
		{
			if(categoryDAO.addCategory(c))
			       model.addAttribute("msg","successfully register");
			else
				   model.addAttribute("msg","not successfully register");
		}
		else
		{
			if(categoryDAO.updateCategory(c))
			       model.addAttribute("msg","successfully updated");
			else
				   model.addAttribute("msg","not successfully updated");
		}
		return "redirect:/CategoryAdd";
	}
	
	
@RequestMapping("/updateCategory/{catId}")
public String updateCategory(@PathVariable("catId") String catId, Model model) {
	
		model.addAttribute("category", categoryDAO.getCategoryById(catId));
		model.addAttribute("listCategory", categoryDAO.getAllCategory());
		return "CategoryAdd";
	}
         

         @RequestMapping("/deleteCategory/{catId}")
         public String deleteCategory(@PathVariable("catId") String catId, Model model)
         {
        	 categoryDAO.deleteCategory(catId);
        	 return "redirect:/CategoryAdd";//URL MAP TO CATEGORY ADD
        
         }

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


