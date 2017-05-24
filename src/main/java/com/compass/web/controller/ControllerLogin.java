/**
 * 
*** compass - Data Management System. 
**
 * Copyright @2017 compass. 
 * 
 * All rights reserved.
 * 
 * THIS PRODUCT CONTAINS CONFIDENTIAL INFORMATION  OF compass. 
 * USE, DISCLOSURE OR REPRODUCTION IS PROHIBITED WITHOUT THE 
 * PRIOR EXPRESS WRITTEN PERMISSION OF compass.
 */
package com.compass.web.controller;

import java.io.IOException;
import java.security.Principal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.RandomStringUtils;
/*import org.apache.catalina.User;*/
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.compass.dao.DaoLoginLog;
import com.compass.dao.DaoLoginTracking;
import com.compass.dao.DaoUser;
import com.compass.email.EmailManager;
import com.compass.email.MailTemplateFactory;
import com.compass.entities.LoginLog;
import com.compass.entities.LoginTracking;
import com.compass.entities.User;
import com.compass.service.ServiceLogin;

import java.util.Date;

/**
 * Description: Name of Project: compass
 * 
 * @author TS Version:
 */
@Controller
public class ControllerLogin {

	private static final Logger LOGGER = Logger.getLogger(ControllerLogin.class);

	@Autowired
	DaoUser daoUser;

	@Autowired
	DaoLoginLog daoLoginLog;
	
	@Autowired
	DaoLoginTracking daoLoginTracking;
	
	@Autowired
	EmailManager emailManager;
	
	@Value("${host.ip}")
	String hostIp;
	
	@Autowired
	ServiceLogin serviceLogin;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginUser(ModelAndView modelAndView) {

		try {
			modelAndView.setViewName("login-new");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return modelAndView;
	}

	@RequestMapping(value = "/loginMethod", method = RequestMethod.GET)
	public ModelAndView loginUserMethod(HttpServletRequest request, ModelAndView modelAndView) {
		System.out.println("In the login method");
		/*
		 * System.out.println("email"+request.getParameter("email"));
		 * System.out.println("password"+request.getParameter("password"));
		 */
		/*
		 * String email = request.getParameter("email"); String password =
		 * request.getParameter("password");
		 */
		String email = "abc";
		String password = "xyz";
		String ipAddress = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest()
				.getRemoteAddr();
		String userAgent = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes())
			       .getRequest().getHeader("User-Agent");
		int userId = 101;
		String securityCode = RandomStringUtils.randomAlphanumeric(10).toUpperCase();
		

		if (email != null && password != null) {
			System.out.println("not null email and pwd");
			
			User users = (User) daoUser.getUserByEmail(email);
			users.setSecurityCode(securityCode);
			daoUser.saveOrUpdate(users);
			LoginTracking loginTracking = new LoginTracking();
			loginTracking.setEmail(email);
			loginTracking.setIp(ipAddress);
			loginTracking.setPassword(password);
			loginTracking.setWebBrowser(userAgent);
			loginTracking.setUserId(users.getUserId());
			daoLoginTracking.saveOrUpdate(loginTracking);
			if (users != null) {
				if (email.equals(users.getEmail()) && password.equals(users.getPassword())) {
					System.out.println("checked values from db");
					modelAndView.setViewName("test");
					LoginLog loginLogs = daoLoginLog.getLastLoginUserByUserId(userId);
					if (loginLogs != null) {
						System.out.println("in not null loginlogs");
						loginLogs.setLastLoggedIn(new Timestamp(new Date().getTime()));
						loginLogs.setIpAddress(ipAddress);
						daoLoginLog.saveOrUpdate(loginLogs);
					}

					else {
						System.out.println("in null loginlogs");
						loginLogs = new LoginLog();
						loginLogs.setUser(users);
						loginLogs.setIpAddress(ipAddress);
						loginLogs.setLastLoggedIn(new Timestamp(new Date().getTime()));
						daoLoginLog.saveOrUpdate(loginLogs);
					}
				}

				if (email.equals(users.getEmail())) {
					System.out.println("in email");
					int loginTrackingSize= daoLoginTracking.getLoginTrackingByEmail(email);
					if(loginTrackingSize==3){
						/*int uid = users.getUserId();
						String name = users.getUsername();*/
						String verificationLink = "";
						System.out.println("in success");
						verificationLink = "http://"
								+ hostIp
								+ "/verifyUser?uid=" + userId + "&sCode="
								+ securityCode;
						System.out.println("verificationLink"+verificationLink);
						User user = (User) daoUser.getUserByEmail(email);
						if(user!=null){
							user.setSecurityCodeUsed("Y");
							daoUser.saveOrUpdate(user);
						}
						try {
							emailManager.sendMessage(
									"FORGOT PASSWORD",
									users.getEmail(),
									MailTemplateFactory.sendEmailForWrongPassword(verificationLink,users.getUsername()).toString());
						} catch (MessagingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					modelAndView.setViewName("test");
				}
				else{
					loginTracking.setFlag("GUEST_USER");
					daoLoginTracking.saveOrUpdate(loginTracking);
					modelAndView.setViewName("test");
				}
			} else {
				modelAndView.setViewName("");
				modelAndView.addObject("loginStatus", 0);
			}
		} else {
			modelAndView.setViewName("/login");
			modelAndView.addObject("loginStatus", 0);
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/verifyUser", method = RequestMethod.GET)
	public ModelAndView verifyUser(HttpSession session, Principal principal, HttpServletRequest request,
			int uid, String sCode, ModelAndView modelAndView) throws Exception {
		System.out.println("inside verifyUser");
		User user = daoUser.getUserByUserId(uid);
		boolean status = serviceLogin.verifyResetCode(uid, sCode);
		if (status) {
			if (sCode.equals(user.getSecurityCode()))

			{
				System.out.println(sCode);
				System.out.println(uid);

				user.setSecurityCodeUsed("Y");
				daoUser.saveOrUpdate(user);

				/*
				 * modelAndView.addObject("verifiedUser", "Y");
				 * modelAndView.setViewName("redirect:http://"+hostIp+"/login");
				 */
			} else {
				/*
				 * session.invalidate(); modelAndView.addObject("verifiedUser",
				 * "N");
				 */
				modelAndView.setViewName("redirect:http://" + hostIp + "/login");
			}
		} else {

			modelAndView.setViewName("redirect:/login");
		}
		return modelAndView;
	}
}