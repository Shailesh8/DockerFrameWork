package com.df.liquid.docker.core.command;

import java.io.InputStream;

import com.df.liquid.docker.api.NotFoundException;
import com.df.liquid.docker.api.command.AttachContainerCmd;
import com.google.common.base.Preconditions;

/**
 * The Class AttachContainerCmdImpl implements the method of AttachContainerCmd
 */
public class AttachContainerCmdImpl extends	AbstrDockerCmd<AttachContainerCmd, InputStream> implements AttachContainerCmd{
	
	/** The container id. */
	private String containerId;

	/** The stderr. */
	private boolean logs, followStream, timestamps, stdout, stderr;

	/**
	 * Instantiates a new attach container cmd impl.
	 *
	 * @param exec the exec
	 * @param containerId the container id
	 */
	public AttachContainerCmdImpl(AttachContainerCmd.Exec exec, String containerId) {
		super(exec);
		withContainerId(containerId);
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.AttachContainerCmd#getContainerId()
	 */
	@Override
	public String getContainerId() {
		return containerId;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.AttachContainerCmd#hasLogsEnabled()
	 */
	@Override
	public boolean hasLogsEnabled() {
		return logs;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.AttachContainerCmd#hasFollowStreamEnabled()
	 */
	@Override
	public boolean hasFollowStreamEnabled() {
		return followStream;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.AttachContainerCmd#hasTimestampsEnabled()
	 */
	@Override
	public boolean hasTimestampsEnabled() {
		return timestamps;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.AttachContainerCmd#hasStdoutEnabled()
	 */
	@Override
	public boolean hasStdoutEnabled() {
		return stdout;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.AttachContainerCmd#hasStderrEnabled()
	 */
	@Override
	public boolean hasStderrEnabled() {
		return stderr;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.AttachContainerCmd#withContainerId(java.lang.String)
	 */
	@Override
	public AttachContainerCmd withContainerId(String containerId) {
		Preconditions.checkNotNull(containerId, "containerId was not specified");
		this.containerId = containerId;
		return this;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.AttachContainerCmd#withFollowStream()
	 */
	@Override
	public AttachContainerCmd withFollowStream() {
		return withFollowStream(true);
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.AttachContainerCmd#withFollowStream(boolean)
	 */
	@Override
	public AttachContainerCmd withFollowStream(boolean followStream) {
		this.followStream = followStream;
		return this;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.AttachContainerCmd#withTimestamps(boolean)
	 */
	@Override
	public AttachContainerCmd withTimestamps(boolean timestamps) {
		this.timestamps = timestamps;
		return this;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.AttachContainerCmd#withStdOut()
	 */
	@Override
	public AttachContainerCmd withStdOut() {
		return withStdOut(true);
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.AttachContainerCmd#withStdOut(boolean)
	 */
	@Override
	public AttachContainerCmd withStdOut(boolean stdout) {
		this.stdout = stdout;
		return this;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.AttachContainerCmd#withStdErr()
	 */
	@Override
	public AttachContainerCmd withStdErr() {
		return withStdErr(true);
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.AttachContainerCmd#withStdErr(boolean)
	 */
	@Override
	public AttachContainerCmd withStdErr(boolean stderr) {
		this.stderr = stderr;
		return this;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.AttachContainerCmd#withLogs(boolean)
	 */
	@Override
	public AttachContainerCmd withLogs(boolean logs) {
		this.logs = logs;
		return this;
	}
	
	/**
	 * Exec.
	 *
	 * @return the input stream
	 * @throws NotFoundException No such container
	 */
	@Override
	public InputStream exec() throws NotFoundException {
		return super.exec();
	}
}

