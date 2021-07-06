package com.coffee.persistance;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.coffee.bean.AddOnsOrder;
import com.coffee.bean.Bill;



public interface BillDao {
	Collection<Bill> getBill()throws SQLException, ClassNotFoundException;
	void setStatus() throws ClassNotFoundException, SQLException;
	void setAddonStatus() throws ClassNotFoundException, SQLException;
}
