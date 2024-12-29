package com.abcShopApp.service;

import java.util.List;

import com.abcShopApp.dto.Product;

public interface ProductService {

	double calculateOrderAmout(int customerId, int productId, int qty);
	
	void addProduct(Product product);
	
	List<Product> getAllProducts();
}
