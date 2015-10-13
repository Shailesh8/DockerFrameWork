package com.df.liquid.docker.api.command;

import com.df.liquid.docker.api.NotFoundException;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * The Interface InspectContainerCmd.
 */
public interface InspectContainerCmd extends DockerCmd<JsonNode>{
	
	/**
	 * Gets the container id.
	 *
	 * @return the container id
	 */
	public String getContainerId();

	/**
	 * With container id.
	 *
	 * @param containerId the container id
	 * @return the inspect container cmd
	 */
	public InspectContainerCmd withContainerId(String containerId);

	/**
	 * Exec.
	 *
	 * @return the inspect container response
	 * @throws NotFoundException No such container
	 */
	public JsonNode exec() throws NotFoundException;
	
	/**
	 * The Interface Exec.
	 */
	public static interface Exec extends DockerCmdExec<InspectContainerCmd, JsonNode> {
	}
}
