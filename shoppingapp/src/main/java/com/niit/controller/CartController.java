package com.niit.controller;
import java.security.Principal;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.backendproject.Backend.DAO.CartDAO;
import com.niit.backendproject.Backend.DAO.ProductDAO;
import com.niit.backendproject.Backend.DAO.UserDAO;
import com.niit.backendproject.Backend.model.Cart;
import com.niit.backendproject.Backend.model.Customer;
import com.niit.backendproject.Backend.model.Product;




@Controller

public class CartController {

	
	
	

	@Autowired(required=true)
	private Cart cart;

	@Autowired
	private CartDAO cartDAO;

	@Autowired
	private Product product;

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private HttpSession session;

	@RequestMapping("/all")
	public String getCart() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		String loggedInUsername = username;
		session.setAttribute("numberProducts", cartDAO	.getNumberOfProducts(loggedInUsername));
		session.setAttribute("cartList", cartDAO.getCartList(loggedInUsername));
		session.setAttribute("totalAmount", cartDAO.getTotalAmount(loggedInUsername));
		return "Cart";
	}

	@RequestMapping(value = "/addToCart/{id}")

	public String addToCart(@PathVariable("id") int id, RedirectAttributes redirect, Model model,Principal p) {
		
System.out.println("addtocart");
		try {
			Cart cart = new Cart();
			Product product = productDAO.getProductId(id);
		
			cart. setProductName(product.getProName());
			cart.setPrice1(product.getPrice());
			cart.setDateAdded(new Date());

			/*if (loggedInUsername == null) {

				Authentication auth = SecurityContextHolder.getContext().getAuthentication();
				String username = auth.getName();
				loggedInUsername = username;

			}*/
			
		String username=p.getName();
		System.out.println("username: "+username);
			cart.setUsername(username);
			cart.setStatus("NEW");
			Customer customer =userDAO.getUserByCustomerName(username);
			System.out.println(customer.getId());
			cart.setCustomer_id(customer.getId());
			Cart existCart = cartDAO.getCartByUsername(username, cart.getProductName());
			System.out.println(product.getProName());
			if (existCart != null) {
				int currentQuantity = cartDAO.getQuantity(username, cart.getProductName());
				cart.setId(existCart.getId());
				cart.setQuantity(currentQuantity + 1);
				boolean flag = cartDAO.update(cart);

				if (flag) {

					redirect.addFlashAttribute("success", product.getProName() + " " + "Successfully added to cart!");
					session.setAttribute("numberProducts", cartDAO.getNumberOfProducts(username));
					return "redirect:/all";

				} else {
					redirect.addFlashAttribute("error", "Failed to add product to cart!");
					return "redirect:/CatProduct";
				}
			} else {
				System.out.println("first time product is going to add");
				cart.setQuantity(1);
				boolean flag = cartDAO.save(cart);

				if (flag) {

					redirect.addFlashAttribute("success", product.getProName() + " " + "Successfully added to cart!");
					session.setAttribute("numberProducts", cartDAO.getNumberOfProducts(username));
					return "Cart";

				} else {
					redirect.addFlashAttribute("error", "Failed to add product to cart!");
					return "redirect:/CatProduct";
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("catchError", "Server is not responding please try again letter.");
			return "Cart";
		}
	}

	@RequestMapping("/deleteItem/{id}")
	public String deleteCartItem(@PathVariable("id") int id, Model model, RedirectAttributes redirect) {
			try {
			Cart cart = cartDAO.getCartById(id);

			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String username = auth.getName();

			int checkQ = cartDAO.getQuantity(username, cart.getProductName());

			if (checkQ > 1) {
				cart.setQuantity(checkQ - 1);
				cartDAO.update(cart);
				redirect.addFlashAttribute("success", "Cart updated successfully.");
				return "redirect:/all";
			} else {
				// cart.setStatus("OLD");
				cartDAO.delete(id);
				redirect.addFlashAttribute("success", "Item removed successfully.");
				return "redirect:/all";
			}
		} catch (Exception e) {
			model.addAttribute("catchError", "Server is not responding please try again letter.");
			return "error";
		}
	}

	@RequestMapping("/clearCart")
	public String clearCart(RedirectAttributes redirect, Model model) {
		
		try {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String username = auth.getName();
			int flag = cartDAO.clearCart(username);

			if (flag >= 1) {
				redirect.addFlashAttribute("success", "All Items removed successfully.");
				return "redirect:/all";
			} else {
				redirect.addFlashAttribute("error", "Failed to clear cart!");
				return "redirect:/all";
			}

		} catch (Exception e) {
			// TODO: handle exception
			
			model.addAttribute("catchError", "Server is not responding please try again letter.");
			return "error";
		}
	}
	
	
}
