package com.df.liquid.docker.api.command;

import java.util.Map;

//import models.api.model.HostConfig;






import org.apache.commons.lang3.builder.ToStringBuilder;

import com.df.liquid.docker.api.model.ContainerConfig;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class InspectContainerResponse.
 */
public class InspectContainerResponse {

	/** The args. */
	@JsonProperty("Args")
	private String[] args;

	/** The config. */
	@JsonProperty("Config")
	private ContainerConfig config;

	/** The created. */
	@JsonProperty("Created")
	private String created;

	/** The driver. */
	@JsonProperty("Driver")
	private String driver;

	/** The exec driver. */
	@JsonProperty("ExecDriver")
	private String execDriver;

	/*@JsonProperty("HostConfig")
	private HostConfig hostConfig;
*/
	/** The hostname path. */
	@JsonProperty("HostnamePath")
	private String hostnamePath;

	/** The hosts path. */
	@JsonProperty("HostsPath")
	private String hostsPath;

	/** The id. */
	@JsonProperty("Id")
    private String id;

	/** The image id. */
	@JsonProperty("Image")
	private String imageId;

	/** The mount label. */
	@JsonProperty("MountLabel")
	private String mountLabel;

	/** The name. */
	@JsonProperty("Name")
	private String name;

	/** The network settings. */
	@JsonProperty("NetworkSettings")
	private NetworkSettings networkSettings;

	/** The path. */
	@JsonProperty("Path")
    private String path;

	/** The process label. */
	@JsonProperty("ProcessLabel")
    private String processLabel;

	/** The resolv conf path. */
	@JsonProperty("ResolvConfPath")
	private String resolvConfPath;

	/** The state. */
	@JsonProperty("State")
    private ContainerState state;

    /** The volumes. */
    @JsonProperty("Volumes")
    private String[] volumes;

    /** The volumes rw. */
    @JsonProperty("VolumesRW")
    private String[] volumesRW;

    /**
     * Gets the id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the created.
     *
     * @return the created
     */
    public String getCreated() {
        return created;
    }

    /**
     * Gets the path.
     *
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * Gets the process label.
     *
     * @return the process label
     */
    public String getProcessLabel() {
		return processLabel;
	}

    /**
     * Gets the args.
     *
     * @return the args
     */
    public String[] getArgs() {
        return (String[])args.clone();
    }

    /**
     * Gets the config.
     *
     * @return the config
     */
    public ContainerConfig getConfig() {
        return config;
    }

    /**
     * Gets the state.
     *
     * @return the state
     */
    public ContainerState getState() {
        return state;
    }

    /**
     * Gets the image id.
     *
     * @return the image id
     */
    public String getImageId() {
        return imageId;
    }

    /**
     * Gets the network settings.
     *
     * @return the network settings
     */
    public NetworkSettings getNetworkSettings() {
        return networkSettings;
    }

    /**
     * Gets the resolv conf path.
     *
     * @return the resolv conf path
     */
    public String getResolvConfPath() {
        return resolvConfPath;
    }

    /**
     * Gets the volumes.
     *
     * @return the volumes
     */
    @JsonIgnore
    public String[] getVolumes() {
        return (String[])volumes.clone();
    }

    /**
     * Gets the volumes rw.
     *
     * @return the volumes rw
     */
    @JsonIgnore
    public String[] getVolumesRW() {
        return (String[])volumesRW.clone();
    }

    /**
     * Gets the hostname path.
     *
     * @return the hostname path
     */
    public String getHostnamePath() {
        return hostnamePath;
    }

    /**
     * Gets the hosts path.
     *
     * @return the hosts path
     */
    public String getHostsPath() {
        return hostsPath;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the driver.
     *
     * @return the driver
     */
    public String getDriver() {
        return driver;
    }

   /* public HostConfig getHostConfig() {
        return hostConfig;
    }
*/
    /**
    * Gets the exec driver.
    *
    * @return the exec driver
    */
   public String getExecDriver() {
		return execDriver;
	}

    /**
     * Gets the mount label.
     *
     * @return the mount label
     */
    public String getMountLabel() {
		return mountLabel;
	}
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }


    /**
     * The Class NetworkSettings.
     */
    @JsonIgnoreProperties(ignoreUnknown = true)     
    public static class NetworkSettings {

        /** The ip address. */
        @JsonProperty("IPAddress") private String ipAddress;
        
        /** The ip prefix len. */
        @JsonProperty("IPPrefixLen") private int ipPrefixLen;
        
        /** The gateway. */
        @JsonProperty("Gateway") private String gateway;
        
        /** The bridge. */
        @JsonProperty("Bridge") private String bridge;
        
        /** The port mapping. */
        @JsonProperty("PortMapping") private Map<String,Map<String, String>> portMapping;
        
        /** The ports. */
        @JsonProperty("Ports") private String[] ports;

        /**
         * Gets the ip address.
         *
         * @return the ip address
         */
        public String getIpAddress() {
			return ipAddress;
		}

		/**
		 * Gets the ip prefix len.
		 *
		 * @return the ip prefix len
		 */
		public int getIpPrefixLen() {
			return ipPrefixLen;
		}

		/**
		 * Gets the gateway.
		 *
		 * @return the gateway
		 */
		public String getGateway() {
			return gateway;
		}

		/**
		 * Gets the bridge.
		 *
		 * @return the bridge
		 */
		public String getBridge() {
			return bridge;
		}

		/**
		 * Gets the port mapping.
		 *
		 * @return the port mapping
		 */
		public Map<String, Map<String, String>> getPortMapping() {
			return portMapping;
		}

		/**
		 * Gets the ports.
		 *
		 * @return the ports
		 */
		public String[] getPorts() {
			return (String[])ports.clone();
		}


		 /* (non-Javadoc)
 		 * @see java.lang.Object#toString()
 		 */
 		@Override
	     public String toString() {
	       return ToStringBuilder.reflectionToString(this);
	        } 
    }

    /**
     * The Class ContainerState.
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ContainerState {

        /** The running. */
        @JsonProperty("Running") private boolean running;
        
        /** The paused. */
        @JsonProperty("Paused") private boolean paused;
        
        /** The pid. */
        @JsonProperty("Pid") private int pid;
        
        /** The exit code. */
        @JsonProperty("ExitCode") private int exitCode;
        
        /** The started at. */
        @JsonProperty("StartedAt") private String startedAt;
        
        /** The finished at. */
        @JsonProperty("FinishedAt") private String finishedAt;

        /**
         * Checks if is running.
         *
         * @return true, if is running
         */
        public boolean isRunning() {
			return running;
		}

		/**
		 * Checks if is paused.
		 *
		 * @return true, if is paused
		 */
		public boolean isPaused() {
			return paused;
		}

		/**
		 * Gets the pid.
		 *
		 * @return the pid
		 */
		public int getPid() {
			return pid;
		}

		/**
		 * Gets the exit code.
		 *
		 * @return the exit code
		 */
		public int getExitCode() {
			return exitCode;
		}

		/**
		 * Gets the started at.
		 *
		 * @return the started at
		 */
		public String getStartedAt() {
			return startedAt;
		}

		/**
		 * Gets the finished at.
		 *
		 * @return the finished at
		 */
		public String getFinishedAt() {
			return finishedAt;
		}
     
		 /* (non-Javadoc)
 		 * @see java.lang.Object#toString()
 		 */
 		@Override
	     public String toString() {
	            return ToStringBuilder.reflectionToString(this);
	        }  
    }
}
