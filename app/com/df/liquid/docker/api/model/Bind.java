package com.df.liquid.docker.api.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;


/**
 * Represents a host path being bind mounted as a {@link Volume}
 * in a Docker container.
 * The Bind can be in read only or read write access mode.
 */
public class Bind {

	/** The path. */
	private String path;

	/** The volume. */
	private Volume volume;

	/** The access mode. */
	private AccessMode accessMode;

	/**
	 * Instantiates a new bind.
	 *
	 * @param path the path
	 * @param volume the volume
	 */
	public Bind(String path, Volume volume) {
		this(path, volume, AccessMode.DEFAULT);
	}

	/**
	 * Instantiates a new bind.
	 *
	 * @param path the path
	 * @param volume the volume
	 * @param accessMode the access mode
	 */
	public Bind(String path, Volume volume, AccessMode accessMode) {
		this.path = path;
		this.volume = volume;
		this.accessMode = accessMode;
	}

	/**
	 * Gets the path.
	 *
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * Gets the volume.
	 *
	 * @return the volume
	 */
	public Volume getVolume() {
		return volume;
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
	 * Parses a bind mount specification to a {@link Bind}.
	 *
	 * @param serialized the specification, e.g. <code>/host:/container:ro</code>
	 * @return a {@link Bind} matching the specification
	 */
	public static Bind parse(String serialized) {
		try {
			String[] parts = serialized.split(":");
			switch (parts.length) {
			case 2: {
				return new Bind(parts[0], new Volume(parts[1]));
			}
			case 3: {
				AccessMode accessMode = AccessMode.valueOf(parts[2].toLowerCase());
				return new Bind(parts[0], new Volume(parts[1]), accessMode);
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
		if (obj instanceof Bind) {
			Bind other = (Bind) obj;
			return new EqualsBuilder().append(path, other.getPath())
					.append(volume, other.getVolume())
					.append(accessMode, other.getAccessMode()).isEquals();
		} else
			return super.equals(obj);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(path).append(volume)
				.append(accessMode).toHashCode();
	}

	/**
	 * Returns a string representation of this {@link Bind} suitable
	 * for inclusion in a JSON message.
	 * The format is <code>&lt;host path&gt;:&lt;container path&gt;:&lt;access mode&gt;</code>,
	 * like the argument in {@link #parse(String)}.
	 * 
	 * @return a string representation of this {@link Bind}
	 */
	@Override
	public String toString() {
		return path + ":" + volume.getPath() + ":" + accessMode.toString();
	}

}