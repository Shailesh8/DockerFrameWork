package com.df.liquid.docker.api.command;

/**
 * The Interface DockerCmdExec.
 *
 * @param <CMD_T> the generic type
 * @param <RES_T> the generic type
 */
public interface DockerCmdExec<CMD_T extends DockerCmd<RES_T>, RES_T> {
	public RES_T exec(CMD_T command);
}
