package com.abcShopApp.main;

import java.util.Scanner;

import com.abcShopApp.service.InvoiceService;
import com.abcShopApp.service.InvoiceServiceImpl;

public class InvoiceMain {

	public static void main(String[] args) {
		
Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Invoice Number");
		int invoiceNo = sc.nextInt();
		
		System.out.println("Enter Quantity");
		int qty = sc.nextInt();
		
		System.out.println("Enter Govt. Tax");
		int gst = sc.nextInt();
		
		
		sc.close();
		
		//calling service 
		InvoiceService productService = new InvoiceServiceImpl();
		double orderAmount = productService.calculateOrderAmount(invoiceNo,qty,gst);
		
		System.out.println("OrderAmount : "+orderAmount);;
	}

}
