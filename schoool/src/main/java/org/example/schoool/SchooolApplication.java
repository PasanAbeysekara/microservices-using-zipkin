package org.example.schoool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableFeignClients
@SpringBootApplication
public class SchooolApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchooolApplication.class, args);
	}

}
