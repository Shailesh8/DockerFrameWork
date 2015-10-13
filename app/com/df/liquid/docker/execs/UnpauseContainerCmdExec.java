package com.df.liquid.docker.execs;

import com.df.liquid.docker.api.command.UnpauseContainerCmd;
import com.df.utils.LoggerConstants;

import play.Logger;
import play.libs.F;
import play.libs.WS;
import play.libs.F.Promise;

/**
 * The Class UnpauseContainerCmdExec making a post request and processing the repsonse
 * at specified URL
 */
public class UnpauseContainerCmdExec extends AbstrDockerCmdExec<UnpauseContainerCmd, String> implements UnpauseContainerCmd.Exec{

	/**
	 * Instantiates a new unpause container cmd exec.
	 *
	 * @param requestHolder the request holder
	 */
	public UnpauseContainerCmdExec(String requestHolder) {
		super(requestHolder);
		
	}

	/* (non-Javadoc)
	 * @see com.egnaro.automatter.liquid.docker.execs.AbstrDockerCmdExec#execute(com.egnaro.automatter.liquid.docker.api.command.DockerCmd)
	 */
	@Override
	protected String execute(UnpauseContainerCmd command) {
		Logger.of(LoggerConstants.DockerLogger).debug(
				LoggerConstants.methodEntry);
		String requestHolder = getRequestHolder();
		Promise<WS.Response> response=WS.url(requestHolder + "/containers/"+command.getContainerId()+"/unpause")
				.setContentType("application/json")
				.post("")
				.map(new F.Function<WS.Response, WS.Response>() {
				  public WS.Response apply(WS.Response response){
					  Logger.of(LoggerConstants.DockerLogger).debug(
								LoggerConstants.methodExit);   
					  return response;
					  }
					});
		Logger.of(LoggerConstants.DockerLogger).debug(
				LoggerConstants.methodExit);
		return String.valueOf(response.get(1000).getStatus());
	}

}
