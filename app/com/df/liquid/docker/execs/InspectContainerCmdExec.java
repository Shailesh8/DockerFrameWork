package com.df.liquid.docker.execs;

import play.Logger;
import play.libs.F;
import play.libs.F.Promise;
import play.libs.WS;

import com.df.liquid.docker.api.command.InspectContainerCmd;
import com.df.liquid.docker.api.command.InspectContainerResponse;
import com.df.logger.LoggerConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The Class InspectContainerCmdExec making a get request and processing the
 * repsonse at specified URL
 */
public class InspectContainerCmdExec extends
		AbstrDockerCmdExec<InspectContainerCmd, JsonNode> implements
		InspectContainerCmd.Exec {

	/**
	 * Instantiates a new inspect container cmd exec.
	 *
	 * @param requestHolder
	 *            the request holder
	 */
	public InspectContainerCmdExec(String requestHolder) {
		super(requestHolder);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.egnaro.automatter.liquid.docker.execs.AbstrDockerCmdExec#execute(
	 * com.egnaro.automatter.liquid.docker.api.command.DockerCmd)
	 */
	@SuppressWarnings("deprecation")
	@Override
	protected JsonNode execute(InspectContainerCmd command) {
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODENTRY);
		String requestHolder = getRequestHolder();
		Promise<WS.Response> response = WS
				.url(requestHolder + "/containers/" + command.getContainerId()
						+ "/json").setContentType("application/json").get()
				.map(new F.Function<WS.Response, WS.Response>() {
					public WS.Response apply(WS.Response response) {
						return response;
					}
				});
		Logger.of(LoggerConstants.DOCKERLOGGER).info(
				LoggerConstants.INSPECTCONTAINERRESPONSE);
		JsonNode res = response.get().asJson();
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);
		return res;

	}

}
