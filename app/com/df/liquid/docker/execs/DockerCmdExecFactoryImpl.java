package com.df.liquid.docker.execs;

import com.df.liquid.docker.api.DockerCmdExecFactory;
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
import com.df.liquid.docker.api.command.AuthCmd.Exec;
import com.df.liquid.docker.core.DockerClientConfig;
import com.google.common.base.Preconditions;

/**
 * The Class DockerCmdExecFactoryImpl implements the method of
 * DockerCmdExecFactory
 */
public class DockerCmdExecFactoryImpl implements DockerCmdExecFactory {

	/** The request holder. */
	private String requestHolder;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.egnaro.automatter.liquid.docker.api.DockerCmdExecFactory#init(com
	 * .egnaro.automatter.liquid.docker.core.DockerClientConfig)
	 */
	@Override
	public void init(DockerClientConfig dockerClientConfig) {

		Preconditions.checkNotNull(dockerClientConfig,
				"config was not specified");
		requestHolder = dockerClientConfig.getUri();

	}

	/**
	 * Gets the request holder.
	 *
	 * @return the request holder
	 */
	protected String getRequestHolder() {
		Preconditions.checkNotNull(requestHolder,
				"Factory not initialized. You probably forgot to call init()!");
		return requestHolder;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.egnaro.automatter.liquid.docker.api.DockerCmdExecFactory#
	 * createCreateContainerCmdExec()
	 */
	@Override
	public CreateContainerCmd.Exec createCreateContainerCmdExec() {
		return new CreateContainerCmdExec(getRequestHolder());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.egnaro.automatter.liquid.docker.api.DockerCmdExecFactory#
	 * createKillContainerCmdExec()
	 */
	@Override
	public KillContainerCmd.Exec createKillContainerCmdExec() {
		return new KillContainerCmdExec(requestHolder);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.egnaro.automatter.liquid.docker.api.DockerCmdExecFactory#
	 * createAttachContainerCmdExec()
	 */
	@Override
	public AttachContainerCmd.Exec createAttachContainerCmdExec() {
		return new AttachContainerCmdExec(getRequestHolder());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.egnaro.automatter.liquid.docker.api.DockerCmdExecFactory#
	 * createStartContainerCmdExec()
	 */
	@Override
	public StartContainerCmd.Exec createStartContainerCmdExec() {
		return new StartContainerCmdExec(getRequestHolder());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.egnaro.automatter.liquid.docker.api.DockerCmdExecFactory#
	 * createStopContainerCmdExec()
	 */
	@Override
	public StopContainerCmd.Exec createStopContainerCmdExec() {
		return new StopContainerCmdExec(getRequestHolder());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.egnaro.automatter.liquid.docker.api.DockerCmdExecFactory#
	 * createRestartContainerCmdExec()
	 */
	@Override
	public RestartContainerCmd.Exec createRestartContainerCmdExec() {

		return new RestartContainerCmdExec(getRequestHolder());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.egnaro.automatter.liquid.docker.api.DockerCmdExecFactory#
	 * createPauseContainerCmdExec()
	 */
	@Override
	public PauseContainerCmd.Exec createPauseContainerCmdExec() {

		return new PauseContainerCmdExec(getRequestHolder());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.egnaro.automatter.liquid.docker.api.DockerCmdExecFactory#
	 * createUnpauseContainerCmdExec()
	 */
	@Override
	public UnpauseContainerCmd.Exec createUnpauseContainerCmdExec() {

		return new UnpauseContainerCmdExec(getRequestHolder());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.egnaro.automatter.liquid.docker.api.DockerCmdExecFactory#
	 * createInspectContainerCmdExec()
	 */
	@Override
	public InspectContainerCmd.Exec createInspectContainerCmdExec() {
		return new InspectContainerCmdExec(getRequestHolder());
	}

	public RemoveContainerCmd.Exec createRemoveContainerCmdExec() {
		return new RemoveContainerCmdExec(getRequestHolder());
	}

	public WaitContainerCmd.Exec createWaitContainerCmdExec() {
		return new WaitContainerCmdExec(getRequestHolder());
	}

	public VersionCmd.Exec createVersionCmdExec() {
		return new VersionCmdExec(getRequestHolder());
	}

	public PingCmd.Exec createPingCmdExec() {
		return new PingCmdExec(getRequestHolder());
	}

	public ExecCreateCmd.Exec createExecCreateCmdExec() {
		return new ExecCreateCmdExec(getRequestHolder());
	}

	@Override
	public TopContainerCmd.Exec createTopContainerCmdExec() {
		// TODO Auto-generated method stub
		return new TopContainerCmdExec(getRequestHolder());
	}

	public ListContainersCmd.Exec createListContainersCmdExec() {
		return new ListContainersCmdExec(getRequestHolder());
	}

	@Override
	public ContainerDiffCmd.Exec createContainerDiffCmdExec() {
		// TODO Auto-generated method stub
		return new ContainerDiffCmdExec(getRequestHolder());
	}

	@Override
	public CopyFileFromContainerCmd.Exec createCopyFileFromContainerCmdExec() {
		// TODO Auto-generated method stub
		return new CopyFileFromContainerCmdExec(getRequestHolder());
	}

	@Override
	public ListImagesCmd.Exec createListImagesCmdExec() {
		// TODO Auto-generated method stub
		return new ListImagesCmdExec(getRequestHolder());
	}

	@Override
	public RemoveImageCmd.Exec createRemoveImageCmdExec() {
		// TODO Auto-generated method stub
		return new RemoveImageCmdExec(getRequestHolder());
	}

	@Override
	public InfoCmd.Exec createInfoCmdExec() {
		// TODO Auto-generated method stub
		return new InfoCmdExec(getRequestHolder());
	}

	@Override
	public InspectImageCmd.Exec createInspectImageCmdExec() {
		// TODO Auto-generated method stub
		return new InspectImageCmdExec(getRequestHolder());
	}

    public LogContainerCmd.Exec createLogContainerCmdExec(){
    	return new LogContainerCmdExec(getRequestHolder());
    }
}
