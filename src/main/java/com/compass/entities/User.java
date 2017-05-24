
package com.compass.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@org.hibernate.annotations.Entity(dynamicInsert = true)
@Table(name = "users")
@Cache(region = "user", usage = CacheConcurrencyStrategy.READ_WRITE)
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {

	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private int userId;

	@Column(name = "CREATED_DATE")
	private Timestamp createdDate;

	private String email;

	@Transient
	private String message;

	@Column(name = "FACEBOOK_ID")
	private String facebookId;

	@Column(name = "IS_BLOCKED")
	private String isBlocked;

	@Column(name = "IS_DELETED")
	private String isDeleted;

	@Column(name = "IS_EMAIL_VERIFIED")
	private String isEmailVerified;

	@Column(name = "IS_RESET")
	private String isReset;

	@Column(name = "IS_RESET_PASSWORD_USED")
	private String isResetPasswordUsed;

	@Column(name = "IS_RESET_REQUEST_GENERATED")
	private String isResetRequestGenerated;

	@Column(name = "IS_VERIFIED")
	private String isVerified;
	
	@Column(name = "TOKEN")
	private String token;
	
	@Column(name = "Type")
	private String type;

	@Column(name = "MOBILE_NUMBER")
	private String mobileNumber;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "NOTIFICATION_UPDATED_DATE")
	private Date notificationUpdatedDate;

	private String password;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SUBSCRIPTION_DATE")
	private Date subscriptionDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SUBSCRIPTION_EXPIRE_DATE")
	private Date subscriptionExpireDate;

	@Column(name = "SUBSCRIPTION_EXPIRE_EMAIL")
	private String subscriptionExpireEmail;

	@Column(name = "SUBSCRIPTION_WARNING_EMAIL")
	private String subscriptionWarningEmail;

	@Column(name = "IS_FIRST_LOGIN")
	private String isFirstLogin;

	@Column(name = "TWITTER_ID")
	private String twitterId;

	private String username;

	@Column(name = "VERIFICATION_CODE")
	private String verificationCode;

	@Column(name = "SEPRATE_TEACHER")
	private String seprateTeacher;

	@Column(name = "REFERENCE_CODE")
	private String referenceCode;
	
	@Column(name = "PROMO_CODE")
	private String promoCode;

	@Column(name = "MIGRATED")
	private String migrated;

	@Column(name = "ANSWER1")
	private String answer1;

	@Column(name = "ANSWER2")
	private String answer2;

	@Column(name = "INVITE_DATE")
	private Date inviteDate;

	@Column(name = "JOINED")
	private String joined;

	@Column(name = "IP")
	private String ipAddress;

	@Column(name = "UPDATED_BY")
	private String updatedBy;

	@Column(name = "TEACHER_SIGNUP_COMPLETE")
	private String teacherSignupComplete;
	
	@Column(name = "SECURITY_CODE")
	private String securityCode;
	
	@Column(name = "SECURITY_CODE_USED")
	private String securityCodeUsed;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CODE_VALIDITY_DATE")
	private Date codeValidityDate;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getFacebookId() {
		return facebookId;
	}

	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}

	public String getIsBlocked() {
		return isBlocked;
	}

	public void setIsBlocked(String isBlocked) {
		this.isBlocked = isBlocked;
	}

	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getIsEmailVerified() {
		return isEmailVerified;
	}

	public void setIsEmailVerified(String isEmailVerified) {
		this.isEmailVerified = isEmailVerified;
	}

	public String getIsReset() {
		return isReset;
	}

	public void setIsReset(String isReset) {
		this.isReset = isReset;
	}

	public String getIsResetPasswordUsed() {
		return isResetPasswordUsed;
	}

	public void setIsResetPasswordUsed(String isResetPasswordUsed) {
		this.isResetPasswordUsed = isResetPasswordUsed;
	}

	public String getIsResetRequestGenerated() {
		return isResetRequestGenerated;
	}

	public void setIsResetRequestGenerated(String isResetRequestGenerated) {
		this.isResetRequestGenerated = isResetRequestGenerated;
	}

	public String getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(String isVerified) {
		this.isVerified = isVerified;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Date getNotificationUpdatedDate() {
		return notificationUpdatedDate;
	}

	public void setNotificationUpdatedDate(Date notificationUpdatedDate) {
		this.notificationUpdatedDate = notificationUpdatedDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getSubscriptionDate() {
		return subscriptionDate;
	}

	public void setSubscriptionDate(Date subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}

	public Date getSubscriptionExpireDate() {
		return subscriptionExpireDate;
	}

	public void setSubscriptionExpireDate(Date subscriptionExpireDate) {
		this.subscriptionExpireDate = subscriptionExpireDate;
	}

	public String getSubscriptionExpireEmail() {
		return subscriptionExpireEmail;
	}

	public void setSubscriptionExpireEmail(String subscriptionExpireEmail) {
		this.subscriptionExpireEmail = subscriptionExpireEmail;
	}

	public String getSubscriptionWarningEmail() {
		return subscriptionWarningEmail;
	}

	public void setSubscriptionWarningEmail(String subscriptionWarningEmail) {
		this.subscriptionWarningEmail = subscriptionWarningEmail;
	}

	public String getIsFirstLogin() {
		return isFirstLogin;
	}

	public void setIsFirstLogin(String isFirstLogin) {
		this.isFirstLogin = isFirstLogin;
	}

	public String getTwitterId() {
		return twitterId;
	}

	public void setTwitterId(String twitterId) {
		this.twitterId = twitterId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	public String getSeprateTeacher() {
		return seprateTeacher;
	}

	public void setSeprateTeacher(String seprateTeacher) {
		this.seprateTeacher = seprateTeacher;
	}

	public String getReferenceCode() {
		return referenceCode;
	}

	public void setReferenceCode(String referenceCode) {
		this.referenceCode = referenceCode;
	}

	public String getPromoCode() {
		return promoCode;
	}

	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	public String getMigrated() {
		return migrated;
	}

	public void setMigrated(String migrated) {
		this.migrated = migrated;
	}

	public String getAnswer1() {
		return answer1;
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public String getAnswer2() {
		return answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	public Date getInviteDate() {
		return inviteDate;
	}

	public void setInviteDate(Date inviteDate) {
		this.inviteDate = inviteDate;
	}

	public String getJoined() {
		return joined;
	}

	public void setJoined(String joined) {
		this.joined = joined;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getTeacherSignupComplete() {
		return teacherSignupComplete;
	}

	public void setTeacherSignupComplete(String teacherSignupComplete) {
		this.teacherSignupComplete = teacherSignupComplete;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public String getSecurityCodeUsed() {
		return securityCodeUsed;
	}

	public void setSecurityCodeUsed(String securityCodeUsed) {
		this.securityCodeUsed = securityCodeUsed;
	}

	public Date getCodeValidityDate() {
		return codeValidityDate;
	}

	public void setCodeValidityDate(Date codeValidityDate) {
		this.codeValidityDate = codeValidityDate;
	}
	
	
	
}