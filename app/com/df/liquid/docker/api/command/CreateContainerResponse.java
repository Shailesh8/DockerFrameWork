package com.df.liquid.docker.api.command;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class CreateContainerResponse.
 */
public class CreateContainerResponse {
	
	/** The id. */
	@JsonProperty("Id")
    private String id;

    /** The warnings. */
    @JsonProperty("Warnings")
    private String[] warnings;

    /**
     * Gets the id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the warnings.
     *
     * @return the warnings
     */
    public String[] getWarnings() {
        return warnings;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Sets the warnings.
     *
     * @param warnings the new warnings
     */
    public void setWarnings(String[] warnings) {
        this.warnings = warnings;
    }

}
