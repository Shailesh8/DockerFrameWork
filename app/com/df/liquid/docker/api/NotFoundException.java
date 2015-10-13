package com.df.liquid.docker.api;

/**
 * The Class NotFoundException.
 */
public class NotFoundException extends DockerException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = DockerConstants.dockerSerialVersionUID6;

	/**
	 * Instantiates a new not found exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public NotFoundException(String message, Throwable cause) {
        super(message, 404, cause);
    }
	
	/**
	 * Instantiates a new not found exception.
	 *
	 * @param message the message
	 */
	public NotFoundException(String message) {
        this(message, null);
    }
	
	/**
	 * Instantiates a new not found exception.
	 *
	 * @param cause the cause
	 */
	public NotFoundException(Throwable cause) {
        this(cause.getMessage(), cause);
    }
}
