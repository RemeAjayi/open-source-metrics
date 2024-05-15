package com.reme;

import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class GithubAPIController {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public GithubAPIController(KafkaTemplate<String, String> kafkaTemplate) {
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
    public void publish(@RequestParam String message) {
// change to requestbody annotation
        kafkaTemplate.send("open-source-pull-requests", message);
    }
}

