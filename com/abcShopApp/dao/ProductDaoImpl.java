package com.abcShopApp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.abcShopApp.dto.Product;
import com.abcShopApp.main.ProductMain;
import com.abcShopApp.service.ProductServiceImpl;
import com.abcShopApp.dao.ProductDao;
import com.abcShopApp.util.DBUtil;

public abstract class ProductDaoImpl implements ProductDao{

	@Override
	public void save(Product product) {
		String sql = "insert into product_tbl (product_name,product_price,mfd,category) values(?,?,?,?)";
		
		//try with resources
		
		try (Connection con = DBUtil.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setString(1, product.getProductName());
			ps.setDouble(2, product.getProductPrice());
			ps.setDate(3, null);
			ps.setString(4, product.getCategory());

			ps.executeUpdate();
			System.out.println("New Product added");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Product findById(int productId) {
		
		String sql = "select * from product_tbl where product_id=?";
		Product product=null;
		
		try (Connection con = DBUtil.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setInt(1, productId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int pId = rs.getInt(1);
				String productName = rs.getString(2);
				double productPrice = rs.getDouble(3);
				Date mfd = rs.getDate(4);
				String category = rs.getString(5);
				
				product=new Product();
				product.setProductId(pId);
				product.setProductName(productName);
				product.setProductPrice(productPrice);
				product.setMfd(null);
				product.setCategory(category);
			}

			ps.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public List<Product> findAll() {
		
		List<Product> products = new ArrayList<>();
		
		String sql="select * from product_tbl";
		
		try(Connection con=DBUtil.getDBConnection();
				Statement st=con.createStatement();){
			
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				int pId = rs.getInt(1);
				String productName = rs.getString(2);
				double productPrice = rs.getDouble(3);
				Date mfd = rs.getDate(4);
				String category = rs.getString(5);
				
				Product product=new Product();
				product=new Product();
				product.setProductId(pId);
				product.setProductName(productName);
				product.setProductPrice(productPrice);
				product.setMfd(null);
				product.setCategory(category);
				
				products.add(product);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return products;
	}

}
