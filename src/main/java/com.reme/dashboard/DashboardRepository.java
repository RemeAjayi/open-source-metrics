package com.reme.dashboard;

import com.reme.dto.LeaderBoardMember;
import com.reme.entity.PullRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DashboardRepository extends JpaRepository<PullRequest, String> {

    @Query(value = "SELECT current_rank, previous_rank, repo, pull_request_count FROM repo_activity_view")
    List<LeaderBoardMember> getMostActiveRepos();
}
