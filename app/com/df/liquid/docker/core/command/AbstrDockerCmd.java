package com.df.liquid.docker.core.command;

import com.df.liquid.docker.api.DockerException;
import com.df.liquid.docker.api.command.DockerCmd;
import com.df.liquid.docker.api.command.DockerCmdExec;
import com.google.common.base.Preconditions;

/**
 * The Class AbstrDockerCmd.
 *
 * @param <CMD_T> the generic type
 * @param <RES_T> the generic type
 */
public abstract class AbstrDockerCmd<CMD_T extends DockerCmd<RES_T>, RES_T> implements DockerCmd<RES_T> {

/** The execution. */
protected DockerCmdExec<CMD_T, RES_T> execution;
	
	/**
	 * Instantiates a new abstr docker cmd.
	 *
	 * @param execution the execution
	 */
	public AbstrDockerCmd(DockerCmdExec<CMD_T, RES_T> execution) {
		Preconditions.checkNotNull(execution, "execution was not specified");
		this.execution = execution;
	}

    /* (non-Javadoc)
     * @see com.egnaro.automatter.liquid.docker.api.command.DockerCmd#exec()
     */
    @Override
    @SuppressWarnings("unchecked")
	public RES_T exec() throws DockerException {
		
		return execution.exec((CMD_T)this);
	}
}
