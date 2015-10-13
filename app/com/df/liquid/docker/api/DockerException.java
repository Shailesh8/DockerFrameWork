package com.df.liquid.docker.api;

/**
 * The Class DockerException.
 */
public class DockerException extends RuntimeException {

/** The Constant serialVersionUID. */
private static final long serialVersionUID = DockerConstants.dockerSerialVersionUID5;
	
	/** The http status. */
	private int httpStatus = 0;

    /**
     * Instantiates a new docker exception.
     *
     * @param message the message
     * @param httpStatus the http status
     */
    public DockerException(String message, int httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    /**
     * Instantiates a new docker exception.
     *
     * @param message the message
     * @param httpStatus the http status
     * @param cause the cause
     */
    public DockerException(String message, int httpStatus, Throwable cause) {
        super(message, cause);
    }
    
    /**
     * Gets the http status.
     *
     * @return the http status
     */
    public int getHttpStatus() {
		return httpStatus;
	}
}
