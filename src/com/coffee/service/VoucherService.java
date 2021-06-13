package com.coffee.service;

import java.sql.SQLException;

import com.coffee.bean.Voucher;

public interface VoucherService {
	Voucher checkVoucher(String voucherName) throws ClassNotFoundException, SQLException;
}
