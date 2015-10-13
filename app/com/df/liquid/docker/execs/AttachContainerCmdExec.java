package com.df.liquid.docker.execs;

import java.io.InputStream;

import com.df.liquid.docker.api.command.AttachContainerCmd;
import com.df.logger.LoggerConstants;

import play.Logger;
import play.libs.F;
import play.libs.WS;
import play.libs.F.Promise;

/**
 * The Class AttachContainerCmdExec making a post request and processing the
 * repsonse at specified URL
 */

public class AttachContainerCmdExec extends
		AbstrDockerCmdExec<AttachContainerCmd, InputStream> implements
		AttachContainerCmd.Exec {

	/**
	 * Instantiates a new attach container cmd exec.
	 *
	 * @param requestHolder
	 *            the request holder
	 */
	public AttachContainerCmdExec(String requestHolder) {
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
	protected InputStream execute(AttachContainerCmd command) {
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODENTRY);
		String requestHolder = getRequestHolder();
		Promise<WS.Response> response = WS
				.url(requestHolder + "/containers/" + command.getContainerId()
						+ "/attach")
				.setContentType("APPLICATION/OCTET-STREAM")
				.setQueryParameter("logs", command.hasLogsEnabled() ? "1" : "0")
				.setQueryParameter("stdout",
						command.hasStdoutEnabled() ? "1" : "0")
				.setQueryParameter("stderr",
						command.hasStderrEnabled() ? "1" : "0")
				.setQueryParameter("stream",
						command.hasFollowStreamEnabled() ? "1" : "0").post("")
				.map(new F.Function<WS.Response, WS.Response>() {
					public WS.Response apply(WS.Response response) {
						return response;
					}
				});
		Logger.of(LoggerConstants.DOCKERLOGGER).info(
				LoggerConstants.ATTACHCONTAINERRESPONSE);
		Logger.of(LoggerConstants.DOCKERLOGGER).debug(
				LoggerConstants.METHODEXIT);

		return response.get().getBodyAsStream();

	}

}
