package com.df.liquid.docker.core.command;

import com.df.liquid.docker.api.NotFoundException;
import com.df.liquid.docker.api.command.InspectContainerCmd;
import com.df.liquid.docker.api.command.InspectContainerResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Preconditions;

/**
 * The Class InspectContainerCmdImpl implements the method of InspectContainerCmd 
 */
public class InspectContainerCmdImpl extends AbstrDockerCmd<InspectContainerCmd, JsonNode> implements InspectContainerCmd  {

	/** The container id. */
	private String containerId;

	/**
	 * Instantiates a new inspect container cmd impl.
	 *
	 * @param exec the exec
	 * @param containerId the container id
	 */
	public InspectContainerCmdImpl(InspectContainerCmd.Exec exec, String containerId) {
		super(exec);
		withContainerId(containerId);
	}

    /* (non-Javadoc)
     * @see com.egnaro.automatter.liquid.docker.api.command.InspectContainerCmd#getContainerId()
     */
    @Override
	public String getContainerId() {
        return containerId;
    }

    /* (non-Javadoc)
     * @see com.egnaro.automatter.liquid.docker.api.command.InspectContainerCmd#withContainerId(java.lang.String)
     */
    @Override
	public InspectContainerCmd withContainerId(String containerId) {
		Preconditions.checkNotNull(containerId, "containerId was not specified");
		this.containerId = containerId;
		return this;
	}

    
    
    /**
     * Exec.
     *
     * @return the inspect container response
     * @throws NotFoundException No such container
     */
	@Override
    public JsonNode exec() throws NotFoundException {
    	return super.exec();
    }
}
