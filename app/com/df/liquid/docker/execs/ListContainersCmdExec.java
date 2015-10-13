package com.df.liquid.docker.execs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.core.GenericType;

import play.Logger;
import play.libs.F;
import play.libs.Json;
import play.libs.WS;
import play.libs.F.Promise;

import com.df.liquid.docker.api.command.ListContainersCmd;
import com.df.liquid.docker.api.model.Container;
import com.df.utils.LoggerConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The Class ListContainersCmdExec.
 */

public class ListContainersCmdExec extends
		AbstrDockerCmdExec<ListContainersCmd, List<Container>> implements
		ListContainersCmd.Exec {

	/**
	 * Instantiates a new list containers cmd exec.
	 *
	 * @param requestHolder
	 *            the request holder
	 */
	public ListContainersCmdExec(String requestHolder) {
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
	public class ListWrap {
		public List<Container> list;
	}

	@Override
	protected List<Container> execute(ListContainersCmd command) {
		Logger.of(LoggerConstants.DockerLogger).debug(
				LoggerConstants.methodEntry);
		String requestHolder = getRequestHolder();
		Promise<WS.Response> response = WS
				.url(requestHolder + "/containers/json?all="
						+ command.hasShowAllEnabled() + "&before="
						+ command.getBeforeId() + "&size="
						+ command.hasShowSizeEnabled()).get()
				.map(new F.Function<WS.Response, WS.Response>() {
					public WS.Response apply(WS.Response response) {
						Logger.of(LoggerConstants.DockerLogger).debug(
								LoggerConstants.methodExit);
						return response;
					}
				});

		List<Container> listContainer = new ArrayList<Container>();

		try {

			Logger.of(LoggerConstants.DockerLogger).debug(
					LoggerConstants.methodExit);

			JsonNode node = response.get().asJson();
			Iterator<JsonNode> iterator = node.iterator();
			while (iterator.hasNext()) {
				JsonNode nodeElement = iterator.next();
				Container obj = new ObjectMapper().treeToValue(nodeElement,
						Container.class);
				listContainer.add(obj);

			}
			return listContainer;

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
