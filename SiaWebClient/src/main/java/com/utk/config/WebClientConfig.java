package com.utk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@ComponentScan(basePackages = "com.utk.proxy")
public class WebClientConfig {

	@Bean
	public WebClient webClient() {
		return WebClient.builder().build();
	}

}
