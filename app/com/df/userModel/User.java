package com.df.userModel;

import java.util.List;

import play.Logger;

import com.df.logger.LoggerConstants;
import com.df.utils.UserConstants;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Reference;


@Entity
public class User {

	@Id
	public String emailId;
	public String alias;
	public String password;
	public String userRole;
	public String approvedBy;
	
	@Reference
	List<GraphRecord> createdNetworks;
	@Reference
	List<GraphRecord> sharedNetworks;

	public User(){}
	
	public User(String emailId, String alias, String password, String userRole,String approvedBy) {
		setAlias(alias);
		setEmailId(emailId);
		setPassword(password);
		setUserRole(userRole);
		setApprovedBy(approvedBy);
		setSharedNetworks(null);
		setCreatedNetworks(null);
	}

	public User(String emailId, String alias, String password, String userRole, String approvedBy,List<GraphRecord> createdNetworks,
			List<GraphRecord> sharedNetworks) {
		this(emailId, alias, password, userRole,approvedBy);
		setCreatedNetworks(createdNetworks);
		setSharedNetworks(sharedNetworks);
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public List<GraphRecord> getCreatedNetworks() {
		return createdNetworks;
	}

	public void setCreatedNetworks(List<GraphRecord> createdNetworks) {
		this.createdNetworks = createdNetworks;
	}

	public void setSharedNetworks(List<GraphRecord> sharedNetworks) {
		this.sharedNetworks = sharedNetworks;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getApprovedBy() {
		return this.approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public List<GraphRecord> getSharedNetworks() {
		return sharedNetworks;
	}

	public static void insertUser(User userData) {
		MorphiaObject.datastore.save(userData);
	}

	public static User findByEmail(String email){//**
    	return MorphiaObject.datastore.get(User.class, email);

   	}
	/**
	 *This function will return true only when user is exist and password is valid else it'll retun false 
	 * @param email
	 * @param password
	 * @return boolean true or false 
	 */
	public static Boolean authenticate(String email, String password){
    	
		User user = MorphiaObject.datastore.get(User.class,email);
		System.out.println("The login data"+user );
    	
    	if(user==null){
    		Logger.of(LoggerConstants.DF).info(email + "is not existed");
        	return false;
    	}
    	String sercurePassword = UserConstants.get_SecurePassword(password);
    	if(user.getPassword().equals(sercurePassword)){
    		Logger.of(LoggerConstants.DF).debug(email + " username matched with password "+user.getEmailId());
    		return true;
    	}    	
    	Logger.info("wrong credentials");
        return false;
    }
	
	
	public static Boolean isUserExist(String email) throws NullPointerException {
    	//User  user = MorphiaObject.datastore.find(User.class,"_id",email).get();
		
		User user = MorphiaObject.datastore.get(User.class,email);
	     	
    	if(user==null){
    		Logger.info(email + "is not existed");
        	return false;
    	}
    	
     return true;
    	 
	}
	public static Boolean authenticateAdmin(String email, String password) throws NullPointerException {
    	
		User user = MorphiaObject.datastore.get(User.class,email);
		
    	if(user==null){
    		Logger.info(email + "is not existed");
        	return false;
    	}
    	String sercurePassword = UserConstants.get_SecurePassword(password);
    	if((user.getPassword().equals(sercurePassword))&&(user.getUserRole().equals("ADMIN"))){
       		Logger.info("Admin name matched with password "+user.getEmailId());
    		return true;
    	}else{    	
    	Logger.info("wrong credentials for admin");
               return false;
    	}
    }
	

	public static Boolean authenticateAdmin(String email) throws NullPointerException {
   
		User user = MorphiaObject.datastore.get(User.class,email);
		
    	if(user==null){
    		Logger.info(email + "is not existed");
        	return false;
    	}
    	if(user.getUserRole().equals("ADMIN")){
       		Logger.info("Admin is varified "+user.getEmailId());
    		return true;
    	}    	
    	Logger.info("wrong credentials for admin");
        return false;
    }

   public static String deleteUser(User user){
	   //MorphiaObject.datastore.delete(user);
	   MorphiaObject.datastore.delete(user);
	   return "deleted";
   }	

}
