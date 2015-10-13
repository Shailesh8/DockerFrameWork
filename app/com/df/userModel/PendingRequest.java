package com.df.userModel;


import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;




@Entity
public class PendingRequest {
	
	public PendingRequest(String email, String alias, String password, String userRole, String userStatus) {
		super();
		this.email = email;
		this.alias = alias;
		this.password = password;
		this.userRole = userRole;
		this.userStatus = userStatus;
	}
	
	@Id
	private String email;
	private String alias;
    
	private String password;
    private String userRole;
    private String userStatus;
	
    public PendingRequest(){
    	
    }
    public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
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
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public void save(PendingRequest obj){
		MorphiaObject.datastore.save(obj);
	}
	public static PendingRequest findByEmail(String email){
    	return  MorphiaObject.datastore.find(PendingRequest.class,"_id ==",email).get();
   	}
}