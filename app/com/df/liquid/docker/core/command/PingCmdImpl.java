package com.df.liquid.docker.core.command;

import com.df.liquid.docker.api.command.PingCmd;


/**
 * Ping the Docker server
 * 
 */
public class PingCmdImpl extends AbstrDockerCmd<PingCmd, String> implements PingCmd {

	public PingCmdImpl(PingCmd.Exec exec) {
		super(exec);
	}
}