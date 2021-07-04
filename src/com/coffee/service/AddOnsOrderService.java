package com.coffee.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.coffee.bean.AddOnsOrder;

public interface AddOnsOrderService {
	void addOnsEntry(ArrayList<ArrayList<AddOnsOrder>> addonsorder) throws ClassNotFoundException, SQLException;
}
