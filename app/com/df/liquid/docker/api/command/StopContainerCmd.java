package com.df.liquid.docker.api.command;

import com.df.liquid.docker.api.NotFoundException;
import com.df.liquid.docker.api.NotModifiedException;

/**
 * The Interface StopContainerCmd.
 */
public interface StopContainerCmd extends DockerCmd<String>{
	
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
	 * @return the stop container cmd
	 */
	public StopContainerCmd withContainerId(String containerId);

	/**
	 * With timeout.
	 *
	 * @param timeout the timeout
	 * @return the stop container cmd
	 */
	public StopContainerCmd withTimeout(int timeout);

	/**
	 * Exec.
	 *
	 * @return the string
	 * @throws NotFoundException No such container
	 * @throws NotModifiedException Container already stopped
	 */
	public String exec() throws NotFoundException, NotModifiedException;
	
	/**
	 * The Interface Exec.
	 */
	public static interface Exec extends DockerCmdExec<StopContainerCmd, String> {
	}

}
