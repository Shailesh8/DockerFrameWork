package com.df.liquid.docker.api.model;


import static com.google.common.base.Preconditions.checkNotNull;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class Device.
 */
public class Device {

	/** The c group permissions. */
	@JsonProperty("CgroupPermissions")
	private String cGroupPermissions = "";

	/** The path on host. */
	@JsonProperty("PathOnHost")
	private String pathOnHost = null;

	/** The path in container. */
	@JsonProperty("PathInContainer")
	private String pathInContainer = null;

	/**
	 * Instantiates a new device.
	 */
	public Device() {
	}

	/**
	 * Instantiates a new device.
	 *
	 * @param cGroupPermissions the c group permissions
	 * @param pathInContainer the path in container
	 * @param pathOnHost the path on host
	 */
	public Device(String cGroupPermissions, String pathInContainer,
			String pathOnHost) {
		checkNotNull(cGroupPermissions,
				"cGroupPermissions is null");
		checkNotNull(pathInContainer, "pathInContainer is null");
		checkNotNull(pathOnHost, "pathOnHost is null");
		this.cGroupPermissions = cGroupPermissions;
		this.pathInContainer = pathInContainer;
		this.pathOnHost = pathOnHost;
	}

	/**
	 * Gets the c group permissions.
	 *
	 * @return the c group permissions
	 */
	public String getcGroupPermissions() {
		return cGroupPermissions;
	}

	/**
	 * Gets the path in container.
	 *
	 * @return the path in container
	 */
	public String getPathInContainer() {
		return pathInContainer;
	}

	/**
	 * Gets the path on host.
	 *
	 * @return the path on host
	 */
	public String getPathOnHost() {
		return pathOnHost;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Device) {
			Device other = (Device) obj;
			return new EqualsBuilder()
					.append(cGroupPermissions, other.getcGroupPermissions())
					.append(pathInContainer, other.getPathInContainer())
					.append(pathOnHost, other.getPathOnHost()).isEquals();
		} else
			return super.equals(obj);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(cGroupPermissions)
				.append(pathInContainer).append(pathOnHost).toHashCode();
	}

}

