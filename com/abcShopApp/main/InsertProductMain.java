package com.abcShopApp.main;

import java.util.Scanner;

import com.abcShopApp.dto.Product;
import com.abcShopApp.service.ProductService;
import com.abcShopApp.service.ProductServiceImpl;

public class InsertProductMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Product name :");
		String productName = sc.next();

		System.out.println("Enter product price :");
		double productPrice = sc.nextInt();

		System.out.println("Enter MFD :");
		String mfd = sc.next();
		
		System.out.println("Enter Category :");
		String category = sc.next();
		
		Product product = new Product();
		product.setProductName(productName);
		product.setProductPrice(productPrice);
		product.setMfd(null);
		product.setCategory(category);
		
		ProductService productservice=new ProductServiceImpl();
		productservice.addProduct(product);;
		sc.close();
	}

}
