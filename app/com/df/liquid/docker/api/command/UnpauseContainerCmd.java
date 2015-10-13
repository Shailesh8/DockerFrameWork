package com.df.liquid.docker.api.command;

import com.df.liquid.docker.api.NotFoundException;

/**
 * The Interface UnpauseContainerCmd.
 */
public interface UnpauseContainerCmd extends DockerCmd<String> {

	/**
	 * Gets the container id.
	 *
	 * @return the container id
	 */
	public String getContainerId();

	/**
	 * With container id.
	 *
	 * @param containerId the container id
	 * @return the unpause container cmd
	 */
	public UnpauseContainerCmd withContainerId(String containerId);

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
	public static interface Exec extends DockerCmdExec<UnpauseContainerCmd, String> {
	}
}
