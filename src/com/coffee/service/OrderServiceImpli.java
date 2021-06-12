package com.coffee.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.coffee.bean.Order;
import com.coffee.persistance.OrderDao;
import com.coffee.persistance.OrderDaoImpli;


public class OrderServiceImpli implements OrderService {
	OrderDao orderDao=new OrderDaoImpli();
	@Override
	public void orderEntry(ArrayList<Order> orders,String name) throws ClassNotFoundException, SQLException {
		
		orderDao.orderEntry(orders,name);
	}

}
