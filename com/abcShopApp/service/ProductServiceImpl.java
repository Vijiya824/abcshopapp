package com.abcShopApp.service;

import java.util.List;

import com.abcShopApp.dao.ProductDao;
import com.abcShopApp.dao.ProductDaoImpl;
import com.abcShopApp.dto.Product;

public class ProductServiceImpl implements ProductService{

	@Override
	public double calculateOrderAmout(int customerId, int productId, int qty) {
		
		//calling dao to get the product details
				ProductDao productDao = new ProductDaoImpl() {
				};
				
				Product product = productDao.findById(productId);
				
				double totalPrice = product.getProductPrice() * qty;
				
				//System.out.println("Total Price = "+totalPrice);
				
				double orderAmount = totalPrice + (totalPrice* 0.05);
				
				return orderAmount;
	}

	@Override
	public void addProduct(Product product) {
		
		ProductDao productDao = new ProductDaoImpl() {
		};
		productDao.save(product);
		
	}

	@Override
	public List<Product> getAllProducts() {
		ProductDao productDao = new ProductDaoImpl() {
		};
		List<Product> products = productDao.findAll();
		return products;
	}
	

}
