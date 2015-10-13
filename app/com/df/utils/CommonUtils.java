package com.df.utils;

import java.net.UnknownHostException;
import play.Logger;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.df.userModel.MorphiaObject;
import com.google.code.morphia.Morphia;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.Mongo;


public class CommonUtils {

	private static Gson gson = new Gson();
		
	public static void createDBConnection() {
	
		Logger.of(LoggerConstants.OTNlogger).debug(LoggerConstants.methodEntry);
		// Mongo object created
		try {
			Logger.of(LoggerConstants.OTNlogger).info(LoggerConstants.mongoDBIntilization);
			MorphiaObject.mongo = new Mongo("127.0.0.1", 27017);
		} catch (UnknownHostException e) {
			e.printStackTrace();
			Logger.of(LoggerConstants.OTNlogger).error(LoggerConstants.mongoDBIntilizationError);
		}

		// Creating Morphia object
		MorphiaObject.morphia = new Morphia();

		// MorphiaObject.morphia.map(Hotel.class).map(Address.class);
		MorphiaObject.datastore = MorphiaObject.morphia.createDatastore(
				MorphiaObject.mongo, "odeDB");
		Logger.of(LoggerConstants.OTNlogger).info(LoggerConstants.mongoDBCreated);
		Logger.of(LoggerConstants.OTNlogger).debug(LoggerConstants.methodExit);
	}


	public static void initializeEmailConstatnts() {
		 try{
		 EmailConstants.props = new Properties();
		 EmailConstants.input = new FileInputStream("config.properties");
		 EmailConstants.props.load(EmailConstants.input);
		 EmailConstants.session = Session.getInstance(EmailConstants.props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(EmailConstants.username, EmailConstants.password);
				}

			});
		 EmailConstants.message = new MimeMessage(EmailConstants.session);
		 EmailConstants.message.setFrom(new InternetAddress("otnmailer@egnaroinc.com"));
		 EmailConstants.transport = EmailConstants.session.getTransport();
		 }
		 catch (AddressException ex) {
				Logger.of(LoggerConstants.OTNlogger).error("exception while sending mail");
				ex.printStackTrace();
			} catch (IOException ex) {
				Logger.of(LoggerConstants.OTNlogger).error("exception while sending mail");
				ex.printStackTrace();
			} catch (MessagingException ex) {
				Logger.of(LoggerConstants.OTNlogger).error("exception while sending mail");
				ex.printStackTrace();
			}

			finally {
				if (EmailConstants.input != null) {
					try {
						EmailConstants.input.close();
					} catch (IOException e) {
						Logger.of(LoggerConstants.OTNlogger).error("exception while sending mail");
					}
				}
			}

	 }

	

}
