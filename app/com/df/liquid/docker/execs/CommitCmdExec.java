package com.df.liquid.docker.execs;


import play.Logger;
import play.libs.F;
import play.libs.Json;
import play.libs.WS;
import play.libs.F.Promise;

import com.df.liquid.docker.api.command.CommitCmd;
import com.df.utils.LoggerConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The Class CommitCmdExec.
 */
public class CommitCmdExec extends AbstrDockerCmdExec<CommitCmd, String> implements CommitCmd.Exec {

	/**
	 * Instantiates a new commit cmd exec.
	 *
	 * @param requestHolder the request holder
	 */
	public CommitCmdExec(String requestHolder) {
		super(requestHolder);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see models.execs.AbstrDockerCmdExec#execute(models.api.command.DockerCmd)
	 * Get request and set path and query parameter for given command and return response
	 */
	@Override
	protected String execute(CommitCmd command) {
		Logger.of(LoggerConstants.DockerLogger).debug(LoggerConstants.methodEntry);
		String requestHolder = getRequestHolder();
		JsonNode postData = Json.toJson(command);
		Promise<WS.Response> response = WS.url(requestHolder+"/commit")
				    .setQueryParameter("container", command.getContainerId())
	                .setQueryParameter("repo", command.getRepository())
	                .setQueryParameter("tag", command.getTag())
	                .setQueryParameter("m", command.getMessage())
	                .setQueryParameter("author", command.getAuthor())
	                .setQueryParameter("pause",  command.hasPauseEnabled() ? "1" : "0")
	    .post(postData)
	    .map(new F.Function<WS.Response, WS.Response>() {
			public WS.Response apply(WS.Response response) {
			Logger.of(LoggerConstants.DockerLogger).debug(
						LoggerConstants.methodExit);
				return response;
			}
		});
	  // return response.get().toString();
	//	return String.valueOf(response.get(1000).getStatus());
	//return response.get().asJson().asText();
		try {
			Logger.of(LoggerConstants.DockerLogger).debug(
					LoggerConstants.methodExit);
			return new ObjectMapper().treeToValue(response.get().asJson(),
					String.class);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			Logger.of(LoggerConstants.DockerLogger).error("error in Json response");
			Logger.of(LoggerConstants.DockerLogger).debug(
					LoggerConstants.methodExit);
			e.printStackTrace();
		}
		Logger.of(LoggerConstants.DockerLogger).debug(
				LoggerConstants.methodExit); 
		return null;
	
	}

}
