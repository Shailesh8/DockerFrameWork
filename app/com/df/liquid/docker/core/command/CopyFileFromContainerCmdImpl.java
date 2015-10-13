package com.df.liquid.docker.core.command;



import java.io.InputStream;
import org.apache.commons.lang3.builder.ToStringBuilder;
import play.Logger;

import com.df.liquid.docker.api.NotFoundException;
import com.df.liquid.docker.api.command.CopyFileFromContainerCmd;
import com.df.utils.LoggerConstants;
import com.fasterxml.jackson.annotation.JsonProperty;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 *
 * Copy files or folders from a container.
 *
 */
public class CopyFileFromContainerCmdImpl extends AbstrDockerCmd<CopyFileFromContainerCmd, InputStream> implements CopyFileFromContainerCmd {

	private String containerId;
	
	@JsonProperty("HostPath")
    private String hostPath = ".";

    @JsonProperty("Resource")
    private String resource;

	public CopyFileFromContainerCmdImpl(CopyFileFromContainerCmd.Exec exec, String containerId, String resource) {
		super(exec);
		withContainerId(containerId);
		withResource(resource);
	}

    @Override
	public String getContainerId() {
        return containerId;
    }

    @Override
	public String getResource() {
        return resource;
    }

    @Override
	public CopyFileFromContainerCmdImpl withContainerId(String containerId) {
    	Logger.of(LoggerConstants.DockerLogger).debug(LoggerConstants.methodEntry);
    	checkNotNull(containerId, "containerId was not specified");
		this.containerId = containerId;
		Logger.of(LoggerConstants.DockerLogger).debug(
				LoggerConstants.methodExit);
		return this;
	}

	@Override
	public CopyFileFromContainerCmdImpl withResource(String resource) {
		Logger.of(LoggerConstants.DockerLogger).debug(LoggerConstants.methodEntry);
		checkNotNull(resource, "resource was not specified");
		this.resource = resource;
		Logger.of(LoggerConstants.DockerLogger).debug(
				LoggerConstants.methodExit);
		return this;
	}
	
	@Override
	public String getHostPath() {
		return hostPath;
	}
	
	@Override
	public CopyFileFromContainerCmdImpl withHostPath(String hostPath) {
		Logger.of(LoggerConstants.DockerLogger).debug(LoggerConstants.methodEntry);
		checkNotNull(hostPath, "hostPath was not specified");
		this.hostPath = hostPath;
		Logger.of(LoggerConstants.DockerLogger).debug(
				LoggerConstants.methodExit);
		return this;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this).append("cp ")
            .append(containerId)
            .append(":")
            .append(resource)
            .toString();
    }
    
    /**
     * @throws NotFoundException No such container
     */
	@Override
    public InputStream exec() throws NotFoundException {
    	return super.exec();
    }
}

