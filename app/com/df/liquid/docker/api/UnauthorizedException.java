package com.df.liquid.docker.api;



public class UnauthorizedException extends DockerException {

	private static final long serialVersionUID = DockerConstants.dockerSerialVersionUID7;

	public UnauthorizedException(String message, Throwable cause) {
        super(message, 401, cause);
    }
	
	public UnauthorizedException(String message) {
        this(message, null);
    }
	
	public UnauthorizedException(Throwable cause) {
        this(cause.getMessage(), cause);
    }

}