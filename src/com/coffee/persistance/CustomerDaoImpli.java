package com.coffee.persistance;

import java.sql.Connection; 

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.coffee.bean.Customer;
import com.coffee.helper.MYSQLConnection;


public class CustomerDaoImpli implements CustomerDao {
	
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

	

	


}
