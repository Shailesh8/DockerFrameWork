package com.df.liquid.docker.api.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Represents a bind mounted volume in a Docker container.
 * 
 * @see Bind
 */
public class Volume {

	/** The path. */
	private String path;
	
	/**
	 * Instantiates a new volume.
	 *
	 * @param path the path
	 */
	public Volume(String path) {
		this.path = path;
	}

	/**
	 * Gets the path.
	 *
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getPath();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Volume) {
			Volume other = (Volume) obj;
			return new EqualsBuilder().append(path, other.getPath()).isEquals();
		} else
			return super.equals(obj);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(path).toHashCode();
	}

}


