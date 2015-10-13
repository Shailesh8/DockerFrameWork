package com.df.liquid.docker.execs;

import play.Logger;
import play.libs.F;
import play.libs.Json;
import play.libs.WS;
import play.libs.F.Promise;

import com.df.liquid.docker.api.command.WaitContainerCmd;
import com.df.utils.LoggerConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The Class WaitContainerCmdExec.
 */
public class WaitContainerCmdExec extends
		AbstrDockerCmdExec<WaitContainerCmd, Integer> implements
		WaitContainerCmd.Exec {

	/**
	 * Instantiates a new wait container cmd exec.
	 *
	 * @param requestHolder
	 *            the request holder
	 */
	public WaitContainerCmdExec(String requestHolder) {
		super(requestHolder);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * models.execs.AbstrDockerCmdExec#execute(models.api.command.DockerCmd) Get
	 * request and set path and query parameter for given command and return
	 * response
	 */
	@Override
	protected Integer execute(WaitContainerCmd command) {
		String requestHolder = getRequestHolder();
		Promise<WS.Response> response = WS
				.url(requestHolder + "/containers/" + command.getContainerId()
						+ "/wait").setContentType("application/json").post("")
				.map(new F.Function<WS.Response, WS.Response>() {
					public WS.Response apply(WS.Response response) {
						Logger.of(LoggerConstants.DockerLogger).debug(
								LoggerConstants.methodExit);
						return response;
					}
				});
		Logger.of(LoggerConstants.DockerLogger).debug(
				LoggerConstants.methodExit);
		return response.get().getStatus();
	}

}
