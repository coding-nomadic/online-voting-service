package org.votings.university.otpservice;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public enum OTPService {
	INSTANCE;
	public String sendOTPMail(String email,JavaMailSender sender) {
		 MimeMessage message = sender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message);
	        try {
	        	helper.setTo(email);
	            helper.setText("Greetings!! Your one time password to vote is :"+otpGenerator());
	            helper.setSubject("Mail From Online Voting System");
	        } catch (MessagingException e) {
	            e.printStackTrace();
	            return "Error while sending mail ..";
	        }
	        sender.send(message);
	        return "Mail Sent Success!";
	}
	
	public String otpGenerator() {
		int randomPIN = (int) (Math.random() * 9000) + 1000;
		return String.valueOf(randomPIN);
	}
}
