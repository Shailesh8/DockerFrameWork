package com.df.liquid.docker.api.model;

import com.df.utils.LoggerConstants;

import play.Logger;

/**
 * The IP protocols supported by Docker.
 * 
 * @see #TCP
 * @see #UDP
 */
public enum InternetProtocol {
	
	/**  The <i>Transmission Control Protocol</i>. */
	TCP, 

	/**  The <i>User Datagram Protocol</i>. */
	UDP;
	
	/** The default {@link InternetProtocol}: {@link #TCP}. */
	public static final InternetProtocol DEFAULT = TCP;

	/**
	 * Returns a string representation of this {@link InternetProtocol} suitable
	 * for inclusion in a JSON message.
	 * The output is the lowercased name of the Protocol, e.g. <code>tcp</code>.
	 * 
	 * @return a string representation of this {@link InternetProtocol}
	 */
	@Override
	public String toString() {
		return super.toString().toLowerCase();
	}

	/**
	 * Parses a string to an {@link InternetProtocol}.
	 * 
	 * @param serialized the protocol, e.g. <code>tcp</code> or <code>TCP</code>
	 * @return an {@link InternetProtocol} described by the string
	 * @throws IllegalArgumentException if the argument cannot be parsed
	 */
	public static InternetProtocol parse(String serialized) throws IllegalArgumentException {
		Logger.of(LoggerConstants.DockerLogger).debug(LoggerConstants.methodEntry);
		try {
			Logger.of(LoggerConstants.DockerLogger).info("parsing protocol '"+ serialized +"'");
			Logger.of(LoggerConstants.DockerLogger).debug(
					LoggerConstants.methodExit);
			return valueOf(serialized.toUpperCase());
		} catch (Exception e) {
			Logger.of(LoggerConstants.DockerLogger).error("Error parsing protocol '"+ serialized + "'");
			Logger.of(LoggerConstants.DockerLogger).debug(
					LoggerConstants.methodExit);
			throw new IllegalArgumentException("Error parsing Protocol '" + serialized + "'");
		}
	}

}

