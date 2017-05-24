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

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;


public class AuthenticationManager {

	private static String appType = null;
	private static String appToken = null;
	
	private static final Logger LOGGER = Logger
			.getLogger(AuthenticationManager.class);
	
	//@Autowired
	//DaoSessionLog daoSessionLog;
	
	/**
	 * @param req
	 * @return
	 */
	public static boolean initialize(HttpServletRequest request) {

		appType = request.getHeader("Application-Type");
		appToken = request.getHeader("Application-Token");

		if (appType == null || appToken == null) {
			LOGGER.info("***in intialize method ****");
			LOGGER.info("Authentication attempted from IP "
					+ request.getRemoteAddr() + " without valid api key. Key: "
					+ appToken + "  and CLient Type=" + appType);
			return false;
		}
		if (ApiKeyManager.isApplicationAuthorizedwithKey(appType, appToken)) {
			LOGGER.info("Authentication sucessfull from AppType="
					+ appType + " with app token =" + appToken);
			return true;
		} else {
			return false;
		}
	}
	
    /**
     * @param userDetailsId
     * @param request
     * @return
     */
    public boolean validateUserSessionId(int userDetailsId, HttpServletRequest request) {

        String sessionId = request.getHeader("SessionId");
        if (sessionId != null && !sessionId.isEmpty()) {
      /*       SessionLog sessionLog = daoSessionLog.getSessionLog(sessionId);
             if(sessionLog != null){
                  if(userDetailsId==sessionLog.getUser().getUserId()){
                        return true;
                  }
                  else{
                        return false;
                  }
             }
             else{
                  return false;
             }
        */     return false;
        }    
        else{
             LOGGER.info("++Invalid userId along with session");
             return false;
        }
  }

	
	/**
	 * Description:
	 * @param req
	 * @return String
	 */
	public static String getApplicationType(HttpServletRequest request) {
		return request.getHeader("Application-Type");
	}
	
	/**
	 * @param request
	 * @return
	 */
	public static String getDeviceToken(HttpServletRequest request) {
		return request.getHeader("Device-Token");
	}
}
