package com.coffee.service;

import java.sql.SQLException;
import java.util.Collection;

import com.coffee.bean.Bill;

public interface BillService {
	Collection<Bill> getBill()throws SQLException, ClassNotFoundException;
	void setStatus() throws ClassNotFoundException, SQLException;
}
