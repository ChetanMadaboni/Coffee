package com.coffee.service;

import java.sql.SQLException;
import java.util.Collection;

import com.coffee.bean.Bill;
import com.coffee.persistance.BillDaoImpli;

public class BillServiceImpli implements BillService {
	private BillDaoImpli billdaoimpli=new BillDaoImpli();
	@Override
	public Collection<Bill> getBill() throws SQLException, ClassNotFoundException {
		return billdaoimpli.getBill();
	}
	@Override
	public void setStatus() throws ClassNotFoundException, SQLException {
		billdaoimpli.setStatus();
		
	}
	

}
