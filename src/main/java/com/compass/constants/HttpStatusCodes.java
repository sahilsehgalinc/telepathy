/**
 * compass. 
 * Copyright � 2017 compass. 
 * 
 * All rights reserved.
 * 
 * THIS PRODUCT CONTAINS CONFIDENTIAL INFORMATION  OF compass. 
 * USE, DISCLOSURE OR REPRODUCTION IS PROHIBITED WITHOUT THE 
 * PRIOR EXPRESS WRITTEN PERMISSION OF compass.
 */
package com.compass.constants;

/**
 * The <code>HttpStatusCodes</code> interface contains all HTTP Codes Constants
 * @author RK
 *
 */

public interface HttpStatusCodes {
	
	//Sucess Codes
	int SUCCESS_OK=200;
	int SUCCESS_CREATED=201;
	int SUCCESS_ACCEPTED=202;
	
	//ERROR Codes
	int ERROR_BAD_REQUEST=400;
	int ERROR_UNAUTHORIZED=401;
	int ERROR_SOCIAL_UNAUTHORIZED=402;
	int ERROR_FORBIDDEN=403;
	int ERROR_NOT_FOUND=404;
	int ERROR_RESOURCE_ALREADY_EXIST=409;

	//SERVER Codes
	int ERROR_INTERNAL_SERVER=500;
	int ERROR_SERVICE_UNAVAILABLE=503;
	int ERROR_SMTP_SERVER=504;

	
	//Customize codes
	int ERROR_RESOURCE_UNAVAILABLE=603;
}
