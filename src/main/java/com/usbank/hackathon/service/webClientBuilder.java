package com.usbank.hackathon.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class webClientBuilder {
	@Bean
	public WebClient.Builder getWebClientBuilder(){
	    return WebClient.builder();
	}
}

