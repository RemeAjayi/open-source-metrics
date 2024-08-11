package com.reme.entity;
import com.reme.model.Label;
import com.reme.model.User;
import jakarta.persistence.*;


import java.util.List;

@Entity
@Table(name = "pull_request")
public class PullRequest {

    @Id
    private String id;

    private String title;

    @ElementCollection
    @Embedded
    private List<Label> labelNames;

    @Embedded
    private User userType;
    private String url;
    private String createdAt;
    private String updatedAt;
    private String closedAt;
    private String mergedAt;
    private String state;
    private String body;
    private String repo;

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

    public List<Label> getLabelNames() {
        return labelNames;
    }

    public void setLabelNames(List<Label> labelNames) {
        this.labelNames = labelNames;
    }

    public User getUserType() {
        return userType;
    }

    public void setUserType(User userType) {
        this.userType = userType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(String closedAt) {
        this.closedAt = closedAt;
    }

    public String getMergedAt() {
        return mergedAt;
    }

    public void setMergedAt(String mergedAt) {
        this.mergedAt = mergedAt;
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
}