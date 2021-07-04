package com.coffee.service;

import java.sql.SQLException;

import com.coffee.bean.Customer;
import com.coffee.persistance.CustomerDao;
import com.coffee.persistance.CustomerDaoImpli; 


public class CustomerServiceImpli implements CustomerService {
	private CustomerDao coffeedao=new CustomerDaoImpli();
	@Override
	public boolean insertCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		
		return coffeedao.insertCustomer(customer);
	}
	@Override
	public Customer checkCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		Customer c= coffeedao.checkCustomer(customer);
		return c;
	}
	
	

}
