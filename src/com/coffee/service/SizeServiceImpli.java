package com.coffee.service;

import java.sql.SQLException;
import java.util.Collection;

import com.coffee.bean.Size;
import com.coffee.persistance.SizeDao;
import com.coffee.persistance.SizeDaoImpli;

public class SizeServiceImpli implements SizeService {
	private SizeDao sizeDao=new SizeDaoImpli();
	@Override
	public Collection<Size> getSize() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return sizeDao.getSize();
	}

}
