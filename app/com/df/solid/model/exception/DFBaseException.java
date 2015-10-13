/**
 * 
 */
package com.df.solid.model.exception;

public class DFBaseException extends Exception {

	private static final long serialVersionUID = 1L;

	public DFBaseException(String exception) {
		super(exception);
	}

	public DFBaseException(String exception, Throwable cause) {
		super(exception, cause);
	}
}
