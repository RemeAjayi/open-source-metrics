package com.reme.entity;


import com.reme.model.Label;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "pull_request")
public class PullRequest {

    @Id
    private String id;

    private String title;
    private Label[] labelNames;
    private String userType;
    private String url;
    private String createdAt;
    private String updatedAt;
    private String closedAt;
    private String mergedAt;
    private String state;
    private String body;
    private String repo;

}

