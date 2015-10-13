package com.df.liquid.docker.core.command;

import java.io.IOException;
import org.apache.commons.codec.binary.Base64;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.df.liquid.docker.api.command.DockerCmd;
import com.df.liquid.docker.api.command.DockerCmdExec;
import com.df.liquid.docker.api.model.AuthConfig;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * The Class AbstrAuthCfgDockerCmd.
 *
 * @param <T> the generic type
 * @param <RES_T> the generic type
 */
public abstract class AbstrAuthCfgDockerCmd<T extends DockerCmd<RES_T>, RES_T> extends
AbstrDockerCmd<T, RES_T> {

/**
 * Instantiates a new abstr auth cfg docker cmd.
 *
 * @param execution the execution
 * @param authConfig the auth config
 */
public AbstrAuthCfgDockerCmd(DockerCmdExec<T, RES_T> execution, AuthConfig authConfig) {
super(execution);
withOptionalAuthConfig(authConfig);
}

/**
 * Instantiates a new abstr auth cfg docker cmd.
 *
 * @param execution the execution
 */
public AbstrAuthCfgDockerCmd(DockerCmdExec<T, RES_T> execution) {
super(execution);
}

/** The auth config. */
private AuthConfig authConfig;

/**
 * Gets the auth config.
 *
 * @return the auth config
 */
public AuthConfig getAuthConfig() {
return authConfig;
}

/**
 * With auth config.
 *
 * @param authConfig the auth config
 * @return the t
 */
public T withAuthConfig(AuthConfig authConfig) {
checkNotNull(authConfig, "authConfig was not specified");
return withOptionalAuthConfig(authConfig);
}

/**
 * With optional auth config.
 *
 * @param authConfig the auth config
 * @return the t
 */
@SuppressWarnings("unchecked")
private T withOptionalAuthConfig(AuthConfig authConfig) {
this.authConfig = authConfig;
return (T)this;
}

/**
 * Registry auth.
 *
 * @return the string
 */
protected String registryAuth() {
try {
	return Base64.encodeBase64String(new ObjectMapper().writeValueAsString(authConfig).getBytes());
} catch (IOException e) {
	throw new RuntimeException(e);
}
}

}

