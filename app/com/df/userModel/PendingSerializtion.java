package com.df.userModel;

import java.lang.reflect.Type;


import com.google.gson.JsonSerializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;

public class PendingSerializtion implements JsonSerializer<PendingRequest> {

	@Override
	public JsonElement serialize(PendingRequest user, Type typeOfDemands, JsonSerializationContext context) {

		final JsonObject jsonObject = new JsonObject();

		jsonObject.addProperty("alias", user.getAlias());
		jsonObject.addProperty("email", user.getEmail());
		jsonObject.addProperty("userRole", user.getUserRole());
		jsonObject.addProperty("UserStatus", user.getUserStatus());

		return jsonObject;
	}

}

