package com.coffee.service;

import java.sql.SQLException;
import java.util.Collection;

import com.coffee.bean.Coffee;
import com.coffee.persistance.CoffeeDao;
import com.coffee.persistance.CoffeeDaoImpli;

public class CoffeeServiceImpli implements CoffeeService {
	CoffeeDao coffeedao=new CoffeeDaoImpli();
	@Override
	public Collection<Coffee> getCoffees() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return coffeedao.getCoffees();
	}

}
