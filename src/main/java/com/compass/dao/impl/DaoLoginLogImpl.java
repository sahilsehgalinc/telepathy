package com.compass.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.compass.dao.DaoLoginLog;
import com.compass.dao.base.DaoBase;
import com.compass.entities.LoginLog;

/**
 * @author rsingh4
 *
 */
@Repository(value = "daoLoginLogs")
public class DaoLoginLogImpl extends DaoBase<LoginLog> implements DaoLoginLog {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.compass.dao.DaoLoginLog#getUserByUserId(int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public LoginLog getLastLoginUserByUserId(int parseInt) {
		List<LoginLog> list = sessionFactory.getCurrentSession()
				.createQuery("from LoginLog where user.userId=:parseInt").setParameter("parseInt", parseInt)
				.setCacheable(true).list();
		return list.size() > 0 ? list.get(0) : null;
	}

}
