package com.df.liquid.docker.core.command;

import com.df.liquid.docker.api.NotFoundException;
import com.df.liquid.docker.api.command.KillContainerCmd;
import com.google.common.base.Preconditions;

/**
 * The Class KillContainerCmdImpl implements the method of KillContainerCmd 
 */
public class KillContainerCmdImpl extends AbstrDockerCmd<KillContainerCmd, String> implements KillContainerCmd{
	
	/** The signal. */
	private String containerId, signal;

	/**
	 * Instantiates a new kill container cmd impl.
	 *
	 * @param exec the exec
	 * @param containerId the container id
	 */
	public KillContainerCmdImpl(KillContainerCmd.Exec exec, String containerId) {
		super(exec);
		withContainerId(containerId);
	}

    /* (non-Javadoc)
     * @see com.egnaro.automatter.liquid.docker.api.command.KillContainerCmd#getContainerId()
     */
    @Override
	public String getContainerId() {
        return containerId;
    }

    /* (non-Javadoc)
     * @see com.egnaro.automatter.liquid.docker.api.command.KillContainerCmd#getSignal()
     */
    @Override
	public String getSignal() {
        return signal;
    }

    /* (non-Javadoc)
     * @see com.egnaro.automatter.liquid.docker.api.command.KillContainerCmd#withContainerId(java.lang.String)
     */
    @Override
	public KillContainerCmd withContainerId(String containerId) {
		Preconditions.checkNotNull(containerId, "containerId was not specified");
		this.containerId = containerId;
		return this;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.KillContainerCmd#withSignal(java.lang.String)
	 */
	@Override
	public KillContainerCmd withSignal(String signal) {
		Preconditions.checkNotNull(signal, "signal was not specified");
		this.signal = signal;
		return this;
	}

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "kill " + containerId;
    }
    
    /**
     * Exec.
     *
     * @return the string
     * @throws NotFoundException No such container
     */
	@Override
    public String exec() throws NotFoundException {
    	return super.exec();
    }
}
