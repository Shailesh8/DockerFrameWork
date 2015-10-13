package com.df.liquid.docker.execs;



import java.io.InputStream;

import play.Logger;
import play.libs.F;
import play.libs.F.Promise;
import play.libs.WS;

import com.df.liquid.docker.api.command.LogContainerCmd;
import com.df.utils.LoggerConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * The Class LogContainerCmdExec.
 */
public class LogContainerCmdExec extends AbstrDockerCmdExec<LogContainerCmd, InputStream> implements LogContainerCmd.Exec {

	/**
	 * Instantiates a new log container cmd exec.
	 *
	 * @param requestHolder the request holder
	 */
	public LogContainerCmdExec(String requestHolder) {
		super(requestHolder);
		// TODO Auto-generated constructor stub
	}


	/* (non-Javadoc)
	 * @see models.execs.AbstrDockerCmdExec#execute(models.api.command.DockerCmd)
	 * Get request and set path and query parameter for given command and return response
	 */
	@Override
	protected InputStream execute(LogContainerCmd command) {
		Logger.of(LoggerConstants.DockerLogger).debug(LoggerConstants.methodEntry);
		String requestHolder = getRequestHolder();
		Promise<WS.Response> response = WS.url(requestHolder+"/containers/"+command.getContainerId()+"/logs")
		.setQueryParameter("timestamps", command.hasTimestampsEnabled() ? "1" : "0")
	    .setQueryParameter("stdout", command.hasStdoutEnabled() ? "1" : "0")
	    .setQueryParameter("stderr", command.hasStderrEnabled() ? "1" : "0")
	    .setQueryParameter("follow", command.hasFollowStreamEnabled() ? "1" : "0")
	    .setQueryParameter("tail", command.getTail() < 0 ? "all" : "" + command.getTail())
	    .get()
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
					InputStream.class);
		} catch (JsonProcessingException e) {
			Logger.of(LoggerConstants.DockerLogger).error("error in Json response");
			Logger.of(LoggerConstants.DockerLogger).debug(
					LoggerConstants.methodExit);	
			e.printStackTrace();
			return null;
		}
		
	}

}
