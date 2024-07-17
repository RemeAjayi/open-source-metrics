package com.reme;

import com.reme.model.PullRequest;
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
//    private final PullRequestRepository pullRequestRepository;

    public GithubAPIController() throws IOException {
//        this.pullRequestRepository = PullRequestRepository;
    }


    public void SavePullRequests() {
        for (String repo : repos) {
            String url = "https://api.github.com/repos/apache/" + repo + "/pulls?since=" + todayMidnight;
            RestTemplate restTemplate = new RestTemplate();
            PullRequest[] prs = restTemplate.getForObject(url, PullRequest[].class);
            assert prs != null;
            for (PullRequest pr : prs) {
            pr.setRepo(repo);
//            pullRequestRepository.save(pr);
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

