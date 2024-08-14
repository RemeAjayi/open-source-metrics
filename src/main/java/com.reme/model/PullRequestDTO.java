package com.reme.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.ArrayList;


@JsonIgnoreProperties("ignoreUnknown = true")
public class PullRequestDTO {

    @JsonProperty("id")
    String id;
    @JsonProperty("title")
    String title;
    @JsonProperty("labels")
    List<Label> label_names;
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

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Label> getLabel_names() {
        return label_names;
    }

    public List<String> getLabelNamesAsString() {
        List<String> labelNames = new ArrayList<>();
        for (Label label : label_names) {
            labelNames.add(label.getName());
        }
        return labelNames;
    }

    public void setLabel_names(List<Label> label_names) {
        this.label_names = label_names;
    }

    public User getUser_type() {
        return user_type;
    }

    public void setUser_type(User user_type) {
        this.user_type = user_type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getClosed_at() {
        return closed_at;
    }

    public void setClosed_at(String closed_at) {
        this.closed_at = closed_at;
    }

    public String getMerged_at() {
        return merged_at;
    }

    public void setMerged_at(String merged_at) {
        this.merged_at = merged_at;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getRepo() {
        return repo;
    }

    public void setRepo(String repo) {
        this.repo = repo;
    }

    public String toString() {
        return "PullRequestDTO{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", label_names=" + label_names +
                ", user_type=" + user_type +
                ", url='" + url + '\'' +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", closed_at='" + closed_at + '\'' +
                ", merged_at='" + merged_at + '\'' +
                ", state='" + state + '\'' +
                ", body='" + body + '\'' +
                ", repo='" + repo + '\'' +
                '}';
    }
}