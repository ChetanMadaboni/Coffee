package com.coffee.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.coffee.bean.AddOnsOrder;
import com.coffee.bean.Bill;
import com.coffee.bean.Voucher;

public interface BillService {
	ArrayList getBill(Voucher voucher,ArrayList<ArrayList<AddOnsOrder>> arr)throws SQLException, ClassNotFoundException;
	void setStatus() throws ClassNotFoundException, SQLException;
	void setAddonStatus() throws ClassNotFoundException, SQLException;
	Collection<Bill> billdetails() throws SQLException, ClassNotFoundException;
}
