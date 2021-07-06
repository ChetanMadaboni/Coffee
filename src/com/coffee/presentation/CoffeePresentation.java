package com.coffee.presentation;

import java.sql.SQLException;
import java.util.ArrayList;

import com.coffee.bean.AddOnsOrder;
import com.coffee.bean.Customer;
import com.coffee.bean.Order;
import com.coffee.bean.Voucher;

public interface CoffeePresentation {
	void checkCustomer();
	void showMenu();
	void showAddOns();
	void showSize();
	void addonsEntry(ArrayList<ArrayList<AddOnsOrder>> addonsorder);
	void orderEntry(ArrayList<Order> orders);
	Voucher checkVoucher(String vouchername);
	void displayBillDetails();
	void getBill(Voucher voucher,ArrayList<ArrayList<AddOnsOrder>> arr);
	void setStatus() throws ClassNotFoundException, SQLException;
	void setAddonStatus() throws ClassNotFoundException, SQLException;
}
