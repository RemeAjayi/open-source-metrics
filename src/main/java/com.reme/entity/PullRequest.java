package com.reme.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PullRequest {

    @Id
    private Long id;

    private String title;
    private String[] labelNames;
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

