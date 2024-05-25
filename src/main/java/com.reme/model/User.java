package com.reme.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties("ignoreUnknown = true")
public class User {
    @JsonProperty("type")
    private String type;
}
