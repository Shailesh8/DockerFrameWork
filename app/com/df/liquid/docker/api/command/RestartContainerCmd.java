package com.df.liquid.docker.api.command;

import com.df.liquid.docker.api.NotFoundException;

/**
 * The Interface RestartContainerCmd.
 */
public interface RestartContainerCmd extends DockerCmd<String>{

	/**
	 * Gets the container id.
	 *
	 * @return the container id
	 */
	public String getContainerId();

	/**
	 * Gets the timeout.
	 *
	 * @return the timeout
	 */
	public int getTimeout();

	/**
	 * With container id.
	 *
	 * @param containerId the container id
	 * @return the restart container cmd
	 */
	public RestartContainerCmd withContainerId(String containerId);

	/**
	 * Witht timeout.
	 *
	 * @param timeout the timeout
	 * @return the restart container cmd
	 */
	public RestartContainerCmd withtTimeout(int timeout);

	/**
	 * Exec.
	 *
	 * @return the void
	 * @throws NotFoundException No such container
	 */
	public String exec() throws NotFoundException;
	
	/**
	 * The Interface Exec.
	 */
	public static interface Exec extends DockerCmdExec<RestartContainerCmd, String> {
	}
}
