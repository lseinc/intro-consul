package com.example.democonsul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.*;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableZuulProxy
public class DemoZuulServiceGatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoZuulServiceGatewayApplication.class, args);
	}
}
