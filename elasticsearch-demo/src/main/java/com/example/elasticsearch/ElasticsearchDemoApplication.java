package com.example.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.elasticsearch.repository.jpa") // JPA Repositories
@EnableElasticsearchRepositories(basePackages = "com.example.elasticsearch.repository.elasticsearch") // Elasticsearch Repositories

public class ElasticsearchDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElasticsearchDemoApplication.class, args);
	}

}
