package com.df.liquid.docker.core;

import com.df.liquid.docker.api.DockerClient;
import com.df.liquid.docker.api.DockerCmdExecFactory;
import com.df.liquid.docker.core.DockerClientConfig.DockerClientConfigBuilder;
import com.df.liquid.docker.execs.DockerCmdExecFactoryImpl;

/**
 * The Class DockerClientBuilder.
 */
public class DockerClientBuilder {

	

	/** The docker client. */
	private DockerClientImpl dockerClient = null;
	
	/** The docker cmd exec factory. */
	private DockerCmdExecFactory dockerCmdExecFactory = null;

	/**
	 * Instantiates a new docker client builder.
	 *
	 * @param dockerClient the docker client
	 */
	private DockerClientBuilder(DockerClientImpl dockerClient) {
		this.dockerClient = dockerClient;
	}

	/**
	 * Gets the single instance of DockerClientBuilder.
	 *
	 * @return single instance of DockerClientBuilder
	 */
	public static DockerClientBuilder getInstance() {
		return new DockerClientBuilder(DockerClientImpl.getInstance());
	}

	/**
	 * Gets the single instance of DockerClientBuilder.
	 *
	 * @param dockerClientConfigBuilder the docker client config builder
	 * @return single instance of DockerClientBuilder
	 */
	public static DockerClientBuilder getInstance(
			DockerClientConfigBuilder dockerClientConfigBuilder) {
		return getInstance(dockerClientConfigBuilder.build());
	}

	/**
	 * Gets the single instance of DockerClientBuilder.
	 *
	 * @param dockerClientConfig the docker client config
	 * @return single instance of DockerClientBuilder
	 */
	public static DockerClientBuilder getInstance(
			DockerClientConfig dockerClientConfig) {
		return new DockerClientBuilder(
				DockerClientImpl.getInstance(dockerClientConfig));
	}

	/**
	 * Gets the default docker cmd exec factory.
	 *
	 * @return the default docker cmd exec factory
	 */
	public static DockerCmdExecFactory getDefaultDockerCmdExecFactory() {
		return new DockerCmdExecFactoryImpl();
	}

	/**
	 * Builds the.
	 *
	 * @return the docker client
	 */
	public DockerClient build() {
		if (dockerCmdExecFactory != null) {
			dockerClient.withDockerCmdExecFactory(dockerCmdExecFactory);
		} else {
			dockerClient.withDockerCmdExecFactory(getDefaultDockerCmdExecFactory());
		}

		return dockerClient;
	}

}
