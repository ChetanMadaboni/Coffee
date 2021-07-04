package com.coffee.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.coffee.bean.AddOns;
import com.coffee.bean.AddOnsOrder;
import com.coffee.helper.MYSQLConnection;

public class AddOnOrderDaoImpli implements AddOnOrderDao {

	@Override
	public void orderEntry(ArrayList<ArrayList<AddOnsOrder>> addonorders) throws ClassNotFoundException, SQLException {
		for(int i=0;i<addonorders.size();i++) {
		for(AddOnsOrder add:addonorders.get(i)) {
			Connection connection = MYSQLConnection.getConnection();
			PreparedStatement addstatement = connection.prepareStatement("select * from addons where addonid=?");
			AddOns addon=new AddOns();	
			addstatement.setInt(1,add.getAddonid());
			ResultSet rs=addstatement.executeQuery();
			while(rs.next()) {
				addon.setName(rs.getString("addonname"));
				addon.setAddOnPrice(rs.getInt("addonprice"));
			}
			PreparedStatement billstatement = connection.prepareStatement("insert into orderaddons (cid,addon,addonprice,addonid) values (?,?,?,?)");
			billstatement.setInt(1,add.getCoffeeid());
			billstatement.setString(2, addon.getName());
			billstatement.setInt(3, addon.getAddOnPrice());
			billstatement.setInt(4, add.getAddonid());
			billstatement.executeUpdate();
		}
		}
	}

	

}
