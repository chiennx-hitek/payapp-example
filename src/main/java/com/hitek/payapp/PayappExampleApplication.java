package com.hitek.payapp;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PayappExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayappExampleApplication.class, args);
	}

	@Bean(name = "httpClient")
	public CloseableHttpClient httpClient() {
		return HttpClientBuilder.create().build();
	}

}
