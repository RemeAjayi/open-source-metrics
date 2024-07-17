package com.reme.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties("ignoreUnknown = true")
public class PullRequest {

    @JsonProperty("id")
    String id;
    @JsonProperty("title")
    String title;
    @JsonProperty("labels")
    Label[] label_names;
    @JsonProperty("user")
    User user_type;
    @JsonProperty("url")
    String url;
    @JsonProperty("created_at")
    String created_at;
    @JsonProperty("updated_at")
    String updated_at;
    @JsonProperty("closed_at")
    String closed_at;
    @JsonProperty("merged_at")
    String merged_at;
    @JsonProperty("state")
    String state;
    @JsonProperty("body")
    String body;
    String repo;


    public void setRepo (String repo) {
        this.repo = repo;
    }

}


