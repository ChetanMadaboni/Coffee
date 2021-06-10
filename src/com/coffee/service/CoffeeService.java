package com.coffee.service;

import java.sql.SQLException;
import java.util.Collection;

import com.coffee.bean.Coffee;
import com.coffee.bean.Customer;


public interface CoffeeService {
	boolean insertCustomer(Customer customer) throws ClassNotFoundException, SQLException;
	public Customer checkCustomer(Customer customer) throws ClassNotFoundException, SQLException;
	Collection<Coffee> getCoffees()throws SQLException, ClassNotFoundException;
}
