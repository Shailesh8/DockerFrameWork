package com.df.liquid.docker.api.command;

import com.df.liquid.docker.api.NotFoundException;




/**
 * Remove a container.
 * 
 * @param removeVolumes - true or false, Remove the volumes associated to the container. Defaults to false
 * @param force - true or false, Removes the container even if it was running. Defaults to false
 */
public interface RemoveContainerCmd extends DockerCmd<String> {

	public String getContainerId();

	public boolean hasRemoveVolumesEnabled();

	public boolean hasForceEnabled();

	public RemoveContainerCmd withContainerId(String containerId);

	public RemoveContainerCmd withRemoveVolumes(boolean removeVolumes);

	public RemoveContainerCmd withForce();

	public RemoveContainerCmd withForce(boolean force);

	/**
	 * @throws NotFoundException No such container
	 */
	@Override
	public String exec() throws NotFoundException;
	
	public static interface Exec extends DockerCmdExec<RemoveContainerCmd, String> {
	}

}

