package com.coffee.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.coffee.bean.AddOns;
import com.coffee.bean.Coffee;
import com.coffee.bean.Order;
import com.coffee.bean.Size;
import com.coffee.helper.MYSQLConnection;

public class OrderDaoImpli implements OrderDao{
	private int total;
	private int row=0;
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
		PreparedStatement addstatement = connection.prepareStatement("select * from addons where addonid=?");
		AddOns addon=new AddOns();	
		addstatement.setInt(1,order.getAddonid());
		rs=addstatement.executeQuery();
		while(rs.next()) {
			addon.setName(rs.getString("addonname"));
			addon.setAddOnPrice(rs.getInt("addonprice"));;
		}
		PreparedStatement sizestatement = connection.prepareStatement("select * from size where sizeid=?");
		Size size=new Size();
		sizestatement.setInt(1,order.getSizeid());
		rs=sizestatement.executeQuery();
		while(rs.next()) {
			size.setSizename(rs.getString("sizename"));
			size.setSizeprice(rs.getInt("sizeprice"));
		}
		int row=coffee.getCoffeePrice()+addon.getAddOnPrice()+size.getSizeprice();
		PreparedStatement billstatement = connection.prepareStatement("insert into bill (customername,coffeename,addonname,sizename,coffeeprice) values (?,?,?,?,?)");
		billstatement.setString(1,name);
		billstatement.setString(2, coffee.getCoffeeName());
		billstatement.setString(3, addon.getName());
		billstatement.setString(4,size.getSizename());
		billstatement.setInt(5,row);
		billstatement.executeUpdate();
		total+=row;
		System.out.println("  "+coffee.getCoffeeName()+"  "+addon.getName()+"  "+size.getSizename()+"  "+row);
	}
		
	}
}
