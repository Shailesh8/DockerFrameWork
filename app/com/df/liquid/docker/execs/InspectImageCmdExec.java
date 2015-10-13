package com.df.liquid.docker.execs;

import com.df.liquid.docker.api.command.InspectImageCmd;
import com.df.liquid.docker.api.command.InspectImageResponse;
import com.df.utils.LoggerConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import play.Logger;
import play.libs.F;
import play.libs.WS;
import play.libs.F.Promise;

public class InspectImageCmdExec extends AbstrDockerCmdExec<InspectImageCmd, JsonNode> implements InspectImageCmd.Exec {

	/**
	 * Instantiates a new inspect image cmd exec.
	 *
	 * @param requestHolder the request holder
	 */
	public InspectImageCmdExec(String requestHolder) {
		super(requestHolder);
		// TODO Auto-generated constructor stub
	}
    /*
     * (non-Javadoc)
     * @see models.execs.AbstrDockerCmdExec#execute(models.api.command.DockerCmd)
     * Get request and set path and query parameter for given command and return response
     */
	@Override
	protected JsonNode execute(InspectImageCmd command) {
		Logger.of(LoggerConstants.DockerLogger).debug(LoggerConstants.methodEntry);
		String requestHolder = getRequestHolder();
		Promise<WS.Response> response = WS
				.url(requestHolder + "/images/"+command.getImageId()+"/json")
				.setContentType("APPLICATION/JSON")
				.get()
				.map(new F.Function<WS.Response, WS.Response>() {
					public WS.Response apply(WS.Response response) {
						Logger.of(LoggerConstants.DockerLogger).debug(
								LoggerConstants.methodExit);	
						return response;
					}
				});
	/*	try {
			Logger.of(LoggerConstants.DockerLogger).debug(
					LoggerConstants.methodExit);	
			return new ObjectMapper().treeToValue(response.get().asJson(),
					InspectImageResponse.class);
			
			
		} catch (JsonProcessingException e) {
			Logger.of(LoggerConstants.DockerLogger).error("error in Json response");
			e.printStackTrace();
		}
		Logger.of(LoggerConstants.DockerLogger).debug(
				LoggerConstants.methodExit);	
		return null;
	*/
	return response.get().asJson();
	}
}
