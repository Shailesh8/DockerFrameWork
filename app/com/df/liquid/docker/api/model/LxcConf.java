package com.df.liquid.docker.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class LxcConf.
 */
public class LxcConf {
	
	/** The key. */
	@JsonProperty("Key")
	public String key;

	/** The value. */
	@JsonProperty("Value")
	public String value;

	/**
	 * Instantiates a new lxc conf.
	 *
	 * @param key the key
	 * @param value the value
	 */
	public LxcConf(String key, String value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * Instantiates a new lxc conf.
	 */
	public LxcConf() {
	}

	/**
	 * Gets the key.
	 *
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Sets the key.
	 *
	 * @param key the key
	 * @return the lxc conf
	 */
	public LxcConf setKey(String key) {
		this.key = key;
		return this;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value the value
	 * @return the lxc conf
	 */
	public LxcConf setValue(String value) {
		this.value = value;
		return this;
	}

}


