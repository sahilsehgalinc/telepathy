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
package com.compass.authentication;

public abstract class ApiKeyManager {

	public static final String IPHONE = "IPHONE";
	public static final String ANDROID = "ANDROID";

	// compass API Keys

	private static final String IPHONE_APP_API_KEY = "IPHONE-7";
	private static final String ANDROID_APP_API_KEY = "ANDROID-6";


	/**
	 * @param applicationType
	 * @param appKey
	 * @return
	 */
	public static boolean isApplicationAuthorizedwithKey(
			String applicationType, String appKey) {

		if (applicationType.equals(IPHONE) && appKey.equals(IPHONE_APP_API_KEY)) {
			return true;
		}
		if (applicationType.equals(ANDROID)
				&& appKey.equals(ANDROID_APP_API_KEY)) {
			return true;
		}
		else {
			return false;
		}
	}

}
