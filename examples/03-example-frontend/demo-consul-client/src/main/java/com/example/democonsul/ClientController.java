package com.example.democonsul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableAutoConfiguration
@RefreshScope
@RestController
public class ClientController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/message")
    public String fetchMessage() {
        String results = restTemplate.getForObject("http://demo-consul-service/hello", String.class);
        return results;
    }

}
