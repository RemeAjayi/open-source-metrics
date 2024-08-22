package com.reme;

import com.reme.mapper.PullRequestMapper;
import com.reme.model.PullRequestDTO;
import com.reme.repositories.PullRequestRepository;
import com.reme.utils.FileUtilsService;
import com.reme.utils.Utils;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@RestController
public class GithubAPIController {
    private final String todayMidnight = Utils.getTodayMidnight();
    private final FileUtilsService fileUtilsService = new FileUtilsService();
    private final String[] repos = fileUtilsService.getRepos();
    private final PullRequestRepository pullRequestRepository;
    private final GithubAPIService gService;

    public GithubAPIController(PullRequestRepository pullRequestRepository,
                               GithubAPIService gService) throws IOException {
        this.pullRequestRepository = pullRequestRepository;
        this.gService = gService;
    }

    @Scheduled(fixedRate=60*60*1000)
    public void SavePullRequests() {
        for (String repo : repos) {
            String GITHUB_API_URL = "https://api.github.com/repos/apache/" + repo + "/pulls?since=" + todayMidnight;
            RestTemplate restTemplate = new RestTemplate();

            String AUTH_TOKEN = System.getenv("GITHUB_AUTH_TOKEN");
            // Set up headers
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "token " + AUTH_TOKEN);
            headers.set("Accept", "application/vnd.github.v3+json"); // Optional, for GitHub API v3

            // Set up the request entity
            HttpEntity<String> entity = new HttpEntity<>(headers);

            // Make the API call
            ResponseEntity<PullRequestDTO[]> response = restTemplate.exchange(
                    GITHUB_API_URL,
                    HttpMethod.GET,
                    entity,
                    PullRequestDTO[].class,
                    repo,
                    todayMidnight
            );

            // Check the response status and headers
            if (response.getStatusCode() == HttpStatus.OK) {
                // You can get headers if needed
                HttpHeaders responseHeaders = response.getHeaders();
                int remainingRequests = Integer.parseInt(Objects.requireNonNull(responseHeaders.getFirst("X-RateLimit-Remaining")));
                System.out.println("Remaining requests: " + remainingRequests);

                if (remainingRequests == 0){
                    System.out.println("Rate limit exceeded");
                    break;
                }

                PullRequestDTO[] prs = response.getBody();
                assert prs != null;
                for (PullRequestDTO pr : prs) {
                    pr.setRepo(repo);
                    pullRequestRepository.save(PullRequestMapper.toEntity(pr));
                }
                System.out.println("Successfully retrieved pull requests for " + repo);

            }
            else if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
                System.out.println("No pull requests found for " + repo +"skipping");

            } else {
                // Handle the error response
                throw new RuntimeException("Failed to retrieve pull requests: " + response.getStatusCode());
            }

        }
    }

    @GetMapping("leaders")
    public List<String> getLeaders() {
        return gService.getLeaders();
    }

    @GetMapping("users")
    public List<String> getUsers() {
        return gService.getUsers();
    }

    @GetMapping("labels")
    public List<String> getLabels() {
        return gService.getLabels();
    }

    @GetMapping("longest-running-prs")
    public List<String> getLongestRunningPRs() {
        return gService.getLongestRunningPRs();
    }

    @GetMapping("hello")
    public String hello() {
        return "Hello World";
    }

}