package com.coffee.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.coffee.bean.AddOns;
import com.coffee.helper.MYSQLConnection;

public class AddOnDaoImpli implements AddOnDao {

	@Override
	public Collection<AddOns> getAddons() throws SQLException, ClassNotFoundException {
		
		ArrayList<AddOns> addonsarr = null;
		Connection connection = MYSQLConnection.getConnection();

		PreparedStatement statement = connection.prepareStatement("select * from addons");
		ResultSet resultset = statement.executeQuery();

		AddOns addons = null;
		addonsarr = new ArrayList<AddOns>();

		while (resultset.next()) {
			addons = new AddOns();
			addons.setAddOnId(resultset.getInt("addonid"));
			addons.setName(resultset.getString("addonname"));
			addons.setAddOnPrice(resultset.getInt("addonprice"));
			addonsarr.add(addons);
		}

		connection.close();

		return addonsarr;
	}

}
