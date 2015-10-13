package com.df.liquid.docker.core.command;



import play.Logger;

import com.df.liquid.docker.api.UnauthorizedException;
import com.df.liquid.docker.api.command.AuthCmd;
import com.df.liquid.docker.api.model.AuthConfig;
import com.df.liquid.docker.api.model.AuthResponse;
import com.df.utils.LoggerConstants;

/*
 * Authenticate with the server, useful for checking authentication.
 */
public class AuthCmdImpl extends AbstrAuthCfgDockerCmd<AuthCmd, AuthResponse> implements AuthCmd {

	public AuthCmdImpl(AuthCmd.Exec exec, AuthConfig authConfig) {
		super(exec);
		withAuthConfig(authConfig);
	}

	@Override
	public AuthResponse exec() throws UnauthorizedException {
		Logger.of(LoggerConstants.DockerLogger).debug(LoggerConstants.methodEntry);
		Logger.of(LoggerConstants.DockerLogger).debug(
				LoggerConstants.methodExit);
		return super.exec();
	}

	@Override
	public String toString() {
		return "authenticate using " + this.getAuthConfig();
	}
}