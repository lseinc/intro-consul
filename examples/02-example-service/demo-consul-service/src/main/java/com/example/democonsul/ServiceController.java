package com.example.democonsul;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.*;
import org.springframework.web.bind.annotation.*;

@Configuration
@EnableAutoConfiguration
@RefreshScope
@RestController
public class ServiceController {

    @Value("${special.name:not-yet-special}")
    private String specialName;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World! From "+specialName+" !";
    }

    @Bean
    public HealthIndicator specialRuleHealthIndicator() {
        return () -> Health.up().withDetail("hello", specialName).build();
    }

}
