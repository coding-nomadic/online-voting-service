package org.votings.university.otpservice;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class Test {
    
   @Autowired
   private static JavaMailSender sender;
   public static void main(String[] args) {
	   MimeMessage message = sender.createMimeMessage();
       MimeMessageHelper helper = new MimeMessageHelper(message);

       try {
           helper.setTo("tenzin.dawa@cognizant.com");
           helper.setText("Greetings :)");
           helper.setSubject("Mail From Spring Boot");
       } catch (MessagingException e) {
           e.printStackTrace();
         
       }
       sender.send(message);
   }
}