package com.abcShopApp.dao;

import java.util.List;

import com.abcShopApp.dto.Invoice;

public interface InvoiceDao {

	void save(Invoice invoice);
	
	Invoice findById(int invoiceNo);
	
	List<Invoice> findAll();
}
