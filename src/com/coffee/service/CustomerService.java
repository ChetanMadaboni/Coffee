package com.coffee.service;

import java.sql.SQLException;

import com.coffee.bean.Customer; 



public interface CustomerService {
	boolean insertCustomer(Customer customer) throws ClassNotFoundException, SQLException;
	public Customer checkCustomer(Customer customer) throws ClassNotFoundException, SQLException;
	
	
}
