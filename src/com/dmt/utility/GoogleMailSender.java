package com.dmt.utility;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class GoogleMailSender
{
	public static boolean sendEmail(String fromEmail, String toEmail,String subject,String message) 
	{
		boolean sentFlag = false;
		try 
		{
			/*
			// TLS
			Properties propsTLS = new Properties();
			propsTLS.put("mail.transport.protocol", "smtp");
			propsTLS.put("mail.smtp.host", "smtp.gmail.com");
			propsTLS.put("mail.smtp.auth", "true");
			propsTLS.put("mail.smtp.starttls.enable", "true"); // GMail requires STARTTLS

			Session sessionTLS = Session.getInstance(propsTLS);
			sessionTLS.setDebug(true);

			Message messageTLS = new MimeMessage(sessionTLS);
			messageTLS.setFrom(new InternetAddress(fromEmail, ""));
			messageTLS.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail)); // real recipient
			messageTLS.setSubject(subject);
			messageTLS.setText(message);

			Transport transportTLS = sessionTLS.getTransport();
			transportTLS.connect("smtp.gmail.com", 587, CryptoUtil.decrypt(Constants.USERNAME),CryptoUtil.decrypt(Constants.PASSWORD)); // account used
			transportTLS.sendMessage(messageTLS, messageTLS.getAllRecipients());
			transportTLS.close();

			System.out.println("TLS done.");
			System.out.println("------------------------------------------------------------------------");
			*/
			// SSL			
			Properties propsSSL = new Properties();
			propsSSL.put("mail.transport.protocol", "smtps");
			propsSSL.put("mail.smtps.host", "smtp.gmail.com");
			propsSSL.put("mail.smtps.auth", "true");

			Session sessionSSL = Session.getInstance(propsSSL);
			sessionSSL.setDebug(true);

			Message messageSSL = new MimeMessage(sessionSSL);
			messageSSL.setFrom(new InternetAddress(fromEmail, ""));
			messageSSL.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail)); // real recipient
			messageSSL.setSubject(subject);
			messageSSL.setText(message);

			Transport transportSSL = sessionSSL.getTransport();
			transportSSL.connect("smtp.gmail.com", 465, CryptoUtil.decrypt(Constants.USERNAME),CryptoUtil.decrypt(Constants.PASSWORD)); // account used
			transportSSL.sendMessage(messageSSL, messageSSL.getAllRecipients());
			transportSSL.close();

			System.out.println("SSL done.");
			System.out.println("------------------------------------------------------------------------");
			sentFlag = true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return sentFlag;
	}
}
