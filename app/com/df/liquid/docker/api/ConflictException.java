package com.df.liquid.docker.api;

/**
 * The Class ConflictException.
 */
public class ConflictException extends DockerException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = DockerConstants.dockerSerialVersionUID4;

	/**
	 * Instantiates a new conflict exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public ConflictException(String message, Throwable cause) {
        super(message, 409, cause);
    }
	
	/**
	 * Instantiates a new conflict exception.
	 *
	 * @param message the message
	 */
	public ConflictException(String message) {
        this(message, null);
    }
	
	/**
	 * Instantiates a new conflict exception.
	 *
	 * @param cause the cause
	 */
	public ConflictException(Throwable cause) {
        this(cause.getMessage(), cause);
    }

}
