package com.df.liquid.docker.api.command;

import java.io.InputStream;

import com.df.liquid.docker.api.NotFoundException;

/**
 * The Interface AttachContainerCmd.
 */
public interface AttachContainerCmd extends DockerCmd<InputStream>{
	
	/**
	 * Gets the container id.
	 *
	 * @return the container id
	 */
	public String getContainerId();

	/**
	 * Checks for logs enabled.
	 *
	 * @return true, if successful
	 */
	public boolean hasLogsEnabled();

	/**
	 * Checks for follow stream enabled.
	 *
	 * @return true, if successful
	 */
	public boolean hasFollowStreamEnabled();

	/**
	 * Checks for timestamps enabled.
	 *
	 * @return true, if successful
	 */
	public boolean hasTimestampsEnabled();

	/**
	 * Checks for stdout enabled.
	 *
	 * @return true, if successful
	 */
	public boolean hasStdoutEnabled();

	/**
	 * Checks for stderr enabled.
	 *
	 * @return true, if successful
	 */
	public boolean hasStderrEnabled();

	/**
	 * With container id.
	 *
	 * @param containerId the container id
	 * @return the attach container cmd
	 */
	public AttachContainerCmd withContainerId(String containerId);

	/**
	 * With follow stream.
	 *
	 * @return the attach container cmd
	 */
	public AttachContainerCmd withFollowStream();

	/**
	 * With follow stream.
	 *
	 * @param followStream the follow stream
	 * @return the attach container cmd
	 */
	public AttachContainerCmd withFollowStream(boolean followStream);

	/**
	 * With timestamps.
	 *
	 * @param timestamps the timestamps
	 * @return the attach container cmd
	 */
	public AttachContainerCmd withTimestamps(boolean timestamps);

	/**
	 * With std out.
	 *
	 * @return the attach container cmd
	 */
	public AttachContainerCmd withStdOut();

	/**
	 * With std out.
	 *
	 * @param stdout the stdout
	 * @return the attach container cmd
	 */
	public AttachContainerCmd withStdOut(boolean stdout);

	/**
	 * With std err.
	 *
	 * @return the attach container cmd
	 */
	public AttachContainerCmd withStdErr();

	/**
	 * With std err.
	 *
	 * @param stderr the stderr
	 * @return the attach container cmd
	 */
	public AttachContainerCmd withStdErr(boolean stderr);

	/**
	 * With logs.
	 *
	 * @param logs the logs
	 * @return the attach container cmd
	 */
	public AttachContainerCmd withLogs(boolean logs);

	/**
	 * Exec.
	 *
	 * @return the input stream
	 * @throws NotFoundException No such container
	 */
	@Override
	public InputStream exec() throws NotFoundException;
	
	/**
	 * The Interface Exec.
	 */
	public static interface Exec extends DockerCmdExec<AttachContainerCmd, InputStream> {
	}
}
