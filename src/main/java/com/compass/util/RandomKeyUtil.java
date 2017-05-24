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
package com.compass.util;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * The <code>RandomKeyUtil</code> class returns the random key that should be
 * used as session key in user's session
 * 
 * @author TS
 * 
 */
public class RandomKeyUtil {

	private SecureRandom random = new SecureRandom();

	/**
	 * @return
	 */
	public String nextRandomKey() {
		return new BigInteger(60, random).toString(32);
	}

}
