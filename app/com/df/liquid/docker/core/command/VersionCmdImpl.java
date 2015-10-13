package com.df.liquid.docker.core.command;

import com.df.liquid.docker.api.command.VersionCmd;
import com.df.liquid.docker.api.model.Version;





/**
 * Returns the Docker version info.
 */
public class VersionCmdImpl extends AbstrDockerCmd<VersionCmd, Version> implements VersionCmd  {

	 @Override
    public String toString() {
        return "version";
    }   
    
    public VersionCmdImpl(VersionCmd.Exec exec) {
    	super(exec);
	}
}