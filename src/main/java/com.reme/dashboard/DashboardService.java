package com.reme.dashboard;

import com.reme.dto.LeaderBoardMember;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {
    private final DashboardRepository dashboardRepository;

    public DashboardService(DashboardRepository dashboardRepository) {
        this.dashboardRepository = dashboardRepository;
    }

    public List<LeaderBoardMember> getMostActiveRepos() {
        return dashboardRepository.getMostActiveRepos();
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
