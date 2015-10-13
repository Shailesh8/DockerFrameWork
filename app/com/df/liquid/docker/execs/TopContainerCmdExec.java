package com.df.liquid.docker.execs;

import play.Logger;
import play.libs.F;
import play.libs.Json;
import play.libs.WS;
import play.libs.F.Promise;

import com.df.liquid.docker.api.command.TopContainerCmd;
import com.df.liquid.docker.api.command.TopContainerResponse;
import com.df.utils.LoggerConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TopContainerCmdExec extends
		AbstrDockerCmdExec<TopContainerCmd, TopContainerResponse> implements
		TopContainerCmd.Exec {

	public TopContainerCmdExec(String requestHolder) {
		super(requestHolder);
	}

	@Override
	protected TopContainerResponse execute(TopContainerCmd command) {
		Logger.of(LoggerConstants.DockerLogger).debug(
				LoggerConstants.methodEntry);
		String requestHolder = getRequestHolder();
		Promise<WS.Response> response = WS
				.url(requestHolder + "/containers/" + command.getContainerId()
						+ "/top").setContentType("application/json")
				// .setQueryParameter("ps_args", command.getPsArgs())
				.get().map(new F.Function<WS.Response, WS.Response>() {
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
					TopContainerResponse.class);
		} catch (JsonProcessingException e) {
			Logger.of(LoggerConstants.DockerLogger).error(
					"error in Json response");
			Logger.of(LoggerConstants.DockerLogger).debug(
					LoggerConstants.methodExit);
			e.printStackTrace();
			return null;
		}

	}

}
