package com.df.liquid.docker.execs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import play.Logger;
import play.libs.F;
import play.libs.Json;
import play.libs.WS;
import play.libs.F.Promise;

import com.df.liquid.docker.api.command.ListImagesCmd;
import com.df.liquid.docker.api.model.Container;
import com.df.liquid.docker.api.model.Image;
import com.df.utils.LoggerConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

//one setQueryParameter skip
/**
 * The Class ListImagesCmdExec.
 */
public class ListImagesCmdExec extends
		AbstrDockerCmdExec<ListImagesCmd, List<Image>> implements
		ListImagesCmd.Exec {

	/**
	 * Instantiates a new list images cmd exec.
	 *
	 * @param requestHolder
	 *            the request holder
	 */
	public ListImagesCmdExec(String requestHolder) {
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
	protected List<Image> execute(ListImagesCmd command) {
		Logger.of(LoggerConstants.DockerLogger).debug(
				LoggerConstants.methodEntry);
		String requestHolder = getRequestHolder();

		Promise<WS.Response> response =

		WS.url(requestHolder + "/images/json")
				.setContentType("application/json")
				.setQueryParameter("all",
						command.hasShowAllEnabled() ? "1" : "0").get()
				.map(new F.Function<WS.Response, WS.Response>() {
					public WS.Response apply(WS.Response response) {
						Logger.of(LoggerConstants.DockerLogger).debug(
								LoggerConstants.methodExit);
						return response;
					}
				});
		List<Image> listImage = new ArrayList<Image>();
		try {
			Logger.of(LoggerConstants.DockerLogger).debug(
					LoggerConstants.methodExit);
			JsonNode node = response.get().asJson();
			Iterator<JsonNode> iterator = node.iterator();
			while (iterator.hasNext()) {
				JsonNode nodeElement = iterator.next();
				Image obj = new ObjectMapper().treeToValue(nodeElement,
						Image.class);
				listImage.add(obj);

			}
			return listImage;

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
