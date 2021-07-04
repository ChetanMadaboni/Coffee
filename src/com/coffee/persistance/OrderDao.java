package com.coffee.persistance;


import java.sql.SQLException;
import java.util.ArrayList;


import com.coffee.bean.Order;



public interface OrderDao {
	void orderEntry(ArrayList<Order> orders,String name) throws ClassNotFoundException, SQLException;
	

}
