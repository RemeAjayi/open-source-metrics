package com.reme;

import com.reme.model.PullRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@RestController
public class GithubAPIController {
    private final KafkaTemplate<String, PullRequest> kafkaTemplate;

    public GithubAPIController(KafkaTemplate<String, PullRequest> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/prs")
    public ResponseEntity<String> index() {
        LocalDateTime todayMidnight = LocalDateTime.of(today, midnight);
//        repo = FileReaderService.getRepo();
        String repo = "spark";

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.github.com/repos/apache/" + repo + "pulls?since=" + todayMidnight;
        return restTemplate.getForEntity(url, String.class);
    }

    @GetMapping("/publish")
    public void publish() {
// change to requestbody annotation
        String url = "https://api.github.com/repos/apache/spark/pulls?since=2024-05-02T00:00:00Z";
        RestTemplate restTemplate = new RestTemplate();
        PullRequest[] prs = restTemplate.getForObject(url, PullRequest[].class);
        assert prs != null;
        for (PullRequest pr : prs) {
            kafkaTemplate.send("open-source-pull-requests", pr);
        }
    }
}

