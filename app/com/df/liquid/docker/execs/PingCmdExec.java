package com.df.liquid.docker.execs;

import com.df.liquid.docker.api.command.PingCmd;
import com.df.logger.LoggerConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import play.Logger;
import play.libs.F;
import play.libs.WS;
import play.libs.F.Promise;

/**
 * The Class PingCmdExec.
 */
public class PingCmdExec extends AbstrDockerCmdExec<PingCmd, String> implements
		PingCmd.Exec {

	/**
	 * Instantiates a new ping cmd exec.
	 *
	 * @param requestHolder
	 *            the request holder
	 */
	public PingCmdExec(String requestHolder) {
		super(requestHolder);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * models.execs.AbstrDockerCmdExec#execute(models.api.command.DockerCmd) get
	 * request set parameter and return response
	 */
	@Override
	protected String execute(PingCmd command) {
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODENTRY);
		String requestHolder = getRequestHolder();
		Promise<WS.Response> response = WS.url(requestHolder + "/_ping").get()
				.map(new F.Function<WS.Response, WS.Response>() {
					public WS.Response apply(WS.Response response) {
						Logger.of(LoggerConstants.DOCKERLOGGER).debug(
								LoggerConstants.METHODEXIT);
						return response;
					}
				});
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);
		return String.valueOf(response.get(1000).getStatus());
	}

}
