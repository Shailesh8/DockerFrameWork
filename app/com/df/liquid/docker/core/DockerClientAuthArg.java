package com.df.liquid.docker.core;

public class DockerClientAuthArg {
private String username;
private String password;
private String email;
private String serverAddress;

public  void  setUsername(String  username){
	this.username=username;
}
public void setPassword(String password){
	this.password=password;
}
public void  setEmail(String email){
	this.email=email;
}
public void setServerAddress(String serverAddress){
	this.serverAddress=serverAddress;
}

public String getUsername(){
	return username;
}

public String getPassword(){
	return password ;
}

public String getEmail(){
   return email;	
}
public String getServerAddress(){
	return serverAddress;
}

}
