/**
 * compass. 
 * Copyright � 2015 compass. 
 * 
 * All rights reserved.
 * 
 * THIS PRODUCT CONTAINS CONFIDENTIAL INFORMATION  OF compass. 
 * USE, DISCLOSURE OR REPRODUCTION IS PROHIBITED WITHOUT THE 
 * PRIOR EXPRESS WRITTEN PERMISSION OF compass.
 */
package com.compass.aspect.UserCRUDAspect;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserCRUDAspect {
	
	@Autowired
	HttpSession session;
     
	private static final Logger LOGGER = Logger
			.getLogger(UserCRUDAspect.class);
    
    @Before("execution(* com.compass.web.controller.*.*(..))")
    public void logBeforeV2(JoinPoint joinPoint) 
    {
        LOGGER.info("UserCRUDAspect.logBefore : " + joinPoint.getSignature().getName());
        LOGGER.info("==========session======="+session.getAttribute("userIdAOP"));
    }
     
    @After("execution(* com.compass.web.controller.*.*(..))")
    public void logAfterV2(JoinPoint joinPoint) 
    {
    	LOGGER.info("UserCRUDAspect.logAfter : " + joinPoint.getSignature().getName());
    	LOGGER.info("==========session======="+session.getAttribute("userIdAOP"));
    }
    
    
    
}