package com.learn.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsImageServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsImageServiceApplication.class, args);
	}

}
