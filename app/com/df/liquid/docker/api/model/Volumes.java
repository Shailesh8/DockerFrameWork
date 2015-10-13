package com.df.liquid.docker.api.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
 * The Class Volumes.
 */
@JsonSerialize(using = Volumes.Serializer.class)
@JsonDeserialize(using = Volumes.Deserializer.class)
public class Volumes {

	/** The volumes. */
	private Volume[] volumes;

	/**
	 * Instantiates a new volumes.
	 *
	 * @param volumes the volumes
	 */
	public Volumes(Volume... volumes) {
		this.volumes = volumes;
	}
	
	/**
	 * Instantiates a new volumes.
	 *
	 * @param volumes the volumes
	 */
	public Volumes(List<Volume> volumes) {
		this.volumes = volumes.toArray(new Volume[volumes.size()]);
	}

	/**
	 * Gets the volumes.
	 *
	 * @return the volumes
	 */
	public Volume[] getVolumes() {
		return volumes;
	}

	/**
	 * The Class Serializer.
	 */
	public static class Serializer extends JsonSerializer<Volumes> {

		/* (non-Javadoc)
		 * @see com.fasterxml.jackson.databind.JsonSerializer#serialize(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider)
		 */
		@Override
		public void serialize(Volumes volumes, JsonGenerator jsonGen,
				SerializerProvider serProvider) throws IOException,
				JsonProcessingException {
			
			jsonGen.writeStartObject();
			for (Volume volume : volumes.getVolumes()) {
				jsonGen.writeFieldName(volume.getPath());
				jsonGen.writeStartObject();
				jsonGen.writeEndObject();
				//jsonGen.writeString(Boolean.toString(volume.getAccessMode().equals(AccessMode.rw) ? true: false));
			}
			jsonGen.writeEndObject();
		}

	}
	
	/**
	 * The Class Deserializer.
	 */
	public static class Deserializer extends JsonDeserializer<Volumes> {
        
        /* (non-Javadoc)
         * @see com.fasterxml.jackson.databind.JsonDeserializer#deserialize(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext)
         */
        @Override
        public Volumes deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

        	List<Volume> volumes = new ArrayList<Volume>();
            ObjectCodec oc = jsonParser.getCodec();
            JsonNode node = oc.readTree(jsonParser);
            for (Iterator<Map.Entry<String, JsonNode>> it = node.fields(); it.hasNext();) {

                Map.Entry<String, JsonNode> field = it.next();
                if (!field.getValue().equals(NullNode.getInstance())) {
                	String path = field.getKey();
                	Volume volume = new Volume(path);
                	volumes.add(volume);
                }
            }
            return new Volumes(volumes.toArray(new Volume[0]));
        }
    
	}
}
