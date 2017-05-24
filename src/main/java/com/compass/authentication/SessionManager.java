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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "sessionManager")
public class SessionManager {

	//@Autowired
//	DaoSessionLog daoSessionLog;
	
	//@Autowired
//	DaoInitialInfo daoInitialInfo;

	@Autowired(required = false)
	HttpServletRequest request;

	/**
	 * Description:
	 * 
	 * @param userId
	 * @param deviceType
	 * @return String
	 */
	private static final Logger LOGGER = Logger
			.getLogger(SessionManager.class);
	
	/**
	 * @param userId
	 * @param deviceType
	 * @param deviceToken
	 * @return
	 */
	public String getUniqueSessionId(int userId, String deviceType, String deviceToken) {
		String sessionId = null;
	/*	// delete old entry by  if this device token used BY Another User.
		List<SessionLog> SessionLogListByDeviceToken = daoSessionLog.getListSessionLogByDeviceTokenIfUSERIDNotEQualCURRENTUserId(deviceToken, userId);
		if(SessionLogListByDeviceToken!= null){
			for(SessionLog sesssionLog : SessionLogListByDeviceToken){
				daoSessionLog.delete(sesssionLog);
			}*/
	//	}
		// delete old entry by  if this userId  used BY Another Device Token.
		/*List<SessionLog> SessionLogListByUserId = daoSessionLog.getListSessionLogByDeviceTokenIfUSERIDNotEQualCURRENTUserId(deviceToken, userId);
		if(SessionLogListByUserId!= null){
			for(SessionLog sesssionLog : SessionLogListByUserId){
				daoSessionLog.delete(sesssionLog);
			}
		}*/
		
	/*	SessionLog loginByThisDevice = daoSessionLog.checkLoginByUserIdandDeviceTokenAndType(userId, deviceToken, deviceType);
		if(loginByThisDevice!= null){
			return loginByThisDevice.getSessionCode();
		}
		else
		  {
			String sessionId = new RandomKeyUtil().nextRandomKey();
			SessionLog sessionLog = daoSessionLog.getSessionLog(sessionId);
			if (sessionLog != null) {
				// Re call method if session Id already exist
				LOGGER.info("Session repeat..recall method");
				getUniqueSessionId(userId, deviceType, deviceToken);
			}
			sessionLog = daoSessionLog.getSessionLogByUserIdandDeviceTokenAndType(userId, deviceToken, deviceType);
			if (sessionLog == null) 
			{
				sessionLog = new SessionLog();
				sessionLog.setCreatedBy(1);
				sessionLog.setCreatedDate(new Timestamp(new Date().getTime()));
			}
			sessionLog.setIsDelebted("N");
			sessionLog.setIsLogin("Y");
			sessionLog.setSessionCode(sessionId);
			sessionLog.setUser(daoInitialInfo.get(userId));
			sessionLog.setLastAccessTime(new Date());
			if(sessionLog.getUpdatedBy()>0){
				sessionLog.setUpdatedBy(sessionLog.getUpdatedBy()+1);
			}
			else{
				sessionLog.setUpdatedBy(1);
			}
			sessionLog.setUpdatedDate(new Timestamp(new Date().getTime()));
			sessionLog.setDeviceType(deviceType);
			sessionLog.setDeviceToken(deviceToken);  
			daoSessionLog.saveOrUpdate(sessionLog);*/
			return sessionId;
		}
		
	
	/**
	 * Description:
	 * @param loginId
	 * @return int
	 */
	public boolean validateUserSessionId(int userDetailsId) {

		String sessionId = request.getHeader("SessionId");
		if (sessionId != null && !sessionId.isEmpty()) {
		/*	SessionLog sessionLog = daoSessionLog.getSessionLog(sessionId);
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
			*/
			 return false;
		}	
		else{
			LOGGER.info("++Invalid userId along with session");
			return false;
		}
	}
	
	/**Description: On Logout, clears the Session Log of a user.  
	 * @param loginId
	 */
	public void clearSessionLog(int userId,String deviceType, String deviceToken) {
	/*	SessionLog sessionlog = daoSessionLog.getSessionLogByUserIdandDeviceTokenAndType(userId, deviceToken, deviceType);
		if(sessionlog != null){
			sessionlog.setIsDeleted("Y");
			sessionlog.setIsLogin("N");
			daoSessionLog.saveOrUpdate(sessionlog);
		}*/
	}
}