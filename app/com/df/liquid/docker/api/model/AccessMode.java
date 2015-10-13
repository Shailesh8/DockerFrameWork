package com.df.liquid.docker.api.model;

/**
 * The access mode of a file system or file: <code>read-write</code>
 * or <code>read-only</code>.
 */
public enum AccessMode {
	
	/**  read-write. */
	rw,
	
	/**  read-only. */
	ro;
	
	/** The default {@link AccessMode}: {@link #rw}. */
	public static final AccessMode DEFAULT = rw;
	
	/**
	 * From boolean.
	 *
	 * @param accessMode the access mode
	 * @return the access mode
	 */
	public static final AccessMode fromBoolean(boolean accessMode) {
		return accessMode ? rw : ro;
	}
	
	/**
	 * To boolean.
	 *
	 * @return true, if successful
	 */
	public final boolean toBoolean() {
		return this.equals(AccessMode.rw) ? true: false;
	}

	
}


