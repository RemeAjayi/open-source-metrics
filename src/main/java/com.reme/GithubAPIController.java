package com.reme;

import com.reme.model.PullRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class GithubAPIController {
    private final KafkaTemplate<String, PullRequest> kafkaTemplate;

    public GithubAPIController(KafkaTemplate<String, PullRequest> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/prs")
    public ResponseEntity<String> index() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.github.com/repos/apache/spark/pulls?since=2024-05-02T00:00:00Z";
//        TODO:Parameterize the since date
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
//        PullRequest pr = new PullRequest("1", "title", "label_name", "repo_name", "user_type", "created_at", "updated_at", "closed_at", "merged_at", "state", "body");
//        kafkaTemplate.send("open-source-pull-requests", pr);
    }
}

