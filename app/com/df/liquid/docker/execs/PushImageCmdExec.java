package com.df.liquid.docker.execs;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import play.Logger;
import play.libs.F;
import play.libs.Json;
import play.libs.WS;
import play.libs.F.Promise;

import com.df.liquid.docker.api.command.PushImageCmd;
import com.df.liquid.docker.api.command.PushImageCmd.Response;
import com.df.liquid.docker.api.model.AuthConfig;
import com.df.liquid.docker.api.model.PushEventStreamItem;
import com.df.utils.LoggerConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.google.common.collect.ImmutableList;





// TODO: Auto-generated Javadoc
/**
 * The Class PushImageCmdExec.
 */
public class PushImageCmdExec extends AbstrDockerCmdExec<PushImageCmd, Response> implements PushImageCmd.Exec {

	/**
	 * Instantiates a new push image cmd exec.
	 *
	 * @param requestHolder the request holder
	 */
	public PushImageCmdExec(String requestHolder) {
		super(requestHolder);
		// TODO Auto-generated constructor stub
	}
	
	/* (non-Javadoc)
	 * @see models.execs.AbstrDockerCmdExec#execute(models.api.command.DockerCmd)
	 * Get request and set path and query parameter for given command and return response
	 */
	@Override
	protected ResponseImpl execute(PushImageCmd command) {
		Logger.of(LoggerConstants.DockerLogger).debug(LoggerConstants.methodEntry);
		String requestHolder = getRequestHolder();
		JsonNode postData = Json.toJson(command);
		
	//	final String registryAuth = registryAuth(command.getAuthConfig());

		Promise<WS.Response> response = WS.url(requestHolder+"/images/"+ name(command) + "/push" )
				.setQueryParameter("tag",command.getTag() )
				.post(postData)
				.map(new F.Function<WS.Response, WS.Response>() {
					public WS.Response apply(WS.Response response) {
						Logger.of(LoggerConstants.DockerLogger).debug(
								LoggerConstants.methodExit);
						return response;
					}
				});
		ObjectMapper mapper =new ObjectMapper();
		try {
			Logger.of(LoggerConstants.DockerLogger).debug(
					LoggerConstants.methodExit);
		//	return new ObjectMapper().treeToValue(response.get().asJson(),
			//		Response.class);
		InputStream resp=mapper.treeToValue(response.get().asJson(), InputStream.class);

		  return new ResponseImpl(resp);
		} catch (JsonProcessingException e) {
			Logger.of(LoggerConstants.DockerLogger).error("error in Json response");
			e.printStackTrace();
		}
		Logger.of(LoggerConstants.DockerLogger).debug(
				LoggerConstants.methodExit); 
		return null;
		
	}
		
		
		/**
		 * Name.
		 *
		 * @param command the command
		 * @return the string
		 */
		
	private String name(PushImageCmd command) {
			Logger.of(LoggerConstants.DockerLogger).debug(LoggerConstants.methodEntry);
			String name = command.getName();
			AuthConfig authConfig = command.getAuthConfig();
			Logger.of(LoggerConstants.DockerLogger).debug(
					LoggerConstants.methodExit);
			return name.contains("/") ? name : "shailesh123";
		}
		  
  		/**
  		 * The Class ResponseImpl.
  		 */
  		public static class ResponseImpl extends Response {
			    
    			/** The proxy. */
    			private final InputStream proxy;

			    /**
    			 * Instantiates a new response impl.
    			 *
    			 * @param proxy the proxy
    			 */
    			ResponseImpl(InputStream proxy) {
			      this.proxy = proxy;
			    }

			    /* (non-Javadoc)
    			 * @see models.api.command.PushImageCmd.Response#getItems()
    			 */
    			@Override
			    public Iterable<PushEventStreamItem> getItems() throws IOException {
			    	Logger.of(LoggerConstants.DockerLogger).debug(LoggerConstants.methodEntry);
			    	ObjectMapper mapper = new ObjectMapper();
			      // we'll be reading instances of MyBean
			      ObjectReader reader = mapper.reader(PushEventStreamItem.class);
			      // and then do other configuration, if any, and read:
			      Iterator<PushEventStreamItem> items = reader.readValues(proxy);

			        try {
			            return ImmutableList.copyOf(items);
			        } finally {
			            proxy.close();
			        }
			    }

			    /* (non-Javadoc)
    			 * @see java.io.InputStream#read()
    			 */
    			@Override
			    public int read() throws IOException {
			    	Logger.of(LoggerConstants.DockerLogger).debug(LoggerConstants.methodEntry);
			    	Logger.of(LoggerConstants.DockerLogger).debug(
							LoggerConstants.methodExit);
			    	return proxy.read();
			    }
			  }
	
	
	}
