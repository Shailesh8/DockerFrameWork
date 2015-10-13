
package com.df.utils;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class GraphObjectAdapter implements JsonSerializer<Object>,
		JsonDeserializer<Object> {

	@Override
	public Object deserialize(JsonElement jsonElement, Type type,
			JsonDeserializationContext jsonDeserializationContext)
			throws JsonParseException {
		JsonObject jsonObj = jsonElement.getAsJsonObject();
		String className = null;

		if (jsonObj.get("modelInfo") != null) {
			JsonElement modelElem = jsonObj.get("modelInfo");

			className = modelElem.getAsJsonObject().get("concreteClass")
					.getAsString();
		} else if (jsonObj.get("concreteClass") != null) {
			className = jsonObj.get("concreteClass").getAsString();
		}

		if (className != null) {
			try {
				Class<?> clz = Class.forName(className.substring(6));
				return jsonDeserializationContext.deserialize(jsonElement, clz);
			} catch (ClassNotFoundException e) {
				throw new JsonParseException(e);
			}
		}
		return null;

	}

	@Override
	public JsonElement serialize(Object object, Type type,
			JsonSerializationContext jsonSerializationContext) {
		JsonElement jsonEle = jsonSerializationContext.serialize(object,
				object.getClass());
		return jsonEle;
	}

}
