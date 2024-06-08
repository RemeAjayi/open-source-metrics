package com.reme;

import com.reme.model.PullRequest;
import com.reme.utils.FileUtilsService;
import com.reme.utils.Utils;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@RestController
public class GithubAPIController {
    private final KafkaTemplate<String, PullRequest> kafkaTemplate;
    private final String todayMidnight = Utils.getTodayMidnight();
    private final FileUtilsService fileUtilsService = new FileUtilsService();
    private final String[] repos = fileUtilsService.getRepos();

    public GithubAPIController(KafkaTemplate<String, PullRequest> kafkaTemplate) throws IOException {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/prs")
    public ResponseEntity<String> index() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.github.com/repos/apache/spark/pulls?since=" + todayMidnight;
        return restTemplate.getForEntity(url, String.class);
    }

//    time this
    @GetMapping("/publish")
    public void publish() {
        for (String repo : repos) {
            String url = "https://api.github.com/repos/apache/" + repo + "/pulls?since=" + todayMidnight;
            RestTemplate restTemplate = new RestTemplate();
            PullRequest[] prs = restTemplate.getForObject(url, PullRequest[].class);
            assert prs != null;
            for (PullRequest pr : prs) {
            pr.setRepo(repo);
            kafkaTemplate.send("open-source-pull-requests", pr);
            }
        }
    }

//    time this
    @GetMapping("/publish-async/")
    public void publishAsync() {
    }
}

