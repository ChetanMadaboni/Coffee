package com.coffee.service;

import java.sql.SQLException;
import java.util.Collection;

import com.coffee.bean.AddOns;
import com.coffee.persistance.AddOnDao;
import com.coffee.persistance.AddOnDaoImpli;

public class AddOnServiceImpli implements AddOnService {
	private AddOnDao addondao=new AddOnDaoImpli();
	@Override
	public Collection<AddOns> getAddOns() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return addondao.getAddons();
	}

}
