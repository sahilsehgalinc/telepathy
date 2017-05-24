/**
 * COMPASS. 
 * Copyright © 2015 COMPASS. 
 * 
 * All rights reserved.
 * 
 * THIS PRODUCT CONTAINS CONFIDENTIAL INFORMATION  OF COMPASS. 
 * USE, DISCLOSURE OR REPRODUCTION IS PROHIBITED WITHOUT THE 
 * PRIOR EXPRESS WRITTEN PERMISSION OF COMPASS.
 */
package com.compass.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.compass.dao.DaoEmailLogging;
import com.compass.dao.base.DaoBase;
import com.compass.entities.EmailLogging;

/**
 * @author rsingh4
 *
 */
@Repository(value="daoEmailLogging")
public class DaoEmailLoggingImpl extends DaoBase<EmailLogging> implements DaoEmailLogging{
	

}
