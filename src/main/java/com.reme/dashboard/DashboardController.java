package com.reme.dashboard;

import com.reme.dto.LeaderBoardMember;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class DashboardController {
    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("leaders")
    public List<LeaderBoardMember> getLeaders() {
        return dashboardService.getMostActiveRepos();
    }

    @GetMapping("users")
    public List<String> getUsers() {
        return dashboardService.getUsers();
    }

    @GetMapping("labels")
    public List<String> getLabels() {
        return dashboardService.getLabels();
    }

    @GetMapping("longest-running-prs")
    public List<String> getLongestRunningPRs() {
        return dashboardService.getLongestRunningPRs();
    }
}
