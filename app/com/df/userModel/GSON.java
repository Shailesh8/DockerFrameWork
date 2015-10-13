package com.df.userModel;



import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GSON {

	public static Gson getGson(){
	GsonBuilder gsonBuilder = new GsonBuilder();
	gsonBuilder.registerTypeAdapter(PendingRequest.class, new PendingSerializtion());
	
	
	

	return gsonBuilder.create();
}

}