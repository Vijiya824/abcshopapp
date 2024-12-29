package com.abcShopApp.main;

import java.util.List;
import com.abcShopApp.dto.Product;
import com.abcShopApp.service.ProductService;
import com.abcShopApp.service.ProductServiceImpl;

public class FetchAllProductsMain {

	public static void main(String[] args) {
		
		ProductService productService = new ProductServiceImpl();
		List<Product> productList=productService.getAllProducts();
		
		productList.forEach(p->System.out.println(p.getProductId()+" "+p.getProductName()+" "+p.getProductPrice()));
		
	}

}
