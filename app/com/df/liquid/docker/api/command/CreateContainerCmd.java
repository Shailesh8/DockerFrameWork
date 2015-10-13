package com.df.liquid.docker.api.command;

import com.df.liquid.docker.api.ConflictException;
import com.df.liquid.docker.api.NotFoundException;
import com.df.liquid.docker.api.model.ExposedPorts;
import com.df.liquid.docker.api.model.HostConfig;

/**
 * The Interface CreateContainerCmd.
 */
public interface CreateContainerCmd extends DockerCmd<CreateContainerResponse>{
	
	/**
	 * With name.
	 *
	 * @param name the name
	 * @return the creates the container cmd
	 */
	public CreateContainerCmd withName(String name);

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName();

	//public CreateContainerCmd withExposedPorts(ExposedPorts exposedPorts);

	//public ExposedPorts getExposedPorts();

	/**
	 * Checks if is disable network.
	 *
	 * @return true, if is disable network
	 */
	public boolean isDisableNetwork();

	//public String getWorkingDir();

	//public CreateContainerCmd withWorkingDir(String workingDir);

	//public CreateContainerCmd withHostConfig(HostConfig hostConfig);
	/**
	 * Gets the host name.
	 *
	 * @return the host name
	 */
	public String getHostName();

	/**
	 * With disable network.
	 *
	 * @param disableNetwork the disable network
	 * @return the creates the container cmd
	 */
	public CreateContainerCmd withDisableNetwork(boolean disableNetwork);

	/**
	 * With host name.
	 *
	 * @param hostName the host name
	 * @return the creates the container cmd
	 */
	public CreateContainerCmd withHostName(String hostName);

	/**
	 * Gets the port specs.
	 *
	 * @return the port specs
	 */
	public String[] getPortSpecs();

	/**
	 * With port specs.
	 *
	 * @param portSpecs the port specs
	 * @return the creates the container cmd
	 */
	public CreateContainerCmd withPortSpecs(String... portSpecs);

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public String getUser();

	/**
	 * With user.
	 *
	 * @param user the user
	 * @return the creates the container cmd
	 */
	public CreateContainerCmd withUser(String user);

	/**
	 * Checks if is tty.
	 *
	 * @return true, if is tty
	 */
	public boolean isTty();

	/**
	 * With tty.
	 *
	 * @param tty the tty
	 * @return the creates the container cmd
	 */
	public CreateContainerCmd withTty(boolean tty);

	/**
	 * Checks if is stdin open.
	 *
	 * @return true, if is stdin open
	 */
	public boolean isStdinOpen();

	/**
	 * With stdin open.
	 *
	 * @param stdinOpen the stdin open
	 * @return the creates the container cmd
	 */
	public CreateContainerCmd withStdinOpen(boolean stdinOpen);

	/**
	 * Checks if is std in once.
	 *
	 * @return true, if is std in once
	 */
	public boolean isStdInOnce();

	/**
	 * With std in once.
	 *
	 * @param stdInOnce the std in once
	 * @return the creates the container cmd
	 */
	public CreateContainerCmd withStdInOnce(boolean stdInOnce);

	/**
	 * Gets the memory limit.
	 *
	 * @return the memory limit
	 */
	public long getMemoryLimit();

	/**
	 * With memory limit.
	 *
	 * @param memoryLimit the memory limit
	 * @return the creates the container cmd
	 */
	public CreateContainerCmd withMemoryLimit(long memoryLimit);

	/**
	 * Gets the memory swap.
	 *
	 * @return the memory swap
	 */
	public long getMemorySwap();

	/**
	 * With memory swap.
	 *
	 * @param memorySwap the memory swap
	 * @return the creates the container cmd
	 */
	public CreateContainerCmd withMemorySwap(long memorySwap);

	/**
	 * Gets the cpu shares.
	 *
	 * @return the cpu shares
	 */
	public int getCpuShares();

	/**
	 * With cpu shares.
	 *
	 * @param cpuShares the cpu shares
	 * @return the creates the container cmd
	 */
	public CreateContainerCmd withCpuShares(int cpuShares);

	/**
	 * Checks if is attach stdin.
	 *
	 * @return true, if is attach stdin
	 */
	public boolean isAttachStdin();

	/**
	 * With attach stdin.
	 *
	 * @param attachStdin the attach stdin
	 * @return the creates the container cmd
	 */
	public CreateContainerCmd withAttachStdin(boolean attachStdin);

	/**
	 * Checks if is attach stdout.
	 *
	 * @return true, if is attach stdout
	 */
	public boolean isAttachStdout();

	/**
	 * With attach stdout.
	 *
	 * @param attachStdout the attach stdout
	 * @return the creates the container cmd
	 */
	public CreateContainerCmd withAttachStdout(boolean attachStdout);

	/**
	 * Checks if is attach stderr.
	 *
	 * @return true, if is attach stderr
	 */
	public boolean isAttachStderr();

	/**
	 * With attach stderr.
	 *
	 * @param attachStderr the attach stderr
	 * @return the creates the container cmd
	 */
	public CreateContainerCmd withAttachStderr(boolean attachStderr);

	/**
	 * Gets the env.
	 *
	 * @return the env
	 */
	public String[] getEnv();

	/**
	 * With env.
	 *
	 * @param env the env
	 * @return the creates the container cmd
	 */
	public CreateContainerCmd withEnv(String... env);

	/**
	 * Gets the cmd.
	 *
	 * @return the cmd
	 */
	public String[] getCmd();

	/**
	 * With cmd.
	 *
	 * @param cmd the cmd
	 * @return the creates the container cmd
	 */
	public CreateContainerCmd withCmd(String... cmd);

	//public String[] getDns();

	//public CreateContainerCmd withDns(String... dns);

	/**
	 * Gets the image.
	 *
	 * @return the image
	 */
	public String getImage();

	/**
	 * With image.
	 *
	 * @param image the image
	 * @return the creates the container cmd
	 */
	public CreateContainerCmd withImage(String image);

	/**
	 * Gets the volumes.
	 *
	 * @return the volumes
	 */
	public String[] getVolumes();

	/**
	 * With volumes.
	 *
	 * @param volumes the volumes
	 * @return the creates the container cmd
	 */
	public CreateContainerCmd withVolumes(String[] volumes);

	//public String[] getVolumesFrom();

	//public CreateContainerCmd withVolumesFrom(String... volumesFrom);
	
		
		
	/**
	 * Exec.
	 *
	 * @return the creates the container response
	 * @throws NotFoundException No such container
	 * @throws ConflictException Named container already exists
	 */
    @Override
	public CreateContainerResponse exec() throws NotFoundException,
			ConflictException;
	
	/**
	 * The Interface Exec.
	 */
	public static interface Exec extends DockerCmdExec<CreateContainerCmd, CreateContainerResponse> {
	}
}
