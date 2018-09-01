package com.joegabonito.graphqlspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class GraphqlSpringbootApplication extends SpringBootServletInitializer {
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(GraphqlSpringbootApplication.class);
    }
	public static void main(String[] args) {
		SpringApplication.run(GraphqlSpringbootApplication.class, args);
	}
}
