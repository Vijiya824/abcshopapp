package com.abcShopApp.main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import com.abcShopApp.dto.Product;
import com.abcShopApp.util.DBUtil;

public class ProductInsertDemo {

	public static void main(String[] args) {
		
		LocalDate mfd=LocalDate.of(2000, 10, 07);
		
		Product product = new Product();
		product.setProductName("IphoneZs");
		product.setProductPrice(125000.00);
		product.setCategory("Mobile");
		//product.setMfd(mfd);
		product.setMfd(LocalDate.of(2001, 10, 8));
		
        String sql = "insert into product_tbl (product_name,product_price,mfd,category) values(?,?,?,?)";
		
		//try with resources
		
		try (Connection con = DBUtil.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setString(1, product.getProductName());
			ps.setDouble(2, product.getProductPrice());
			
			//Convert Local date SQL date
			
			Date sdate=Date.valueOf(product.getMfd());
			ps.setDate(3, sdate);
			ps.setString(4, product.getCategory());

			ps.executeUpdate();
			System.out.println("New Product added");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
