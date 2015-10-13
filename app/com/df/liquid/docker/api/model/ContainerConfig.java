package com.df.liquid.docker.api.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class ContainerConfig.
 */
public class ContainerConfig {
	
	/** The attach stderr. */
	@JsonProperty("AttachStderr")
	private boolean attachStderr = false;

	/** The attach stdin. */
	@JsonProperty("AttachStdin")
	private boolean attachStdin = false;

	/** The attach stdout. */
	@JsonProperty("AttachStdout")
	private boolean attachStdout = false;

	/** The cmd. */
	@JsonProperty("Cmd")
	private String[] cmd;

	/** The cpu shares. */
	@JsonProperty("CpuShares")
	private int cpuShares = 0;

	/** The cpuset. */
	@JsonProperty("Cpuset")
	private String cpuset = "";

	/** The domain name. */
	@JsonProperty("Domainname")
	private String domainName = "";

	/** The entrypoint. */
	@JsonProperty("Entrypoint")
	private String[] entrypoint = new String[] {};

	/** The env. */
	@JsonProperty("Env")
	private String[] env;

	/** The exposed ports. */
	@JsonProperty("ExposedPorts")
	private String[] exposedPorts;

	/** The host name. */
	@JsonProperty("Hostname")
	private String hostName = "";

	/** The image. */
	@JsonProperty("Image")
	private String image;

	/** The memory limit. */
	@JsonProperty("Memory")
	private long memoryLimit = 0;

	/** The memory swap. */
	@JsonProperty("MemorySwap")
	private long memorySwap = 0;

	/** The network disabled. */
	@JsonProperty("NetworkDisabled")
	private boolean networkDisabled = false;

	/** The on build. */
	@JsonProperty("OnBuild")
	private int[] onBuild;

	/** The stdin open. */
	@JsonProperty("OpenStdin")
	private boolean stdinOpen = false;

	/** The port specs. */
	@JsonProperty("PortSpecs")
	private String[] portSpecs;

	/** The std in once. */
	@JsonProperty("StdinOnce")
	private boolean stdInOnce = false;

	/** The tty. */
	@JsonProperty("Tty")
	private boolean tty = false;

	/** The user. */
	@JsonProperty("User")
	private String user = "";

	/** The volumes. */
	@JsonProperty("Volumes")
	private Map<String, ?> volumes;

	/** The working dir. */
	@JsonProperty("WorkingDir")
	private String workingDir = "";

	/**
	 * Gets the exposed ports.
	 *
	 * @return the exposed ports
	 */
	@JsonIgnore
	public String[] getExposedPorts() {
		return exposedPorts == null ? null :  (String [])exposedPorts.clone();
	}

	/**
	 * Checks if is network disabled.
	 *
	 * @return true, if is network disabled
	 */
	public boolean isNetworkDisabled() {
		return networkDisabled;
	}

	/**
	 * Gets the domain name.
	 *
	 * @return the domain name
	 */
	public String getDomainName() {
		return domainName;
	}

	/**
	 * Gets the working dir.
	 *
	 * @return the working dir
	 */
	public String getWorkingDir() {
		return workingDir;
	}

	/**
	 * Gets the host name.
	 *
	 * @return the host name
	 */
	public String getHostName() {
		return hostName;
	}

	/**
	 * Gets the port specs.
	 *
	 * @return the port specs
	 */
	public String[] getPortSpecs() {
		return portSpecs == null ? null : (String []) portSpecs.clone();
	}

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Checks if is tty.
	 *
	 * @return true, if is tty
	 */
	public boolean isTty() {
		return tty;
	}

	/**
	 * Checks if is stdin open.
	 *
	 * @return true, if is stdin open
	 */
	public boolean isStdinOpen() {
		return stdinOpen;
	}

	/**
	 * Checks if is std in once.
	 *
	 * @return true, if is std in once
	 */
	public boolean isStdInOnce() {
		return stdInOnce;
	}

	/**
	 * Gets the memory limit.
	 *
	 * @return the memory limit
	 */
	public long getMemoryLimit() {
		return memoryLimit;
	}

	/**
	 * Gets the memory swap.
	 *
	 * @return the memory swap
	 */
	public long getMemorySwap() {
		return memorySwap;
	}

	/**
	 * Gets the cpu shares.
	 *
	 * @return the cpu shares
	 */
	public int getCpuShares() {
		return cpuShares;
	}

	/**
	 * Gets the cpuset.
	 *
	 * @return the cpuset
	 */
	public String getCpuset() {
		return cpuset;
	}

	/**
	 * Checks if is attach stdin.
	 *
	 * @return true, if is attach stdin
	 */
	public boolean isAttachStdin() {
		return attachStdin;
	}

	/**
	 * Checks if is attach stdout.
	 *
	 * @return true, if is attach stdout
	 */
	public boolean isAttachStdout() {
		return attachStdout;
	}

	/**
	 * Checks if is attach stderr.
	 *
	 * @return true, if is attach stderr
	 */
	public boolean isAttachStderr() {
		return attachStderr;
	}

	/**
	 * Gets the env.
	 *
	 * @return the env
	 */
	public String[] getEnv() {
		return env == null ? null : (String[]) env.clone();
	}

	/**
	 * Gets the cmd.
	 *
	 * @return the cmd
	 */
	public String[] getCmd() {
		return cmd == null ? null : (String[]) cmd.clone();
	}

	/**
	 * Gets the image.
	 *
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * Gets the volumes.
	 *
	 * @return the volumes
	 */
	public Map<String, ?> getVolumes() {
		return volumes;
	}

	/**
	 * Gets the entrypoint.
	 *
	 * @return the entrypoint
	 */
	public String[] getEntrypoint() {
		return entrypoint;
	}

	/**
	 * Gets the on build.
	 *
	 * @return the on build
	 */
	public int[] getOnBuild() {
		return onBuild == null ? null : (int[]) onBuild.clone();
	}

	
}
