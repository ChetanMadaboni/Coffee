package com.coffee.persistance;

import java.sql.SQLException;
import java.util.Collection;

import com.coffee.bean.Coffee;

public interface CoffeeDao {
	Collection<Coffee> getCoffees()throws SQLException, ClassNotFoundException;
}
