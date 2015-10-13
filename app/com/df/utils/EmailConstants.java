/**
 * 
 */
package com.df.utils;

import java.io.InputStream;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;

/**
 * @author kushang
 *
 */
public class EmailConstants {

	 public static final String username = "otnmailer@egnaroinc.com";
	 public static final String password = "@temp1234";

	 public static Properties props;
	public static  InputStream input;
	public static  Session session;
	public static  Transport transport;
	public static Message message;
}
