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
 * The <code>UserNotVerifiedException</code> class handles exceptions that can occur while authenticating a User
 * @author TS
 * 
 */
public class UserNotVerifiedException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * UserNotVerifiedException constructor comment.
	 */
	public UserNotVerifiedException() {
		super();
	}

	/**
	 * UserAuthenticationException constructor comment.
	 * 
	 * @param s
	 *            java.lang.String
	 */
	public UserNotVerifiedException(String s) {
		super(s);
	}
	

	/**
	 * UserAuthenticationException constructor comment.
	 * 
	 * @param s
	 *            java.lang.String
	 * @param cause
	 *            java.lang.Throwable
	 */
	public UserNotVerifiedException(String s, Throwable cause) {
		super(s, cause);
	}
}