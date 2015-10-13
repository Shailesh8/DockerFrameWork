package com.df.liquid.docker.execs;

import com.df.liquid.docker.api.DockerException;
import com.df.liquid.docker.api.command.DockerCmd;
import com.df.liquid.docker.api.command.DockerCmdExec;
import com.df.logger.LoggerConstants;
import com.google.common.base.Preconditions;

import javax.ws.rs.ProcessingException;

import play.Logger;

/**
 * The Class AbstrDockerCmdExec 
 *
 * @param <CMD_T> the generic type
 * @param <RES_T> the generic type
 */
public abstract class AbstrDockerCmdExec<CMD_T extends DockerCmd<RES_T>, RES_T> implements DockerCmdExec<CMD_T, RES_T>{
	
	/** The request holder. */
	private String requestHolder;

	/**
	 * Instantiates a new abstr docker cmd exec.
	 *
	 * @param requestHolder the request holder
	 */
	public AbstrDockerCmdExec(String requestHolder) {
		Preconditions.checkNotNull(requestHolder,
				"baseResource was not specified");
		this.requestHolder = requestHolder;
	}

	/**
	 * Gets the request holder.
	 *
	 * @return the request holder
	 */
	protected String getRequestHolder() {
		return requestHolder;
	}

	
	
	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.DockerCmdExec#exec(com.egnaro.automatter.liquid.docker.api.command.DockerCmd)
	 */
	public RES_T exec(CMD_T command) {
		
		RES_T result;
		try {
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(LoggerConstants.METHODENTRY);
			result = execute(command);
		} catch (ProcessingException e) {
			Logger.of(LoggerConstants.DOCKERLOGGER).error(LoggerConstants.INVALIDPARAMETER);
		    Throwable cause =  e.getCause();
		if( cause instanceof DockerException) {
			Logger.of(LoggerConstants.DOCKERLOGGER).info(LoggerConstants.DOCKEREXCEPTION);	
			throw (DockerException) cause;
		} else {
			Logger.of(LoggerConstants.DOCKERLOGGER).info(LoggerConstants.EXCEPTION);	
			throw e;
			}
		}
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);
		return result;
	}

	/**
	 * Execute.
	 *
	 * @param command the command
	 * @return the res t
	 */
	protected abstract RES_T execute(CMD_T command);
}
