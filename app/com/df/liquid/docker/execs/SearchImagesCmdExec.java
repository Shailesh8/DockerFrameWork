package com.df.liquid.docker.execs;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.df.liquid.docker.api.command.SearchImagesCmd;
import com.df.liquid.docker.api.model.Container;
import com.df.liquid.docker.api.model.SearchItem;
import com.df.utils.LoggerConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import play.Logger;
import play.libs.F;
import play.libs.Json;
import play.libs.WS;
import play.libs.F.Promise;



/**
 * The Class SearchImagesCmdExec.
 */
public class SearchImagesCmdExec extends AbstrDockerCmdExec<SearchImagesCmd, List<SearchItem>> implements SearchImagesCmd.Exec {

	/**
	 * Instantiates a new search images cmd exec.
	 *
	 * @param requestHolder the request holder
	 */
	public SearchImagesCmdExec(String requestHolder) {
		super(requestHolder);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see models.execs.AbstrDockerCmdExec#execute(models.api.command.DockerCmd)
	 * Get request and set path and query parameter for given command and return response
	 */
	@Override
	protected List<SearchItem> execute(SearchImagesCmd command) {
		Logger.of(LoggerConstants.DockerLogger).debug(LoggerConstants.methodEntry);
		String requestHolder = getRequestHolder();
		JsonNode postData = Json.toJson(command);
		Promise<WS.Response> response = WS.url(requestHolder+"/images/search")
				.setQueryParameter("term", command.getTerm())
				.get()
			    .map(new F.Function<WS.Response, WS.Response>() {
				public WS.Response apply(WS.Response response) {
				Logger.of(LoggerConstants.DockerLogger).debug(
								LoggerConstants.methodExit);			
						return response;
					}
				});
		 List<SearchItem> listSearchItem=new ArrayList<SearchItem>();
		try {
			Logger.of(LoggerConstants.DockerLogger).debug(
					LoggerConstants.methodExit);
			JsonNode node = response.get().asJson();
			Iterator<JsonNode> iterator = node.iterator();
			while(iterator.hasNext()){
				JsonNode nodeElement = iterator.next();
			    SearchItem obj=new  ObjectMapper().treeToValue(nodeElement, SearchItem.class);
			    listSearchItem.add(obj);
			}
			return listSearchItem;
			//	return (List<SearchItem>) new ObjectMapper().treeToValue(response.get().asJson(),
			//		SearchItem.class);
		} catch (JsonProcessingException e) {
			Logger.of(LoggerConstants.DockerLogger).error("error in Json response");
			e.printStackTrace();
		}
		Logger.of(LoggerConstants.DockerLogger).debug(
				LoggerConstants.methodExit);
		return null;
	}

}
