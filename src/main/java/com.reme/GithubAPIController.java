package com.reme;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GithubAPIController {
    @GetMapping("/prs")
    public ResponseEntity<String> index() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.github.com/repos/apache/spark/pulls?since=2024-05-02T00:00:00Z";
//        TODO:Parameterize the since date
        return restTemplate.getForEntity(url, String.class);
    }
}

