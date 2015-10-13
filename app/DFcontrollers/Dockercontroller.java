package DFcontrollers;

import java.io.InputStream;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;

import play.Logger;
import play.libs.F;
import play.libs.F.Promise;
import play.libs.Json;
import play.libs.WS;
import play.libs.WS.WSRequestHolder;
import play.mvc.Controller;

import com.df.liquid.docker.api.DockerClient;
import com.df.liquid.docker.api.DockerConstants;
import com.df.liquid.docker.api.command.AttachContainerCmd;
import com.df.liquid.docker.api.command.AuthCmd;
import com.df.liquid.docker.api.command.CommitCmd;
import com.df.liquid.docker.api.command.ContainerDiffCmd;
import com.df.liquid.docker.api.command.CopyFileFromContainerCmd;
import com.df.liquid.docker.api.command.CreateContainerCmd;
import com.df.liquid.docker.api.command.CreateContainerResponse;
import com.df.liquid.docker.api.command.CreateImageCmd;
import com.df.liquid.docker.api.command.CreateImageResponse;
import com.df.liquid.docker.api.command.ExecCreateCmd;
import com.df.liquid.docker.api.command.ExecCreateCmdResponse;
import com.df.liquid.docker.api.command.InfoCmd;
import com.df.liquid.docker.api.command.InspectContainerCmd;
import com.df.liquid.docker.api.command.InspectContainerResponse;
import com.df.liquid.docker.api.command.InspectImageCmd;
import com.df.liquid.docker.api.command.InspectImageResponse;
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
import com.df.liquid.docker.api.command.TopContainerResponse;
import com.df.liquid.docker.api.command.UnpauseContainerCmd;
import com.df.liquid.docker.api.command.VersionCmd;
import com.df.liquid.docker.api.command.WaitContainerCmd;
import com.df.liquid.docker.api.model.AuthConfig;
import com.df.liquid.docker.api.model.AuthResponse;
import com.df.liquid.docker.api.model.ChangeLog;
import com.df.liquid.docker.api.model.Container;
import com.df.liquid.docker.api.model.Image;
import com.df.liquid.docker.api.model.Info;
import com.df.liquid.docker.api.model.SearchItem;
import com.df.liquid.docker.api.model.Version;
import com.df.liquid.docker.core.DockerClientAuthArg;
import com.df.liquid.docker.core.DockerClientBuilder;
import com.df.liquid.docker.core.DockerClientConfig;
import com.df.liquid.docker.execs.PushImageCmdExec.ResponseImpl;
import com.df.liquid.docker.procedure.DockerCommands;
import com.df.logger.LoggerConstants;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import com.spotify.docker.client.DefaultDockerClient;
import com.spotify.docker.client.DockerException;

import play.mvc.Result;

/**
 * The Class Dockercontroller class contain the methods of docker commands
 */
public class Dockercontroller extends Controller  {

	/** The cmd. */
	/** The Constant config. */
	static final DockerClientConfig config = DockerClientConfig
			.createDefaultConfigBuilder().build();

	/** The Constant dockerClient. */
	static final DockerClient dockerClient = DockerClientBuilder.getInstance(
			config).build();

	/**
	 * method for get the list of container
	 */
	public static Result listContainer() {
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.LISTCONTAINER);
		ListContainersCmd listContainerCmd = dockerClient.listContainersCmd();
		List<Container> listContainer = listContainerCmd.exec();
		String status = new Gson().toJson(listContainer);
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.LISTEDCONTAINER);
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);
		return ok(status);
	}

	/**
	 * method for create the container.
	 */
	public static Result createContainer() {
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.CREATECONTAINER);
		CreateContainerCmd cmdContainer = dockerClient
				.createContainerCmd(DockerConstants.dockerImage)
				.withCmd(DockerConstants.odeServerCommand)
				.withEnv(DockerConstants.dockerEnv)
				.withHostName(RandomStringUtils.randomAlphanumeric(12));
		CreateContainerResponse response = cmdContainer.exec();
		String status = new Gson().toJson(response);
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.CREATEDCONTAINER);
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);

		return ok(status);
	}

	/**
	 * method for Inspect the container.
	 */
	public static Result inspectContainer(String containerId) {
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.INSPECTCONTAINER);
		com.fasterxml.jackson.databind.node.ObjectNode result = Json
				.newObject();
		if (containerId == null || containerId.isEmpty()) {
			result.put("MESSAGE", LoggerConstants.INVALIDPARAMETER);
			Logger.of(LoggerConstants.DOCKERLOGGER).error(
					LoggerConstants.INVALIDPARAMETER);
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.METHODEXIT);
			return status(401, result);
		}
		InspectContainerCmd inspectContainerCmd = dockerClient
				.inspectContainerCmd(containerId);
		JsonNode status = inspectContainerCmd.exec();
	
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);
	//	return ok(status.findPath("Restarting").asText());
	     return ok(status);
	}

	/**
	 * method for List of processes running inside a container
	 */
	public static Result topContainer(String containerId) {
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.TOPCONTAINER);
		com.fasterxml.jackson.databind.node.ObjectNode result = Json
				.newObject();
		if (containerId == null || containerId.isEmpty()) {
			result.put("MESSAGE", LoggerConstants.INVALIDPARAMETER);
			Logger.of(LoggerConstants.DOCKERLOGGER).error(
					LoggerConstants.INVALIDPARAMETER);
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.METHODEXIT);
			return status(401, result);
		}
		TopContainerCmd topCmd = dockerClient.topContainerCmd(containerId);
		TopContainerResponse topResponse = topCmd.exec();
		String status = new Gson().toJson(topResponse);
		Logger.of(LoggerConstants.DOCKERLOGGER).info(
				LoggerConstants.TOPPEDCONTAINER);
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);

		return ok(status);
	}

	/**
	 * method for Inspect changes on a container's filesystem
	 */
	public static Result containerDiffCmd(String containerId) {
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.CONTAINERDIFFCMD);
		com.fasterxml.jackson.databind.node.ObjectNode result = Json
				.newObject();
		if (containerId == null || containerId.isEmpty()) {
			result.put("MESSAGE", LoggerConstants.INVALIDPARAMETER);
			Logger.of(LoggerConstants.DOCKERLOGGER).error(
					LoggerConstants.INVALIDPARAMETER);
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.METHODEXIT);
			return status(401, result);
		}
		ContainerDiffCmd containerDiffCmd = dockerClient
				.containerDiffCmd(containerId);
		List<ChangeLog> listChangeLog = containerDiffCmd.exec();
		String status = new Gson().toJson(listChangeLog);
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);
		return ok(status);
	}

	/**
	 * method for start the container.
	 */
	public static Result startContainer(String containerId) {
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.STARTCONTAINER);
		com.fasterxml.jackson.databind.node.ObjectNode result = Json
				.newObject();
		if (containerId == null || containerId.isEmpty()) {
			result.put("MESSAGE", LoggerConstants.INVALIDPARAMETER);
			Logger.of(LoggerConstants.DOCKERLOGGER).error(
					LoggerConstants.INVALIDPARAMETER);
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.METHODEXIT);
			return status(401, result);
		}
		StartContainerCmd startContainerCmd = dockerClient
				.startContainerCmd(containerId);
		String status = startContainerCmd.exec();
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.STARTEDCONTAINER);
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);
		return ok(status);
	}
     
	/**
	 * method for stop the container.
	 */
	public static Result stopContainer(String containerId) {
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.STOPCONTAINER);
		com.fasterxml.jackson.databind.node.ObjectNode result = Json
				.newObject();
		if (containerId == null || containerId.isEmpty()) {
			result.put("MESSAGE", LoggerConstants.INVALIDPARAMETER);
			Logger.of(LoggerConstants.DOCKERLOGGER).error(
					LoggerConstants.INVALIDPARAMETER);
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.METHODEXIT);
			return status(401, result);
		}
		StopContainerCmd stopContainerCmd = dockerClient
				.stopContainerCmd(containerId);
		String status = stopContainerCmd.exec();
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.STOPPEDCONTAINER);
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);
		return ok(status);
	}

	/**
	 * method for attach the container
	 */
	public static Result attachContainer(String containerId) {
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.ATTACHCONTAINER);
		com.fasterxml.jackson.databind.node.ObjectNode result = Json
				.newObject();
		if (containerId == null || containerId.isEmpty()) {
			result.put("MESSAGE", LoggerConstants.INVALIDPARAMETER);
			Logger.of(LoggerConstants.DOCKERLOGGER).error(
					LoggerConstants.INVALIDPARAMETER);
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.METHODEXIT);
			return status(401, result);
		}
		AttachContainerCmd attachContainerCmd = dockerClient
				.attachContainerCmd(containerId);
		InputStream listInputStream = attachContainerCmd.exec();
		String status = new Gson().toJson(listInputStream);
		Logger.of(LoggerConstants.DOCKERLOGGER).info(
				LoggerConstants.ATTACHEDCONTAINER);
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);
		return ok(status);
	}

	/**
	 * method for pause the container
	 */
	public static Result pauseContainer(String containerId) {
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.PAUSECONTAINER);
		com.fasterxml.jackson.databind.node.ObjectNode result = Json
				.newObject();
		if (containerId == null || containerId.isEmpty()) {
			result.put("MESSAGE", LoggerConstants.INVALIDPARAMETER);
			Logger.of(LoggerConstants.DOCKERLOGGER).error(
					LoggerConstants.INVALIDPARAMETER);
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.METHODEXIT);
			return status(401, result);
		}
		PauseContainerCmd pauseContainerCmd = dockerClient
				.pauseContainerCmd(containerId);
		String status = pauseContainerCmd.exec();
		Logger.of(LoggerConstants.DOCKERLOGGER).info(
				LoggerConstants.PAUSEDCONTAINER);
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);
		return ok(status);

	}

	/**
	 * method for unpause the container
	 */
	public static Result unpauseContainer(String containerId) {
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.UNPAUSECONTAINER);
		com.fasterxml.jackson.databind.node.ObjectNode result = Json
				.newObject();
		if (containerId == null || containerId.isEmpty()) {
			result.put("MESSAGE", LoggerConstants.INVALIDPARAMETER);
			Logger.of(LoggerConstants.DOCKERLOGGER).error(
					LoggerConstants.INVALIDPARAMETER);
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.METHODEXIT);
			return status(401, result);
		}
		UnpauseContainerCmd unpauseContainerCmd = dockerClient
				.unpauseContainerCmd(containerId);
		String status = unpauseContainerCmd.exec();
		Logger.of(LoggerConstants.DOCKERLOGGER).info(
				LoggerConstants.UNPAUSEDCONTAINER);
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);
		return ok(status);

	}

	/**
	 * method for restart the container
	 */
	public static Result restartContainer(String containerId) {
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.RESTARTCONTAINER);
		com.fasterxml.jackson.databind.node.ObjectNode result = Json
				.newObject();
		if (containerId == null || containerId.isEmpty()) {
			result.put("MESSAGE", LoggerConstants.INVALIDPARAMETER);
			Logger.of(LoggerConstants.DOCKERLOGGER).error(
					LoggerConstants.INVALIDPARAMETER);
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.METHODEXIT);
			return status(401, result);
		}
		RestartContainerCmd restartContainerCmd = dockerClient
				.restartContainerCmd(containerId);
		String status = restartContainerCmd.exec();
		Logger.of(LoggerConstants.DOCKERLOGGER).info(
				LoggerConstants.RESTARTEDCONTAINER);
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);
		return ok(status);

	}

	/**
	 * method for wait the container first stop the container then run
	 * waitContainer method
	 */

	public static Result waitContainer(String containerId) {
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.WAITCONTAINER);
		com.fasterxml.jackson.databind.node.ObjectNode result = Json
				.newObject();
		if (containerId == null || containerId.isEmpty()) {
			result.put("MESSAGE", LoggerConstants.INVALIDPARAMETER);
			Logger.of(LoggerConstants.DOCKERLOGGER).error(
					LoggerConstants.INVALIDPARAMETER);
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.METHODEXIT);
			return status(401, result);
		}
		WaitContainerCmd waitContainerCmd = dockerClient
				.waitContainerCmd(containerId);
		Integer status = waitContainerCmd.exec();
		Logger.of(LoggerConstants.DOCKERLOGGER).info(
				LoggerConstants.WAITEDCONTAINER);
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);
		return ok(String.valueOf(status));

	}

	/**
	 * method for remove the container
	 */
	public static Result removeContainer(String containerId) {
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.REMOVECONTAINER);
		com.fasterxml.jackson.databind.node.ObjectNode result = Json
				.newObject();
		if (containerId == null || containerId.isEmpty()) {
			result.put("MESSAGE", LoggerConstants.INVALIDPARAMETER);
			Logger.of(LoggerConstants.DOCKERLOGGER).error(
					LoggerConstants.INVALIDPARAMETER);
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.METHODEXIT);
			return status(401, result);
		}
		RemoveContainerCmd removeContainerCmd = dockerClient
				.removeContainerCmd(containerId);
		String status = removeContainerCmd.exec();
		Logger.of(LoggerConstants.DOCKERLOGGER).info(
				LoggerConstants.REMOVEDCONTAINER);
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);
		return ok(status);

	}

	/**
	 * method for Kill the container
	 */
	public static Result killContainer(String containerId) {
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.KILLCONTAINER);
		com.fasterxml.jackson.databind.node.ObjectNode result = Json
				.newObject();
		if (containerId == null || containerId.isEmpty()) {
			result.put("MESSAGE", LoggerConstants.INVALIDPARAMETER);
			Logger.of(LoggerConstants.DOCKERLOGGER).error(
					LoggerConstants.INVALIDPARAMETER);
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.METHODEXIT);
			return status(401, result);
		}
		KillContainerCmd killContainerCmd = dockerClient
				.killContainerCmd(containerId);
		String status = killContainerCmd.exec();
		Logger.of(LoggerConstants.DOCKERLOGGER).info(
				LoggerConstants.KILLEDCONTAINER);
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);
		return ok(status);
	}

	/**
	 * method for copy file from container e.g resource argument is Data.txt
	 * file
	 */

	public static Result copyFileFromContainer(String containerId,
			String resource) {
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.COPYFILEFROMCONTAINER);
		com.fasterxml.jackson.databind.node.ObjectNode result = Json
				.newObject();
		if (containerId == null || containerId.isEmpty() || resource == null
				|| resource.isEmpty()) {
			result.put("MESSAGE", LoggerConstants.INVALIDPARAMETER);
			Logger.of(LoggerConstants.DOCKERLOGGER).error(
					LoggerConstants.INVALIDPARAMETER);
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.METHODEXIT);
			return status(401, result);
		}
		CopyFileFromContainerCmd copyFileFromContainerCmd = dockerClient
				.copyFileFromContainerCmd(containerId, resource);
		InputStream listInputStream = copyFileFromContainerCmd.exec();
		String status = new Gson().toJson(listInputStream);
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);
		return ok(status);
	}

	/**
	 * method for get the list of image
	 */
	public static Result listImage() {
		Logger.of(LoggerConstants.DOCKERLOGGER)
				.debug(LoggerConstants.LISTIMAGE);
		ListImagesCmd listImagesCmd = dockerClient.listImagesCmd();
		List<Image> listImage = listImagesCmd.exec();
		String status = Json.toJson(listImage).findPath("Id").asText();
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.LISTEDIMAGE);
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);
		return ok(status);
	}

	/**
	 * method for remove the image e.g imageId of pavant/odetool
	 */

	public static Result removeImage(String imageId) {
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.REMOVEIMAGE);
		com.fasterxml.jackson.databind.node.ObjectNode result = Json
				.newObject();
		if (imageId == null || imageId.isEmpty()) {
			result.put("MESSAGE", LoggerConstants.INVALIDPARAMETER);
			Logger.of(LoggerConstants.DOCKERLOGGER).error(
					LoggerConstants.INVALIDPARAMETER);
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.METHODEXIT);
			return status(401, result);
		}
		RemoveImageCmd removeImageCmd = dockerClient.removeImageCmd(imageId);
		String status = removeImageCmd.exec();

		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.REMOVEDIMAGE);
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);

		return ok(status);
	}

	/**
	 * method for get the version of docker
	 */
	public static Result dockerVersion() {
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.DOCKERVERSION);
		VersionCmd versionCmd = dockerClient.versionCmd();
		Version ver = versionCmd.exec();
		String status = new Gson().toJson(ver);
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);
		return ok(status);
	}

	/**
	 * method for ping the Docker server
	 */
	public static Result pingDockerServer() {
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.PINGDOCKERSERVER);
		PingCmd pingCmd = dockerClient.pingCmd();
		String status = pingCmd.exec();
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);
		return ok(status);
	}
	/**
	 * method for getting the system wide information
	 */
   public static Result infoCmd(){
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.INFOCOMMAND);
	   InfoCmd infocmd=dockerClient.infoCmd();
	   JsonNode response=infocmd.exec();
	   String status= new Gson().toJson(response);
	   Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);
	   return ok(status);
	   
   }
   public static Result inspectImage(String imagename){
	   Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.INSPECTIMAGE);
		com.fasterxml.jackson.databind.node.ObjectNode result = Json
				.newObject();
		if (imagename == null || imagename.isEmpty()) {
			result.put("MESSAGE", LoggerConstants.INVALIDPARAMETER);
			Logger.of(LoggerConstants.DOCKERLOGGER).error(
					LoggerConstants.INVALIDPARAMETER);
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.METHODEXIT);
			return status(401, result);
		 		}
	   InspectImageCmd inspectImageCmd=dockerClient.inspectImageCmd(imagename);
       JsonNode response=inspectImageCmd.exec();
       if(response==null){
    	   return null;
       }
       String status= new Gson().toJson(response);
       Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.INSPECTEDIMAGE);
       Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);
       return ok(status);
   }
/*
   public static Result logContainer(String containerId){ 
	    LogContainerCmd logContainerCmd=dockerClient.
   
   }
*/
 public static Result listCont(){
	 DockerCommands dockerCommands=new DockerCommands();
     String result =dockerCommands.listContainer();
     return ok(dockerCommands.getListContainerResponse());
 }
public static Result inspCont(String containerId){
	DockerCommands dockerCommands=new DockerCommands();
	String result=dockerCommands.inspectContainer(containerId);
	return  ok(dockerCommands.getInspectResponse());
}
  
 public static Result cretCont(){ 
	 DockerCommands dockerCommands=new DockerCommands();
	 String result =dockerCommands.createContainer(DockerConstants.dockerImage, DockerConstants.odeServerCommand);
     return ok(dockerCommands.getCreateResponse());
 }

 public static Result topCont(String containerId){

	 DockerCommands dockerCommands=new DockerCommands();
	 String result =dockerCommands.topContainer(containerId);
      return ok(dockerCommands.getTopContainerResponse());
 }

public static Result pong(){
	DefaultDockerClient ddc=new DefaultDockerClient("http://localhost:2375/_ping");
	String str = null;
	try {
		str=ddc.ping();
	} catch (DockerException | InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return ok(str);
}


}
 