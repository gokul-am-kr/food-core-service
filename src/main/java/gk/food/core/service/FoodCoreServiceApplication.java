package gk.food.core.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Application class for food core service.
 *
 */
@SpringBootApplication
public class FoodCoreServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodCoreServiceApplication.class, args);
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}