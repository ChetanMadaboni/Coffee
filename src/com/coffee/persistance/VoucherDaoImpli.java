package com.coffee.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.coffee.bean.Voucher;
import com.coffee.helper.MYSQLConnection;

public class VoucherDaoImpli implements VoucherDao {

	@Override
	public Voucher checkVoucher(String voucherName) throws ClassNotFoundException, SQLException {
		Connection connection=MYSQLConnection.getConnection();
		Voucher voucher=new Voucher();
		PreparedStatement statement = connection.prepareStatement("select * from voucher where vname=?");
		statement.setString(1,voucherName);
		ResultSet rs=statement.executeQuery();
		while(rs.next()) {
			voucher.setVname(rs.getString("vname"));
			voucher.setPrice(rs.getInt("vprice"));;
		}
		
		return voucher;
	}

}
