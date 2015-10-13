package com.df.liquid.docker.execs;

import com.df.liquid.docker.api.command.PauseContainerCmd;
import com.df.logger.LoggerConstants;

import play.Logger;
import play.libs.F;
import play.libs.WS;
import play.libs.F.Promise;

/**
 * The Class PauseContainerCmdExec making a post request and processing the
 * repsonse at specified URL
 */
public class PauseContainerCmdExec extends
		AbstrDockerCmdExec<PauseContainerCmd, String> implements
		PauseContainerCmd.Exec {

	/**
	 * Instantiates a new pause container cmd exec.
	 *
	 * @param requestHolder
	 *            the request holder
	 */
	public PauseContainerCmdExec(String requestHolder) {
		super(requestHolder);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.egnaro.automatter.liquid.docker.execs.AbstrDockerCmdExec#execute(
	 * com.egnaro.automatter.liquid.docker.api.command.DockerCmd)
	 */
	@Override
	protected String execute(PauseContainerCmd command) {
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODENTRY);
		String requestHolder = getRequestHolder();
		Promise<WS.Response> response = WS
				.url(requestHolder + "/containers/" + command.getContainerId()
						+ "/pause").setContentType("application/json").post("")
				.map(new F.Function<WS.Response, WS.Response>() {
					public WS.Response apply(WS.Response response) {
						return response;
					}
				});
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);  
		return String.valueOf(response.get(1000).getStatus());

	}

}
