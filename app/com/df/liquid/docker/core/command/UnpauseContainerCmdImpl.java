package com.df.liquid.docker.core.command;

import com.df.liquid.docker.api.NotFoundException;
import com.df.liquid.docker.api.command.UnpauseContainerCmd;
import com.google.common.base.Preconditions;

/**
 * The Class UnpauseContainerCmdImpl implements the method of UnpauseContainerCmd class 
 */
public class UnpauseContainerCmdImpl extends AbstrDockerCmd<UnpauseContainerCmd, String> implements UnpauseContainerCmd{

	/** The container id. */
	private String containerId;
	
	/**
	 * Instantiates a new unpause container cmd impl.
	 *
	 * @param exec the exec
	 * @param containerId the container id
	 */
	public UnpauseContainerCmdImpl(UnpauseContainerCmd.Exec exec, String containerId) {
		super(exec);
		withContainerId(containerId);
	}
	
	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.UnpauseContainerCmd#getContainerId()
	 */
	@Override
	public String getContainerId() {
		return containerId;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.UnpauseContainerCmd#withContainerId(java.lang.String)
	 */
	@Override
	public UnpauseContainerCmd withContainerId(String containerId) {
		Preconditions.checkNotNull(containerId, "containerId was not specified");
		this.containerId = containerId;
		return this;
	}

	/**
	 * Exec.
	 *
	 * @return the void
	 * @throws NotFoundException No such container
	 */
	@Override
	public String exec() throws NotFoundException {
		return super.exec();
	}
}
