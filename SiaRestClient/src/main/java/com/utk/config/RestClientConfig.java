package com.utk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackages = "com.utk.proxy")
public class RestClientConfig {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
