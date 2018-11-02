package com.weather.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 * This is spring boot application main file to bootstrap the weather application.
 * @author shubham kumar
 *
 */
@SpringBootApplication
@ComponentScan("com.weather.*")
public class WeatherAppApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(WeatherAppApplication.class, args);
	}
}
