package com.df.liquid.docker.api.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
 * The Class Links.
 */
@JsonSerialize(using = Links.Serializer.class)
@JsonDeserialize(using = Links.Deserializer.class)
public class Links
{

	/** The links. */
	private final Link[] links;

	/**
	 * Instantiates a new links.
	 *
	 * @param links the links
	 */
	public Links(final Link... links)
	{
		this.links = links;
	}

	/**
	 * Instantiates a new links.
	 *
	 * @param links the links
	 */
	public Links(final List<Link> links) {
		this.links = links.toArray(new Link[links.size()]);
	}

	/**
	 * Gets the links.
	 *
	 * @return the links
	 */
	public Link[] getLinks()
	{
		return links;
	}

	/**
	 * The Class Serializer.
	 */
	public static class Serializer extends JsonSerializer<Links>
	{

		/* (non-Javadoc)
		 * @see com.fasterxml.jackson.databind.JsonSerializer#serialize(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider)
		 */
		@Override
		public void serialize(final Links links, final JsonGenerator jsonGen, final SerializerProvider serProvider) throws IOException, JsonProcessingException
		{
			jsonGen.writeStartArray();
			for (final Link link : links.getLinks()) {
				jsonGen.writeString(link.toString());
			}
			jsonGen.writeEndArray();
		}

	}

	/**
	 * The Class Deserializer.
	 */
	public static class Deserializer extends JsonDeserializer<Links>
	{

		/* (non-Javadoc)
		 * @see com.fasterxml.jackson.databind.JsonDeserializer#deserialize(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext)
		 */
		@Override
		public Links deserialize(final JsonParser jsonParser, final DeserializationContext deserializationContext) throws IOException, JsonProcessingException
		{
			final List<Link> binds = new ArrayList<Link>();
			final ObjectCodec oc = jsonParser.getCodec();
			final JsonNode node = oc.readTree(jsonParser);
			for (final Iterator<JsonNode> it = node.elements(); it.hasNext();) {

				final JsonNode element = it.next();
				if (!element.equals(NullNode.getInstance())) {
					binds.add(Link.parse(element.asText()));
				}
			}
			return new Links(binds.toArray(new Link[0]));
		}
	}

}