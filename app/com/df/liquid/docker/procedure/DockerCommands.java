package com.df.liquid.docker.procedure;

import java.io.InputStream;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
import play.Logger;
import play.libs.Json;
import play.mvc.Result;

import com.df.liquid.docker.api.DockerClient;
import com.df.liquid.docker.api.DockerConstants;
import com.df.liquid.docker.api.command.AttachContainerCmd;
import com.df.liquid.docker.api.command.ContainerDiffCmd;
import com.df.liquid.docker.api.command.CopyFileFromContainerCmd;
import com.df.liquid.docker.api.command.CreateContainerCmd;
import com.df.liquid.docker.api.command.CreateContainerResponse;
import com.df.liquid.docker.api.command.InfoCmd;
import com.df.liquid.docker.api.command.InspectContainerCmd;
import com.df.liquid.docker.api.command.InspectImageCmd;
import com.df.liquid.docker.api.command.KillContainerCmd;
import com.df.liquid.docker.api.command.ListContainersCmd;
import com.df.liquid.docker.api.command.ListImagesCmd;
import com.df.liquid.docker.api.command.PauseContainerCmd;
import com.df.liquid.docker.api.command.PingCmd;
import com.df.liquid.docker.api.command.RemoveContainerCmd;
import com.df.liquid.docker.api.command.RemoveImageCmd;
import com.df.liquid.docker.api.command.RestartContainerCmd;
import com.df.liquid.docker.api.command.StartContainerCmd;
import com.df.liquid.docker.api.command.StopContainerCmd;
import com.df.liquid.docker.api.command.TopContainerCmd;
import com.df.liquid.docker.api.command.TopContainerResponse;
import com.df.liquid.docker.api.command.UnpauseContainerCmd;
import com.df.liquid.docker.api.command.VersionCmd;
import com.df.liquid.docker.api.command.WaitContainerCmd;
import com.df.liquid.docker.api.model.ChangeLog;
import com.df.liquid.docker.api.model.Container;
import com.df.liquid.docker.api.model.Image;
import com.df.liquid.docker.api.model.Version;
import com.df.liquid.docker.core.DockerClientBuilder;
import com.df.liquid.docker.core.DockerClientConfig;
import com.df.logger.LoggerConstants;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;

public class DockerCommands {
	/** The cmd. */
	/** The Constant config. */
	static final DockerClientConfig config = DockerClientConfig
			.createDefaultConfigBuilder().build();

	/** The Constant dockerClient. */
	static final DockerClient dockerClient = DockerClientBuilder.getInstance(
			config).build();
   // String servererror="500";
 //	  String successfulStatus="200";
    
	String createResponse;
    JsonNode inspectResponse;
    String inspectImageResponse;  
    String infoCmdResponse;
    String dockerVersionResponse;
    String listImageResponse;
    String copyFileFromContainerResponse;
    String attachContainerResponse;
    String imageId;

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public String getAttachContainerResponse() {
		return attachContainerResponse;
	}

	public void setAttachContainerResponse(String attachContainerResponse) {
		this.attachContainerResponse = attachContainerResponse;
	}

	String listContainerResponse;
    String topContainerResponse;
    String containerDiffCmdResponse;
    
    
    public String getContainerDiffCmdResponse() {
		return containerDiffCmdResponse;
	}

	public void setContainerDiffCmdResponse(String containerDiffCmdResponse) {
		this.containerDiffCmdResponse = containerDiffCmdResponse;
	}

	public String getTopContainerResponse() {
		return topContainerResponse;
	}

	public void setTopContainerResponse(String topContainerResponse) {
		this.topContainerResponse = topContainerResponse;
	}

	public String getListContainerResponse() {
		return listContainerResponse;
	}

	public void setListContainerResponse(String listContainerResponse) {
		this.listContainerResponse = listContainerResponse;
	}

	public String getCreateResponse() {
		return createResponse;
	}

	public void setCreateResponse(String createResponse) {
		this.createResponse = createResponse;
	}

	public JsonNode getInspectResponse() {
		return inspectResponse;
	}

	public void setInspectResponse(JsonNode inspectResponse) {
		this.inspectResponse = inspectResponse;
	}
	
	public String getInspectImageResponse() {
		return inspectImageResponse;
	}

	public void setInspectImageResponse(String inspectImageResponse) {
		this.inspectImageResponse = inspectImageResponse;
	}
	
	public String getInfoCmdResponse() {
		return infoCmdResponse;
	}

	public void setInfoCmdResponse(String infoCmdResponse) {
		this.infoCmdResponse = infoCmdResponse;
	}
	
	public String getDockerVersionResponse() {
		return dockerVersionResponse;
	}

	public void setDockerVersionResponse(String dockerVersionResponse) {
		this.dockerVersionResponse = dockerVersionResponse;
	}
	public String geListImageResponse(){
		return  listImageResponse;
	}
	public void setListImageResponse(String listImageResponse) {
		this.listImageResponse = listImageResponse;
	}
	
	public String getCopyFileFromContainerResponse(){
		return  copyFileFromContainerResponse;
	}
	public void setCopyFileFromContainerResponse(String copyFileFromContainerResponse) {
		this.copyFileFromContainerResponse = copyFileFromContainerResponse;
	}
	
	
	
	
	/**
	 * method for get the list of container
	 */
	public String listContainer() {
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.LISTCONTAINER);
		ListContainersCmd listContainerCmd = dockerClient.listContainersCmd();
		List<Container> listContainer = listContainerCmd.exec();
		if(listContainer==null){
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.NULLOUTPUT);
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.METHODEXIT);
			return null;
		}
		String response = new Gson().toJson(listContainer);
		this.setListContainerResponse(response);
        	
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.LISTEDCONTAINER);
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);
		return LoggerConstants.SUCCESS;
	}

	/**
	 * method for create the container.
	 */
	public String createContainer(String dockerImage,String imageCommand) {
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.CREATECONTAINER);
		if(dockerImage==null || dockerImage.isEmpty() || imageCommand==null || imageCommand.isEmpty()){
			Logger.of(LoggerConstants.DOCKERLOGGER).error(
					LoggerConstants.INVALIDPARAMETER);
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.METHODEXIT);
               return null;		
		}
		CreateContainerCmd cmdContainer = dockerClient
				.createContainerCmd(dockerImage)
				.withCmd(imageCommand)
				.withEnv(DockerConstants.dockerEnv)
				.withHostName(RandomStringUtils.randomAlphanumeric(12));
		CreateContainerResponse response = cmdContainer.exec();
		if(response == null)
		{
			Logger.of(LoggerConstants.DOCKERLOGGER).error(
					LoggerConstants.INVALIDRESULT);
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.METHODEXIT);

			return null;
		}
		this.setCreateResponse(Json.toJson(response).findPath("Id").asText());
        Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.CREATEDCONTAINER);
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);
        
	return LoggerConstants.SUCCESS;
	}
  /* 
	public static String  getCreateContainerId(){
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.CREATECONTAINER);
		CreateContainerCmd cmdContainer = dockerClient
				.createContainerCmd(DockerConstants.dockerImage)
				.withCmd(DockerConstants.odeServerCommand)
				.withEnv(DockerConstants.dockerEnv)
				.withHostName(RandomStringUtils.randomAlphanumeric(12));
		CreateContainerResponse response = cmdContainer.exec();
		String containerId=response.getId();
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.CREATEDCONTAINER);
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);
        
		return containerId;
	}
	*/
	
	/**
	 * method for Inspect the container.
	 */
	public String inspectContainer(String containerId) {
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.INSPECTCONTAINER);
		if (containerId == null || containerId.isEmpty()) {
			Logger.of(LoggerConstants.DOCKERLOGGER).error(
					LoggerConstants.INVALIDPARAMETER);
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.METHODEXIT);
		     return null;
		}
		InspectContainerCmd inspectContainerCmd = dockerClient
				.inspectContainerCmd(containerId);
		JsonNode response = inspectContainerCmd.exec();
		if(response==null){
			Logger.of(LoggerConstants.DOCKERLOGGER).error(
					LoggerConstants.INVALIDRESULT);
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.METHODEXIT);
			return null;
		}
		this.setInspectResponse(response);
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);
	   return LoggerConstants.SUCCESS;
	}

	/**
	 * method for List of processes running inside a container
	 */
	public String topContainer(String containerId) {
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.TOPCONTAINER);
		if(containerId == null || containerId.isEmpty()) {
			Logger.of(LoggerConstants.DOCKERLOGGER).error(
					LoggerConstants.INVALIDPARAMETER);
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.METHODEXIT);
			return null;
		}
		TopContainerCmd topCmd = dockerClient.topContainerCmd(containerId);
		TopContainerResponse topResponse = topCmd.exec();
		if(topResponse==null){
			Logger.of(LoggerConstants.DOCKERLOGGER).error(
					LoggerConstants.INVALIDRESULT);
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.METHODEXIT);
			return null;
		}
		String response = new Gson().toJson(topResponse);
		this.setTopContainerResponse(response);
		Logger.of(LoggerConstants.DOCKERLOGGER).info(
				LoggerConstants.TOPPEDCONTAINER);
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);
             return LoggerConstants.SUCCESS;
	}

	/**
	 * method for Inspect changes on a container's filesystem
	 */
	public String containerDiffCmd(String containerId) {
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.CONTAINERDIFFCMD);
		if (containerId == null || containerId.isEmpty()) {
			Logger.of(LoggerConstants.DOCKERLOGGER).error(
					LoggerConstants.INVALIDPARAMETER);
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.METHODEXIT);
			return null;
		}
		ContainerDiffCmd containerDiffCmd = dockerClient
				.containerDiffCmd(containerId);
		List<ChangeLog> listChangeLog = containerDiffCmd.exec();
		if(listChangeLog==null){
			Logger.of(LoggerConstants.DOCKERLOGGER).error(
					LoggerConstants.INVALIDRESULT);
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.METHODEXIT);
			return null;
		}
		String response = new Gson().toJson(listChangeLog);
		this.setContainerDiffCmdResponse(response);
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);
		return LoggerConstants.SUCCESS;
	}

	/**
	 * method for start the container.
	 */
	public String startContainer(String containerId) {
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.STARTCONTAINER);
		if (containerId == null || containerId.isEmpty()) {
			Logger.of(LoggerConstants.DOCKERLOGGER).error(
					LoggerConstants.INVALIDPARAMETER);
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.METHODEXIT);
			return null;
		}
	    StartContainerCmd startContainerCmd = dockerClient
				.startContainerCmd(containerId);
		String status = startContainerCmd.exec();
		if(status==null){
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.NULLOUTPUT);
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.METHODEXIT);
			return null;
		}
		
		if(status.equals("200")||status.equals("204")||status.equals("304"))
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.STARTEDCONTAINER);
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);
		return status;
		
		}

	/**
	 * method for stop the container.
	 */
	public String stopContainer(String containerId) {
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.STOPCONTAINER);
		if (containerId == null || containerId.isEmpty()) {
			Logger.of(LoggerConstants.DOCKERLOGGER).error(
					LoggerConstants.INVALIDPARAMETER);
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.METHODEXIT);
			return null;
		}
		
		StopContainerCmd stopContainerCmd = dockerClient
				.stopContainerCmd(containerId);
		String status = stopContainerCmd.exec();
		if(status.equals("200")||status.equals("204")||status.equals("304"))
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.STOPPEDCONTAINER);
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);
		return status;
	
	}
	/**
	 * method for attach the container
	 */
	public String attachContainer(String containerId) {
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.ATTACHCONTAINER);
		if(containerId == null || containerId.isEmpty()) {
			Logger.of(LoggerConstants.DOCKERLOGGER).error(
					LoggerConstants.INVALIDPARAMETER);
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.METHODEXIT);
		  return null;
		}
		AttachContainerCmd attachContainerCmd = dockerClient
				.attachContainerCmd(containerId);
		InputStream listInputStream = attachContainerCmd.exec();
		if(listInputStream==null){
			Logger.of(LoggerConstants.DOCKERLOGGER).error(
					LoggerConstants.INVALIDPARAMETER);
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.METHODEXIT);
			return null;
		}
		String response = new Gson().toJson(listInputStream);
		this.setAttachContainerResponse(response);
		Logger.of(LoggerConstants.DOCKERLOGGER).info(
				LoggerConstants.ATTACHEDCONTAINER);
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);
		return LoggerConstants.SUCCESS;
	}

	/**
	 * method for pause the container
	 */
	public String pauseContainer(String containerId) {
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.PAUSECONTAINER);
		if (containerId == null || containerId.isEmpty()) {
			Logger.of(LoggerConstants.DOCKERLOGGER).error(
					LoggerConstants.INVALIDPARAMETER);
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.METHODEXIT);
		     return null;
		}
		
		PauseContainerCmd pauseContainerCmd = dockerClient
				.pauseContainerCmd(containerId);
		String status = pauseContainerCmd.exec();
		if(status.equals("200")||status.equals("204"))
		Logger.of(LoggerConstants.DOCKERLOGGER).info(
				LoggerConstants.PAUSEDCONTAINER);
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);   
		 return status;
		}
		

	/**
	 * first need to pause the container
	 * method for unpause the container
	 */
	public String unpauseContainer(String containerId) {
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.UNPAUSECONTAINER);
		if (containerId == null || containerId.isEmpty()) {
			Logger.of(LoggerConstants.DOCKERLOGGER).error(
					LoggerConstants.INVALIDPARAMETER);
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.METHODEXIT);
		    return null;
		}
		UnpauseContainerCmd unpauseContainerCmd = dockerClient
				.unpauseContainerCmd(containerId);
		String status = unpauseContainerCmd.exec();
		if(status.equals("200")||status.equals("204")||status.equals("304"))
		Logger.of(LoggerConstants.DOCKERLOGGER).info(
				LoggerConstants.UNPAUSEDCONTAINER);
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);
		return status;
		
	}

	/**
	 * first need to stop the container
	 * method for restart the container
	 */
	public String restartContainer(String containerId) {
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.RESTARTCONTAINER);
		if (containerId == null || containerId.isEmpty()) {
			Logger.of(LoggerConstants.DOCKERLOGGER).error(
					LoggerConstants.INVALIDPARAMETER);
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.METHODEXIT);
		     return null;
		}
		
		RestartContainerCmd restartContainerCmd = dockerClient
				.restartContainerCmd(containerId);
		String status = restartContainerCmd.exec();
		if(status.equals("200")||status.equals("204")||status.equals("304"))
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.RESTARTEDCONTAINER);
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);
		return status;
		
	}

	/**
	 * method for wait the container first stop the container then run
	 * waitContainer method
	 */

	public String waitContainer(String containerId) {
		
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.WAITCONTAINER);
		if (containerId == null || containerId.isEmpty()) {
			Logger.of(LoggerConstants.DOCKERLOGGER).error(
					LoggerConstants.INVALIDPARAMETER);
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.METHODEXIT);
		    return null;
		}
		WaitContainerCmd waitContainerCmd = dockerClient
				.waitContainerCmd(containerId);
		Integer status = waitContainerCmd.exec();
		if(String.valueOf(status).equals("200")||String.valueOf(status).equals("204"))
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.WAITEDCONTAINER);
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);
		return String.valueOf(status);

	}

	/**
	 * method for remove the container
	 */
	public String removeContainer(String containerId) {
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.REMOVECONTAINER);
		if (containerId == null || containerId.isEmpty()) {
			Logger.of(LoggerConstants.DOCKERLOGGER).error(
					LoggerConstants.INVALIDPARAMETER);
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.METHODEXIT);
		   return null;
		}
		RemoveContainerCmd removeContainerCmd = dockerClient
				.removeContainerCmd(containerId);
		String status = removeContainerCmd.exec();
		
		if(status.equals("200")||status.equals("204")||status.equals("304"))
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.REMOVEDCONTAINER);
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);
		return status;

	}

	/**
	 * method for Kill the container
	 */
	public String killContainer(String containerId) {
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.KILLCONTAINER);
		if (containerId == null || containerId.isEmpty()) {
			Logger.of(LoggerConstants.DOCKERLOGGER).error(
					LoggerConstants.INVALIDPARAMETER);
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.METHODEXIT);
		     return null;
		}
		KillContainerCmd killContainerCmd = dockerClient
				.killContainerCmd(containerId);
		String status = killContainerCmd.exec();
		if(status.equals("200")||status.equals("204"))
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.KILLEDCONTAINER);
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);
		return status;
	}

	/**
	 * method for copy file from container e.g resource argument is Data.txt
	 * file
	 */

	public String copyFileFromContainer(String containerId,
			String resource) {
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.COPYFILEFROMCONTAINER);
		if (containerId == null || containerId.isEmpty() || resource == null
				|| resource.isEmpty()) {
			Logger.of(LoggerConstants.DOCKERLOGGER).error(
					LoggerConstants.INVALIDPARAMETER);
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.METHODEXIT);
		    return null;
		}
		CopyFileFromContainerCmd copyFileFromContainerCmd = dockerClient
				.copyFileFromContainerCmd(containerId, resource);
		InputStream listInputStream = copyFileFromContainerCmd.exec();
		if(listInputStream==null){
			Logger.of(LoggerConstants.DOCKERLOGGER).error(
					LoggerConstants.NULLOUTPUT);
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.METHODEXIT);
			return null;
		}
		String response = new Gson().toJson(listInputStream);
        this.setCopyFileFromContainerResponse(response);
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.COPIEDFILEFROMCONTAINER);
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);
		return LoggerConstants.SUCCESS;
	}

	/**
	 * method for get the list of image
	 */
	public String listImage() {
		Logger.of(LoggerConstants.DOCKERLOGGER)
				.debug(LoggerConstants.LISTIMAGE);
		ListImagesCmd listImagesCmd = dockerClient.listImagesCmd();
		List<Image> listImage = listImagesCmd.exec();
		if(listImage==null){
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.NULLOUTPUT);
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.METHODEXIT);
			return null;
		}
		String response = new Gson().toJson(listImage);
		this.setListImageResponse(response);
		String response2=Json.toJson(listImage).findPath("Id").asText();
		this.setImageId(response2);
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.LISTEDIMAGE);
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);
		return LoggerConstants.SUCCESS;
	}

	/**
	 * method for remove the image e.g imageId of pavant/odetool
	 */

	public String removeImage(String imageId) {
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.REMOVEIMAGE);
		
		if (imageId == null || imageId.isEmpty()) {
			Logger.of(LoggerConstants.DOCKERLOGGER).error(
					LoggerConstants.INVALIDPARAMETER);
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.METHODEXIT);
			return null;
		}
		RemoveImageCmd removeImageCmd = dockerClient.removeImageCmd(imageId);
		String status = removeImageCmd.exec();
        if(status.equals("200")||status.equals("204"))
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(LoggerConstants.REMOVEDCONTAINER);
        	Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);
        return status;
	}

	/**
	 * method for get the version of docker
	 */
	public String dockerVersion() {
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.DOCKERVERSION);
		VersionCmd versionCmd = dockerClient.versionCmd();
		Version ver = versionCmd.exec();
		if(ver==null){
			Logger.of(LoggerConstants.DOCKERLOGGER).error(
					LoggerConstants.NULLOUTPUT);
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.METHODEXIT);
			return null;
		}
		String response = new Gson().toJson(ver);
		this.setDockerVersionResponse(response);
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);
		
		return LoggerConstants.SUCCESS;
	}

	/**
	 * method for ping the Docker server
	 */
	public String pingDockerServer() {
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.PINGDOCKERSERVER);
		PingCmd pingCmd = dockerClient.pingCmd();
		String status = pingCmd.exec();
		if(status==null){
			Logger.of(LoggerConstants.DOCKERLOGGER).error(
					LoggerConstants.NULLOUTPUT);
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.METHODEXIT);
			return null;	
		}
		if(status.equals("200")||status.equals("204"))
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.PINGEDDOCKERSERVER);
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);
		return status;
	}
	/**
	 * method for getting the system wide information
	 */
   public String infoCmd(){
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.INFOCOMMAND);
	   InfoCmd infocmd=dockerClient.infoCmd();
	   JsonNode response=infocmd.exec();
	   if(response==null){
		   Logger.of(LoggerConstants.DOCKERLOGGER).error(
					LoggerConstants.NULLOUTPUT);
		   Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.METHODEXIT);
		   return null;
	   }
	   String infoResponse= new Gson().toJson(response);
	   this.setInfoCmdResponse(infoResponse);  
	   Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);
	   return LoggerConstants.SUCCESS;
	   
   }
   
   public String inspectImage(String imageId){
	   Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.INSPECTIMAGE);
		if (imageId == null || imageId.isEmpty()) {
			Logger.of(LoggerConstants.DOCKERLOGGER).error(
					LoggerConstants.INVALIDPARAMETER);
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.METHODEXIT);
		   return null;
		}
	   InspectImageCmd inspectImageCmd=dockerClient.inspectImageCmd(imageId);
       JsonNode response=inspectImageCmd.exec();
       if(response==null){
    	   Logger.of(LoggerConstants.DOCKERLOGGER).error(
					LoggerConstants.NULLOUTPUT);
		   Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.METHODEXIT);
    	   return null;
       }
       String imResponse= new Gson().toJson(response);
       this.setInspectImageResponse(imResponse);
       Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.INSPECTEDIMAGE);
       Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);
       return LoggerConstants.SUCCESS;
   }




}
