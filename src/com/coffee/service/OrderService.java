package com.coffee.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.coffee.bean.Order;

public interface OrderService {
		void orderEntry(ArrayList<Order> orders,String name) throws ClassNotFoundException, SQLException;
}
