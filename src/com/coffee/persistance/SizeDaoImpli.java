package com.coffee.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.coffee.bean.Size;
import com.coffee.helper.MYSQLConnection;

public class SizeDaoImpli implements SizeDao {

	@Override
	public Collection<Size> getSize() throws SQLException, ClassNotFoundException {
		ArrayList<Size> sizearr = null;
		Connection connection = MYSQLConnection.getConnection();

		PreparedStatement statement = connection.prepareStatement("select * from size");
		ResultSet resultset = statement.executeQuery();

		Size size = null;
		sizearr = new ArrayList<Size>();

		while (resultset.next()) {
			size = new Size();
			size.setSizeid(resultset.getInt("sizeid"));;
			size.setSizename(resultset.getString("sizename"));;
			size.setSizeprice(resultset.getInt("sizeprice"));;
			sizearr.add(size);
		}

		connection.close();

		return sizearr;
	}

}
