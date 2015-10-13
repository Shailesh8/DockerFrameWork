package com.df.liquid.docker.api;

/**
 * The Class NotModifiedException.
 */
public class NotModifiedException  extends DockerException {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = DockerConstants.dockerSerialVersionUID4;

	/**
	 * Instantiates a new not modified exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public NotModifiedException(String message, Throwable cause) {
        super(message, 304, cause);
    }
	
	/**
	 * Instantiates a new not modified exception.
	 *
	 * @param message the message
	 */
	public NotModifiedException(String message) {
        this(message, null);
    }
	
	/**
	 * Instantiates a new not modified exception.
	 *
	 * @param cause the cause
	 */
	public NotModifiedException(Throwable cause) {
        this(cause.getMessage(), cause);
    }
}
