package com.df.liquid.docker.core.command;


import static com.google.common.base.Preconditions.checkNotNull;

import com.df.liquid.docker.api.NotFoundException;
import com.df.liquid.docker.api.command.RemoveImageCmd;
/**
*
* Remove an image, deleting any tags it might have.
*
*/
public class RemoveImageCmdImpl extends AbstrDockerCmd<RemoveImageCmd, String> implements RemoveImageCmd {

	private String imageId;

	private boolean force, noPrune;

	public RemoveImageCmdImpl(RemoveImageCmd.Exec exec, String imageId) {
		super(exec);
		withImageId(imageId);
	}

   @Override
	public String getImageId() {
       return imageId;
   }

   @Override
	public boolean hasForceEnabled() {
       return force;
   }

   @Override
	public boolean hasNoPruneEnabled() {
       return noPrune;
   }

   @Override
	public RemoveImageCmd withImageId(String imageId) {
		checkNotNull(imageId, "imageId was not specified");
		this.imageId = imageId;
		return this;
	}

	@Override
	public RemoveImageCmd withForce() {
		return withForce(true);
	}

	@Override
	public RemoveImageCmd withForce(boolean force) {
		this.force = force;
		return this;
	}
	
	@Override
	public RemoveImageCmd withNoPrune() {
		return withNoPrune(true);
	}

	@Override
	public RemoveImageCmd withNoPrune(boolean noPrune) {
		this.noPrune = noPrune;
		return this;
	}

   @Override
   public String toString() {
       return new StringBuilder("rmi ")
           .append(noPrune ? "--no-prune=true" : "")
           .append(force ? "--force=true" : "")
           .append(imageId)
           .toString();
   }
   
   /**
    * @throws NotFoundException No such image
    */
	@Override
   public String exec() throws NotFoundException {
   	return super.exec();
   }
}