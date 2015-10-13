package com.df.liquid.docker.execs;

import play.Logger;
import play.libs.F;
import play.libs.Json;
import play.libs.WS;
import play.libs.F.Promise;

import com.df.liquid.docker.api.command.ExecCreateCmd;
import com.df.liquid.docker.api.command.ExecCreateCmdResponse;
import com.df.utils.LoggerConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * The Class ExecCreateCmdExec.
 */
public class ExecCreateCmdExec extends AbstrDockerCmdExec<ExecCreateCmd, ExecCreateCmdResponse> implements ExecCreateCmd.Exec {
	/**
	 * Instantiates a new exec create cmd exec.
	 *
	 * @param requestHolder the request holder
	 */
	public ExecCreateCmdExec(String requestHolder) {
		super(requestHolder);
		// TODO Auto-generated constructor stub
	}


    /* (non-Javadoc)
     * @see models.execs.AbstrDockerCmdExec#execute(models.api.command.DockerCmd)
     */
    @Override
    protected ExecCreateCmdResponse execute(ExecCreateCmd command) {
    	Logger.of(LoggerConstants.DockerLogger).debug(LoggerConstants.methodEntry);
    	String requestHolder = getRequestHolder();
		JsonNode postData = Json.toJson(command);
		Promise<WS.Response> response = WS.url(requestHolder+"/containers/"+command.getContainerId() +"/exec")
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
					ExecCreateCmdResponse.class);
		} catch (JsonProcessingException e) {
			Logger.of(LoggerConstants.DockerLogger).error("error in Json response");
			e.printStackTrace();
		}
		Logger.of(LoggerConstants.DockerLogger).debug(
				LoggerConstants.methodExit);	 
		return null;
    }
}
