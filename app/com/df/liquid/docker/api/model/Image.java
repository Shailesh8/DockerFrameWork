package com.df.liquid.docker.api.model;



import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;



@JsonIgnoreProperties(ignoreUnknown = true)
public class Image {

	@JsonProperty("Created")
	private long created;

	@JsonProperty("Id")
    private String id;

	@JsonProperty("ParentId")
	private String parentId;

	@JsonProperty("RepoTags")
    private String[] repoTags;

    @JsonProperty("Size")
    private long size;

    @JsonProperty("VirtualSize")
    private long virtualSize;

    public String getId() {
        return id;
    }

    public String[] getRepoTags() {
        return repoTags;
    }

    public String getParentId() {
        return parentId;
    }

    public long getCreated() {
        return created;
    }

    public long getSize() {
        return size;
    }

    public long getVirtualSize() {
        return virtualSize;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}

