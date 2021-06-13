package com.coffee.presentation;

import java.sql.SQLException;
import java.util.ArrayList;

import com.coffee.bean.Customer;
import com.coffee.bean.Order;
import com.coffee.bean.Voucher;

public interface CoffeePresentation {
	void checkCustomer();
	void showMenu();
	void showAddOns();
	void showSize();
	void orderEntry(ArrayList<Order> orders);
	Voucher checkVoucher(String vouchername);
	void getBill(Voucher voucher);
	void setStatus() throws ClassNotFoundException, SQLException;
}
