
package com.compass.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.compass.dao.DaoLoginTracking;
import com.compass.dao.base.DaoBase;
import com.compass.entities.LoginTracking;

@Repository(value = "daoLoginTracking")
public class DaoLoginTrackingImpl extends DaoBase<LoginTracking> implements DaoLoginTracking {

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public int getLoginTrackingByEmail(String email) {
		List<LoginTracking> trackingDetails = sessionFactory.getCurrentSession()
				.createQuery("From LoginTracking where email=:email").setParameter("email", email).setCacheable(true)
				.list();
		return trackingDetails!=null ? trackingDetails.size() : 0;
	}

}
