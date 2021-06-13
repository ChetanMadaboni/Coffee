package com.coffee.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.coffee.bean.Bill;
import com.coffee.bean.Coffee;
import com.coffee.helper.MYSQLConnection;

public class BillDaoImpli implements BillDao {

	@Override
	public Collection<Bill> getBill() throws SQLException, ClassNotFoundException {
		ArrayList<Bill> bills = null;
		Connection connection = MYSQLConnection.getConnection();

		PreparedStatement statement = connection.prepareStatement("select * from bill where status=0");
		ResultSet resultset = statement.executeQuery();

		Bill bill = null;
		bills = new ArrayList<Bill>();

		while (resultset.next()) {
			bill = new Bill();
			bill.setCustomerName(resultset.getString("customername"));
			bill.setCoffeeName(resultset.getString("coffeename"));
			bill.setAddOn(resultset.getString("addonname"));
			bill.setSize(resultset.getString("sizename"));
			bill.setPrice(resultset.getInt("coffeeprice"));
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


}
