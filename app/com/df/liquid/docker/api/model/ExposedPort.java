package com.df.liquid.docker.api.model;

import static com.df.liquid.docker.api.model.InternetProtocol.TCP;
import static com.df.liquid.docker.api.model.InternetProtocol.UDP;

import java.io.IOException;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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
import java.util.Map.Entry;

/**
 * Represents a container port that Docker exposes to external clients.
 * The port is defined by its {@link #getPort() port number} and an
 * {@link InternetProtocol}.
 * It can be published by Docker by {@link Ports#bind(ExposedPort, Binding) binding}
 * it to a host port, represented by a {@link Binding}.
 */
@JsonDeserialize(using = ExposedPort.Deserializer.class)
@JsonSerialize(using = ExposedPort.Serializer.class)
public class ExposedPort {

	/** The protocol. */
	private final InternetProtocol protocol;
	
	/** The port. */
	private final int port;

	/**
	 * Creates an {@link ExposedPort} for the given parameters.
	 * 
	 * @param port the {@link #getPort() port number}
	 * @param protocol the {@link InternetProtocol}
	 */
	public ExposedPort(int port, InternetProtocol protocol) {
		this.port = port;
		this.protocol = protocol;
	}

	/**
	 * Creates an {@link ExposedPort} for the given 
	 * {@link #getPort() port number} and {@link InternetProtocol#DEFAULT}.
	 * 
	 * @param port the {@link #getPort() port number}
	 */
	public ExposedPort(int port) {
		this(port, InternetProtocol.DEFAULT);
	}

	/**
	 * Creates an {@link ExposedPort} for the given parameters.
	 * 
	 * @param scheme the {@link #getScheme() scheme}, <code>tcp</code> or 
	 *        <code>udp</code>
	 * @param port the {@link #getPort() port number}
	 * @deprecated use {@link #ExposedPort(int, InternetProtocol)}
	 */
	@Deprecated
	public ExposedPort(String scheme, int port) {
		this(port, InternetProtocol.valueOf(scheme));
	}

	/**
	 * Gets the protocol.
	 *
	 * @return the {@link InternetProtocol} of the {@link #getPort() port}
	 *          that the container exposes
	 */
	public InternetProtocol getProtocol() {
		return protocol;
	}
	
	/**
	 * Gets the scheme.
	 *
	 * @return the scheme (internet protocol), <code>tcp</code> or <code>udp</code>
	 * @deprecated use {@link #getProtocol()}
	 */
	@Deprecated
	public String getScheme() {
		return protocol.toString();
	}

	/**
	 * Gets the port.
	 *
	 * @return the port number that the container exposes
	 */
	public int getPort() {
		return port;
	}

	/**
	 * Creates an {@link ExposedPort} for {@link InternetProtocol#TCP}.
	 * This is a shortcut for <code>new ExposedPort(port, {@link InternetProtocol#TCP})</code>
	 *
	 * @param port the port
	 * @return the exposed port
	 */
	public static ExposedPort tcp(int port) {
		return new ExposedPort(port, TCP);
	}

	/**
	 * Creates an {@link ExposedPort} for {@link InternetProtocol#UDP}.
	 * This is a shortcut for <code>new ExposedPort(port, {@link InternetProtocol#UDP})</code>
	 *
	 * @param port the port
	 * @return the exposed port
	 */
	public static ExposedPort udp(int port) {
		return new ExposedPort(port, UDP);
	}

	/**
	 * Parses a textual port specification (as used by the Docker CLI) to an 
	 * {@link ExposedPort}.
	 * 
	 * @param serialized the specification, e.g. <code>80/tcp</code>
	 * @return an {@link ExposedPort} matching the specification
	 * @throws IllegalArgumentException if the specification cannot be parsed
	 */
	public static ExposedPort parse(String serialized) throws IllegalArgumentException {
		Logger.of(LoggerConstants.DockerLogger).debug(LoggerConstants.methodEntry);
		try {
			String[] parts = serialized.split("/");
			switch (parts.length) {
			case 1:
				Logger.of(LoggerConstants.DockerLogger).debug(
						LoggerConstants.methodExit);
				return new ExposedPort(Integer.valueOf(parts[0]));
			case 2:
				Logger.of(LoggerConstants.DockerLogger).debug(
						LoggerConstants.methodExit);
				return new ExposedPort(Integer.valueOf(parts[0]), InternetProtocol.parse(parts[1]));
			default:
				Logger.of(LoggerConstants.DockerLogger).debug(
						LoggerConstants.methodExit);
				throw new IllegalArgumentException();
			}
		} catch (Exception e) {
			Logger.of(LoggerConstants.DockerLogger)
			.error("error parsing ExposedPart ");
			Logger.of(LoggerConstants.DockerLogger).debug(
					LoggerConstants.methodExit);
			throw new IllegalArgumentException("Error parsing ExposedPort '" + serialized + "'");
		}
	}
	
	/**
	 * Returns a string representation of this {@link ExposedPort} suitable
	 * for inclusion in a JSON message.
	 * The format is <code>port/protocol</code>, like the argument in {@link #parse(String)}.
	 * 
	 * @return a string representation of this {@link ExposedPort}
	 */
	@Override
	public String toString() {
		return port + "/" + protocol.toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ExposedPort) {
			ExposedPort other = (ExposedPort) obj;
			return new EqualsBuilder().append(protocol, other.getProtocol())
					.append(port, other.getPort()).isEquals();
		} else
			return super.equals(obj);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(protocol).append(port).toHashCode();
	}
    /*
     * Deserializer class conatins deserialize method which converting json string into objects
     */
	/**
     * The Class Deserializer.
     */
    public static class Deserializer extends JsonDeserializer<ExposedPort> {
		
		/* (non-Javadoc)
		 * @see com.fasterxml.jackson.databind.JsonDeserializer#deserialize(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext)
		 */
		@Override
		public ExposedPort deserialize(JsonParser jsonParser,
				DeserializationContext deserializationContext)
				throws IOException, JsonProcessingException {
			Logger.of(LoggerConstants.DockerLogger).debug(LoggerConstants.methodEntry); 
			ObjectCodec oc = jsonParser.getCodec();
			JsonNode node = oc.readTree(jsonParser);
			if (!node.equals(NullNode.getInstance())) {
				Logger.of(LoggerConstants.DockerLogger).info("node doesn't contain json null value");
				Entry<String, JsonNode> field = node.fields().next();
				Logger.of(LoggerConstants.DockerLogger).debug(
						LoggerConstants.methodExit);
				return ExposedPort.parse(field.getKey());
			} else {
				Logger.of(LoggerConstants.DockerLogger).info("node contain json null value");
				Logger.of(LoggerConstants.DockerLogger).debug(
						LoggerConstants.methodExit);
				return null;
			}
		}
	}
    /*
     *Serializer class contains serialize method which converting objects into json String      
     */
	/**
     * The Class Serializer.
     */
    public static class Serializer extends JsonSerializer<ExposedPort> {

		/* (non-Javadoc)
		 * @see com.fasterxml.jackson.databind.JsonSerializer#serialize(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider)
		 */
		@Override
		public void serialize(ExposedPort exposedPort, JsonGenerator jsonGen,
				SerializerProvider serProvider) throws IOException,
				JsonProcessingException {
			Logger.of(LoggerConstants.DockerLogger).debug(LoggerConstants.methodEntry);
			jsonGen.writeStartObject();
			jsonGen.writeFieldName(exposedPort.toString());
			jsonGen.writeEndObject();
			Logger.of(LoggerConstants.DockerLogger).debug(
					LoggerConstants.methodExit);
		}

	}

}