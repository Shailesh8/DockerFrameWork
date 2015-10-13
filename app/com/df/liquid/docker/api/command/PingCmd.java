package com.df.liquid.docker.api.command;




/**
 * Ping the Docker server
 * 
 */
public interface PingCmd extends DockerCmd<String> {
	
	public static interface Exec extends DockerCmdExec<PingCmd, String> {
	}

}