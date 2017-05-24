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
 * The <code>ResourceNotFoundException</code> class should be used to throw exception when a specified resource is not found on server
 * @author TS
 * 
 */

public class ResourceNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	public ResourceNotFoundException()
	{
	super();	
	}
	
	/**
	 * @param s the mesage for the LoginFailureException
	 */
	public ResourceNotFoundException(String s)
	{
	super(s);	
	}
	
	/**
	 * @param s
	 * @param cause
	 */
	public ResourceNotFoundException(String s, Throwable cause)
	{
		super(s,cause);
	}
}
