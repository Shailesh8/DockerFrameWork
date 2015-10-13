package com.df.liquid.docker.core.command;

import com.df.liquid.docker.api.command.StartContainerCmd;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Preconditions;

/**
 * The Class StartContainerCmdImpl implements the method of StartContainerCmd class
 */
public class StartContainerCmdImpl extends AbstrDockerCmd<StartContainerCmd, String> implements StartContainerCmd {

	
	/** The container id. */
	@JsonIgnore
	private String containerId;

	@JsonProperty("Binds")
	private String[] binds;

	@JsonProperty("Links")
	private String[] links;

	@JsonProperty("LxcConf")
	private String[] lxcConf;

	@JsonProperty("PortBindings")
	private String[] portBindings;

	@JsonProperty("PublishAllPorts")
	private Boolean publishAllPorts;

	@JsonProperty("Privileged")
	private Boolean privileged;

	@JsonProperty("Dns")
	private String[] dns;
	
	@JsonProperty("DnsSearch")
	private String[] dnsSearch;

	@JsonProperty("VolumesFrom")
	private String volumesFrom;
	
	@JsonProperty("NetworkMode")          
    private String networkMode;
			
	@JsonProperty("CapAdd")
	private String[] capAdd;
	
	@JsonProperty("CapDrop")
	private String[] capDrop;
	
	
	public StartContainerCmdImpl(StartContainerCmd.Exec exec, String containerId) {
		super(exec);
		withContainerId(containerId);
	}

	@Override
	public String[] getBinds() {
		return binds;
	}

	@Override
	public String[] getLinks() {
		return links;
	}

	@Override
	public String[] getLxcConf() {
		return lxcConf;
	}

	@Override
	public String[] getPortBindings() {
		return portBindings;
	}

	@Override
	public Boolean isPublishAllPorts() {
		return publishAllPorts;
	}

	@Override
	public Boolean isPrivileged() {
		return privileged;
	}

	@Override
	public String[] getDns() {
		return dns;
	}

	@Override
	public String[] getDnsSearch() {
		return dnsSearch;
	}

	@Override
	public String getVolumesFrom() {
		return volumesFrom;
	}

	@Override
	public String getContainerId() {
		return containerId;
	}

	@Override
	public String getNetworkMode() {
		 return networkMode;
	}

	@Override
	public String[] getCapAdd() {
		return capAdd;
	}

	@Override
	public String[] getCapDrop() {
		return capDrop;
	}

	@Override
	public StartContainerCmd withBinds(String... binds) {
		Preconditions.checkNotNull(binds, "binds was not specified");
		this.binds=binds;
		return this;
	}

	@Override
	public StartContainerCmd withLinks(String... links) {
		Preconditions.checkNotNull(links, "binds was not specified");
		this.links=links;
		return this;
	}

	@Override
	public StartContainerCmd withLxcConf(String... lxcConf) {
		Preconditions.checkNotNull(lxcConf, "binds was not specified");
		this.lxcConf=lxcConf;
		return this;
	}

	
	@Override
	public StartContainerCmd withPortBindings(String... portBindings) {
		Preconditions.checkNotNull(portBindings, "binds was not specified");
		this.portBindings=portBindings;
		return this;
	}

	@Override
	public StartContainerCmd withPrivileged(Boolean privileged) {
		this.privileged = privileged;
		return this;
	}

	@Override
	public StartContainerCmd withPublishAllPorts(Boolean publishAllPorts) {
		this.publishAllPorts = publishAllPorts;
		return this;
	}

	@Override
	public StartContainerCmd withDns(String... dns) {
		Preconditions.checkNotNull(dns, "dns was not specified");
		this.dns = dns;
		return this;
	}

	@Override
	public StartContainerCmd withDnsSearch(String... dnsSearch) {
		Preconditions.checkNotNull(dnsSearch, "dnsSearch was not specified");
		this.dnsSearch = dnsSearch;
		return this;
	}

	@Override
	public StartContainerCmd withVolumesFrom(String volumesFrom) {
		Preconditions.checkNotNull(volumesFrom, "volumesFrom was not specified");
this.volumesFrom = volumesFrom;
return this;
	}

	@Override
	public StartContainerCmd withContainerId(String containerId) {
		Preconditions
		.checkNotNull(containerId, "containerId was not specified");
this.containerId = containerId;
return this;
	}

	@Override
	public StartContainerCmd withNetworkMode(String networkMode) {
		 Preconditions.checkNotNull(networkMode, "networkMode was not specified");
	        this.networkMode = networkMode;
	        return this;
	}
	
	@Override
	public StartContainerCmd withCapAdd(String... capAdd) {
		Preconditions.checkNotNull(capAdd, "capAdd was not specified");
		this.capAdd = capAdd;
		return this;
	}
    

	@Override
	public StartContainerCmd withCapDrop(String... capDrop) {
		Preconditions.checkNotNull(capDrop, "capDrop was not specified");
		this.capDrop = capDrop;
		return this;
	}

	

}
