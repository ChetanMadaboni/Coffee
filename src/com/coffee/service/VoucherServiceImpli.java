package com.coffee.service;

import java.sql.SQLException;

import com.coffee.bean.Voucher;
import com.coffee.persistance.VoucherDao;
import com.coffee.persistance.VoucherDaoImpli;

public class VoucherServiceImpli implements VoucherService {
	private VoucherDao voucherdao=new VoucherDaoImpli(); 
	@Override
	public Voucher checkVoucher(String voucherName) throws ClassNotFoundException, SQLException {
		return voucherdao.checkVoucher(voucherName);
	}

}
