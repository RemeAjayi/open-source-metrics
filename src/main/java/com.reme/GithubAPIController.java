package com.reme;

import com.reme.entity.PullRequest;
import com.reme.mapper.PullRequestMapper;
import com.reme.model.PullRequestDTO;
import com.reme.repositories.PullRequestRepository;
import com.reme.utils.FileUtilsService;
import com.reme.utils.Utils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@RestController
public class GithubAPIController {
    private final String todayMidnight = Utils.getTodayMidnight();
    private final FileUtilsService fileUtilsService = new FileUtilsService();
    private final String[] repos = fileUtilsService.getRepos();
    private final PullRequestRepository pullRequestRepository;

    public GithubAPIController(PullRequestRepository pullRequestRepository) throws IOException {
        this.pullRequestRepository = pullRequestRepository;
    }


    public void SavePullRequests() {
        for (String repo : repos) {
            String url = "https://api.github.com/repos/apache/" + repo + "/pulls?since=" + todayMidnight;
            RestTemplate restTemplate = new RestTemplate();
            PullRequestDTO[] prs = restTemplate.getForObject(url, PullRequestDTO[].class);
            assert prs != null;
            for (PullRequestDTO pr : prs) {
                pr.setRepo(repo);
                pullRequestRepository.save(PullRequestMapper.toEntity(pr));
            }
        }
    }

    @GetMapping("/pull-requests")
    public ResponseEntity<String> getPullRequests() {
        SavePullRequests();
        return ResponseEntity.ok("Pull Requests saved to Kafka");
    }

    @GetMapping("hello")
    public String hello() {
        return "Hello World";
    }

}

