package com.coffee.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.coffee.bean.AddOns;
import com.coffee.bean.AddOnsOrder;
import com.coffee.bean.Coffee;
import com.coffee.bean.Order;
import com.coffee.bean.Size;
import com.coffee.helper.MYSQLConnection;

public class OrderDaoImpli implements OrderDao{
	
	@Override
	public void orderEntry(ArrayList<Order> orders,String name) throws ClassNotFoundException, SQLException {
		for(Order order:orders) {
		Connection connection = MYSQLConnection.getConnection();
		PreparedStatement statement = connection.prepareStatement("select * from coffees where cid=?");
		Coffee coffee=new Coffee();	
		statement.setInt(1,order.getCoffeeid());
		ResultSet rs=statement.executeQuery();
		while(rs.next()) {
			coffee.setCoffeeName(rs.getString("coffeename"));
			coffee.setCoffeePrice(rs.getInt("coffeeprice"));
		}
		int total=0;
		HashMap<Integer,String> hm=new HashMap<Integer,String>();
		for(AddOnsOrder add:order.getAddonsorder()) {
		PreparedStatement addstatement = connection.prepareStatement("select * from addons where addonid=?");
		AddOns addon=new AddOns();	
		addstatement.setInt(1,add.getAddonid());
		rs=addstatement.executeQuery();
		while(rs.next()) {
			total+=rs.getInt("addonprice");
			if(hm.containsKey(add.getCoffeeid())) {
				hm.put(add.getCoffeeid(), hm.get(add.getCoffeeid())+" "+rs.getString("addonname"));
			}else {
				hm.put(add.getCoffeeid(), rs.getString("addonname"));
			}
		}
		}
		//System.out.println(hm);
		PreparedStatement sizestatement = connection.prepareStatement("select * from size where sizeid=?");
		Size size=new Size();
		sizestatement.setInt(1,order.getSizeid());
		rs=sizestatement.executeQuery();
		while(rs.next()) {
			size.setSizename(rs.getString("sizename"));
			size.setSizeprice(rs.getInt("sizeprice"));
		}
		PreparedStatement billstatement = connection.prepareStatement("insert into bill (customername,coffeename,coffeeid,sizename,coffeeprice,datedetails) values (?,?,?,?,?,CURRENT_TIMESTAMP)");
		billstatement.setString(1,name);
		billstatement.setString(2, coffee.getCoffeeName());
		billstatement.setInt(3, order.getCoffeeid());
		billstatement.setString(4,size.getSizename());
		billstatement.setInt(5,coffee.getCoffeePrice()+size.getSizeprice()+total);
		billstatement.executeUpdate();
	}
		
	}
}
