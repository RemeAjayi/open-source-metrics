package com.reme;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GithubAPIService {
    public GithubAPIService() {
    }

    public List<String> getLeaders() {
        return List.of("Alice", "Bob", "Charlie");
    }

    public List<String> getUsers() {
        return List.of("Alice", "Bob", "Charlie");
    }

    public  List<String> getLabels() {
        return List.of("bug", "feature", "enhancement");
    }

    public List<String> getLongestRunningPRs() {
        return List.of("PR1", "PR2", "PR3");
    }
}
