package com.reme.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties("ignoreUnknown = true")

public class Label {
    @JsonProperty("name")
    private String name;
}
