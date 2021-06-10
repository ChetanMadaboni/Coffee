package com.coffee.service;

import java.sql.SQLException;
import java.util.Collection;

import com.coffee.bean.AddOns;
import com.coffee.bean.Coffee;
import com.coffee.bean.Customer;
import com.coffee.bean.Size;
import com.coffee.persistance.CoffeeDao;
import com.coffee.persistance.CoffeeDaoImpli;

public class CoffeeServiceImpli implements CoffeeService {
	private CoffeeDao coffeedao=new CoffeeDaoImpli();
	@Override
	public boolean insertCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		
		return coffeedao.insertCustomer(customer);
	}
	@Override
	public Customer checkCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		Customer c= coffeedao.checkCustomer(customer);
		return c;
	}
	@Override
	public Collection<Coffee> getCoffees() throws SQLException, ClassNotFoundException {
		return coffeedao.getCoffees();
	}
	@Override
	public Collection<AddOns> getAddOns() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return coffeedao.getAddons();
	}
	@Override
	public Collection<Size> getSize() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return coffeedao.getSize();
	}

}
