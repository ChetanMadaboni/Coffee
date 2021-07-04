package com.coffee.persistance;

import java.sql.SQLException;
import java.util.ArrayList;

import com.coffee.bean.AddOnsOrder;


public interface AddOnOrderDao {
	void orderEntry(ArrayList<ArrayList<AddOnsOrder>> orders) throws ClassNotFoundException, SQLException;
}
