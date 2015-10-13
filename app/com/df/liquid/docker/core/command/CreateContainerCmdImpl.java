package com.df.liquid.docker.core.command;

import play.Logger;

import com.df.liquid.docker.api.ConflictException;
import com.df.liquid.docker.api.NotFoundException;
import com.df.liquid.docker.api.command.CreateContainerCmd;
import com.df.liquid.docker.api.command.CreateContainerResponse;
import com.df.utils.LoggerConstants;
/*import models.api.model.ExposedPorts;
import models.api.model.HostConfig;
*/
import com.fasterxml.jackson.annotation.*;
import com.google.common.base.Preconditions;


/**
 * The Class CreateContainerCmdImpl implements the method of CreateContainerCmd
 */
public class CreateContainerCmdImpl extends
		AbstrDockerCmd<CreateContainerCmd, CreateContainerResponse> implements
		CreateContainerCmd {

	/** The name. */
	private String name;

	/** The host name. */
	@JsonProperty("Hostname")
	private String hostName;

	/** The user. */
	@JsonProperty("User")
	private String user = "";
	
	/** The domain name. */
	@JsonProperty("Domainname")
	private String domainName = "";
	
	/** The memory limit. */
	@JsonProperty("Memory")
	private long memoryLimit = 0;
	
	/** The memory swap. */
	@JsonProperty("MemorySwap")
	private long memorySwap = 0;
	
	/** The cpu shares. */
	@JsonProperty("CpuShares")
	private int cpuShares = 0;
	
	/** The attach stdin. */
	@JsonProperty("AttachStdin")
	private boolean attachStdin = false;
	
	/** The attach stdout. */
	@JsonProperty("AttachStdout")
	private boolean attachStdout = false;
	
	/** The attach stderr. */
	@JsonProperty("AttachStderr")
	private boolean attachStderr = false;
	
	/** The port specs. */
	@JsonProperty("PortSpecs")
	private String[] portSpecs = null;
	
	/** The tty. */
	@JsonProperty("Tty")
	private boolean tty = false;
	
	/** The stdin open. */
	@JsonProperty("OpenStdin")
	private boolean stdinOpen = false;
	
	/** The std in once. */
	@JsonProperty("StdinOnce")
	private boolean stdInOnce = false;
	
	/** The env. */
	@JsonProperty("Env")
	private String[] env;
	
	/** The cmd. */
	@JsonProperty("Cmd")
	private String[] cmd;
	
	/** The image. */
	@JsonProperty("Image")
	private String image;
	
	/** The volumes. */
	@JsonProperty("Volumes")
	private String[] volumes = null;
	
	/** The disable network. */
	@JsonProperty("NetworkDisabled")
	private boolean disableNetwork = false;
/*	@JsonProperty("ExposedPorts")
	private ExposedPorts exposedPorts;*/

	/*@JsonProperty("HostConfig")  
	private HostConfig hostConfig = new HostConfig();
*/	/**
 * Instantiates a new creates the container cmd impl.
 *
 * @param exec the exec
 * @param image the image
 */
public CreateContainerCmdImpl(CreateContainerCmd.Exec exec, String image) {
		super(exec);
		Preconditions.checkNotNull(image, "image was not specified");
		withImage(image);
	}
	
	/* @Override
	    public CreateContainerCmd withHostConfig(HostConfig hostConfig) {
	    	Preconditions.checkNotNull(hostConfig, "no host config was specified");
	    	this.hostConfig = hostConfig;
	    	return this;
	    }
*/
	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.CreateContainerCmd#getName()
	 */
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.CreateContainerCmd#getHostName()
	 */
	public String getHostName() {
		return hostName;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.CreateContainerCmd#getUser()
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Gets the domain name.
	 *
	 * @return the domain name
	 */
	public String getDomainName() {
		return domainName;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.CreateContainerCmd#getMemoryLimit()
	 */
	public long getMemoryLimit() {
		return memoryLimit;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.CreateContainerCmd#getMemorySwap()
	 */
	public long getMemorySwap() {
		return memorySwap;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.CreateContainerCmd#getCpuShares()
	 */
	public int getCpuShares() {
		return cpuShares;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.CreateContainerCmd#isAttachStdin()
	 */
	public boolean isAttachStdin() {
		return attachStdin;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.CreateContainerCmd#isAttachStdout()
	 */
	public boolean isAttachStdout() {
		return attachStdout;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.CreateContainerCmd#isAttachStderr()
	 */
	public boolean isAttachStderr() {
		return attachStderr;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.CreateContainerCmd#getPortSpecs()
	 */
	public String[] getPortSpecs() {
		return portSpecs;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.CreateContainerCmd#isTty()
	 */
	public boolean isTty() {
		return tty;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.CreateContainerCmd#isStdinOpen()
	 */
	public boolean isStdinOpen() {
		return stdinOpen;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.CreateContainerCmd#isStdInOnce()
	 */
	public boolean isStdInOnce() {
		return stdInOnce;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.CreateContainerCmd#getEnv()
	 */
	public String[] getEnv() {
		return env;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.CreateContainerCmd#getCmd()
	 */
	public String[] getCmd() {
		return cmd;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.CreateContainerCmd#getImage()
	 */
	public String getImage() {
		return image;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.CreateContainerCmd#getVolumes()
	 */
	public String[] getVolumes() {
		return volumes;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.CreateContainerCmd#isDisableNetwork()
	 */
	public boolean isDisableNetwork() {
		return disableNetwork;
	}

	
	

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.CreateContainerCmd#withImage(java.lang.String)
	 */
	@Override
	public CreateContainerCmd withImage(String image) {
		Preconditions.checkNotNull(image, "name was not specified");
		this.image = image;
		return this;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.CreateContainerCmd#withName(java.lang.String)
	 */
	@Override
	public CreateContainerCmd withName(String name) {
		Preconditions.checkNotNull(name, "name was not specified");
		this.name = name;
		return this;

	}

	/*@Override
	public CreateContainerCmd withExposedPorts(ExposedPorts exposedPorts) {

		this.exposedPorts = exposedPorts;
		return this;
	}
*/
	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.CreateContainerCmd#withDisableNetwork(boolean)
	 */
	@Override
	public CreateContainerCmd withDisableNetwork(boolean disableNetwork) {
		this.disableNetwork = disableNetwork;
		return this;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.CreateContainerCmd#withHostName(java.lang.String)
	 */
	@Override
	public CreateContainerCmd withHostName(String hostName) {
	this.hostName = hostName;
		return this;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.CreateContainerCmd#withPortSpecs(java.lang.String[])
	 */
	@Override
	public CreateContainerCmd withPortSpecs(String... portSpecs) {
		this.portSpecs = portSpecs;
	    return this;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.CreateContainerCmd#withUser(java.lang.String)
	 */
	@Override
	public CreateContainerCmd withUser(String user) {
		this.user = user;
        return this;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.CreateContainerCmd#withTty(boolean)
	 */
	@Override
	public CreateContainerCmd withTty(boolean tty) {
//		Logger.of(LoggerConstants.DockerLogger).debug(LoggerConstants.methodEntry);
		this.tty = tty;
        return this;
	}

	
	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.CreateContainerCmd#withStdinOpen(boolean)
	 */
	@Override
	public CreateContainerCmd withStdinOpen(boolean stdinOpen) {
		this.stdinOpen = stdinOpen;
	    return this;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.CreateContainerCmd#withStdInOnce(boolean)
	 */
	@Override
	public CreateContainerCmd withStdInOnce(boolean stdInOnce) {
		this.stdInOnce = stdInOnce;
		return this;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.CreateContainerCmd#withMemoryLimit(long)
	 */
	@Override
	public CreateContainerCmd withMemoryLimit(long memoryLimit) {
		this.memoryLimit = memoryLimit;
		return this;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.CreateContainerCmd#withMemorySwap(long)
	 */
	@Override
	public CreateContainerCmd withMemorySwap(long memorySwap) {
		this.memorySwap = memorySwap;
		return this;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.CreateContainerCmd#withCpuShares(int)
	 */
	@Override
	public CreateContainerCmd withCpuShares(int cpuShares) {
		this.cpuShares = cpuShares;
		return this;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.CreateContainerCmd#withAttachStdin(boolean)
	 */
	@Override
	public CreateContainerCmd withAttachStdin(boolean attachStdin) {
		this.attachStdin = attachStdin;
		return this;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.CreateContainerCmd#withAttachStdout(boolean)
	 */
	@Override
	public CreateContainerCmd withAttachStdout(boolean attachStdout) {
		this.attachStdout = attachStdout;
		return this;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.CreateContainerCmd#withAttachStderr(boolean)
	 */
	@Override
	public CreateContainerCmd withAttachStderr(boolean attachStderr) {
		this.attachStderr = attachStderr;
		return this;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.CreateContainerCmd#withEnv(java.lang.String[])
	 */
	@Override
	public CreateContainerCmd withEnv(String... env) {
		this.env = env;
		return this;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.CreateContainerCmd#withCmd(java.lang.String[])
	 */
	@Override
	public CreateContainerCmd withCmd(String... cmd) {
		this.cmd = cmd;
		return this;
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.api.command.CreateContainerCmd#withVolumes(java.lang.String[])
	 */
	@Override
	public CreateContainerCmd withVolumes(String[] volumes) {
		System.arraycopy(volumes, 0, this.volumes, 0, volumes.length);

		return this;
	}
	
	 /* (non-Javadoc)
 	 * @see com.egnaro.automatter.liquid.docker.core.command.AbstrDockerCmd#exec()
 	 */
 	public CreateContainerResponse exec() throws NotFoundException, ConflictException {
	    	return super.exec();
	    }

	/**
	 * @return the hostConfig
	 */
/*	public HostConfig getHostConfig() {
		return hostConfig;
	}

	@Override
	public ExposedPorts getExposedPorts() {
		// TODO Auto-generated method stub
		return null;
	}*/

}
