package com.df.liquid.docker.execs;

import play.Logger;
import play.libs.F;
import play.libs.Json;
import play.libs.WS;
import play.libs.F.Promise;

import com.df.liquid.docker.api.command.VersionCmd;
import com.df.liquid.docker.api.model.Version;
import com.df.utils.LoggerConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The Class VersionCmdExec.
 */
public class VersionCmdExec extends AbstrDockerCmdExec<VersionCmd, Version>
		implements VersionCmd.Exec {

	/**
	 * Instantiates a new version cmd exec.
	 *
	 * @param requestHolder
	 *            the request holder
	 */
	public VersionCmdExec(String requestHolder) {
		super(requestHolder);
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
	protected Version execute(VersionCmd command) {
		Logger.of(LoggerConstants.DockerLogger).debug(
				LoggerConstants.methodEntry);
		String requestHolder = getRequestHolder();
		Promise<WS.Response> response = WS.url(requestHolder + "/version")
				.setContentType("application/json").get()
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
					Version.class);

		} catch (JsonProcessingException e) {
			Logger.of(LoggerConstants.DockerLogger).debug(
					LoggerConstants.methodExit);
			e.printStackTrace();
			return null;
		}

	}

}
