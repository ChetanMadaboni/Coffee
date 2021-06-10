package com.coffee.persistance;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.coffee.bean.Coffee;
import com.coffee.bean.Customer;
import com.coffee.helper.MYSQLConnection;


public class CoffeeDaoImpli implements CoffeeDao {
	
	@Override
	public boolean insertCustomer(Customer customer) throws SQLException, ClassNotFoundException {
		Connection connection = MYSQLConnection.getConnection();
		PreparedStatement statement = connection.prepareStatement("insert into customer (phonenumber,name) values (?,?)");
		statement.setString(1,customer.getPhoneNumber());
		statement.setString(2, customer.getCustomerName());
		int rows=statement.executeUpdate();
		if(rows>0) {
			return true;
		}
		return false;
	}

	@Override
	public Customer checkCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		Connection connection=MYSQLConnection.getConnection();
		Customer s=new Customer();
		PreparedStatement statement = connection.prepareStatement("select * from customer where phonenumber=?");
		statement.setString(1,customer.getPhoneNumber());
		ResultSet rs=statement.executeQuery();
		while(rs.next()) {
			s.setCustomerName(rs.getString("name"));
			s.setPhoneNumber(rs.getString("phonenumber"));
		}
		return s;
	}

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