package com.df.solid.model.exception;

public class NodeNotSpecifiedException extends DFBaseException {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param exception
	 */
	public NodeNotSpecifiedException(String exception) {

		super(exception);
	}

	public NodeNotSpecifiedException(String exception, Throwable cause) {
		super(exception, cause);
	}

}
