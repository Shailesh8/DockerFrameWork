package com.df.liquid.docker.execs;

import java.io.InputStream;
import play.Logger;
import play.libs.F;
import play.libs.Json;
import play.libs.WS;
import play.libs.F.Promise;

import com.df.liquid.docker.api.command.CopyFileFromContainerCmd;
import com.df.utils.LoggerConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The Class CopyFileFromContainerCmdExec.
 */
public class CopyFileFromContainerCmdExec extends
		AbstrDockerCmdExec<CopyFileFromContainerCmd, InputStream> implements
		CopyFileFromContainerCmd.Exec {

	/**
	 * Instantiates a new copy file from container cmd exec.
	 *
	 * @param requestHolder
	 *            the request holder
	 */
	public CopyFileFromContainerCmdExec(String requestHolder) {
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
	protected InputStream execute(CopyFileFromContainerCmd command) {
		Logger.of(LoggerConstants.DockerLogger).debug(
				LoggerConstants.methodEntry);
		String requestHolder = getRequestHolder();
		JsonNode postData = Json.toJson(command);
		Promise<WS.Response> response = WS
				.url(requestHolder + "/containers/" + command.getContainerId()
						+ "/copy").setContentType("APPLICATION/JSON")
				.post(postData).map(new F.Function<WS.Response, WS.Response>() {
					public WS.Response apply(WS.Response response) {

						Logger.of(LoggerConstants.DockerLogger).debug(
								LoggerConstants.methodExit);
						return response;
					}
				});

		Logger.of(LoggerConstants.DockerLogger).debug(
				LoggerConstants.methodExit);
		return response.get().getBodyAsStream();
	}

}
