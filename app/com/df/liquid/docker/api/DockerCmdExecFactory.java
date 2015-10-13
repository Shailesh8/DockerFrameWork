package com.df.liquid.docker.api;

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
import com.df.liquid.docker.core.DockerClientConfig;

public interface DockerCmdExecFactory {

	public void init(DockerClientConfig dockerClientConfig);

	public AttachContainerCmd.Exec createAttachContainerCmdExec();

	public ContainerDiffCmd.Exec createContainerDiffCmdExec();

	public CopyFileFromContainerCmd.Exec createCopyFileFromContainerCmdExec();

	public CreateContainerCmd.Exec createCreateContainerCmdExec();

	public InspectContainerCmd.Exec createInspectContainerCmdExec();

	public KillContainerCmd.Exec createKillContainerCmdExec();

	public ListContainersCmd.Exec createListContainersCmdExec();

	public ListImagesCmd.Exec createListImagesCmdExec();

	public PauseContainerCmd.Exec createPauseContainerCmdExec();

	public PingCmd.Exec createPingCmdExec();

	public RemoveContainerCmd.Exec createRemoveContainerCmdExec();

	public RemoveImageCmd.Exec createRemoveImageCmdExec();

	public RestartContainerCmd.Exec createRestartContainerCmdExec();

	public StartContainerCmd.Exec createStartContainerCmdExec();

	public StopContainerCmd.Exec createStopContainerCmdExec();

	public TopContainerCmd.Exec createTopContainerCmdExec();

	public UnpauseContainerCmd.Exec createUnpauseContainerCmdExec();

	public VersionCmd.Exec createVersionCmdExec();

	public WaitContainerCmd.Exec createWaitContainerCmdExec();

	public ExecCreateCmd.Exec createExecCreateCmdExec();
    
	public InfoCmd.Exec createInfoCmdExec(); 
    
	public InspectImageCmd.Exec createInspectImageCmdExec();
    public LogContainerCmd.Exec createLogContainerCmdExec();
}
