package com.compass.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.compass.dao.DaoUser;
import com.compass.dao.base.DaoBase;
import com.compass.entities.User;
import java.util.List;

@Repository(value = "daoUser")
public class DaoUserImpl extends DaoBase<User> implements DaoUser {

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public User getUserByEmail(String email) {

		List<User> list = sessionFactory.getCurrentSession()
				.createQuery("from User where email=:email ").setString("email", email)
				.setCacheable(true).list();
		return list.size() > 0 ? list.get(0) : null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public User getUserByUserId(Integer integer) {
		User user = (User) sessionFactory.getCurrentSession().createQuery("from User where userId=:integer")
				.setParameter("integer", integer).setCacheable(true).uniqueResult();
		return user;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public User getSecurityCodeByUserId(int userId,String sCode) {
		List<User> resetPasswordsList = sessionFactory.getCurrentSession().createQuery("from User where securityCodeUsed=:sCode and user.userId=:userId")
				.setParameter("userId", userId).setString("sCode", sCode).setCacheable(true).list();
		return resetPasswordsList.size()>0?resetPasswordsList.get(0):null;
	}
}
