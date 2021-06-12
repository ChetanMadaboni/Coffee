package com.coffee.presentation;

import java.util.ArrayList;

import com.coffee.bean.Customer;
import com.coffee.bean.Order;

public interface CoffeePresentation {
	void checkCustomer();
	void showMenu();
	void showAddOns();
	void showSize();
	void orderEntry(ArrayList<Order> orders);
}
