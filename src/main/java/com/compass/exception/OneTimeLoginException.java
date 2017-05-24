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
 * @author TS
 *
 */
public class OneTimeLoginException extends Exception {

	private static final long serialVersionUID = -578023632628705253L;

	public OneTimeLoginException() {
		super();
	}

	public OneTimeLoginException(String message, Throwable cause) {
		super(message, cause);
	}

	public OneTimeLoginException(String message) {
		super(message);
	}

}
