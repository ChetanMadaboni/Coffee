package com.coffee.service;

import java.sql.SQLException;
import java.util.Collection;

import com.coffee.bean.Size;

public interface SizeService {
	Collection<Size> getSize()throws SQLException, ClassNotFoundException;
}
