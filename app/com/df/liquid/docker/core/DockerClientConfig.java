package com.df.liquid.docker.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import com.google.common.base.Preconditions;

/**
 * The Class DockerClientConfig.
 */
public class DockerClientConfig {

	/** The Constant DOCKER_HOST_PROPERTY. */
	private static final String DOCKER_HOST_PROPERTY = "DOCKER_HOST";
	
	/** The Constant DOCKER_CERT_PATH_PROPERTY. */
	private static final String DOCKER_CERT_PATH_PROPERTY = "DOCKER_CERT_PATH";
	
	/** The Constant DOCKER_IO_URL_PROPERTY. */
	private static final String DOCKER_IO_URL_PROPERTY = "docker.io.url";
	
	/** The Constant DOCKER_IO_VERSION_PROPERTY. */
	private static final String DOCKER_IO_VERSION_PROPERTY = "docker.io.version";
	
	/** The Constant DOCKER_IO_USERNAME_PROPERTY. */
	private static final String DOCKER_IO_USERNAME_PROPERTY = "docker.io.username";
	
	/** The Constant DOCKER_IO_PASSWORD_PROPERTY. */
	private static final String DOCKER_IO_PASSWORD_PROPERTY = "docker.io.password";
	
	/** The Constant DOCKER_IO_EMAIL_PROPERTY. */
	private static final String DOCKER_IO_EMAIL_PROPERTY = "docker.io.email";
	
	/** The Constant DOCKER_IO_SERVER_ADDRESS_PROPERTY. */
	private static final String DOCKER_IO_SERVER_ADDRESS_PROPERTY = "docker.io.serverAddress";
	
	/** The Constant DOCKER_IO_READ_TIMEOUT_PROPERTY. */
	private static final String DOCKER_IO_READ_TIMEOUT_PROPERTY = "docker.io.readTimeout";
	
	/** The Constant DOCKER_IO_ENABLE_LOGGING_FILTER_PROPERTY. */
	private static final String DOCKER_IO_ENABLE_LOGGING_FILTER_PROPERTY = "docker.io.enableLoggingFilter";
	
	/** The Constant DOCKER_IO_DOCKER_CERT_PATH_PROPERTY. */
	private static final String DOCKER_IO_DOCKER_CERT_PATH_PROPERTY = "docker.io.dockerCertPath";
	
	/** The Constant DOCKER_IO_DOCKER_CFG_PATH_PROPERTY. */
	private static final String DOCKER_IO_DOCKER_CFG_PATH_PROPERTY = "docker.io.dockerCfgPath";
	
	/** The docker cfg path. */
	private final String uri, version, username, password, email,
			serverAddress, dockerCertPath, dockerCfgPath;
	
	/** The read timeout. */
	private final int readTimeout;
	
	/** The logging filter enabled. */
	private final boolean loggingFilterEnabled;
	
	/** The Constant DOCKER_IO_PROPERTIES_PROPERTY. */
	private static final String DOCKER_IO_PROPERTIES_PROPERTY = "docker.io.properties";

	/**
	 * Instantiates a new docker client config.
	 *
	 * @param uri the uri
	 * @param version the version
	 * @param username the username
	 * @param password the password
	 * @param email the email
	 * @param serverAddress the server address
	 * @param dockerCertPath the docker cert path
	 * @param dockerCfgPath the docker cfg path
	 * @param readTimeout the read timeout
	 * @param loggingFilterEnabled the logging filter enabled
	 */
	DockerClientConfig(String uri, String version, String username,
			String password, String email, String serverAddress,
			String dockerCertPath, String dockerCfgPath, Integer readTimeout,
			boolean loggingFilterEnabled) {
		this.uri = uri;
		this.version = version;
		this.username = username;
		this.password = password;
		this.email = email;
		this.serverAddress = serverAddress;
		this.dockerCertPath = dockerCertPath;
		this.dockerCfgPath = dockerCfgPath;
		this.readTimeout = readTimeout;
		this.loggingFilterEnabled = loggingFilterEnabled;
	}

	/**
	 * Creates the default config builder.
	 *
	 * @return the docker client config builder
	 */
	public static DockerClientConfigBuilder createDefaultConfigBuilder() {
		return createDefaultConfigBuilder(System.getProperties());
	}

	/**
	 * Creates the default config builder.
	 *
	 * @param systemProperties the system properties
	 * @return the docker client config builder
	 */
	static DockerClientConfigBuilder createDefaultConfigBuilder(
			Properties systemProperties) {
		
		InputStream inputStreem = null;
		try {
			inputStreem = new FileInputStream(
					DOCKER_IO_PROPERTIES_PROPERTY);
			systemProperties.load(inputStreem);

			return new DockerClientConfigBuilder()
					.withProperties(systemProperties);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}finally{
						if(inputStreem != null){
								try {
									inputStreem.close();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
					        }
		}

	}

	/**
	 * Gets the docker host property.
	 *
	 * @return the docker host property
	 */
	public static String getDockerHostProperty() {
		return DOCKER_HOST_PROPERTY;
	}

	/**
	 * Gets the docker cert path property.
	 *
	 * @return the docker cert path property
	 */
	public static String getDockerCertPathProperty() {
		return DOCKER_CERT_PATH_PROPERTY;
	}

	/**
	 * Gets the docker io url property.
	 *
	 * @return the docker io url property
	 */
	public static String getDockerIoUrlProperty() {
		return DOCKER_IO_URL_PROPERTY;
	}

	/**
	 * Gets the docker io version property.
	 *
	 * @return the docker io version property
	 */
	public static String getDockerIoVersionProperty() {
		return DOCKER_IO_VERSION_PROPERTY;
	}

	/**
	 * Gets the docker io username property.
	 *
	 * @return the docker io username property
	 */
	public static String getDockerIoUsernameProperty() {
		return DOCKER_IO_USERNAME_PROPERTY;
	}

	/**
	 * Gets the docker io password property.
	 *
	 * @return the docker io password property
	 */
	public static String getDockerIoPasswordProperty() {
		return DOCKER_IO_PASSWORD_PROPERTY;
	}

	/**
	 * Gets the docker io email property.
	 *
	 * @return the docker io email property
	 */
	public static String getDockerIoEmailProperty() {
		return DOCKER_IO_EMAIL_PROPERTY;
	}

	/**
	 * Gets the docker io server address property.
	 *
	 * @return the docker io server address property
	 */
	public static String getDockerIoServerAddressProperty() {
		return DOCKER_IO_SERVER_ADDRESS_PROPERTY;
	}

	/**
	 * Gets the docker io read timeout property.
	 *
	 * @return the docker io read timeout property
	 */
	public static String getDockerIoReadTimeoutProperty() {
		return DOCKER_IO_READ_TIMEOUT_PROPERTY;
	}

	/**
	 * Gets the docker io enable logging filter property.
	 *
	 * @return the docker io enable logging filter property
	 */
	public static String getDockerIoEnableLoggingFilterProperty() {
		return DOCKER_IO_ENABLE_LOGGING_FILTER_PROPERTY;
	}

	/**
	 * Gets the docker io docker cert path property.
	 *
	 * @return the docker io docker cert path property
	 */
	public static String getDockerIoDockerCertPathProperty() {
		return DOCKER_IO_DOCKER_CERT_PATH_PROPERTY;
	}

	/**
	 * Gets the docker io docker cfg path property.
	 *
	 * @return the docker io docker cfg path property
	 */
	public static String getDockerIoDockerCfgPathProperty() {
		return DOCKER_IO_DOCKER_CFG_PATH_PROPERTY;
	}

	/**
	 * Gets the uri.
	 *
	 * @return the uri
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * Gets the version.
	 *
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Gets the server address.
	 *
	 * @return the server address
	 */
	public String getServerAddress() {
		return serverAddress;
	}

	/**
	 * Gets the docker cert path.
	 *
	 * @return the docker cert path
	 */
	public String getDockerCertPath() {
		return dockerCertPath;
	}

	/**
	 * Gets the docker cfg path.
	 *
	 * @return the docker cfg path
	 */
	public String getDockerCfgPath() {
		return dockerCfgPath;
	}

	/**
	 * Gets the read timeout.
	 *
	 * @return the read timeout
	 */
	public int getReadTimeout() {
		return readTimeout;
	}

	/**
	 * Checks if is logging filter enabled.
	 *
	 * @return true, if is logging filter enabled
	 */
	public boolean isLoggingFilterEnabled() {
		return loggingFilterEnabled;
	}

	/**
	 * The Class DockerClientConfigBuilder.
	 */
	public static class DockerClientConfigBuilder {
		// private URI uri;
		/** The docker cfg path. */
		private String uri, version, username, password, email, serverAddress,
				dockerCertPath, dockerCfgPath;
		
		/** The read timeout. */
		private Integer readTimeout;
		
		/** The logging filter enabled. */
		private boolean loggingFilterEnabled;

		/**
		 * This will set all fields in the builder to those contained in the
		 * Properties object. The Properties object should contain the following
		 * docker.io.* keys: url, version, username, password, email,
		 * dockerCertPath, and dockerCfgPath. If docker.io.readTimeout or
		 * docker.io.enableLoggingFilter are not contained, they will be set to
		 * 1000 and true, respectively.
		 *
		 * @param p the p
		 * @return the docker client config builder
		 */
		public DockerClientConfigBuilder withProperties(Properties p) {
			return withUri(p.getProperty(DOCKER_IO_URL_PROPERTY))
					.withVersion(p.getProperty(DOCKER_IO_VERSION_PROPERTY))
					.withUsername(p.getProperty(DOCKER_IO_USERNAME_PROPERTY))
					.withPassword(p.getProperty(DOCKER_IO_PASSWORD_PROPERTY))
					.withEmail(p.getProperty(DOCKER_IO_EMAIL_PROPERTY))
					.withServerAddress(
							p.getProperty(DOCKER_IO_SERVER_ADDRESS_PROPERTY))
					.withReadTimeout(
							Integer.valueOf(p.getProperty(
									DOCKER_IO_READ_TIMEOUT_PROPERTY, "0")))
					.withLoggingFilter(
							Boolean.valueOf(p.getProperty(
									DOCKER_IO_ENABLE_LOGGING_FILTER_PROPERTY,
									"true")))
					.withDockerCertPath(
							p.getProperty(DOCKER_IO_DOCKER_CERT_PATH_PROPERTY))
					.withDockerCfgPath(
							p.getProperty(DOCKER_IO_DOCKER_CFG_PATH_PROPERTY));
		}

		/**
		 * With uri.
		 *
		 * @param uri the uri
		 * @return the docker client config builder
		 */
		public final DockerClientConfigBuilder withUri(String uri) {
			Preconditions.checkNotNull(uri, "uri was not specified");
			this.uri = uri;
			return this;
		}

		/**
		 * With version.
		 *
		 * @param version the version
		 * @return the docker client config builder
		 */
		public final DockerClientConfigBuilder withVersion(String version) {
			this.version = version;
			return this;
		}

		/**
		 * With username.
		 *
		 * @param username the username
		 * @return the docker client config builder
		 */
		public final DockerClientConfigBuilder withUsername(String username) {
			this.username = username;
			return this;
		}

		/**
		 * With password.
		 *
		 * @param password the password
		 * @return the docker client config builder
		 */
		public final DockerClientConfigBuilder withPassword(String password) {
			this.password = password;
			return this;
		}

		/**
		 * With email.
		 *
		 * @param email the email
		 * @return the docker client config builder
		 */
		public final DockerClientConfigBuilder withEmail(String email) {
			this.email = email;
			return this;
		}

		/**
		 * With server address.
		 *
		 * @param serverAddress the server address
		 * @return the docker client config builder
		 */
		public DockerClientConfigBuilder withServerAddress(String serverAddress) {
			this.serverAddress = serverAddress;
			return this;
		}

		/**
		 * With read timeout.
		 *
		 * @param readTimeout the read timeout
		 * @return the docker client config builder
		 */
		public final DockerClientConfigBuilder withReadTimeout(
				Integer readTimeout) {
			this.readTimeout = readTimeout;
			return this;
		}

		/**
		 * With logging filter.
		 *
		 * @param loggingFilterEnabled the logging filter enabled
		 * @return the docker client config builder
		 */
		public final DockerClientConfigBuilder withLoggingFilter(
				boolean loggingFilterEnabled) {
			this.loggingFilterEnabled = loggingFilterEnabled;
			return this;
		}

		/**
		 * With docker cert path.
		 *
		 * @param dockerCertPath the docker cert path
		 * @return the docker client config builder
		 */
		public final DockerClientConfigBuilder withDockerCertPath(
				String dockerCertPath) {
			this.dockerCertPath = dockerCertPath;
			return this;
		}

		/**
		 * With docker cfg path.
		 *
		 * @param dockerCfgPath the docker cfg path
		 * @return the docker client config builder
		 */
		public final DockerClientConfigBuilder withDockerCfgPath(
				String dockerCfgPath) {
			this.dockerCfgPath = dockerCfgPath;
			return this;
		}

		/**
		 * Builds the.
		 *
		 * @return the docker client config
		 */
		public DockerClientConfig build() {
			return new DockerClientConfig(uri, version, username, password,
					email, serverAddress, dockerCertPath, dockerCfgPath,
					readTimeout, loggingFilterEnabled);
		}
	}
}
