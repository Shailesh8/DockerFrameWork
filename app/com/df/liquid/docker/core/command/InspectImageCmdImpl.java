package com.df.liquid.docker.core.command;

import static com.google.common.base.Preconditions.checkNotNull;

import com.df.liquid.docker.api.NotFoundException;
import com.df.liquid.docker.api.command.InspectImageCmd;
import com.df.liquid.docker.api.command.InspectImageResponse;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * Inspect the details of an image.
 */
public class InspectImageCmdImpl extends AbstrDockerCmd<InspectImageCmd, JsonNode> implements InspectImageCmd  {

	private String imageId;

	public InspectImageCmdImpl(InspectImageCmd.Exec exec, String imageId) {
		super(exec);
		withImageId(imageId);
	}

    @Override
	public String getImageId() {
        return imageId;
    }

    @Override
	public InspectImageCmd withImageId(String imageId) {
		checkNotNull(imageId, "imageId was not specified");
		this.imageId = imageId;
		return this;
	}

    @Override
    public String toString() {
        return "inspect " + imageId;
    }
    
    /**
     * @throws NotFoundException No such image
     */
	@Override
    public JsonNode exec() throws NotFoundException {
    	return super.exec();
    }
}