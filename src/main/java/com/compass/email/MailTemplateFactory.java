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
package com.compass.email;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * <code>MailTemplateFactory</code> is used to get the Email Templates from the HTML pages located in resources folder
 * @author TS
 * @timestamp
 */
public class MailTemplateFactory {

	private static final String TEMPLATE_PATH = "resources/";

	/**
	 * Get Forgot Password Email Format in StringBuffer
	 * 
	 * @param firstName
	 * @param link
	 * @return
	 */
	public static StringBuffer getForgotPasswordEmailFormat(String firstName,
			String link) {
		String s = htmlTemplateToStringBuffer("forgot-password.html")
				.toString().replaceAll("##FIRSTNAME##", firstName)
				.replaceAll("##LINK##", link);
		return new StringBuffer(s);
	}
	
	public static StringBuffer getResetPasswordCRIMEmailFormat(String firstName,
			String link) {
		String s = htmlTemplateToStringBuffer("reset-password-crim.html")
				.toString().replaceAll("##FIRSTNAME##", firstName)
				.replaceAll("##LINK##", link);
		return new StringBuffer(s);
	}
	/**
	 * @param referenceCode
	 * @return
	 */
	
	public static Object getReferenceEmailForFriend(String referenceCode,String firstName) {
		String s = htmlTemplateToStringBuffer("ReferAFriend.html")
				.toString().replaceAll("##REFERCODE##", referenceCode).toString()
				.replaceAll("##NAME##", firstName);;
		return new StringBuffer(s);
	}
	

public static StringBuffer getContactMessageEmailFormat(String firstName,String lastName) {
        String s = htmlTemplateToStringBuffer("contact.html")
                .toString().replaceAll("##FIRSTNAME##", firstName)
                .replaceAll("##LASTNAME##", lastName);
        return new StringBuffer(s);
    }

/**
 * @param referenceCode
 * @return
 */

public static StringBuffer getRecommendedEmailForFriend(String firstName, String rName ,  String rPhone , String rEmail , String associatedIE) {
	String s = htmlTemplateToStringBuffer("BostonRecommendation.html").toString().replaceAll("##RNAME##", rName).toString()
			
			.replaceAll("##RPHONE##", rPhone).toString()
			.replaceAll("##ASSOCIATEDIE##", associatedIE).toString()
			.replaceAll("##REMAIL##", rEmail).toString()
			.replaceAll("##NAME##", firstName);
	System.out.println(s);
	/*.replaceAll("##RNAME##", rName).toString()
			
			.replaceAll("##RPHONE##", rPhone).toString()
			.replaceAll("##ASSOCIATEDIE##", associatedIE).toString()
			.replaceAll("##REMAIL##", rEmail).toString()
			.replaceAll("##NAME##", firstName);*/
	return new StringBuffer(s);
}


public static StringBuffer getContactMessageEmailFormat(String firstName, String rName , String rEmail , String rPhone , String associatedIE) {
    String s = htmlTemplateToStringBuffer("contact.html")
    		.toString().replaceAll("##RNAME##", rName)
			.replaceAll("##NAME##", firstName)
			.replaceAll("##RPHONE##", rPhone)
			.replaceAll("##ASSOCIATEDIE##", associatedIE)
			.replaceAll("##REMAIL##", rEmail);
    return new StringBuffer(s);
}

	/**
	 * Get Forgot Password Email Format in StringBuffer
	 * 
	 * @param firstName
	 * @param link
	 * @return
	 */
	public static StringBuffer getOTPForgotPasswordEmailFormat(
			String firstName, String password) {
		String s = htmlTemplateToStringBuffer("OTP-forgot-password.html")
				.toString().replaceAll("##FIRSTNAME##", firstName)
				.replaceAll("##PASSWORD##", password);
		return new StringBuffer(s);
	}

	/**
	 * Get Welcome Message Email Format in StringBuffer
	 * 
	 * @param firstName
	 * @param username
	 * @param loginUrl
	 * @param forgotPasswordUrl
	 * @return
	 */
	public static StringBuffer getWelcomeMessageEmailFormat(String firstName,
			String username, String loginUrl, String password) {
		String s = htmlTemplateToStringBuffer("welcome-message.html")
				.toString().replaceAll("##FIRSTNAME##", firstName)
				.replaceAll("##USERNAME##", username)
				.replaceAll("##PASSWORD##", password)
				.replaceAll("##LOGINURL##", loginUrl);
		return new StringBuffer(s);
	}

	/**
	 * Get HTML content in StringBuffer
	 * 
	 * @param templateName
	 * @return
	 */
	private static StringBuffer htmlTemplateToStringBuffer(String templateName) {

		StringBuffer sb = new StringBuffer();
		InputStream stream = MailTemplateFactory.class
				.getResourceAsStream(TEMPLATE_PATH + templateName);
		BufferedReader in = new BufferedReader(new InputStreamReader(stream));
		try {
			String line;
			while ((line = in.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return sb;

	}

	/**
	 * @param firstName
	 * @param email
	 * @param password
	 * @return
	 */
	public static StringBuffer getSubscriptionDoneFormat(String firstName,
			String email, String password, String loginLink) {
		String s = htmlTemplateToStringBuffer("subscription-done.html")
				.toString().replaceAll("##FIRSTNAME##", firstName)
				.replaceAll("##USERNAME##", email)
				.replaceAll("##PASSWORD##", password)
				.replaceAll("##LOGINLINK##", loginLink);
		return new StringBuffer(s);
	}

	/**
	 * DESC: Letter to Parent by teacher email template
	 * 
	 * @return
	 */
	public static StringBuffer getLetterToParentEmailFormat(String schoolId,
			String content, String schoolName, String teacherName) {
		String s = htmlTemplateToStringBuffer("letter-to-parent.html")
				.toString().replaceAll("##TEACHERID##", schoolId)
				.replaceAll("##CONTENT##", content)
				.replaceAll("##TEACHERNAME##", teacherName)
				.replaceAll("##SCHOOLNAME##", schoolName);
		return new StringBuffer(s);
	}

	/**
	 * @param schoolId
	 * @param email
	 * @return
	 */
	public static StringBuffer getTrackToParentViaEmailFormat(String schoolId,
			String email) {
		String s = htmlTemplateToStringBuffer("track-link-to-parent.html")
				.toString().replaceAll("##TEACHERID##", schoolId)
				.replaceAll("##PARENTEMAIL##", email);
		return new StringBuffer(s);
	}

	/**
	 * @param message
	 * @return
	 */
	public static Object getAudioQualityMessage(String message) {
		String s = htmlTemplateToStringBuffer("audioquality-email.html")
				.toString().replaceAll("##MESSAGE##", message);
		return new StringBuffer(s);
	}

	/**
	 * @param message
	 * @return
	 */
	public static Object getSearchUserContactEmail(String message) {
		String s = htmlTemplateToStringBuffer(
				"searched-user-contact-email.html").toString().replaceAll(
				"##MESSAGE##", message);
		return new StringBuffer(s);
	}

	/**
	 * @param makePaymentLink
	 * @return
	 */
	public static Object sendIpledgeEmail(String makePaymentLink) {
		String s = htmlTemplateToStringBuffer("ipledge-email.html").toString()
				.replaceAll("##PAYMENTLINK##", makePaymentLink);
		return new StringBuffer(s);
	}

	/**
	 * @param loginLink
	 * @param teacherName
	 * @param className
	 * @param feedBackDate
	 * @return
	 */
	public static Object sendPendingFeedbackEmail(String loginLink,
			String teacherName, String className, String feedBackDate) {
		String s = htmlTemplateToStringBuffer("pending-feedback-email.html")
				.toString().replaceAll("##LOGINLINK##", loginLink)
				.replaceAll("##TEACHERNAME##", teacherName)
				.replaceAll("##CLASSNAME##", className)
				.replaceAll("##FEEDBACKDATE##", feedBackDate);
		return new StringBuffer(s);
	}

	/**
	 * @param firstName
	 * @param username
	 * @param changePassUrl
	 * @return
	 */
	public static StringBuffer getMigratedTeacherMessageEmailFormat(
			String firstName, String username, String changePassUrl) {
		String s = htmlTemplateToStringBuffer("welcome-migrant.html")
				.toString().replaceAll("##FIRSTNAME##", firstName)
				.replaceAll("##USERNAME##", username)
				.replaceAll("##LOGINURL##", changePassUrl);
		return new StringBuffer(s);
	}

	/**
	 * @param schoolId
	 * @return
	 */
	public static Object getLetterToParentTeacherDashEmailFormat(String schoolId, String schoolName, String teacherName) {
		String s = htmlTemplateToStringBuffer(
				"letter-to-parent-teacher-dash.html").toString().replaceAll(
				"##TEACHERID##", schoolId)
				.replaceAll("##SCHOOLNAME##", schoolName)
				.replaceAll("##TEACHERNAME##", teacherName);
		return new StringBuffer(s);
	}

	/**
	 * @param message
	 * @param name
	 * @return
	 */
	public static Object getLetterTobrandAmbassadorEmailFormat(String message,
			String name) {
		String s = htmlTemplateToStringBuffer("letter-to-brand-ambassador.html")
				.toString().replaceAll("##MESSAGE##", message).toString()
				.replaceAll("##NAME##", name);
		return new StringBuffer(s);
	}
	/**
	 * @param name
	 * @return
	 */
	
	public static Object getIncompleteSignupEmailFormat(String name) {
		String s = htmlTemplateToStringBuffer("incomplete-signup-email.html")
				.toString().replaceAll("##NAME##", name);
		return new StringBuffer(s);
	}

	
	
	

	/**
	 * @param donorName
	 * @param promoCode
	 * @return
	 */
	public static StringBuffer sendPrincipalEmail(String donorName,
			String promoCode) {
		String s = htmlTemplateToStringBuffer("principal-donor-email.html")
				.toString().replaceAll("##DONORNAME##", donorName)
				.replaceAll("##PROMOCODE##", promoCode);
		return new StringBuffer(s);
	}

	/**
	 * @param donorName
	 * @param principalEmailTable
	 * @return
	 */
	public static Object sendDonorEmail(String donorName,
			String principalEmailTable) {
		String s = htmlTemplateToStringBuffer("donor-email-all-principal.html")
				.toString().replaceAll("##DONORNAME##", donorName)
				.replaceAll("##PRINCIPALEMAILTABLE##", principalEmailTable);
		return new StringBuffer(s);
	}

	/**
	 * @param name
	 * @param email
	 * @param phone
	 * @param organization
	 * @param webSite
	 * @param weekDays
	 * @param time
	 * @param sponsorShipType
	 * @return
	 */
	public static Object getWelcomeMessageBecomeSponsor(String name,
			String email, String phone, String organization, String webSite,
			String weekDays, String time, String sponsorShipType) {
		String s = htmlTemplateToStringBuffer("become-sponsor-email.html")
				.toString().replaceAll("##NAME##", name)
				.replaceAll("##EMAIL##", email).replaceAll("##PHONE##", phone)
				.replaceAll("##ORGANIZATION##", organization)
				.replaceAll("##WEBSITE##", webSite)
				.replaceAll("##WEEKDAYS##", weekDays)
				.replaceAll("##TIME##", time)
				.replaceAll("##SPONSORTYPE##", sponsorShipType);
		return new StringBuffer(s);
	}

	/**
	 * @param date
	 * @param donorName
	 * @param amount
	 * @return
	 */
	public static Object sendDonorThankYouEmail(String date, String donorName,
			String amount) {
		String s = htmlTemplateToStringBuffer("donor-thankyou-message.html")
				.toString().replaceAll("##DATE##", date)
				.replaceAll("##DONORNAME##", donorName)
				.replaceAll("##AMOUNT##", amount);
		return new StringBuffer(s);
	}

	/**
	 * @param firstName
	 * @param username
	 * @return
	 */
	public static StringBuffer sendMexicoCityUserEmailFormat(String firstName,
			String username) {
		String s = htmlTemplateToStringBuffer("mexico-city-user-email.html")
				.toString().replaceAll("##FIRSTNAME##", firstName)
				.replaceAll("##USERNAME##", username);
		return new StringBuffer(s);
	}

	/**
	 * @param className
	 * @param trackName
	 * @param programName
	 * @param playCount
	 * @param teacherName
	 * @param optOutEmail
	 * @param teacherDashBoardURl
	 * @return
	 */
	public static Object sendTeacherReminderEmailFormat(String className,
			String trackName, String programName, String playCount,
			String teacherName, String optOutEmail, String teacherDashBoardURl) {

		String s = htmlTemplateToStringBuffer("teacher-reminder-email.html")
				.toString().replaceAll("##CLASSNAME##", className)
				.replaceAll("##PROGRAMNAME##", programName)
				.replaceAll("##AUDIONUMBER##", playCount)
				.replaceAll("##TEACHERNAME##", teacherName)
				.replaceAll("##TRACKNAME##", trackName)
				.replaceAll("##OPTOUTURL##", optOutEmail)
				.replaceAll("##TEACHERDASHBOARD##", teacherDashBoardURl);
		return new StringBuffer(s);
	}

	/**
	 * @param signupUrl
	 * @param name
	 * @param key
	 * @param parentName
	 * @return
	 */
	public static StringBuffer getParentRadioInvite(String signupUrl,
			String name, String key, String parentName) {
		String s = htmlTemplateToStringBuffer("parent-radio-invite.html")
				.toString().replaceAll("##NAME##", name)
				.replaceAll("##SIGNUPURL##", signupUrl)
				.replaceAll("##VCODE##", key)
				.replaceAll("##PARENTNAME##", parentName);
		return new StringBuffer(s);
	}

	/**
	 * @param signupUrl
	 * @param name
	 * @param key
	 * @param parentFirstName
	 * @param parentName
	 * @return
	 */
	public static StringBuffer getParentSubscriptionInvite(String signupUrl,
			String name, String key, String parentFirstName, String parentName) {
		String s = htmlTemplateToStringBuffer("parent-subscription-invite.html")
				.toString().replaceAll("##NAME##", name)
				.replaceAll("##SIGNUPURL##", signupUrl)
				.replaceAll("##VCODE##", key)
				.replaceAll("##PARENTFNAME##", parentFirstName)
				.replaceAll("##PARENTNAME##", parentName);
		return new StringBuffer(s);
	}

	/**
	 * @param parentName
	 * @param userLastEventDate
	 * @return
	 */
	public static Object sendReminderEmailToParent(String parentName,
			String userLastEventDate) {
		String s = htmlTemplateToStringBuffer("parent-reminder-email.html")
				.toString().replaceAll("##DATE##", userLastEventDate)
				.replaceAll("##DONORNAME##", parentName);
		return new StringBuffer(s);
	}

	/**
	 * @param familyName
	 * @param familyEmail
	 * @param parentName
	 * @param loginUrl
	 * @param familyPassword
	 * @return
	 */
	public static Object getWelcomeEmailFamily(String familyName,
			String familyEmail, String parentName, String loginUrl,
			String familyPassword) {
		String s = htmlTemplateToStringBuffer("welcome-family-email.html")
				.toString().replaceAll("##FAMILYNAME##", familyName)
				.replaceAll("##FAMILYEMAIL##", familyEmail)
				.replaceAll("##FAMILYPASSWORD##", familyPassword)
				.replaceAll("##PARENTNAME##", parentName)
				.replaceAll("##LOGINURL##", loginUrl);
		return new StringBuffer(s);
	}

	/**
	 * @param teacherName
	 * @param teacherEmail
	 * @param schoolName
	 * @param ownerName
	 * @return
	 */
	public static Object sendTeacherVerificationMailToSchool(
			String teacherName, String teacherEmail, String schoolName,
			String ownerName) {
		String s = htmlTemplateToStringBuffer(
				"teacher-verification-email-to-school.html").toString()
				.replaceAll("##TEACHERNAME##", teacherName)
				.replaceAll("##TEACHEREMAIL##", teacherEmail)
				.replaceAll("##SCHOOLNAME##", schoolName)
				.replaceAll("##OWNERNAME##", ownerName);
		return new StringBuffer(s);
	}

	/**
	 * @param teacherName
	 * @param schoolEmail
	 * @param schoolName
	 * @param ownerName
	 * @return
	 */
	public static Object sendTeacherDeleteEmail(String teacherName,
			String schoolEmail, String schoolName, String ownerName) {
		String s = htmlTemplateToStringBuffer("teacher-delete-email.html")
				.toString().replaceAll("##TEACHERNAME##", teacherName)
				.replaceAll("##SCHOOLEMAIL##", schoolEmail)
				.replaceAll("##SCHOOLNAME##", schoolName)
				.replaceAll("##OWNERNAME##", ownerName);
		return new StringBuffer(s);
	}

	/**
	 * @param name
	 * @param email
	 * @param loginUrl
	 * @param password
	 * @return
	 */
	public static Object getWelcomeMessageEmailParent(String name,
			String email, String loginUrl, String password) {
		String s = htmlTemplateToStringBuffer("welcome-message-parent.html")
				.toString().replaceAll("##FIRSTNAME##", name)
				.replaceAll("##USERNAME##", email)
				.replaceAll("##PASSWORD##", password)
				.replaceAll("##LOGINURL##", loginUrl);
		return new StringBuffer(s);
	}

	/**
	 * @param parentName
	 * @param loginUrl
	 * @return
	 */
	public static Object sendRadioExpireEmail(String parentName, String loginUrl) {
		String s = htmlTemplateToStringBuffer("radio-expire.html").toString()
				.replaceAll("##PARENTNAME##", parentName)
				.replaceAll("##LOGINURL##", loginUrl);
		return new StringBuffer(s);
	}

	/**
	 * @param exception
	 * @param classs
	 * @param line
	 * @param message
	 * @return
	 */
	public static StringBuffer sendErrorEmail(String exception, String classs, String line, String message) {
		StringBuffer sb = new StringBuffer();
		for(StackTraceElement st : Thread.currentThread().getStackTrace())
		{
			if(st.getClassName().toString().startsWith("com.compass"))
			{
				sb.append(" \nCalling Class : "+st.getClassName());//+" ---- Calling Method : "+st.getMethodName());
				sb.append(" \nCalling Method : "+st.getMethodName());
				sb.append(" \nCalling Line : "+st.getLineNumber());
			}
		}
		String s = htmlTemplateToStringBuffer("exception-email.html").toString().replaceAll("##EXCEPTION##", exception).toString().replaceAll("##CLASS##", classs).replaceAll("##LINE##", line).replaceAll("##MSG##", message+sb.toString());
		System.out.println("email textt="+s);
		return new StringBuffer(s);
	}

	public static Object sendTeacherReminderEmailForPracticeFormat(
			String className, String teacherName) {
		String s = htmlTemplateToStringBuffer("teacher-reminder-email-for-practice.html")
				.toString().replaceAll("##CLASSNAME##", className)
				.replaceAll("##TEACHERNAME##", teacherName);
		return new StringBuffer(s);
	}

	public static Object getWelcomeMessageEmailTeacherSignUpFormat(String name,
			String email, String loginUrl, String teacherPassword) {
		
			String s = htmlTemplateToStringBuffer("welcome-message-teacher.html")
					.toString().replaceAll("##FIRSTNAME##", name)
					.replaceAll("##USERNAME##", email)
					.replaceAll("##PASSWORD##", teacherPassword)
					.replaceAll("##LOGINURL##", loginUrl);
			return new StringBuffer(s);
	}

	public static Object getWelcomeMessageEmailTeacherComplateRegister(
			String name,String email) {
		String s = htmlTemplateToStringBuffer("welcome-message-teacher-complete-register.html")
				.toString().replaceAll("##FIRSTNAME##", name)
				.replaceAll("##USERNAME##", email);
		return new StringBuffer(s);
	}

	public static Object sendEmailPrincipalToAddClass(String principalName, String parentName) {
		String s = htmlTemplateToStringBuffer("email-to-add-class.html")
				.toString().replaceAll("##PRINCIPALNAME##", principalName)
				.replaceAll("##PARENTNAME##", parentName);
		return new StringBuffer(s);
	}
	public static Object getPaymentReceipt(String string) {
		String s = htmlTemplateToStringBuffer("payment-receipt-principal.html")
				.toString().replaceAll("##TEXT##", string);
		return new StringBuffer(s);
	}
	
	public static StringBuffer getWelcomeBackMessageEmailFormat(String firstName,
			String username, String loginUrl, String password) {
		String s = htmlTemplateToStringBuffer("welcome-back-message.html")
				.toString().replaceAll("##FIRSTNAME##", firstName)
				.replaceAll("##USERNAME##", username)
				.replaceAll("##PASSWORD##", password)
				.replaceAll("##LOGINURL##", loginUrl);
		return new StringBuffer(s);
	}
	
	/**
	 * @param name
	 * @return
	 */
	
	public static Object getSubscriptionExpiredEmailFormat(String name, String amount) {
		String s = htmlTemplateToStringBuffer("subscription-expired-email.html")
				.toString().replaceAll("##NAME##", name)
				.replaceAll("##AMOUNT##", amount);
		return new StringBuffer(s);
	}
	/*added by avneet when user enters correct email but wrong password*/
	public static Object sendEmailForWrongPassword(String verificationLink, String name ) {
		String s = htmlTemplateToStringBuffer("wrong-pwd-email.html")
				.toString().replaceAll("##verificationLink##", verificationLink)
				.replaceAll("##NAME##", name);
		return new StringBuffer(s);
	}

}
