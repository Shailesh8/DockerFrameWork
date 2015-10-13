package com.df.liquid.docker.execs;

import com.df.liquid.docker.api.command.CreateContainerCmd;
import com.df.liquid.docker.api.command.CreateContainerResponse;
import com.df.logger.LoggerConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import play.Logger;
import play.libs.F;
import play.libs.F.Promise;
import play.libs.Json;

import play.libs.WS;

/**
 * The Class CreateContainerCmdExec making a post request and processing the
 * repsonse at specified URL
 */
public class CreateContainerCmdExec extends
		AbstrDockerCmdExec<CreateContainerCmd, CreateContainerResponse>
		implements CreateContainerCmd.Exec {

	/**
	 * Instantiates a new creates the container cmd exec.
	 *
	 * @param requestHolder
	 *            the request holder
	 */
	public CreateContainerCmdExec(String requestHolder) {
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
	protected CreateContainerResponse execute(CreateContainerCmd command) {
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODENTRY);
		String requestHolder = getRequestHolder();
		JsonNode postData = Json.toJson(command);
		Promise<WS.Response> response = WS
				.url(requestHolder + "/containers/create")
				.setQueryParameter("name", command.getName())
				.setContentType("application/json").post(postData)
				.map(new F.Function<WS.Response, WS.Response>() {
					public WS.Response apply(WS.Response response) {
						return response;
					}
				});
		Logger.of(LoggerConstants.DOCKERLOGGER).info(
				LoggerConstants.CREATECONTAINERRESPONSE);
		try {
			Logger.of(LoggerConstants.DOCKERLOGGER).info(
					LoggerConstants.JSONMAPCREATECONTAINERRESPONSE);
			Logger.of(LoggerConstants.DOCKERLOGGER).debug(
					LoggerConstants.METHODEXIT);
			return new ObjectMapper().treeToValue(response.get().asJson(),
					CreateContainerResponse.class);

		} catch (JsonProcessingException e) {
			Logger.of(LoggerConstants.DOCKERLOGGER).error(
					LoggerConstants.NOCONTENTEXCEPTION);
			e.printStackTrace();
		}
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);
		return null;
	}

}
