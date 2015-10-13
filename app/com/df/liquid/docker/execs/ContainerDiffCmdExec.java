package com.df.liquid.docker.execs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import play.Logger;
import play.libs.F;
import play.libs.Json;
import play.libs.WS;
import play.libs.F.Promise;

import com.df.liquid.docker.api.command.ContainerDiffCmd;
import com.df.liquid.docker.api.model.ChangeLog;
import com.df.liquid.docker.api.model.Container;
import com.df.utils.LoggerConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The Class ContainerDiffCmdExec.
 */
public class ContainerDiffCmdExec extends
		AbstrDockerCmdExec<ContainerDiffCmd, List<ChangeLog>> implements
		ContainerDiffCmd.Exec {

	/**
	 * Instantiates a new container diff cmd exec.
	 *
	 * @param requestHolder
	 *            the request holder
	 */
	public ContainerDiffCmdExec(String requestHolder) {
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
	protected List<ChangeLog> execute(ContainerDiffCmd command) {
		Logger.of(LoggerConstants.DockerLogger).debug(
				LoggerConstants.methodEntry);
		String requestHolder = getRequestHolder();
		Promise<WS.Response> response = WS
				.url(requestHolder + "/containers/" + command.getContainerId()
						+ "/changes").get()
				.map(new F.Function<WS.Response, WS.Response>() {
					public WS.Response apply(WS.Response response) {
						Logger.of(LoggerConstants.DockerLogger).debug(
								LoggerConstants.methodExit);
						return response;
					}
				});
		List<ChangeLog> listChangeLog = new ArrayList<ChangeLog>();
		try {
			Logger.of(LoggerConstants.DockerLogger).debug(
					LoggerConstants.methodExit);

			JsonNode node = response.get().asJson();
			Iterator<JsonNode> iterator = node.iterator();
			while (iterator.hasNext()) {
				JsonNode nodeElement = iterator.next();
				ChangeLog obj = new ObjectMapper().treeToValue(nodeElement,
						ChangeLog.class);
				listChangeLog.add(obj);
			}
			return listChangeLog;
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
