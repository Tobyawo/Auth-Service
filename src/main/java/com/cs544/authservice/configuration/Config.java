package com.cs544.authservice.configuration;

import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
@EnableKafka
public class Config {


	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}


}
