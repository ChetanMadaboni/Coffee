package com.coffee.persistance;

import java.sql.SQLException; 

import com.coffee.bean.Customer;


public interface CustomerDao {
	boolean insertCustomer(Customer customer) throws SQLException, ClassNotFoundException;
	Customer checkCustomer(Customer customer) throws ClassNotFoundException, SQLException;
	
}
