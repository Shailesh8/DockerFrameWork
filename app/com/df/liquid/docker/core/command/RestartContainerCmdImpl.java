package com.df.liquid.docker.core.command;

import com.df.liquid.docker.api.NotFoundException;
import com.df.liquid.docker.api.command.RestartContainerCmd;
import com.google.common.base.Preconditions;

/**
 * The Class RestartContainerCmdImpl implements the method of RestartContainerCmd class
 */
public class RestartContainerCmdImpl extends AbstrDockerCmd<RestartContainerCmd, String> implements RestartContainerCmd {
	
	/** The container id. */
	private String containerId;

	/** The timeout. */
	private int timeout = 10;
	
	/**
	 * Instantiates a new restart container cmd impl.
	 *
	 * @param exec the exec
	 * @param containerId the container id
	 */
	public RestartContainerCmdImpl(RestartContainerCmd.Exec exec, String containerId) {
		super(exec);
		withContainerId(containerId);
	}

	
	
	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.RestartContainerCmd#getContainerId()
	 */
	@Override
	public String getContainerId() {
		return containerId;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.RestartContainerCmd#getTimeout()
	 */
	@Override
	public int getTimeout() {
		return timeout;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.RestartContainerCmd#withContainerId(java.lang.String)
	 */
	@Override
	public RestartContainerCmd withContainerId(String containerId) {
		Preconditions.checkNotNull(containerId, "containerId was not specified");
		this.containerId = containerId;
		return this;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.RestartContainerCmd#withtTimeout(int)
	 */
	@Override
	public RestartContainerCmd withtTimeout(int timeout) {
		Preconditions.checkArgument(timeout >= 0, "timeout must be greater or equal 0");
		this.timeout = timeout;
		return this;
	}
	
	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.core.command.AbstrDockerCmd#exec()
	 */
	@Override
    public String exec() throws NotFoundException {
    	return super.exec();
    }

	
}
