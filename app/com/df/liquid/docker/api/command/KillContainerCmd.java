package com.df.liquid.docker.api.command;

import com.df.liquid.docker.api.NotFoundException;

/**
 * The Interface KillContainerCmd.
 */
public interface KillContainerCmd extends DockerCmd<String>{

	
	/**
	 * Gets the container id.
	 *
	 * @return the container id
	 */
	public String getContainerId();

	/**
	 * Gets the signal.
	 *
	 * @return the signal
	 */
	public String getSignal();

	/**
	 * With container id.
	 *
	 * @param containerId the container id
	 * @return the kill container cmd
	 */
	public KillContainerCmd withContainerId(String containerId);

	/**
	 * With signal.
	 *
	 * @param signal the signal
	 * @return the kill container cmd
	 */
	public KillContainerCmd withSignal(String signal);

	/**
	 * Exec.
	 *
	 * @return the string
	 * @throws NotFoundException No such container
	 */
	public String exec() throws NotFoundException;
	
	/**
	 * The Interface Exec.
	 */
	public static interface Exec extends DockerCmdExec<KillContainerCmd, String> {
	}
}
