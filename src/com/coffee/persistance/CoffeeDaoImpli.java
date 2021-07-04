package com.coffee.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.coffee.bean.Coffee;
import com.coffee.helper.MYSQLConnection;

public class CoffeeDaoImpli implements CoffeeDao {

	@Override
	public Collection<Coffee> getCoffees() throws SQLException, ClassNotFoundException {
		ArrayList<Coffee> coffees = null;
		Connection connection = MYSQLConnection.getConnection();

		PreparedStatement statement = connection.prepareStatement("select * from coffees");
		ResultSet resultset = statement.executeQuery();

		Coffee coffee = null;
		coffees = new ArrayList<Coffee>();

		while (resultset.next()) {
			coffee = new Coffee();
			coffee.setCoffeeId(resultset.getInt("cid"));
			coffee.setCoffeeName(resultset.getString("coffeename"));
			coffee.setCoffeePrice(resultset.getInt("coffeeprice"));
			coffees.add(coffee);
		}

		connection.close();

		return coffees;
	}

}
