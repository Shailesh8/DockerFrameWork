package com.df.liquid.docker.core.command;

import com.df.liquid.docker.api.NotFoundException;
import com.df.liquid.docker.api.NotModifiedException;
import com.df.liquid.docker.api.command.StopContainerCmd;
import com.google.common.base.Preconditions;


/**
 * The Class StopContainerCmdImpl implements the method of StopContainerCmd class
 */
public class StopContainerCmdImpl extends AbstrDockerCmd<StopContainerCmd, String> implements StopContainerCmd {

	/** The container id. */
	private String containerId;

	/** The timeout. */
	private int timeout = 10;
	
	/**
	 * Instantiates a new stop container cmd impl.
	 *
	 * @param exec the exec
	 * @param containerId the container id
	 */
	public StopContainerCmdImpl(StopContainerCmd.Exec exec, String containerId) {
		super(exec);
		withContainerId(containerId);
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.StopContainerCmd#getContainerId()
	 */
	@Override
	public String getContainerId() {
		return containerId;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.StopContainerCmd#getTimeout()
	 */
	@Override
	public int getTimeout() {
		return timeout;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.StopContainerCmd#withContainerId(java.lang.String)
	 */
	@Override
	public StopContainerCmd withContainerId(String containerId) {
		Preconditions.checkNotNull(containerId, "containerId was not specified");
		this.containerId = containerId;
		return this;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.StopContainerCmd#withTimeout(int)
	 */
	@Override
	public StopContainerCmd withTimeout(int timeout) {
		Preconditions.checkArgument(timeout >= 0, "timeout must be greater or equal 0");
		this.timeout = timeout;
		return this;
	}
	
	 /**
 	 * Exec.
 	 *
 	 * @return the string
 	 * @throws NotFoundException No such container
 	 * @throws NotModifiedException Container already stopped
 	 */
		@Override
		public String exec() throws NotFoundException, NotModifiedException {
			return super.exec();
		}

}
