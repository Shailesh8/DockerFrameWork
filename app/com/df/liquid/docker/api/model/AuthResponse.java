package com.df.liquid.docker.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthResponse {
    @JsonProperty("Status")
    private String status;

    public String getStatus() {
        return status;
    }
}