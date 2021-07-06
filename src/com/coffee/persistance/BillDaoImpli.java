package com.coffee.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import com.coffee.bean.AddOnsOrder;
import com.coffee.bean.Bill;
import com.coffee.bean.Coffee;
import com.coffee.helper.MYSQLConnection;

public class BillDaoImpli implements BillDao {

	@Override
	public Collection<Bill> getBill() throws SQLException, ClassNotFoundException {
		Connection connection = MYSQLConnection.getConnection();
		PreparedStatement state=connection.prepareStatement("select * from orderaddons where status=0");
		ResultSet rs = state.executeQuery();
		HashMap<Integer,String> hm=new HashMap<Integer,String>();
		
		while (rs.next()) {
			if(hm.containsKey(rs.getInt("cid"))) {
				hm.put(rs.getInt("cid"), hm.get(rs.getInt("cid"))+" "+rs.getString("addon"));
			}else {
				hm.put(rs.getInt("cid"), rs.getString("addon"));
			}
		}
		//System.out.println(hm);
		ArrayList<Bill> bills = null;
	

		PreparedStatement statement = connection.prepareStatement("select * from bill where status=0");
		ResultSet resultset = statement.executeQuery();

		Bill bill = null;
		bills = new ArrayList<Bill>();

		while (resultset.next()) {
			bill = new Bill();
			bill.setCustomerName(resultset.getString("customername"));
			bill.setCoffeeName(resultset.getString("coffeename"));
			//bill.setAddOn(resultset.getString("addonname"));
			bill.setSize(resultset.getString("sizename"));
			bill.setPrice(resultset.getInt("coffeeprice"));
			bill.setDate(resultset.getString("datedetails"));
			bill.setAddOn(hm.get(resultset.getInt("coffeeid")));
			bills.add(bill);
		}

		connection.close();

		return bills;
	}
	
	@Override
	public void setStatus() throws ClassNotFoundException, SQLException {
		Connection connection = MYSQLConnection.getConnection();

		PreparedStatement statement = connection.prepareStatement("update bill set status=1 where status=0");
		int n  = statement.executeUpdate();
		connection.close();
	}

	@Override
	public void setAddonStatus() throws ClassNotFoundException, SQLException {
		Connection connection = MYSQLConnection.getConnection();

		PreparedStatement statement = connection.prepareStatement("update orderaddons set status=1 where status=0");
		int n  = statement.executeUpdate();
		connection.close();
		
	}

	


}
