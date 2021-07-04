package com.coffee.service;

import java.sql.SQLException;
import java.util.Collection;

import com.coffee.bean.Coffee;

public interface CoffeeService {
	Collection<Coffee> getCoffees()throws SQLException, ClassNotFoundException;
}
