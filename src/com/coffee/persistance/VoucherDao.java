package com.coffee.persistance;

import java.sql.SQLException;

import com.coffee.bean.Voucher;

public interface VoucherDao {
	Voucher checkVoucher(String voucherName) throws ClassNotFoundException, SQLException;
}
