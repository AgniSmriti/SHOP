package com.niit.controller;

import java.io.FileOutputStream;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.backendproject.Backend.DAO.CategoryDAO;
import com.niit.backendproject.Backend.DAO.ProductDAO;
import com.niit.backendproject.Backend.DAO.SupplierDAO;
import com.niit.backendproject.Backend.model.Product;

@Controller
public class ProductController {
	
	   @Autowired
	   ProductDAO productDAO;
	   @Autowired
	  CategoryDAO categoryDAO;
	   
	   	@Autowired
	   	SupplierDAO supplierDAO;
		
		@RequestMapping("/ProductAdd")
		public String AddProduct(Model model)
		{ 
		model.addAttribute("product",new Product());

		model.addAttribute("listProduct",productDAO.getAllProduct());
		
		model.addAttribute("listCategory",categoryDAO.getAllCategory());
		model.addAttribute("listSupplier",supplierDAO.getAllSupplier());
		return "ProductAdd";
		
		}
		
		@RequestMapping("/manage_product")
		public String addProduct(@ModelAttribute("product") Product p, Model model,HttpServletRequest request)
		{ 
			

			if(p.getProId()==0)
			{
			if(productDAO.addProduct(p))
			{
				model.addAttribute("msg","data saved in database");
				MultipartFile file=p.getImage();
				HttpSession	session=request.getSession();
				ServletContext con=session.getServletContext();
				String filelocation=con.getRealPath("/resources/images/");
				System.out.println(filelocation);
				String filename=filelocation+"\\"+p.getProId()+".jpg";
				System.out.println(filename);

				try{
					byte b[]=file.getBytes();
					FileOutputStream fos=new FileOutputStream(filename);
					fos.write(b);
					fos.close();
			    	}
				catch(IOException ex){}
				catch(Exception e){
				}
			}
			else
			{
				model.addAttribute("msg", "data not saved in database");
			}
			    		
			}
			
			else
			{ System.out.println(2);
			}
		
		return "ProductAdd";
		
		}

	
	    @RequestMapping("/productbyCategory/{catId}")
		public String getproductbyCategory(@PathVariable("catId") String id,Model model)
		{
	    	
	    	model.addAttribute("listProducts",productDAO.getproductbyCategory(id));
	    	return "AllProducts";
				
	    	
	    	
		}
		
		
		
		
}
