package com.df.liquid.docker.api.command;


import com.fasterxml.jackson.databind.JsonNode;

public interface InfoCmd extends DockerCmd<JsonNode> {

	public static interface Exec extends DockerCmdExec<InfoCmd, JsonNode> {
	}

}