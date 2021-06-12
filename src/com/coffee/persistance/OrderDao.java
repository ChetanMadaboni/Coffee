package com.coffee.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.coffee.bean.Coffee;
import com.coffee.bean.Order;
import com.coffee.helper.MYSQLConnection;


public interface OrderDao {
	void orderEntry(ArrayList<Order> orders,String name) throws ClassNotFoundException, SQLException;
	

}
