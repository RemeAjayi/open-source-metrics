package com.reme.dto;

public class LeaderBoardMember {
    private Integer rank;
    private Integer previousRank;
    private String repo;
    private Long pullRequestCount;

    // Constructor
    public LeaderBoardMember(Integer rank, Integer previousRank, String repo, Long pullRequestCount) {
        this.rank = rank;
        this.previousRank = previousRank;
        this.repo = repo;
        this.pullRequestCount = pullRequestCount;
    }

    // Getters and Setters
    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getPreviousRank() {
        return previousRank;
    }

    public void setPreviousRank(Integer previousRank) {
        this.previousRank = previousRank;
    }

    public String getRepo() {
        return repo;
    }

    public void setRepo(String repo) {
        this.repo = repo;
    }

    public Long getPullRequestCount() {
        return pullRequestCount;
    }

    public void setPullRequestCount(Long pullRequestCount) {
        this.pullRequestCount = pullRequestCount;
    }
}