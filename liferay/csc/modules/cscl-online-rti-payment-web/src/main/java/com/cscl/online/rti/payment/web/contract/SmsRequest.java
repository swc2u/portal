package com.cscl.online.rti.payment.web.contract;

public class SmsRequest {

	 private String mobileNumber;
	 private String message;
	 
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
