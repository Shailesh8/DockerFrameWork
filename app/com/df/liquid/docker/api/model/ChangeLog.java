package com.df.liquid.docker.api.model;



import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChangeLog {

    @JsonProperty("Path")
    private String path;

    @JsonProperty("Kind")
    private int kind;

    public String getPath() {
        return path;
    }

    public int getKind() {
        return kind;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
