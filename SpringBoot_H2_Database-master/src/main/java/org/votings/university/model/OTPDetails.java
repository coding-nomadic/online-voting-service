package org.votings.university.model;

public class OTPDetails {

	private String voterCardNumber;
	private String otp;
	OTPDetails() {
	}
	
	public OTPDetails(String voterCardNumber, String otp) {
		super();
		this.voterCardNumber = voterCardNumber;
		this.otp = otp;
	}

	public String getVoterCardNumber() {
		return voterCardNumber;
	}

	public void setVoterCardNumber(String voterCardNumber) {
		this.voterCardNumber = voterCardNumber;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

}
