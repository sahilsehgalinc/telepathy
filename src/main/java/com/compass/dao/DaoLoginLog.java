package com.compass.dao;

import com.compass.dao.base.IDaoBase;
import com.compass.entities.LoginLog;

public interface DaoLoginLog extends IDaoBase<LoginLog> {

	LoginLog getLastLoginUserByUserId(int parseInt);
	
}
