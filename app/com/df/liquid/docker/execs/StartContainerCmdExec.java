package com.df.liquid.docker.execs;

import com.df.liquid.docker.api.command.StartContainerCmd;
import com.df.logger.LoggerConstants;
import com.fasterxml.jackson.databind.JsonNode;

import play.Logger;
import play.libs.F;
import play.libs.F.Promise;
import play.libs.Json;
import play.libs.WS;

/**
 * The Class StartContainerCmdExec making a post request and processing the
 * repsonse at specified URL
 */
public class StartContainerCmdExec extends
		AbstrDockerCmdExec<StartContainerCmd, String> implements
		StartContainerCmd.Exec {

	/**
	 * Instantiates a new start container cmd exec.
	 *
	 * @param requestHolder
	 *            the request holder
	 */
	public StartContainerCmdExec(String requestHolder) {
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
	protected String execute(StartContainerCmd command) {
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODENTRY);
		String requestHolder = getRequestHolder();
		JsonNode postData = Json.toJson(command);
		Promise<WS.Response> response = WS
				.url(requestHolder + "/containers/" + command.getContainerId()
						+ "/start").setContentType("application/json")
				.post(postData).map(new F.Function<WS.Response, WS.Response>() {
					public WS.Response apply(WS.Response response) {
						return response;
					}
				});
		Logger.of(LoggerConstants.DOCKERLOGGER).info(
				LoggerConstants.STARTCONTAINERRESPONSE);
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);
		return String.valueOf(response.get().getStatus());
	}

}
