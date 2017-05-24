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
package com.compass.exception;

/**
 * The <code>UserBlockedException</code> class handles exceptions that can occur while authenticating a User
 * @author TS
 * 
 */
public class UserBlockedException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * UserBlockedException constructor comment.
	 */
	public UserBlockedException() {
		super();
	}

	/**
	 * UserBlockedException constructor comment.
	 * 
	 * @param s
	 *            java.lang.String
	 */
	public UserBlockedException(String s) {
		super(s);
	}
	

	/**
	 * UserBlockedException constructor comment.
	 * 
	 * @param s
	 *            java.lang.String
	 * @param cause
	 *            java.lang.Throwable
	 */
	public UserBlockedException(String s, Throwable cause) {
		super(s, cause);
	}
}