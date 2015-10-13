package com.df.liquid.docker.execs;

import com.df.liquid.docker.api.command.RestartContainerCmd;
import com.df.logger.LoggerConstants;

import play.Logger;
import play.libs.F;
import play.libs.F.Promise;
import play.libs.WS;

/**
 * The Class RestartContainerCmdExec making a post request and processing the
 * repsonse at specified URL
 */
public class RestartContainerCmdExec extends
		AbstrDockerCmdExec<RestartContainerCmd, String> implements
		RestartContainerCmd.Exec {

	/**
	 * Instantiates a new restart container cmd exec.
	 *
	 * @param requestHolder
	 *            the request holder
	 */
	public RestartContainerCmdExec(String requestHolder) {
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
	protected String execute(RestartContainerCmd command) {
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODENTRY);
		String requestHolder = getRequestHolder();
		Promise<WS.Response> response = WS
				.url(requestHolder + "/containers/" + command.getContainerId()
						+ "/restart").setContentType("application/json")
				.setQueryParameter("t", String.valueOf(command.getTimeout()))
				.post("").map(new F.Function<WS.Response, WS.Response>() {
					public WS.Response apply(WS.Response response) {
						return response;
					}
				});
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);
		return String.valueOf(response.get(1000).getStatus());

	}

}
