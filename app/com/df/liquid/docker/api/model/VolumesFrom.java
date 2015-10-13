package com.df.liquid.docker.api.model;

import java.io.IOException;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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

/**
 * The Class VolumesFrom.
 */
@JsonSerialize(using = VolumesFrom.Serializer.class)
@JsonDeserialize(using = VolumesFrom.Deserializer.class)
public class VolumesFrom {

	/** The container. */
	private String container;

	/** The access mode. */
	private AccessMode accessMode;

	/**
	 * Instantiates a new volumes from.
	 *
	 * @param container the container
	 */
	public VolumesFrom(String container) {
		this(container, AccessMode.DEFAULT);
	}

	/**
	 * Instantiates a new volumes from.
	 *
	 * @param container the container
	 * @param accessMode the access mode
	 */
	public VolumesFrom(String container, AccessMode accessMode) {
		this.container = container;
		this.accessMode = accessMode;
	}
	
	/**
	 * Gets the container.
	 *
	 * @return the container
	 */
	public String getContainer() {
		return container;
	}
	
	/**
	 * Gets the access mode.
	 *
	 * @return the access mode
	 */
	public AccessMode getAccessMode() {
		return accessMode;
	}


	/**
	 * Parses a volume from specification to a {@link VolumesFrom}.
	 *
	 * @param serialized the specification, e.g. <code>container:ro</code>
	 * @return a {@link VolumesFrom} matching the specification
	 */
	public static VolumesFrom parse(String serialized) {
		try {
			String[] parts = serialized.split(":");
			switch (parts.length) {
			case 1: {
				return new VolumesFrom(parts[0]);
			}
			case 2: {
				return new VolumesFrom(parts[0], AccessMode.valueOf(parts[1]));
			}
			
			default: {
				throw new IllegalArgumentException();
			}
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("Error parsing Bind '" + serialized
					+ "'");
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof VolumesFrom) {
			VolumesFrom other = (VolumesFrom) obj;
			return new EqualsBuilder().append(container, other.getContainer())
					.append(accessMode, other.getAccessMode()).isEquals();
		} else
			return super.equals(obj);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(container)
				.append(accessMode).toHashCode();
	}

	/**
	 * Returns a string representation of this {@link VolumesFrom} suitable
	 * for inclusion in a JSON message.
	 * The format is <code>&lt;container&gt;:&lt;access mode&gt;</code>,
	 * like the argument in {@link #parse(String)}.
	 * 
	 * @return a string representation of this {@link VolumesFrom}
	 */
	@Override
	public String toString() {
		return container + ":" + accessMode.toString();
	}
	
	/**
	 * The Class Serializer.
	 */
	public static class Serializer extends JsonSerializer<VolumesFrom> {

		/* (non-Javadoc)
		 * @see com.fasterxml.jackson.databind.JsonSerializer#serialize(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider)
		 */
		@Override
		public void serialize(VolumesFrom volumeFrom, JsonGenerator jsonGen,
				SerializerProvider serProvider) throws IOException,
				JsonProcessingException {

			jsonGen.writeString(volumeFrom.toString());
			
		}

	}

	/**
	 * The Class Deserializer.
	 */
	public static class Deserializer extends JsonDeserializer<VolumesFrom> {
		
		/* (non-Javadoc)
		 * @see com.fasterxml.jackson.databind.JsonDeserializer#deserialize(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext)
		 */
		@Override
		public VolumesFrom deserialize(JsonParser jsonParser,
				DeserializationContext deserializationContext)
				throws IOException, JsonProcessingException {

			ObjectCodec oc = jsonParser.getCodec();
			JsonNode node = oc.readTree(jsonParser);
			return VolumesFrom.parse(node.asText());
			
		}
	}

}


