package com.df.liquid.docker.core;

import java.io.InputStream;

import com.df.liquid.docker.api.DockerClient;
import com.df.liquid.docker.api.DockerCmdExecFactory;
import com.df.liquid.docker.api.DockerException;
import com.df.liquid.docker.api.command.AttachContainerCmd;
import com.df.liquid.docker.api.command.AuthCmd;
import com.df.liquid.docker.api.command.CommitCmd;
import com.df.liquid.docker.api.command.ContainerDiffCmd;
import com.df.liquid.docker.api.command.CopyFileFromContainerCmd;
import com.df.liquid.docker.api.command.CreateContainerCmd;
import com.df.liquid.docker.api.command.CreateImageCmd;
import com.df.liquid.docker.api.command.ExecCreateCmd;
import com.df.liquid.docker.api.command.InfoCmd;
import com.df.liquid.docker.api.command.InspectContainerCmd;
import com.df.liquid.docker.api.command.InspectImageCmd;
import com.df.liquid.docker.api.command.KillContainerCmd;
import com.df.liquid.docker.api.command.ListContainersCmd;
import com.df.liquid.docker.api.command.ListImagesCmd;
import com.df.liquid.docker.api.command.LogContainerCmd;
import com.df.liquid.docker.api.command.PauseContainerCmd;
import com.df.liquid.docker.api.command.PingCmd;
import com.df.liquid.docker.api.command.PushImageCmd;
import com.df.liquid.docker.api.command.RemoveContainerCmd;
import com.df.liquid.docker.api.command.RemoveImageCmd;
import com.df.liquid.docker.api.command.RestartContainerCmd;
import com.df.liquid.docker.api.command.SearchImagesCmd;
import com.df.liquid.docker.api.command.StartContainerCmd;
import com.df.liquid.docker.api.command.StopContainerCmd;
import com.df.liquid.docker.api.command.TopContainerCmd;
import com.df.liquid.docker.api.command.UnpauseContainerCmd;
import com.df.liquid.docker.api.command.VersionCmd;
import com.df.liquid.docker.api.command.WaitContainerCmd;
import com.df.liquid.docker.api.command.ListImagesCmd.Exec;
import com.df.liquid.docker.api.model.AuthConfig;
import com.df.liquid.docker.core.command.AttachContainerCmdImpl;
import com.df.liquid.docker.core.command.AuthCmdImpl;
import com.df.liquid.docker.core.command.CommitCmdImpl;
import com.df.liquid.docker.core.command.ContainerDiffCmdImpl;
import com.df.liquid.docker.core.command.CopyFileFromContainerCmdImpl;
import com.df.liquid.docker.core.command.CreateContainerCmdImpl;
import com.df.liquid.docker.core.command.CreateImageCmdImpl;
import com.df.liquid.docker.core.command.ExecCreateCmdImpl;
import com.df.liquid.docker.core.command.InfoCmdImpl;
import com.df.liquid.docker.core.command.InspectContainerCmdImpl;
import com.df.liquid.docker.core.command.InspectImageCmdImpl;
import com.df.liquid.docker.core.command.KillContainerCmdImpl;
import com.df.liquid.docker.core.command.ListContainersCmdImpl;
import com.df.liquid.docker.core.command.ListImagesCmdImpl;
import com.df.liquid.docker.core.command.LogContainerCmdImpl;
import com.df.liquid.docker.core.command.PauseContainerCmdImpl;
import com.df.liquid.docker.core.command.PingCmdImpl;
import com.df.liquid.docker.core.command.PushImageCmdImpl;
import com.df.liquid.docker.core.command.RemoveContainerCmdImpl;
import com.df.liquid.docker.core.command.RemoveImageCmdImpl;
import com.df.liquid.docker.core.command.RestartContainerCmdImpl;
import com.df.liquid.docker.core.command.SearchImagesCmdImpl;
import com.df.liquid.docker.core.command.StartContainerCmdImpl;
import com.df.liquid.docker.core.command.StopContainerCmdImpl;
import com.df.liquid.docker.core.command.TopContainerCmdImpl;
import com.df.liquid.docker.core.command.UnpauseContainerCmdImpl;
import com.df.liquid.docker.core.command.VersionCmdImpl;
import com.df.liquid.docker.core.command.WaitContainerCmdImpl;
import com.google.common.base.Preconditions;

/**
 * The Class DockerClientImpl.
 */
public class DockerClientImpl implements DockerClient {

	public String username;
	public String password;
	public String email;
	/** The docker client config. */
	private final DockerClientConfig dockerClientConfig;

	/** The docker cmd exec factory. */
	private DockerCmdExecFactory dockerCmdExecFactory;

	/**
	 * Instantiates a new docker client impl.
	 */
	private DockerClientImpl() {
		this(DockerClientConfig.createDefaultConfigBuilder().build());
	}

	/**
	 * Instantiates a new docker client impl.
	 *
	 * @param dockerClientConfig
	 *            the docker client config
	 */
	private DockerClientImpl(DockerClientConfig dockerClientConfig) {
		Preconditions.checkNotNull(dockerClientConfig,
				"config was not specified");
		this.dockerClientConfig = dockerClientConfig;
	}

	/**
	 * Gets the single instance of DockerClientImpl.
	 *
	 * @return single instance of DockerClientImpl
	 */
	public static DockerClientImpl getInstance() {
		return new DockerClientImpl();
	}

	/**
	 * Gets the single instance of DockerClientImpl.
	 *
	 * @param dockerClientConfig
	 *            the docker client config
	 * @return single instance of DockerClientImpl
	 */
	public static DockerClientImpl getInstance(
			DockerClientConfig dockerClientConfig) {
		return new DockerClientImpl(dockerClientConfig);
	}

	/**
	 * With docker cmd exec factory.
	 *
	 * @param dockerCmdExecFactory
	 *            the docker cmd exec factory
	 * @return the docker client impl
	 */
	public DockerClientImpl withDockerCmdExecFactory(
			DockerCmdExecFactory dockerCmdExecFactory) {
		Preconditions.checkNotNull(dockerCmdExecFactory,
				"dockerCmdExecFactory was not specified");
		this.dockerCmdExecFactory = dockerCmdExecFactory;
		this.dockerCmdExecFactory.init(dockerClientConfig);
		return this;
	}

	/**
	 * Gets the docker cmd exec factory.
	 *
	 * @return the docker cmd exec factory
	 */
	private DockerCmdExecFactory getDockerCmdExecFactory() {
		Preconditions.checkNotNull(dockerCmdExecFactory,
				"dockerCmdExecFactory was not specified");
		return dockerCmdExecFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.egnaro.automatter.liquid.docker.api.DockerClient#createContainerCmd
	 * (java.lang.String)
	 */
	@Override
	public CreateContainerCmd createContainerCmd(String image) {

		return new CreateContainerCmdImpl(getDockerCmdExecFactory()
				.createCreateContainerCmdExec(), image);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.egnaro.automatter.liquid.docker.api.DockerClient#attachContainerCmd
	 * (java.lang.String)
	 */
	@Override
	public AttachContainerCmd attachContainerCmd(String containerId) {
		return new AttachContainerCmdImpl(getDockerCmdExecFactory()
				.createAttachContainerCmdExec(), containerId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.egnaro.automatter.liquid.docker.api.DockerClient#killContainerCmd
	 * (java.lang.String)
	 */
	@Override
	public KillContainerCmd killContainerCmd(String containerId) {
		return new KillContainerCmdImpl(getDockerCmdExecFactory()
				.createKillContainerCmdExec(), containerId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.egnaro.automatter.liquid.docker.api.DockerClient#startContainerCmd
	 * (java.lang.String)
	 */
	@Override
	public StartContainerCmd startContainerCmd(String containerId) {
		return new StartContainerCmdImpl(getDockerCmdExecFactory()
				.createStartContainerCmdExec(), containerId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.egnaro.automatter.liquid.docker.api.DockerClient#stopContainerCmd
	 * (java.lang.String)
	 */
	@Override
	public StopContainerCmd stopContainerCmd(String containerId) {
		return new StopContainerCmdImpl(getDockerCmdExecFactory()
				.createStopContainerCmdExec(), containerId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.egnaro.automatter.liquid.docker.api.DockerClient#restartContainerCmd
	 * (java.lang.String)
	 */
	@Override
	public RestartContainerCmd restartContainerCmd(String containerId) {
		return new RestartContainerCmdImpl(getDockerCmdExecFactory()
				.createRestartContainerCmdExec(), containerId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.egnaro.automatter.liquid.docker.api.DockerClient#pauseContainerCmd
	 * (java.lang.String)
	 */
	@Override
	public PauseContainerCmd pauseContainerCmd(String containerId) {
		return new PauseContainerCmdImpl(getDockerCmdExecFactory()
				.createPauseContainerCmdExec(), containerId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.egnaro.automatter.liquid.docker.api.DockerClient#unpauseContainerCmd
	 * (java.lang.String)
	 */
	@Override
	public UnpauseContainerCmd unpauseContainerCmd(String containerId) {
		return new UnpauseContainerCmdImpl(getDockerCmdExecFactory()
				.createUnpauseContainerCmdExec(), containerId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.egnaro.automatter.liquid.docker.api.DockerClient#inspectContainerCmd
	 * (java.lang.String)
	 */
	@Override
	public InspectContainerCmd inspectContainerCmd(String containerId) {
		return new InspectContainerCmdImpl(getDockerCmdExecFactory()
				.createInspectContainerCmdExec(), containerId);
	}

	public RemoveContainerCmd removeContainerCmd(String containerId) {
		return new RemoveContainerCmdImpl(getDockerCmdExecFactory()
				.createRemoveContainerCmdExec(), containerId);
	}

	public WaitContainerCmd waitContainerCmd(String containerId) {
		return new WaitContainerCmdImpl(getDockerCmdExecFactory()
				.createWaitContainerCmdExec(), containerId);
	}

	@Override
	public VersionCmd versionCmd() {
		return new VersionCmdImpl(getDockerCmdExecFactory()
				.createVersionCmdExec());
	}

	public PingCmd pingCmd() {
		return new PingCmdImpl(getDockerCmdExecFactory().createPingCmdExec());
	}

	public ExecCreateCmd execCreateCmd(String containerId) {
		return new ExecCreateCmdImpl(getDockerCmdExecFactory()
				.createExecCreateCmdExec(), containerId);
	}

	@Override
	public TopContainerCmd topContainerCmd(String containerId) {
		// TODO Auto-generated method stub
		return new TopContainerCmdImpl(getDockerCmdExecFactory()
				.createTopContainerCmdExec(), containerId);
	}

	@Override
	public ListContainersCmd listContainersCmd() {
		// TODO Auto-generated method stub
		return new ListContainersCmdImpl(getDockerCmdExecFactory()
				.createListContainersCmdExec());
	}

	@Override
	public ContainerDiffCmd containerDiffCmd(String containerId) {
		// TODO Auto-generated method stub
		return new ContainerDiffCmdImpl(getDockerCmdExecFactory()
				.createContainerDiffCmdExec(), containerId);
	}

	@Override
	public CopyFileFromContainerCmd copyFileFromContainerCmd(
			String containerId, String resource) {
		// TODO Auto-generated method stub
		return new CopyFileFromContainerCmdImpl(getDockerCmdExecFactory()
				.createCopyFileFromContainerCmdExec(), containerId, resource);
	}

	public ListImagesCmd listImagesCmd() {
		// TODO Auto-generated method stub
		return new ListImagesCmdImpl(getDockerCmdExecFactory()
				.createListImagesCmdExec());
	}

	@Override
	public RemoveImageCmd removeImageCmd(String imageId) {
		// TODO Auto-generated method stub
		return new RemoveImageCmdImpl(getDockerCmdExecFactory()
				.createRemoveImageCmdExec(), imageId);
	}

	@Override
	public InfoCmd infoCmd() {
		// TODO Auto-generated method stub
		return new InfoCmdImpl(getDockerCmdExecFactory().createInfoCmdExec());
	}

	@Override
	public InspectImageCmd inspectImageCmd(String imageId) {
		// TODO Auto-generated method stub
		return new InspectImageCmdImpl(getDockerCmdExecFactory().createInspectImageCmdExec(),imageId);
	}

	@Override
	public LogContainerCmd logContainerCmd(String containerId) {
		// TODO Auto-generated method stub
		return new LogContainerCmdImpl(getDockerCmdExecFactory().createLogContainerCmdExec(),containerId);
	}

   

}
