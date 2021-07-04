package com.coffee.service;

import java.sql.SQLException;
import java.util.Collection;

import com.coffee.bean.AddOns;

public interface AddOnService {
	Collection<AddOns> getAddOns()throws SQLException, ClassNotFoundException;
}
