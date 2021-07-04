package com.coffee.persistance;

import java.sql.SQLException;
import java.util.Collection;

import com.coffee.bean.AddOns;

public interface AddOnDao {
	Collection<AddOns> getAddons()throws SQLException, ClassNotFoundException;
}
