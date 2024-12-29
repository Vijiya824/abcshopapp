package com.abcShopApp.main;

import java.util.Scanner;

import com.abcShopApp.service.ProductService;
import com.abcShopApp.service.ProductServiceImpl;

public class ProductMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter customer Id :");
		int customerId = sc.nextInt();

		System.out.println("Enter product Id :");
		int pId = sc.nextInt();

		System.out.println("Enter Quantity Id :");
		int qty = sc.nextInt();
		
		sc.close();
		
		ProductService productService=new ProductServiceImpl();
		double orderAmount = productService.calculateOrderAmout(customerId, pId, qty);
		
		System.out.println("Order Amount :"+orderAmount);

	}

}
