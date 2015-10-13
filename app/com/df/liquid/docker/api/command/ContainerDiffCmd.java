package com.df.liquid.docker.api.command;


import java.util.List;

import com.df.liquid.docker.api.NotFoundException;
import com.df.liquid.docker.api.model.ChangeLog;


public interface ContainerDiffCmd extends DockerCmd<List<ChangeLog>> {

	public String getContainerId();

	public ContainerDiffCmd withContainerId(String containerId);

	@Override
	public String toString();

	/**
	 * @throws NotFoundException No such container
	 * @throws InternalServerErrorException server error
	 * @throws DockerException unexpected http status code
	 */
	@Override
	public List<ChangeLog> exec() throws NotFoundException;
	
	public static interface Exec extends DockerCmdExec<ContainerDiffCmd, List<ChangeLog>> {
	}

}