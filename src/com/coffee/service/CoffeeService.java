package com.coffee.service;

import java.sql.SQLException;
import java.util.Collection;

import com.coffee.bean.AddOns;
import com.coffee.bean.Coffee;
import com.coffee.bean.Customer;
import com.coffee.bean.Size;


public interface CoffeeService {
	boolean insertCustomer(Customer customer) throws ClassNotFoundException, SQLException;
	public Customer checkCustomer(Customer customer) throws ClassNotFoundException, SQLException;
	Collection<Coffee> getCoffees()throws SQLException, ClassNotFoundException;
	Collection<AddOns> getAddOns()throws SQLException, ClassNotFoundException;
	Collection<Size> getSize()throws SQLException, ClassNotFoundException;
}
