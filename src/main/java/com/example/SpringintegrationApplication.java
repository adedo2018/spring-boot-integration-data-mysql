package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@ImportResource("classpath:book-services-http.xml")
public class SpringintegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringintegrationApplication.class, args);
	}

}
