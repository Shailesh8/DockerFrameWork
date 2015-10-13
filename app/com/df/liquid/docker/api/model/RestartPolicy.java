package com.df.liquid.docker.api.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import static com.google.common.base.Preconditions.checkNotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Container restart policy
 * 
 * <dl>
 *   <dt>no</dt>
 *   <dd>Do not restart the container if it dies. (default)</dd>
 *   
 *   <dt>on-failure</dt>
 *   <dd>Restart the container if it exits with a non-zero exit code.
 *       Can also accept an optional maximum restart count (e.g. on-failure:5).<dd>
 *   
 *   <dt>always</dt>
 *   <dd>Always restart the container no matter what exit code is returned.<dd>
 * </dl>
 *
 * @author marcus
 *
 */
public class RestartPolicy {

	/** The maximum retry count. */
	@JsonProperty("MaximumRetryCount")
	private int maximumRetryCount = 0;

	/** The name. */
	@JsonProperty("Name")
	private String name = "";

	/**
	 * Instantiates a new restart policy.
	 */
	public RestartPolicy() {
	}

	/**
	 * Instantiates a new restart policy.
	 *
	 * @param maximumRetryCount the maximum retry count
	 * @param name the name
	 */
	private RestartPolicy(int maximumRetryCount, String name) {
		checkNotNull(name, "name is null");
		this.maximumRetryCount = maximumRetryCount;
		this.name = name;
	}

	/**
	 * Do not restart the container if it dies. (default)
	 *
	 * @return the restart policy
	 */
	public static RestartPolicy noRestart() {
		return new RestartPolicy();
	}

	/**
	 * Always restart the container no matter what exit code is returned.
	 *
	 * @return the restart policy
	 */
	public static RestartPolicy alwaysRestart() {
		return new RestartPolicy(0, "always");
	}

	/**
	 * Restart the container if it exits with a non-zero exit code.
	 *
	 * @param maximumRetryCount the maximum number of restarts.
	 *        Set to <code>0</code> for unlimited retries.
	 * @return the restart policy
	 */
	public static RestartPolicy onFailureRestart(int maximumRetryCount) {
		return new RestartPolicy(maximumRetryCount, "on-failure");
	}

	/**
	 * Gets the maximum retry count.
	 *
	 * @return the maximum retry count
	 */
	public int getMaximumRetryCount() {
		return maximumRetryCount;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Parses a textual restart polixy specification (as used by the Docker CLI) 
	 * to a {@link RestartPolicy}.
	 * 
	 * @param serialized the specification, e.g. <code>on-failure:2</code>
	 * @return a {@link RestartPolicy} matching the specification
	 * @throws IllegalArgumentException if the specification cannot be parsed
	 */
	public static RestartPolicy parse(String serialized) throws IllegalArgumentException {
		try {
			String[] parts = serialized.split(":");
			String name = parts[0];
			if ("no".equals(name))
				return noRestart();
			if ("always".equals(name))
				return alwaysRestart();
			if ("on-failure".equals(name)) {
				int count = 0;
				if (parts.length == 2) {
					count = Integer.parseInt(parts[1]);
				}
				return onFailureRestart(count);
			}
			throw new IllegalArgumentException();
		} catch (Exception e) {
			throw new IllegalArgumentException("Error parsing RestartPolicy '" + serialized + "'");
		}
	}

	/**
	 * Returns a string representation of this {@link RestartPolicy}.
	 * The format is <code>name[:count]</code>, like the argument in {@link #parse(String)}.
	 * 
	 * @return a string representation of this {@link RestartPolicy}
	 */
	@Override
	public String toString() {
		String result = name.isEmpty() ? "no" : name;
		return maximumRetryCount > 0 ? result + ":" + maximumRetryCount : result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof RestartPolicy) {
			RestartPolicy other = (RestartPolicy) obj;
			return new EqualsBuilder()
					.append(maximumRetryCount, other.getMaximumRetryCount())
					.append(name, other.getName())
					.isEquals();
		} else
			return super.equals(obj);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(maximumRetryCount)
				.append(name).toHashCode();
	}

}


