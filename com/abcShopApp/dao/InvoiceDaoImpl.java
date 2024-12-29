package com.abcShopApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.abcShopApp.dto.Invoice;
import com.abcShopApp.util.DBUtil;

public class InvoiceDaoImpl implements InvoiceDao{

	@Override
	public void save(Invoice invoice) {
		
		
	}

	@Override
	public Invoice findById(int invoiceNo) {
		String sql = "select * from invoice_tbl where invoice_no = ?";
		Invoice invoice=null;
		try (Connection con = DBUtil.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, invoiceNo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	
           
				
                invoice = new Invoice();
                invoice.setInvoice(rs.getInt(1));
                invoice.setProductName(rs.getString(2));
                invoice.setUnitPrice(rs.getDouble(3));
                invoice.setCustomerName(rs.getString(4));
                invoice.setEmail(rs.getString(5));
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return invoice;
		
		
	}

	@Override
	public List<Invoice> findAll() {
		List<Invoice> invoices = new ArrayList<>();
        String sql = "select * from invoice_tbl";
        try (Connection con = DBUtil.getDBConnection(); Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Invoice invoice = new Invoice();
                invoice.setInvoice(rs.getInt(1));
                invoice.setProductName(rs.getString(2));
                invoice.setUnitPrice(rs.getDouble(3));
                invoice.setCustomerName(rs.getString(4));
                invoice.setEmail(rs.getString(5));
                invoice.setQty(rs.getInt(6));
                invoice.setTotalCost(rs.getDouble(7));
                invoice.setGst(rs.getDouble(8));
                invoice.setOrderAmount(rs.getDouble(9));
                invoices.add(invoice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return invoices;
	}

	
}
