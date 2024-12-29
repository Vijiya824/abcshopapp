package com.abcShopApp.main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.abcShopApp.util.DBUtil;

public class Main {

	public static void main(String[] args) {

		// Presentation
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter customer Id :");
		int customerId = sc.nextInt();

		System.out.println("Enter product Id :");
		int pId = sc.nextInt();

		System.out.println("Enter Quantity Id :");
		int qty = sc.nextInt();

		sc.close();
		
		int productId = 0;
		String productName = null;
		double productPrice = 0.0;
		Date mfd = null;
		String category = null;

		// Connect to Database
		// Data Access
		String sql = "select * from product_tbl where product_id=?";

		try (Connection con = DBUtil.getDBConnection(); 
				PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setInt(1, pId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				productId = rs.getInt(1);
				productName = rs.getString(2);
				productPrice = rs.getDouble(3);
				mfd = rs.getDate(4);
				category = rs.getString(5);
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Service Logic
		// calculate order amount=product price*qty+gst 5%

		double totalPrice = productPrice * qty;

		System.out.println("Total Price :" + totalPrice);

		double orderAmount = totalPrice + (totalPrice * 0.05);

		//Presentation
		System.out.println("Order Amount :" + orderAmount);
	}

}
