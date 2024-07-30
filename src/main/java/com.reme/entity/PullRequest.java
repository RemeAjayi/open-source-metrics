package com.reme.entity;
import com.reme.model.Label;
import com.reme.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

}

