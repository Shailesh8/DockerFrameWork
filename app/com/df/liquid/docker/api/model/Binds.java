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
 * The Class Binds.
 */
@JsonSerialize(using = Binds.Serializer.class)
@JsonDeserialize(using = Binds.Deserializer.class)
public class Binds {

	/** The binds. */
	private Bind[] binds;

	/**
	 * Instantiates a new binds.
	 *
	 * @param binds the binds
	 */
	public Binds(Bind... binds) {
		this.binds = binds;
	}

	/**
	 * Gets the binds.
	 *
	 * @return the binds
	 */
	public Bind[] getBinds() {
		return binds;
	}

	/**
	 * The Class Serializer.
	 */
	public static class Serializer extends JsonSerializer<Binds> {

		/* (non-Javadoc)
		 * @see com.fasterxml.jackson.databind.JsonSerializer#serialize(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider)
		 */
		@Override
		public void serialize(Binds binds, JsonGenerator jsonGen,
				SerializerProvider serProvider) throws IOException,
				JsonProcessingException {
			
			//
			jsonGen.writeStartArray();
			for (Bind bind : binds.getBinds()) {
				jsonGen.writeString(bind.toString());
			}
			jsonGen.writeEndArray();
			//
		}

	}
	
	/**
	 * The Class Deserializer.
	 */
	public static class Deserializer extends JsonDeserializer<Binds> {
        
        /* (non-Javadoc)
         * @see com.fasterxml.jackson.databind.JsonDeserializer#deserialize(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext)
         */
        @Override
        public Binds deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

        	List<Bind> binds = new ArrayList<Bind>();
            ObjectCodec oc = jsonParser.getCodec();
            JsonNode node = oc.readTree(jsonParser);
            for (Iterator<Map.Entry<String, JsonNode>> it = node.fields(); it.hasNext();) {

                Map.Entry<String, JsonNode> field = it.next();
                if (!field.getValue().equals(NullNode.getInstance())) {
                	binds.add(Bind.parse(field.getKey()));
                }
            }
            return new Binds(binds.toArray(new Bind[0]));
        }
    }

}