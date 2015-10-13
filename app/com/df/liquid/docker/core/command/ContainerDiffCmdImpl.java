package com.df.liquid.docker.core.command;



import java.util.List;
import play.Logger;

import com.df.liquid.docker.api.NotFoundException;
import com.df.liquid.docker.api.command.ContainerDiffCmd;
import com.df.liquid.docker.api.model.ChangeLog;
import com.df.utils.LoggerConstants;

import static com.google.common.base.Preconditions.checkNotNull;


/**
 * Inspect changes on a container's filesystem
 *
 * @param containerId - Id of the container
 *
 */
public class ContainerDiffCmdImpl extends AbstrDockerCmd<ContainerDiffCmd, List<ChangeLog>> implements ContainerDiffCmd {

	private String containerId;

	public ContainerDiffCmdImpl(ContainerDiffCmd.Exec exec, String containerId) {
		super(exec);
		withContainerId(containerId);
	}

    @Override
	public String getContainerId() {
        return containerId;
    }

    @Override
	public ContainerDiffCmdImpl withContainerId(String containerId) {
    	Logger.of(LoggerConstants.DockerLogger).debug(LoggerConstants.methodEntry);
    	checkNotNull(containerId, "containerId was not specified");
		this.containerId = containerId;
		Logger.of(LoggerConstants.DockerLogger).debug(
				LoggerConstants.methodExit);
		return this;
	}

	@Override
    public String toString() {
        return new StringBuilder("diff ").append(containerId).toString();
    }
    
    /**
     * @throws NotFoundException No such container
     * @throws InternalServerErrorException server error
     * @throws DockerException unexpected http status code
     */
	@Override
    public List<ChangeLog> exec() throws NotFoundException {
    	return super.exec();
    }
}