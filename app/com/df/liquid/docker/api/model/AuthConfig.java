package com.df.liquid.docker.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class AuthConfig.
 */
public class AuthConfig {

    /**
     * For backwards compatibility. Make sure you update the properties if you change this.
     *
     * @see "/docker.io.properties"
     */
    public static final String DEFAULT_SERVER_ADDRESS = "https://index.docker.io/v1/";

    /** The username. */
    @JsonProperty
	private String username;
	
	/** The password. */
	@JsonProperty
	private String password;
	
	/** The email. */
	@JsonProperty
	private String email;
	
	/** The server address. */
	@JsonProperty("serveraddress")
	private String serverAddress = DEFAULT_SERVER_ADDRESS;

	/** The auth. */
	private String auth;

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username.
	 *
	 * @param username the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the server address.
	 *
	 * @return the server address
	 */
	public String getServerAddress() {
		return serverAddress;
	}

	/**
	 * Sets the server address.
	 *
	 * @param serverAddress the new server address
	 */
	public void setServerAddress(String serverAddress) {
		this.serverAddress = serverAddress;
	}

	/**
	 * Gets the auth.
	 *
	 * @return the auth
	 */
	@JsonIgnore
	public String getAuth() {
		return auth;
	}

	/**
	 * Sets the auth.
	 *
	 * @param auth the new auth
	 */
	@JsonProperty("auth")
	public void setAuth(String auth) {
		this.auth = auth;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AuthConfig{" +
				"username='" + username + '\'' +
				", password='" + password + '\'' +
				", email='" + email + '\'' +
				", serverAddress='" + serverAddress + '\'' +
				'}';
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((auth == null) ? 0 : auth.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((serverAddress == null) ? 0 : serverAddress.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuthConfig other = (AuthConfig) obj;
		if (auth == null) {
			if (other.auth != null)
				return false;
		} else if (!auth.equals(other.auth))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (serverAddress == null) {
			if (other.serverAddress != null)
				return false;
		} else if (!serverAddress.equals(other.serverAddress))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
}
