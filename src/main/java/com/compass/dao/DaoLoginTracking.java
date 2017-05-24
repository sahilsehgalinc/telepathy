
package com.compass.dao;

import com.compass.dao.base.IDaoBase;
import com.compass.entities.LoginTracking;

public interface DaoLoginTracking extends IDaoBase<LoginTracking>{

	public int getLoginTrackingByEmail(String email);
}
