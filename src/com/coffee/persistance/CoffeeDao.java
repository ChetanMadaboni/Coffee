package com.coffee.persistance;

import java.sql.SQLException;
import java.util.Collection;

import com.coffee.bean.Coffee;
import com.coffee.bean.Customer;

public interface CoffeeDao {
	boolean insertCustomer(Customer customer) throws SQLException, ClassNotFoundException;
	Customer checkCustomer(Customer customer) throws ClassNotFoundException, SQLException;
	Collection<Coffee> getCoffees()throws SQLException, ClassNotFoundException;
}
