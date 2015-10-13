package com.df.liquid.docker.execs;

import com.df.liquid.docker.api.command.RemoveImageCmd;
import com.df.utils.LoggerConstants;

import play.Logger;
import play.libs.F;
import play.libs.WS;
import play.libs.F.Promise;

/**
 * The Class RemoveImageCmdExec.
 */
public class RemoveImageCmdExec extends
		AbstrDockerCmdExec<RemoveImageCmd, String> implements
		RemoveImageCmd.Exec {

	/**
	 * Instantiates a new removes the image cmd exec.
	 *
	 * @param requestHolder
	 *            the request holder
	 */
	public RemoveImageCmdExec(String requestHolder) {
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
	protected String execute(RemoveImageCmd command) {
		Logger.of(LoggerConstants.DockerLogger).debug(
				LoggerConstants.methodEntry);
		String requestHolder = getRequestHolder();
		Promise<WS.Response> response = WS
				.url(requestHolder + "/images/" + command.getImageId())
				.setQueryParameter("force",
						command.hasForceEnabled() ? "1" : "0")
				.setQueryParameter("noprune",
						command.hasNoPruneEnabled() ? "1" : "0").delete()
				.map(new F.Function<WS.Response, WS.Response>() {
					public WS.Response apply(WS.Response response) {
						Logger.of(LoggerConstants.DockerLogger).debug(
								LoggerConstants.methodExit);
						return response;
					}
				});
		Logger.of(LoggerConstants.DockerLogger).debug(
				LoggerConstants.methodExit);
		return String.valueOf(response.get().getStatus());
	}

}
