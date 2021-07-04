package com.coffee.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.coffee.bean.AddOnsOrder;
import com.coffee.persistance.AddOnDaoImpli;
import com.coffee.persistance.AddOnOrderDao;
import com.coffee.persistance.AddOnOrderDaoImpli;

public class AddOnsOrderServiceImpli implements AddOnsOrderService {
	private AddOnOrderDao addon=new AddOnOrderDaoImpli();
	@Override
	public void addOnsEntry(ArrayList<ArrayList<AddOnsOrder>> addonsorder) throws ClassNotFoundException, SQLException {
			addon.orderEntry(addonsorder);
	}

}
