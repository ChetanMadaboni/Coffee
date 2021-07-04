package com.coffee.persistance;

import java.sql.SQLException;
import java.util.Collection;

import com.coffee.bean.Size;

public interface SizeDao {
	Collection<Size> getSize()throws SQLException, ClassNotFoundException;
}
