package com.abcShopApp.dao;

import java.util.List;

import com.abcShopApp.dto.Product;

public interface ProductDao {

	void save(Product product);
	
	Product findById(int productId);
	
	List <Product>findAll();
	
}
