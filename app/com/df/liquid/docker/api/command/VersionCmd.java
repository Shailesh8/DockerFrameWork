package com.df.liquid.docker.api.command;

import com.df.liquid.docker.api.model.Version;


/**
 * Returns the Docker version info.
 */
public interface VersionCmd extends DockerCmd<Version> {
	
	public static interface Exec extends DockerCmdExec<VersionCmd, Version> {
	}

}