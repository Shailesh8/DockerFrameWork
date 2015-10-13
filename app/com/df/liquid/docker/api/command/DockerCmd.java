package com.df.liquid.docker.api.command;

/**
 * The Interface DockerCmd.
 *
 * @param <RES_T> the generic type
 */
public interface DockerCmd<RES_T> {
	
	/**
	 * Exec.
	 *
	 * @return the res t
	 */
	public RES_T exec();
}
