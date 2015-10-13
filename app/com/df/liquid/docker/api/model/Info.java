package com.df.liquid.docker.api.model;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Info {

	@JsonProperty("Containers")
	private int containers;

	@JsonProperty("Debug")
	private boolean debug;
	
	@JsonProperty("DockerRootDir")
	private String DockerRootDir;

	@JsonProperty("Driver")
	private String driver;

	@JsonProperty("DriverStatus")
	private List<Object> driverStatuses;

	@JsonProperty("ExecutionDriver")
	private String executionDriver;
	
	@JsonProperty("ID")
	private String ID;

	@JsonProperty("IPv4Forwarding")
	private boolean IPv4Forwarding;

	@JsonProperty("Images")
	private int images;

	@JsonProperty("IndexServerAddress")
	private String IndexServerAddress;

	@JsonProperty("InitPath")
	private String initPath;

	@JsonProperty("InitSha1")
	private String initSha1;

	/*@JsonProperty("RegistryConfig")
	private String registryConfig;
   */
	/*public String getRegistryConfig() {
		return registryConfig;
	}

	public void setRegistryConfig(String registryConfig) {
		this.registryConfig = registryConfig;
	}*/

	@JsonProperty("KernelVersion")
	private String kernelVersion;
	
	@JsonProperty("Labels")
	private String Labels;

	@JsonProperty("MemoryLimit")
	private boolean memoryLimit;
	
	@JsonProperty("MemTotal")
	private long memTotal;
		
	@JsonProperty("Name")
	private String name;
	
	@JsonProperty("NCPU")
	private int NCPU;

	@JsonProperty("NEventsListener")
	private long nEventListener;

	@JsonProperty("NFd")
	private int NFd;

	@JsonProperty("NGoroutines")
	private int NGoroutines;
	
	@JsonProperty("OperatingSystem")
	private String OperatingSystem;

	@JsonProperty("Sockets")
	private String[] sockets;

	@JsonProperty("SwapLimit")
	private boolean swapLimit;

	public boolean isDebug() {
		return debug;
	}

	public int getContainers() {
		return containers;
	}
	
	public String getDockerRootDir() {
		return DockerRootDir;
	}

	public String getDriver() {
		return driver;
	}

	public List<Object> getDriverStatuses() {
		return driverStatuses;
	}

	public int getImages() {
		return images;
	}
	
	public String getID() {
		return ID;
	}

	public boolean getIPv4Forwarding() {
		return IPv4Forwarding;
	}

	public String getIndexServerAddress() {
		return IndexServerAddress;
	}

	public String getInitPath() {
		return initPath;
	}

	public String getInitSha1() {
		return initSha1;
	}

	public String getKernelVersion() {
		return kernelVersion;
	}
	
	public String getLabels() {
		return Labels;
	}

	public String[] getSockets() {
		return sockets;
	}

	public boolean isMemoryLimit() {
		return memoryLimit;
	}

	public long getnEventListener() {
		return nEventListener;
	}
	
	public long getMemTotal() {
		return memTotal;
	}
	
	public String getName() {
		return name;
	}
	
	public int getNCPU() {
		return NCPU;
	}

	public int getNFd() {
		return NFd;
	}

	public int getNGoroutines() {
		return NGoroutines;
	}
	
	public String getOperatingSystem() {
		return OperatingSystem;
	}

	public boolean getSwapLimit() {
		return swapLimit;
	}

	public String getExecutionDriver() {
		return executionDriver;
	}

    
}