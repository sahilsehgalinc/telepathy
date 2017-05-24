/**
 * compass - Data Management System. 
 * Copyright � 2015 compass. 
 * 
 * All rights reserved.
 * 
 * THIS PRODUCT CONTAINS CONFIDENTIAL INFORMATION  OF compass. 
 * USE, DISCLOSURE OR REPRODUCTION IS PROHIBITED WITHOUT THE 
 * PRIOR EXPRESS WRITTEN PERMISSION OF compass.
 */

package com.compass.dao.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.transaction.annotation.Transactional;


/**
 * The <code>DaoBase</code> class is an implementation of <code>IDaoBase</code>
 * interface for all the basic CRUD methods
 * 
 * @author TS
 * @timestamp String
 */
public abstract class DaoBase<T> implements IDaoBase<T> {

	/**
	 * LOGGER for logging the information inside CRUD methods
	 */
	private final Logger LOGGER = Logger.getLogger(this.getClass().getName());

	/**
	 * Generic entity class object.
	 */
	private Class<T> entityClass;

	@Resource
	protected SessionFactory sessionFactory;

	/**
	 * @return sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * Default Constructor Used to set entityClass object
	 */
	@SuppressWarnings({ "unchecked" })
	public DaoBase() {
		entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	/**
	 * Basic Overrided CRUD methods Implementation
	 */

	@Override
	@Transactional
	public void delete(T domain) {
		/* LOGGER.info("Deleting Object...Inside delete......."); */
		sessionFactory.getCurrentSession().delete(domain);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.compass.dao.base.IDaoBase#save(java.lang.Object)
	 */
	@Override
	@Transactional
	public T save(T domain) {
		sessionFactory.getCurrentSession().save(domain);
		return domain;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.compass.dao.base.IDaoBase#update(java.lang.Object)
	 */
	@Override
	@Transactional
	public T update(T domain) {
		/*
		 * LOGGER.info( "Updating Object..Inside update.......");
		 */
		sessionFactory.getCurrentSession().update(domain);
		return domain;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.compass.dao.base.IDaoBase#saveOrUpdate(java.lang.Object)
	 */
	@Override
	@Transactional
	public T saveOrUpdate(T domain) {
		/*
		 * Logger.getLogger(this.getClass().getName()) .log(Level.INFO,
		 * "SavingOrUpdating Object...Inside saveOrUpdate.......");
		 */
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.compass.dao.base.IDaoBase#get(java.io.Serializable)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public T get(Serializable id) {
		/*
		 * LOGGER.info( "Getting Object By ID...Inside get.......");
		 */
		return (T) sessionFactory.getCurrentSession().get(entityClass, id);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.compass.dao.base.IDaoBase#getListByCriteria(org.hibernate.criterion.
	 * DetachedCriteria)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<T> getListByCriteria(DetachedCriteria criteria) {
		Logger.getLogger(this.getClass().getName()).log(Level.INFO,
				"Getting List By Crieteria...Inside getListByCriteria.......");
		return criteria.getExecutableCriteria(sessionFactory.getCurrentSession()).list();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.compass.dao.base.IDaoBase#getUniqueResultByCriteria(org.hibernate.
	 * criterion.DetachedCriteria)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public T getUniqueResultByCriteria(DetachedCriteria detachedCriteria) {

		return (T) DataAccessUtils
				.uniqueResult(detachedCriteria.getExecutableCriteria(sessionFactory.getCurrentSession()).list());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.compass.dao.base.IDaoBase#getAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<T> getAll() {
		/*
		 * LOGGER.info( "Getting List of Object ...Inside getAll.......");
		 */
		return sessionFactory.getCurrentSession().createQuery("from ".concat(entityClass.getName())).list();
	}

	

}