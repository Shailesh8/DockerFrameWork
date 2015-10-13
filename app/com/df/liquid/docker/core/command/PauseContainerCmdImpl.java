package com.df.liquid.docker.core.command;

import com.df.liquid.docker.api.NotFoundException;
import com.df.liquid.docker.api.command.PauseContainerCmd;
import com.google.common.base.Preconditions;


/**
 * The Class PauseContainerCmdImpl implements the method of PauseContainerCmd class
 */
public class PauseContainerCmdImpl extends AbstrDockerCmd<PauseContainerCmd, String> implements PauseContainerCmd{

	/** The container id. */
	private String containerId;
	
	/**
	 * Instantiates a new pause container cmd impl.
	 *
	 * @param exec the exec
	 * @param containerId the container id
	 */
	public PauseContainerCmdImpl(
			PauseContainerCmd.Exec exec, String containerId) {
		super(exec);
		withContainerId(containerId);
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.PauseContainerCmd#getContainerId()
	 */
	@Override
	public String getContainerId() {
		return containerId;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.PauseContainerCmd#withContainerId(java.lang.String)
	 */
	@Override
	public PauseContainerCmd withContainerId(String containerId) {
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
