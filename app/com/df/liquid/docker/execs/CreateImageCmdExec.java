package com.df.liquid.docker.execs;



import play.Logger;
import play.libs.F;
import play.libs.Json;
import play.libs.WS;
import play.libs.F.Promise;

import com.df.liquid.docker.api.command.CreateImageCmd;
import com.df.liquid.docker.api.command.CreateImageResponse;
import com.df.utils.LoggerConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;



// TODO: Auto-generated Javadoc
/**
 * The Class CreateImageCmdExec.
 */
public class CreateImageCmdExec extends AbstrDockerCmdExec<CreateImageCmd, CreateImageResponse> implements CreateImageCmd.Exec {

	/**
	 * Instantiates a new creates the image cmd exec.
	 *
	 * @param requestHolder the request holder
	 */
	public CreateImageCmdExec(String requestHolder) {
		super(requestHolder);
		// TODO Auto-generated constructor stub
	}


	/* (non-Javadoc)
	 * @see models.execs.AbstrDockerCmdExec#execute(models.api.command.DockerCmd)
     * Get request and set path and query parameter for given command and return response
	 */
	@Override
	protected CreateImageResponse execute(CreateImageCmd command) {
		Logger.of(LoggerConstants.DockerLogger).debug(LoggerConstants.methodEntry);
		String requestHolder = getRequestHolder();
		JsonNode postData = Json.toJson(command);
		Promise<WS.Response> response = WS.url(requestHolder+"/images/create").setQueryParameter("repo", command.getRepository())
	    .setQueryParameter("tag", command.getTag())
	    .setQueryParameter("fromSrc","-")
	    .post(postData)
	    .map(new F.Function<WS.Response, WS.Response>() {
			public WS.Response apply(WS.Response response) {
			Logger.of(LoggerConstants.DockerLogger).debug(
						LoggerConstants.methodExit);	
				return response;
			}
		});
		try {
			Logger.of(LoggerConstants.DockerLogger).debug(
					LoggerConstants.methodExit);
			return new ObjectMapper().treeToValue(response.get().asJson(),
					CreateImageResponse.class);
		} catch (JsonProcessingException e) {
			Logger.of(LoggerConstants.DockerLogger).error("error in Json response");
			e.printStackTrace();
		}
		Logger.of(LoggerConstants.DockerLogger).debug(
				LoggerConstants.methodExit); 
		return null;
	}

}
