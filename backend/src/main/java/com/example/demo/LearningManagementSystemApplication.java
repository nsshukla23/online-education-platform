package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class LearningManagementSystemApplication {

	public static void main(String[] args) {
		System.setProperty("DATASOURCE_URL", System.getenv("DATASOURCE_URL"));
		System.setProperty("DATASOURCE_USERNAME", System.getenv("DATASOURCE_USERNAME"));
		System.setProperty("DATASOURCE_PASSWORD", System.getenv("DATASOURCE_PASSWORD"));

		SpringApplication.run(LearningManagementSystemApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer configure() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry reg) {
				reg.addMapping("/**").allowedOrigins("*");
			}
		};
	}
}
