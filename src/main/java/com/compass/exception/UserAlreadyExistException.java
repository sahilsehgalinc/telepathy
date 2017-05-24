/**
 * compass - 
 * Copyright � 2015 compass. 
 * 
 * All rights reserved.
 * 
 * THIS PRODUCT CONTAINS CONFIDENTIAL INFORMATION  OF compass. 
 * USE, DISCLOSURE OR REPRODUCTION IS PROHIBITED WITHOUT THE 
 * PRIOR EXPRESS WRITTEN PERMISSION OF compass.
 */
package com.compass.exception;


/**
 * The <code>UserAlreadyExistException</code> is a exception class that should be used if User is already exist in compass system 
 * @author Platform Z
 * @timestamp
 *  
 */
public class UserAlreadyExistException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public UserAlreadyExistException() {
		super();
	}
	
	/**
	 * @param message
	 */
	public UserAlreadyExistException(String message) {
		super(message);
	}
	

}
