package com.df.liquid.docker.api.command;

import com.df.liquid.docker.api.NotFoundException;
import com.df.liquid.docker.api.NotModifiedException;

/**
 * The Interface StartContainerCmd.
 */
public interface StartContainerCmd extends DockerCmd<String>{
	
	/**
	 * Gets the binds.
	 *
	 * @return the binds
	 */
	public String[] getBinds();

	/**
	 * Gets the links.
	 *
	 * @return the links
	 */
	public String[] getLinks();

	/**
	 * Gets the lxc conf.
	 *
	 * @return the lxc conf
	 */
	public String[] getLxcConf();

	/**
	 * Gets the port bindings.
	 *
	 * @return the port bindings
	 */
	public String[] getPortBindings();

	/**
	 * Checks if is publish all ports.
	 *
	 * @return the boolean
	 */
	public Boolean isPublishAllPorts();

	/**
	 * Checks if is privileged.
	 *
	 * @return the boolean
	 */
	public Boolean isPrivileged();

	/**
	 * Gets the dns.
	 *
	 * @return the dns
	 */
	public String[] getDns();

	/**
	 * Gets the dns search.
	 *
	 * @return the dns search
	 */
	public String[] getDnsSearch();

	/**
	 * Gets the volumes from.
	 *
	 * @return the volumes from
	 */
	public String getVolumesFrom();

	/**
	 * Gets the container id.
	 *
	 * @return the container id
	 */
	public String getContainerId();

	/**
	 * Gets the network mode.
	 *
	 * @return the network mode
	 */
	public String getNetworkMode();

	

	/**
	 * Gets the cap add.
	 *
	 * @return the cap add
	 */
	public String[] getCapAdd();

	/**
	 * Gets the cap drop.
	 *
	 * @return the cap drop
	 */
	public String[] getCapDrop();

	/**
	 * With binds.
	 *
	 * @param binds the binds
	 * @return the start container cmd
	 */
	public StartContainerCmd withBinds(String... binds);

	/**
	 * Add link to another container.
	 *
	 * @param links the links
	 * @return the start container cmd
	 */
	public StartContainerCmd withLinks(String... links);

	/**
	 * With lxc conf.
	 *
	 * @param lxcConf the lxc conf
	 * @return the start container cmd
	 */
	public StartContainerCmd withLxcConf(String... lxcConf);

	

	/**
	 * Add one or more {@link PortBinding}s.
	 * This corresponds to the <code>--publish</code> (<code>-p</code>)
	 * option of the <code>docker run</code> CLI command.
	 *
	 * @param portBindings the port bindings
	 * @return the start container cmd
	 */
	public StartContainerCmd withPortBindings(String... portBindings);

	/**
	 * With privileged.
	 *
	 * @param privileged the privileged
	 * @return the start container cmd
	 */
	public StartContainerCmd withPrivileged(Boolean privileged);

	/**
	 * With publish all ports.
	 *
	 * @param publishAllPorts the publish all ports
	 * @return the start container cmd
	 */
	public StartContainerCmd withPublishAllPorts(Boolean publishAllPorts);

	/**
	 * Set custom DNS servers.
	 *
	 * @param dns the dns
	 * @return the start container cmd
	 */
	public StartContainerCmd withDns(String... dns);

	/**
	 * Set custom DNS search domains.
	 *
	 * @param dnsSearch the dns search
	 * @return the start container cmd
	 */
	public StartContainerCmd withDnsSearch(String... dnsSearch);

	/**
	 * With volumes from.
	 *
	 * @param volumesFrom the volumes from
	 * @return the start container cmd
	 */
	public StartContainerCmd withVolumesFrom(String volumesFrom);

	/**
	 * With container id.
	 *
	 * @param containerId the container id
	 * @return the start container cmd
	 */
	public StartContainerCmd withContainerId(String containerId);

	/**
	 * Set the Network mode for the container
	 * <ul>
	 * <li>'bridge': creates a new network stack for the container on the docker
	 * bridge</li>
	 * <li>'none': no networking for this container</li>
	 * <li>'container:<name|id>': reuses another container network stack</li>
	 * <li>'host': use the host network stack inside the container. Note: the
	 * host mode gives the container full access to local system services such
	 * as D-bus and is therefore considered insecure.</li>
	 * </ul>
	 *
	 * @param networkMode the network mode
	 * @return the start container cmd
	 */
	public StartContainerCmd withNetworkMode(String networkMode);

	
	/**
	 * With cap add.
	 *
	 * @param capAdd the cap add
	 * @return the start container cmd
	 */
	public StartContainerCmd withCapAdd(String... capAdd) ;
    

	/**
	 * Drop linux <a
	 * href="http://man7.org/linux/man-pages/man7/capabilities.7.html">kernel
	 * capability</a> from the container. For example: dropping {@link Capability#CHOWN}
	 * prevents the container from changing the owner of any files.
	 *
	 * @param capDrop the cap drop
	 * @return the start container cmd
	 */
	public StartContainerCmd withCapDrop(String... capDrop);

	/**
	 * Exec.
	 *
	 * @return the string
	 * @throws NotFoundException             No such container
	 * @throws NotModifiedException             Container already started
	 */
	public String exec() throws NotFoundException, NotModifiedException;

	/**
	 * The Interface Exec.
	 */
	public static interface Exec extends DockerCmdExec<StartContainerCmd, String> {
	}
}
