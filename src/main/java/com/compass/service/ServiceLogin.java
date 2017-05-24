package com.compass.service;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compass.dao.DaoUser;
import com.compass.entities.User;

@Service(value = "serviceLogin")
public class ServiceLogin {
	private static final Logger LOGGER = Logger.getLogger(ServiceLogin.class);

	
	@Autowired
	DaoUser daoUser;
	
	
	
	
	public boolean verifyResetCode(int uid, String sCode) {

		User user = daoUser.getSecurityCodeByUserId(
				uid, sCode);
		if (user == null) {
			return false;
		} else {
			// Check if Password Code Expire
			if (user.getCodeValidityDate().before(new Date())) {
				return false;
			} else {
				return true;
			}
		}
	}

}