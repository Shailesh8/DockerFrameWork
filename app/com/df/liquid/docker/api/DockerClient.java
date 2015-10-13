package com.df.liquid.docker.api;

import java.io.File;
import java.io.InputStream;

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
import com.df.liquid.docker.api.model.AuthConfig;

public interface DockerClient {

	public PingCmd pingCmd();

	public VersionCmd versionCmd();
    
	public InfoCmd infoCmd();
	/**
	 * * IMAGE API *
	 */

	public RemoveImageCmd removeImageCmd(String imageId);

	public ListImagesCmd listImagesCmd();

	/**
	 * * CONTAINER API *
	 */
	public ListContainersCmd listContainersCmd();

	public CreateContainerCmd createContainerCmd(String image);

	/**
	 * Creates a new {@link StartContainerCmd} for the container with the given
	 * ID. The command can then be further customized by using builder methods
	 * on it like {@link StartContainerCmd#withDns(String...)}.
	 * <p>
	 * <b>If you customize the command, any existing configuration of the target
	 * container will get reset to its default before applying the new
	 * configuration. To preserve the existing configuration, use an
	 * unconfigured {@link StartContainerCmd}.</b>
	 * <p>
	 * This command corresponds to the <code>/containers/{id}/start</code>
	 * endpoint of the Docker Remote API.
	 */
	public StartContainerCmd startContainerCmd(String containerId);

	public ExecCreateCmd execCreateCmd(String containerId);

	public RemoveContainerCmd removeContainerCmd(String containerId);

	public WaitContainerCmd waitContainerCmd(String containerId);

	public AttachContainerCmd attachContainerCmd(String containerId);

	public InspectContainerCmd inspectContainerCmd(String containerId);

	public StopContainerCmd stopContainerCmd(String containerId);

	public KillContainerCmd killContainerCmd(String containerId);

	public RestartContainerCmd restartContainerCmd(String containerId);

	public CopyFileFromContainerCmd copyFileFromContainerCmd(
			String containerId, String resource);

	public ContainerDiffCmd containerDiffCmd(String containerId);

	public PauseContainerCmd pauseContainerCmd(String containerId);

	public UnpauseContainerCmd unpauseContainerCmd(String containerId);

	public TopContainerCmd topContainerCmd(String containerId);
    
	public InspectImageCmd inspectImageCmd(String imageId);
	
	public LogContainerCmd logContainerCmd(String imageId);
    
       
}
