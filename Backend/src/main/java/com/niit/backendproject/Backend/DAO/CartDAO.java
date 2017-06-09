package com.niit.backendproject.Backend.DAO;

import java.io.IOException;
import java.util.List;

import com.niit.backendproject.Backend.model.Cart;

public interface CartDAO {






    

	public boolean delete(int id);
    public List<Cart> getCartList(String username);
    public boolean save(Cart cart) ;
	public boolean update(Cart cart) ;
	public int getQuantity(String username, String productname);
	public long getTotalAmount(String username);
	public long getNumberOfProducts(String username);
	public Cart getCartById(int id);
	public int clearCart(String username);
	public Cart validate(int cartId) throws IOException ;
	public Cart getCartByUsername(String username, String proName);
	;

}
