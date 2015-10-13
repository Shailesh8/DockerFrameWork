package com.df.utils;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class UserConstants {
	
	 String emailTestData1;
	 String userPasswordTestData1;
	 String userRoleTestData1;
	 String sharedNetworkTestData1;
	 String createdNetworkTestData1;
	 String aliasTestData1;
	 String status;
	
	UserConstants(String email,String password,String Role,String SharedNetwork,String createdNetwork,String alias){
		this.emailTestData1 = email;
		this.userPasswordTestData1 = password;
		this.userRoleTestData1 = Role;
		this.sharedNetworkTestData1 = SharedNetwork;
		this.createdNetworkTestData1 = createdNetwork;
		this.aliasTestData1 = alias;
	}
	UserConstants(String email,String password,String Role,String alias,String status){
		this.emailTestData1 = email;
		this.userPasswordTestData1 = password;
		this.userRoleTestData1 = Role;
		this.aliasTestData1 = alias;
		this.status= status;
	}

	public static List<UserConstants> getData(){
		List<UserConstants> toppings = new ArrayList<UserConstants>();
		/*toppings.add(new UserConstants("test1@cisco.com","cisco123","ADMIN","200","300","test1"));
		toppings.add(new UserConstants("test2@cisco.com","cisco123","ADMIN","240","300","test2"));
		toppings.add(new UserConstants("test3@cisco.com","cisco123","ADMIN","200","300","test3"));
		toppings.add(new UserConstants("test4@cisco.com","cisco123","ADMIN","20","400","test4"));
		toppings.add(new UserConstants("test5@cisco.com","cisco123","ADMIN","100","300","test5"));

		toppings.add(new UserConstants("test21@cisco.com","cisco123","SE","200","300","test21"));
		toppings.add(new UserConstants("test22@cisco.com","cisco123","SE","240","300","test22"));
		toppings.add(new UserConstants("test23@cisco.com","cisco123","SE","200","300","test23"));
		toppings.add(new UserConstants("test24@cisco.com","cisco123","SE","20","400","test24"));*/
		toppings.add(new UserConstants("abkhunti@cisco.com","cisco123","ADMIN","200","300","abhishek"));

		return toppings;

	}
	public static List<UserConstants> getPendingData(){
		List<UserConstants> toppings = new ArrayList<UserConstants>();
		/*toppings.add(new UserConstants("test6@cisco.com","cisco123","SE","test6","pending"));
		toppings.add(new UserConstants("test7@cisco.com","cisco123","SE","test7","pending"));
		toppings.add(new UserConstants("test8@cisco.com","cisco123","SE","test8","pending"));
		toppings.add(new UserConstants("test9@cisco.com","cisco123","SE","test9","pending"));
		toppings.add(new UserConstants("test10@cisco.com","cisco123","SE","test10","pending"));
		toppings.add(new UserConstants("test11@cisco.com","cisco123","SE","test6","pending"));
		toppings.add(new UserConstants("test12@cisco.com","cisco123","SE","test7","pending"));
		toppings.add(new UserConstants("test13@cisco.com","cisco123","SE","test8","pending"));
		toppings.add(new UserConstants("test14@cisco.com","cisco123","SE","test9","pending"));
		toppings.add(new UserConstants("test15@cisco.com","cisco123","SE","test10","pending"));
		toppings.add(new UserConstants("test16@cisco.com","cisco123","SE","test6","pending"));
		toppings.add(new UserConstants("test17@cisco.com","cisco123","SE","test7","pending"));
		toppings.add(new UserConstants("test18@cisco.com","cisco123","SE","test8","pending"));
		toppings.add(new UserConstants("test19@cisco.com","cisco123","SE","test9","pending"));
		toppings.add(new UserConstants("test20@cisco.com","cisco123","SE","test10","pending"));*/
		return toppings;

	}
 	
	
	
	
	public static  String get_SecurePassword(String passwordToHash) 
	{
		String generatedPassword = null;
        try {
	            MessageDigest md = MessageDigest.getInstance("SHA-1");
	           // md.update(salt.getBytes());
	            byte[] bytes = md.digest(passwordToHash.getBytes(Charset.forName("UTF-8")));
	            StringBuilder sb = new StringBuilder();
	            for(int i=0; i< bytes.length ;i++)
	            {
	                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	            }
	            generatedPassword = sb.toString();
        	}catch (NoSuchAlgorithmException e) 
		        {
		            e.printStackTrace();
		        }
        return generatedPassword;
	}

	/**
	 * @return the emailTestData1
	 */
	public String getEmailTestData1() {
		return emailTestData1;
	}

	/**
	 * @param emailTestData1 the emailTestData1 to set
	 */
	public void setEmailTestData1(String emailTestData1) {
		this.emailTestData1 = emailTestData1;
	}

	/**
	 * @return the userPasswordTestData1
	 */
	public String getUserPasswordTestData1() {
		return userPasswordTestData1;
	}

	/**
	 * @param userPasswordTestData1 the userPasswordTestData1 to set
	 */
	public void setUserPasswordTestData1(String userPasswordTestData1) {
		this.userPasswordTestData1 = userPasswordTestData1;
	}

	/**
	 * @return the userRoleTestData1
	 */
	public String getUserRoleTestData1() {
		return userRoleTestData1;
	}

	/**
	 * @param userRoleTestData1 the userRoleTestData1 to set
	 */
	public void setUserRoleTestData1(String userRoleTestData1) {
		this.userRoleTestData1 = userRoleTestData1;
	}

	/**
	 * @return the sharedNetworkTestData1
	 */
	public String getSharedNetworkTestData1() {
		return sharedNetworkTestData1;
	}

	/**
	 * @param sharedNetworkTestData1 the sharedNetworkTestData1 to set
	 */
	public void setSharedNetworkTestData1(String sharedNetworkTestData1) {
		this.sharedNetworkTestData1 = sharedNetworkTestData1;
	}

	/**
	 * @return the createdNetworkTestData1
	 */
	public String getCreatedNetworkTestData1() {
		return createdNetworkTestData1;
	}

	/**
	 * @param createdNetworkTestData1 the createdNetworkTestData1 to set
	 */
	public void setCreatedNetworkTestData1(String createdNetworkTestData1) {
		this.createdNetworkTestData1 = createdNetworkTestData1;
	}

	/**
	 * @return the aliasTestData1
	 */
	public String getAliasTestData1() {
		return aliasTestData1;
	}

	/**
	 * @param aliasTestData1 the aliasTestData1 to set
	 */
	public void setAliasTestData1(String aliasTestData1) {
		this.aliasTestData1 = aliasTestData1;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	
	
}
