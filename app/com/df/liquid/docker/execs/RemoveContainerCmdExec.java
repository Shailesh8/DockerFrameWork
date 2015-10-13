package com.df.liquid.docker.execs;

import play.Logger;
import play.libs.F;
import play.libs.Json;
import play.libs.WS;
import play.libs.F.Promise;

import com.df.liquid.docker.api.command.RemoveContainerCmd;
import com.df.utils.LoggerConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The Class RemoveContainerCmdExec.
 */
public class RemoveContainerCmdExec extends
		AbstrDockerCmdExec<RemoveContainerCmd, String> implements
		RemoveContainerCmd.Exec {

	/**
	 * Instantiates a new removes the container cmd exec.
	 *
	 * @param requestHolder
	 *            the request holder
	 */
	public RemoveContainerCmdExec(String requestHolder) {
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
	protected String execute(RemoveContainerCmd command) {
		Logger.of(LoggerConstants.DockerLogger).debug(
				LoggerConstants.methodEntry);
		String requestHolder = getRequestHolder();

		Promise<WS.Response> response = WS
				.url(requestHolder + "/containers/" + command.getContainerId())
				.setContentType("application/json")
				.setQueryParameter("v",
						command.hasRemoveVolumesEnabled() ? "1" : "0")
				.setQueryParameter("force",
						command.hasForceEnabled() ? "1" : "0").delete()
				.map(new F.Function<WS.Response, WS.Response>() {
					public WS.Response apply(WS.Response response) {
						Logger.of(LoggerConstants.DockerLogger).debug(
								LoggerConstants.methodExit);
						return response;
					}
				});

		Logger.of(LoggerConstants.DockerLogger).debug(
				LoggerConstants.methodExit);
		return String.valueOf(response.get().getStatus());
	}

}
