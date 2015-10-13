package com.df.liquid.docker.api.model;



import java.io.Serializable;

import com.df.liquid.docker.api.DockerConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;



/**
 * Represents an item returned from push
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class PushEventStreamItem implements Serializable {

	private static final long serialVersionUID = DockerConstants.dockerSerialVersionUID2;

	@JsonProperty("status")
    private String status;

    @JsonProperty("progress")
    private String progress;

    @JsonProperty("progressDetail")
    private ProgressDetail progressDetail;


    public String getStatus() {
        return status;
    }

    public String getProgress() {
        return progress;
    }

    public ProgressDetail getProgressDetail() {
        return progressDetail;
    }

    @JsonIgnoreProperties(ignoreUnknown=true)
    public static class ProgressDetail implements Serializable {
        @JsonProperty("current")
        int current;


        @Override
        public String toString() {
            return "current " + current;
        }
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("status", status)
                .add("progress", progress)
                .add("progressDetail", progressDetail)
                .toString();
    }
}