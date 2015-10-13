package com.df.liquid.docker.api.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class HostConfig.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class HostConfig {

	/** The binds. */
	@JsonProperty("Binds")
	private Binds binds;

	/** The links. */
	@JsonProperty("Links")
	private Links links;

	/** The lxc conf. */
	@JsonProperty("LxcConf")
	private LxcConf[] lxcConf;

	/** The port bindings. */
	@JsonProperty("PortBindings")
	private Ports portBindings;

	/** The publish all ports. */
	@JsonProperty("PublishAllPorts")
	private boolean publishAllPorts;

	/** The privileged. */
	@JsonProperty("Privileged")
	private boolean privileged;

	/** The dns. */
	@JsonProperty("Dns")
	private String[] dns;

	/** The dns search. */
	@JsonProperty("DnsSearch")
	private String[] dnsSearch;

	/** The volumes from. */
	@JsonProperty("VolumesFrom")
	private VolumesFrom[] volumesFrom;

	/** The container id file. */
	@JsonProperty("ContainerIDFile")
	private String containerIDFile;

	/** The cap add. */
	@JsonProperty("CapAdd")
	private Capability[] capAdd;

	/** The cap drop. */
	@JsonProperty("CapDrop")
	private Capability[] capDrop;

	/** The restart policy. */
	@JsonProperty("RestartPolicy")
	private RestartPolicy restartPolicy;

	/** The network mode. */
	@JsonProperty("NetworkMode")
	private String networkMode;

	/** The devices. */
	@JsonProperty("Devices")
	private Device[] devices;

	/** The extra hosts. */
	@JsonProperty("ExtraHosts")
	private String[] extraHosts;

	/**
	 * Instantiates a new host config.
	 */
	public HostConfig() {
	}

	/**
	 * Instantiates a new host config.
	 *
	 * @param binds the binds
	 * @param links the links
	 * @param lxcConf the lxc conf
	 * @param portBindings the port bindings
	 * @param publishAllPorts the publish all ports
	 * @param privileged the privileged
	 * @param dns the dns
	 * @param dnsSearch the dns search
	 * @param volumesFrom the volumes from
	 * @param containerIDFile the container id file
	 * @param capAdd the cap add
	 * @param capDrop the cap drop
	 * @param restartPolicy the restart policy
	 * @param networkMode the network mode
	 * @param devices the devices
	 * @param extraHosts the extra hosts
	 */
	public HostConfig(Bind[] binds, Link[] links, LxcConf[] lxcConf, Ports portBindings, boolean publishAllPorts,
			boolean privileged, String[] dns, String[] dnsSearch, VolumesFrom[] volumesFrom, String containerIDFile,
			Capability[] capAdd, Capability[] capDrop, RestartPolicy restartPolicy, String networkMode, Device[] devices,
            String[] extraHosts) {
		this.binds = new Binds(binds);
		this.links = new Links(links);
		this.lxcConf = lxcConf;
		this.portBindings = portBindings;
		this.publishAllPorts = publishAllPorts;
		this.privileged = privileged;
		this.dns = dns;
		this.dnsSearch = dnsSearch;
		this.volumesFrom = volumesFrom;
		this.containerIDFile = containerIDFile;
		this.capAdd = capAdd;
		this.capDrop = capDrop;
		this.restartPolicy = restartPolicy;
		this.networkMode = networkMode;
		this.devices = devices;
		this.extraHosts = extraHosts;
	}


	/**
	 * Gets the binds.
	 *
	 * @return the binds
	 */
	@JsonIgnore
	public Bind[] getBinds() {
		return (binds == null) ? new Bind[0] : binds.getBinds();
	}

	/**
	 * Gets the lxc conf.
	 *
	 * @return the lxc conf
	 */
	public LxcConf[] getLxcConf() {
		return lxcConf;
	}
	
	/**
	 * Gets the port bindings.
	 *
	 * @return the port bindings
	 */
	public Ports getPortBindings() {
		return portBindings;
	}

	/**
	 * Checks if is publish all ports.
	 *
	 * @return true, if is publish all ports
	 */
	public boolean isPublishAllPorts() {
		return publishAllPorts;
	}

	/**
	 * Checks if is privileged.
	 *
	 * @return true, if is privileged
	 */
	public boolean isPrivileged() {
		return privileged;
	}

	/**
	 * Gets the dns.
	 *
	 * @return the dns
	 */
	public String[] getDns() {
		return dns;
	}

	/**
	 * Gets the volumes from.
	 *
	 * @return the volumes from
	 */
	public VolumesFrom[] getVolumesFrom() {
		return volumesFrom;
	}

	/**
	 * Gets the container id file.
	 *
	 * @return the container id file
	 */
	public String getContainerIDFile() {
		return containerIDFile;
	}

	/**
	 * Gets the dns search.
	 *
	 * @return the dns search
	 */
	public String[] getDnsSearch() {
		return dnsSearch;
	}

	/**
	 * Gets the links.
	 *
	 * @return the links
	 */
	@JsonIgnore
	public Link[] getLinks() {
		return (links == null) ? new Link[0] : links.getLinks();
	}

	/**
	 * Gets the network mode.
	 *
	 * @return the network mode
	 */
	public String getNetworkMode() {
		return networkMode;
	}

	/**
	 * Gets the devices.
	 *
	 * @return the devices
	 */
	public Device[] getDevices() {
		return devices;
	}

	/**
	 * Gets the extra hosts.
	 *
	 * @return the extra hosts
	 */
	public String[] getExtraHosts() {
		return extraHosts;
	}

	/**
	 * Gets the restart policy.
	 *
	 * @return the restart policy
	 */
	public RestartPolicy getRestartPolicy() {
		return restartPolicy;
	}

	/**
	 * Gets the cap add.
	 *
	 * @return the cap add
	 */
	public Capability[] getCapAdd() {
		return capAdd;
	}

	/**
	 * Gets the cap drop.
	 *
	 * @return the cap drop
	 */
	public Capability[] getCapDrop() {
		return capDrop;
	}

	/**
	 * Sets the binds.
	 *
	 * @param binds the new binds
	 */
	@JsonIgnore
	public void setBinds(Bind... binds) {
		this.binds = new Binds(binds);
	}

	/**
	 * Sets the links.
	 *
	 * @param links the new links
	 */
	@JsonIgnore
	public void setLinks(Link... links) {
		this.links = new Links(links);
	}

	/**
	 * Sets the lxc conf.
	 *
	 * @param lxcConf the new lxc conf
	 */
	public void setLxcConf(LxcConf[] lxcConf) {
		this.lxcConf = lxcConf;
	}

	/**
	 * Sets the port bindings.
	 *
	 * @param portBindings the new port bindings
	 */
	public void setPortBindings(Ports portBindings) {
		this.portBindings = portBindings;
	}

	/**
	 * Sets the publish all ports.
	 *
	 * @param publishAllPorts the new publish all ports
	 */
	public void setPublishAllPorts(boolean publishAllPorts) {
		this.publishAllPorts = publishAllPorts;
	}

	/**
	 * Sets the privileged.
	 *
	 * @param privileged the new privileged
	 */
	public void setPrivileged(boolean privileged) {
		this.privileged = privileged;
	}

	/**
	 * Sets the dns.
	 *
	 * @param dns the new dns
	 */
	public void setDns(String[] dns) {
		this.dns = dns;
	}

	/**
	 * Sets the dns search.
	 *
	 * @param dnsSearch the new dns search
	 */
	public void setDnsSearch(String[] dnsSearch) {
		this.dnsSearch = dnsSearch;
	}

	/**
	 * Sets the volumes from.
	 *
	 * @param volumesFrom the new volumes from
	 */
	public void setVolumesFrom(VolumesFrom[] volumesFrom) {
		this.volumesFrom = volumesFrom;
	}

	/**
	 * Sets the container id file.
	 *
	 * @param containerIDFile the new container id file
	 */
	public void setContainerIDFile(String containerIDFile) {
		this.containerIDFile = containerIDFile;
	}

	/**
	 * Sets the cap add.
	 *
	 * @param capAdd the new cap add
	 */
	public void setCapAdd(Capability[] capAdd) {
		this.capAdd = capAdd;
	}

	/**
	 * Sets the cap drop.
	 *
	 * @param capDrop the new cap drop
	 */
	public void setCapDrop(Capability[] capDrop) {
		this.capDrop = capDrop;
	}

	/**
	 * Sets the restart policy.
	 *
	 * @param restartPolicy the new restart policy
	 */
	public void setRestartPolicy(RestartPolicy restartPolicy) {
		this.restartPolicy = restartPolicy;
	}

	/**
	 * Sets the network mode.
	 *
	 * @param networkMode the new network mode
	 */
	public void setNetworkMode(String networkMode) {
		this.networkMode = networkMode;
	}

	/**
	 * Sets the devices.
	 *
	 * @param devices the new devices
	 */
	public void setDevices(Device[] devices) {
		this.devices = devices;
	}

	/**
	 * Sets the extra hosts.
	 *
	 * @param extraHosts the new extra hosts
	 */
	public void setExtraHosts(String[] extraHosts) {
		this.extraHosts = extraHosts;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}