package com.df.liquid.docker.execs;

import com.df.liquid.docker.api.command.InfoCmd;
import com.df.liquid.docker.api.model.Info;
import com.df.utils.LoggerConstants;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

import play.Logger;
import play.libs.F;
import play.libs.Json;
import play.libs.WS;
import play.libs.F.Promise;

/**
 * The Class InfoCmdExec.
 */
public class InfoCmdExec extends AbstrDockerCmdExec<InfoCmd, JsonNode> implements
		InfoCmd.Exec {

	/**
	 * Instantiates a new info cmd exec.
	 *
	 * @param requestHolder
	 *            the request holder
	 */
	public InfoCmdExec(String requestHolder) {
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
	protected JsonNode execute(InfoCmd command) {
		Logger.of(LoggerConstants.DockerLogger).debug(
				LoggerConstants.methodEntry);
		String requestHolder = getRequestHolder();
		Promise<WS.Response> response = WS.url(requestHolder + "/info").get()
				.map(new F.Function<WS.Response, WS.Response>() {
					public WS.Response apply(WS.Response response) {
						Logger.of(LoggerConstants.DockerLogger).debug(
								LoggerConstants.methodExit);
						return response;
					}
				});
		Logger.of(LoggerConstants.DockerLogger).debug(
				LoggerConstants.methodExit);
          return response.get().asJson();

	}

}
