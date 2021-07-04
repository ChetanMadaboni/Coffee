package com.coffee.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.coffee.bean.Bill;
import com.coffee.bean.Voucher;
import com.coffee.persistance.BillDaoImpli;

public class BillServiceImpli implements BillService {
	private BillDaoImpli billdaoimpli=new BillDaoImpli();
	@Override
	public ArrayList getBill(Voucher voucher) throws SQLException, ClassNotFoundException {
		//return billdaoimpli.getBill();
		Collection<Bill> bill=billdaoimpli.getBill();
		Integer total=0;
		ArrayList<Object> arr=new ArrayList<Object>();
		for(Bill b:bill) {
			total+=b.getPrice();
		}
		
		Integer netValue=total-voucher.getPrice();
		Double gst=(0.18)*netValue;
		Double serviceTax=(0.08)*netValue;
		Double finaltotal= netValue+gst+serviceTax;
		arr.add(total);
		arr.add(voucher.getPrice());
		arr.add(netValue);
		arr.add(gst);
		arr.add(serviceTax);
		arr.add(finaltotal);
		return arr;
		
	}
	@Override
	public void setStatus() throws ClassNotFoundException, SQLException {
		billdaoimpli.setStatus();
		
	}
	@Override
	public Collection<Bill> billdetails() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return billdaoimpli.getBill();
	}
	

}
