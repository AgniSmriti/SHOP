package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.backendproject.Backend.DAO.SupplierDAO;
import com.niit.backendproject.Backend.model.Supplier;

@Controller
public class SupplierController {
	
	
	
	
	  @Autowired
	   SupplierDAO supplierDAO;
	   

		
		@RequestMapping("/SupplierAdd")
		public String AddSupp(Model model)
		{ 
		model.addAttribute("supplier",new Supplier());

		model.addAttribute("listSupplier",supplierDAO.getAllSupplier());
				return "SupplierAdd";
		}
		
		
		@RequestMapping("/manage_supplier")
		public String addSupplier(@ModelAttribute("supplier") Supplier s,Model model)
		{ 
			if(s.getSupId()==null || s.getSupId().isEmpty())
			{
				if(supplierDAO.addSupplier(s))
			   model.addAttribute("msg","successfully register");
			else
				model.addAttribute("msg","not successfully register");
	        
			}
			else
			{
				if(supplierDAO.updateSupplier(s))
					 model.addAttribute("msg","successfully updated");
				else
					model.addAttribute("msg","not successfully updated");
			}
				
				return "redirect:/SupplierAdd";
		}
		
		@RequestMapping("/updateSupplier/{supId}")
		public String updateSupplier(@PathVariable("supId") String supId, Model model) {
			
				model.addAttribute("supplier", supplierDAO.getSupplierById(supId));
				model.addAttribute("listSupplier", supplierDAO.getAllSupplier());
				return "SupplierAdd";
			}
		         

        @RequestMapping("/deleteSupplier/{supId}")
        public String deleteSupplier(@PathVariable("supId") String supId, Model model)
        {
       	 supplierDAO.deleteSupplier(supId);
       	 return "redirect:/SupplierAdd";
       
        }
}
