package com.df.liquid.docker.api.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import play.Logger;

import com.df.utils.LoggerConstants;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.node.NullNode;

/**
 * The Class ExposedPorts.
 */
@JsonSerialize(using = ExposedPorts.Serializer.class)
@JsonDeserialize(using = ExposedPorts.Deserializer.class)
public class ExposedPorts {

	/** The exposed ports. */
	private ExposedPort[] exposedPorts;

	/**
	 * Instantiates a new exposed ports.
	 *
	 * @param exposedPorts the exposed ports
	 */
	public ExposedPorts(ExposedPort... exposedPorts) {
		this.exposedPorts = exposedPorts;
	}
	
	/**
	 * Instantiates a new exposed ports.
	 *
	 * @param exposedPorts the exposed ports
	 */
	public ExposedPorts(List<ExposedPort> exposedPorts) {
		this.exposedPorts = exposedPorts.toArray(new ExposedPort[exposedPorts.size()]);
	}

	/**
	 * Gets the exposed ports.
	 *
	 * @return the exposed ports
	 */
	public ExposedPort[] getExposedPorts() {
		return exposedPorts;
	}
	/*
     *Serializer class contains serialize method which converting objects into json String      
     */
	/**
	 * The Class Serializer.
	 */
	public static class Serializer extends JsonSerializer<ExposedPorts> {
        
		/* (non-Javadoc)
		 * @see com.fasterxml.jackson.databind.JsonSerializer#serialize(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider)
		 */
		@Override
		public void serialize(ExposedPorts exposedPorts, JsonGenerator jsonGen,
				SerializerProvider serProvider) throws IOException,
				JsonProcessingException {
			Logger.of(LoggerConstants.DockerLogger).debug(LoggerConstants.methodEntry);	
			jsonGen.writeStartObject();
			for (ExposedPort exposedPort : exposedPorts.getExposedPorts()) {
				jsonGen.writeFieldName(exposedPort.toString());
				jsonGen.writeStartObject();
				jsonGen.writeEndObject();
			}
			jsonGen.writeEndObject();
			Logger.of(LoggerConstants.DockerLogger).debug(
					LoggerConstants.methodExit);
		}

	}
	/*
     * Deserializer class conatins deserialize method which converting json string into objects
     */
	/**
	 * The Class Deserializer.
	 */
	public static class Deserializer extends JsonDeserializer<ExposedPorts> {
        
        /* (non-Javadoc)
         * @see com.fasterxml.jackson.databind.JsonDeserializer#deserialize(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext)
         */
        @Override
        public ExposedPorts deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        	Logger.of(LoggerConstants.DockerLogger).debug(LoggerConstants.methodEntry);
        	List<ExposedPort> exposedPorts = new ArrayList<ExposedPort>();
            ObjectCodec oc = jsonParser.getCodec();
            JsonNode node = oc.readTree(jsonParser);
            for (Iterator<Map.Entry<String, JsonNode>> it = node.fields(); it.hasNext();) {

                Map.Entry<String, JsonNode> field = it.next();
                if (!field.getValue().equals(NullNode.getInstance())) {
                	exposedPorts.add(ExposedPort.parse(field.getKey()));
                }
            }
			Logger.of(LoggerConstants.DockerLogger).debug(
					LoggerConstants.methodExit);
            return new ExposedPorts(exposedPorts.toArray(new ExposedPort[0]));
        }
    }

}

