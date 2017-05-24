package com.compass.dao;
import com.compass.dao.base.IDaoBase;
import com.compass.entities.User;
public interface DaoUser extends IDaoBase<User> {

	public User getUserByEmail(String email);
	
	public User getUserByUserId(Integer integer);
	
	public User getSecurityCodeByUserId(int userId,String sCode);
}
