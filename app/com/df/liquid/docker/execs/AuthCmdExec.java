package com.df.liquid.docker.execs;

import com.df.liquid.docker.api.UnauthorizedException;
import com.df.liquid.docker.api.command.AuthCmd;
import com.df.liquid.docker.api.model.AuthResponse;
import com.df.utils.LoggerConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import play.Logger;
import play.libs.F;
import play.libs.Json;
import play.libs.WS;
import play.libs.F.Promise;

/**
 * The Class AuthCmdExec.
 */

public class AuthCmdExec extends AbstrDockerCmdExec<AuthCmd,AuthResponse> implements AuthCmd.Exec {

	/**
	 * Instantiates a new auth cmd exec.
	 *
	 * @param requestHolder the request holder
	 */
	public AuthCmdExec(String requestHolder) {
		super(requestHolder);
		// TODO Auto-generated constructor stub
	}

/* (non-Javadoc)
 * @see models.execs.AbstrDockerCmdExec#execute(models.api.command.DockerCmd)
 * Get request and set path and query parameter for given command and return response
 */
@SuppressWarnings("deprecation")
@Override
protected AuthResponse execute(AuthCmd command){
	Logger.of(LoggerConstants.DockerLogger).debug(LoggerConstants.methodEntry);
	String requestHolder = getRequestHolder();	
	JsonNode postData = Json.toJson(command.getAuthConfig());
	Promise<JsonNode> response = WS.url(requestHolder+"/auth")
			.setContentType("application/json")
			.post(postData)
			.map(new F.Function<WS.Response, JsonNode>() {
		public JsonNode apply(WS.Response response) {
			Logger.of(LoggerConstants.DockerLogger).debug(
					LoggerConstants.methodExit);	
			JsonNode json=response.asJson();
			if(response.getStatus()==401)
			throw new UnauthorizedException("Unauthorized");
			return json;
		}
	});
	
	
	try {
		Logger.of(LoggerConstants.DockerLogger).debug(
				LoggerConstants.methodExit);
		return new ObjectMapper().treeToValue(response.get(),
				AuthResponse.class);
		
		
	} catch (JsonProcessingException e) {
		Logger.of(LoggerConstants.DockerLogger).error("error in Json response");
		e.printStackTrace();
	}
	Logger.of(LoggerConstants.DockerLogger).debug(
			LoggerConstants.methodExit);
	return null;
}

}
