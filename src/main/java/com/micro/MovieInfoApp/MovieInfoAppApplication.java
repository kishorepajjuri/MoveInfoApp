package com.micro.MovieInfoApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MovieInfoAppApplication {

	
	
	
	public static void main(String[] args) {
		System.out.println("mAIN");
		SpringApplication.run(MovieInfoAppApplication.class, args);
	}

}
