package com.df.liquid.docker.api.command;

import com.df.liquid.docker.api.NotFoundException;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * Inspect the details of an image.
 */
public interface InspectImageCmd extends DockerCmd<JsonNode>{

	public String getImageId();

	public InspectImageCmd withImageId(String imageId);

	/**
	 * @throws NotFoundException No such image
	 */
	@Override
	public JsonNode exec() throws NotFoundException;
	
	public static interface Exec extends DockerCmdExec<InspectImageCmd, JsonNode> {
	}

}