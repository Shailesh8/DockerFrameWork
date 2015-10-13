package com.df.liquid.docker.core.command;

import com.df.liquid.docker.api.command.InfoCmd;
import com.df.liquid.docker.api.model.Info;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * Return Docker server info
 */
public class InfoCmdImpl extends AbstrDockerCmd<InfoCmd, JsonNode> implements InfoCmd  {

	public InfoCmdImpl(InfoCmd.Exec exec) {
		super(exec);
	}
	
	@Override
    public String toString() {
        return "info";
    }
}