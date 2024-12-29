package com.abcShopApp.service;

import java.util.List;

import com.abcShopApp.dao.InvoiceDao;
import com.abcShopApp.dao.InvoiceDaoImpl;
import com.abcShopApp.dto.Invoice;

public class InvoiceServiceImpl implements InvoiceService {

	@Override
	public void createInvoice(Invoice invoice) {
		// TODO Auto-generated method stub

	}

	@Override
	public double calculateOrderAmount(int invoiceNo, int qty, double gst) {
		InvoiceDao invoiceDao = new InvoiceDaoImpl();

		Invoice Invoice = invoiceDao.findById(invoiceNo);

		double totalCost = Invoice.getUnitPrice() * qty;

		double orderAmount = totalCost + ((totalCost * gst) / 100);

		return orderAmount;
	}

	@Override
	public List<Invoice> getAllInvoices() {
		// TODO Auto-generated method stub
		return null;
	}

}
